package ir.otragh.core.domain.rents.events;

import ir.otragh.core.domain.framework.events.DomainEvent;

public record RentConfirmed(long id) implements DomainEvent {

}
