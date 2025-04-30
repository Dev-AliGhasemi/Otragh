package ir.otragh.core.domain.homes.entities;

import ir.otragh.core.domain.framework.Result;
import ir.otragh.core.domain.framework.entities.BaseEntity;
import ir.otragh.core.domain.homes.events.HomeCreated;
import ir.otragh.core.domain.homes.events.HomeReserved;
import ir.otragh.core.domain.homes.valueobjects.Address;
import ir.otragh.core.domain.homes.valueobjects.Description;
import ir.otragh.core.domain.shared.valueobjects.Money;
import ir.otragh.core.domain.shared.valueobjects.Title;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.LinkedList;

@Getter
public final class Home extends BaseEntity<Integer> {
    private Title title;
    private Description description;
    private Address address;
    private Money price;
    private LinkedList<Long> amenities;
    private LocalDateTime lastReservedOnUTC;

    private Home(int id, Title title, Description description, Address address, Money price, LinkedList<Long> amenities) {
        super(id);
        this.title = title;
        this.description = description;
        this.address = address;
        this.price = price;
        this.amenities = amenities;
    }

    public static Home create(int id, Title title, Description description, Address address, Money price, LinkedList<Long> amenities) {
        Home home = new Home(id, title, description, address, price, amenities);
        home.addDomainEvent(new HomeCreated(id));
        return home;
    }

    public Result reserve(LocalDateTime utcNow) {
        lastReservedOnUTC = utcNow;
        addDomainEvent(new HomeReserved(getId()));
        return Result.success();
    }
}
