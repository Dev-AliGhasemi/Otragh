package ir.otragh.core.domain.amenities.entities;

import ir.otragh.core.domain.amenities.events.AmenityCreated;
import ir.otragh.core.domain.framework.entities.BaseEntity;
import ir.otragh.core.domain.shared.valueobjects.Money;
import ir.otragh.core.domain.shared.valueobjects.Title;
import lombok.Getter;

@Getter
public final class Amenity extends BaseEntity<Integer> {
    private Title title;
    private Money price;

    private Amenity(int id, Title title, Money price) {
        super(id);
        this.title = title;
        this.price = price;
    }

    public static Amenity create(int id, Title title, Money price) {
        Amenity amenity = new Amenity(id, title, price);
        amenity.addDomainEvent(new AmenityCreated(id));
        return amenity;
    }

}
