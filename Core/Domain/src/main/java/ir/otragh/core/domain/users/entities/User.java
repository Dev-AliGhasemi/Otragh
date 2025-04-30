package ir.otragh.core.domain.users.entities;

import ir.otragh.core.domain.framework.entities.BaseEntity;
import ir.otragh.core.domain.users.events.UserCreated;
import ir.otragh.core.domain.users.valueobjects.Email;
import ir.otragh.core.domain.users.valueobjects.FirstName;
import ir.otragh.core.domain.users.valueobjects.LastName;
import lombok.Getter;

@Getter
public final class User extends BaseEntity<Integer> {
    private FirstName firstName;
    private LastName lastName;
    private Email email;

    private User(int integer, FirstName firstName, LastName lastName, Email email) {
        super(integer);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public static User create(int id, FirstName firstName, LastName lastName, Email email) {
        User user = new User(id, firstName, lastName, email);
        user.addDomainEvent(new UserCreated(id));
        return user;
    }
}
