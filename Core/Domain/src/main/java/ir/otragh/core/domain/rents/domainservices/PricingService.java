package ir.otragh.core.domain.rents.domainservices;

import ir.otragh.core.domain.amenities.entities.Amenity;
import ir.otragh.core.domain.homes.entities.Home;
import ir.otragh.core.domain.rents.valueobjects.DateRange;
import ir.otragh.core.domain.rents.valueobjects.PricingDetails;
import ir.otragh.core.domain.shared.valueobjects.Money;

import java.util.List;

public class PricingService {
    private List<Amenity> amenities;

    public PricingService(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    public PricingDetails calculatePrice(Home home, DateRange duration){

        Money priceForPeriod = new Money(home.getPrice().amount() * duration.lengthInDays());

        long upCharge = amenities.stream().mapToLong(value -> value.getPrice().amount()).reduce(Long::sum).getAsLong();

        return new PricingDetails(priceForPeriod,new Money(upCharge));
    }
}
