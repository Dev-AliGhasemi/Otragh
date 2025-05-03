package ir.otragh.applicationservice.rents.events;

import ir.otragh.core.domain.framework.events.DomainEvent;

public record RentCanceled(Long id) implements DomainEvent {
}
