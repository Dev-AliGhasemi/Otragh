package ir.otragh.core.domain.rents.entities;

import ir.otragh.core.domain.amenities.entities.Amenity;
import ir.otragh.core.domain.comments.entities.Comment;
import ir.otragh.core.domain.framework.entities.BaseAggregate;
import ir.otragh.core.domain.homes.entities.Home;
import ir.otragh.core.domain.rents.events.CommentSubmitted;
import ir.otragh.core.domain.rents.events.Payed;
import ir.otragh.core.domain.rents.events.RentCreated;
import ir.otragh.core.domain.rents.microtypes.EndDate;
import ir.otragh.core.domain.rents.microtypes.StartDate;
import ir.otragh.core.domain.shared.valueobjects.Money;
import ir.otragh.core.domain.users.entities.User;
import lombok.Getter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;

@Getter
public final class Rent extends BaseAggregate<Long> {

    private Home home;
    private User user;
    private Comment comment;
    private LinkedList<Amenity> selectedAmenities;
    private StartDate startRent;
    private EndDate endRent;
    private Money amount;
    private boolean isPayed = false;

    private Rent(long id, Home home, User user, StartDate startRent, EndDate endRent, Money amount,
                 LinkedList<Amenity> selectedAmenities) {
        super(id);
        this.home = home;
        this.user = user;
        this.startRent = startRent;
        this.endRent = endRent;
        this.amount = amount;
        this.selectedAmenities = selectedAmenities;
    }

    public static Rent create(int id, Home home, User user, StartDate startRent, EndDate endRent,
                              LinkedList<Amenity> selectedAmenities) {
        int amount = selectedAmenities.stream().mapToInt(value -> value.getPrice().amount()).reduce(Integer::sum).getAsInt();
        Rent rent = new Rent(id, home, user, startRent, endRent, new Money(amount), selectedAmenities);
        rent.addDomainEvent(new RentCreated(id));
        return rent;
    }

    public void pay(){
        isPayed = true;
        addDomainEvent(new Payed(getId()));
    }

    public void submitComment(Comment comment) {
        if (isPayed && Date.valueOf(LocalDate.now()).after(endRent.value())){
            this.comment = comment;
            addDomainEvent(new CommentSubmitted(comment.getId()));
        }else {

        }
    }






}
