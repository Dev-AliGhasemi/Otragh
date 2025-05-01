package ir.otragh.core.domain.rents.entities;

import ir.otragh.core.domain.amenities.entities.Amenity;
import ir.otragh.core.domain.framework.Result;
import ir.otragh.core.domain.framework.entities.BaseAggregate;
import ir.otragh.core.domain.homes.entities.Home;
import ir.otragh.core.domain.rents.domainservices.PricingService;
import ir.otragh.core.domain.rents.events.*;
import ir.otragh.core.domain.rents.valueobjects.DateRange;
import ir.otragh.core.domain.rents.valueobjects.PricingDetails;
import ir.otragh.core.domain.shared.valueobjects.Money;
import lombok.Getter;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public final class Rent extends BaseAggregate<Long> {

    private int homeId;
    private int userId;
    private Money priceForPeriod;
    private Money amenitiesUpCharge;
    private RentStatus rentStatus;
    private DateRange duration;
    private LocalDateTime createdOnUTC;
    private LocalDateTime hostStatusOnUTC;
    private LocalDateTime guestStatusOnUTC;

    public Rent(Long id, int homeId, int userId, DateRange duration, Money priceForPeriod, Money amenitiesUpCharge, RentStatus rentStatus,
                LocalDateTime createdOnUTC) {
        super(id);
        this.homeId = homeId;
        this.userId = userId;
        this.duration = duration;
        this.priceForPeriod = priceForPeriod;
        this.amenitiesUpCharge = amenitiesUpCharge;
        this.rentStatus = rentStatus;
        this.createdOnUTC = createdOnUTC;
    }

    public static Rent reserve(long id, Home home, int userId, DateRange duration, LocalDateTime utcNow, List<Amenity> amenities) {
        PricingDetails pricingDetails = PricingService.calculatePrice(amenities,home,duration);
        Rent rent = new Rent(id, home.getId(), userId, duration,pricingDetails.priceForPeriod(),pricingDetails.amenitiesUpCharge(),
                RentStatus.RESERVED, utcNow);
        rent.addDomainEvent(new RentReserved(id));
        home.reserve(utcNow);
        return rent;
    }

    public Result confirm(LocalDateTime utcNow){
        if (rentStatus != RentStatus.RESERVED)
            return Result.failure(RentErrors.NOT_RESERVED);
        rentStatus = RentStatus.CONFIRMED;
        hostStatusOnUTC = utcNow;
        addDomainEvent(new RentConfirmed(id));
        return Result.success();
    }

    public Result reject(LocalDateTime utcNow){
        if (rentStatus != RentStatus.RESERVED)
            return Result.failure(RentErrors.NOT_RESERVED);
        rentStatus = RentStatus.REJECTED;
        hostStatusOnUTC = utcNow;
        addDomainEvent(new RentRejected(id));
        return Result.success();
    }

    public Result complete(LocalDateTime utcNow){
        if (rentStatus != RentStatus.CONFIRMED)
            return Result.failure(RentErrors.NOT_CONFIRMED);
        if(!duration.isFinishedAt(Date.valueOf(utcNow.toLocalDate())))
            return Result.failure(RentErrors.NOT_CONFIRMED);

        rentStatus = RentStatus.COMPLETED;
        guestStatusOnUTC = utcNow;
        addDomainEvent(new RentCompleted(id));
        return Result.success();
    }

    public Result cancel(LocalDateTime utcNow){
        if (rentStatus != RentStatus.CONFIRMED)
            return Result.failure(RentErrors.NOT_CONFIRMED);
        if(duration.isInProgressAt(Date.valueOf(utcNow.toLocalDate())))
            return Result.failure(RentErrors.ALREADY_STARTED);

        rentStatus = RentStatus.CANCELLED;
        guestStatusOnUTC = utcNow;
        addDomainEvent(new RentCanceled(id));
        return Result.success();
    }

    public Money totalPrice() {
        return Money.sum(priceForPeriod, amenitiesUpCharge);
    }


}
