package ir.otragh.applicationservice.rents.events;

import ir.otragh.core.domain.framework.events.DomainEvent;

public record RentRejected(Long id) implements DomainEvent {
}
