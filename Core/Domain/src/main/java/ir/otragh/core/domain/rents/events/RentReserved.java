package ir.otragh.core.domain.rents.events;

import ir.otragh.core.domain.framework.events.DomainEvent;

public record RentReserved(long id) implements DomainEvent {
}
