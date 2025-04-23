package ir.otragh.core.domain.homes.entities;

import ir.otragh.core.domain.framework.entities.BaseEntity;
import ir.otragh.core.domain.homes.events.HomeCreated;
import ir.otragh.core.domain.homes.valueobjects.Address;
import ir.otragh.core.domain.homes.valueobjects.Description;
import ir.otragh.core.domain.shared.valueobjects.Money;
import ir.otragh.core.domain.shared.valueobjects.Title;
import lombok.Getter;

import java.util.LinkedList;

@Getter
public final class Home extends BaseEntity<Integer> {
    private Title title;
    private Description description;
    private Address address;
    private Money price;
    private LinkedList<Integer> amenities;

    private Home(int id, Title title, Description description, Address address, Money price, LinkedList<Integer> amenities) {
        super(id);
        this.title = title;
        this.description = description;
        this.address = address;
        this.price = price;
        this.amenities = amenities;
    }

    public static Home create(int id, Title title, Description description, Address address, Money price, LinkedList<Integer> amenities) {
        Home home = new Home(id, title, description, address, price, amenities);
        home.addDomainEvent(new HomeCreated(id));
        return home;
    }
}
