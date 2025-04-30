package ir.otragh.core.domain.amenities.events;

import ir.otragh.core.domain.framework.events.DomainEvent;

public record AmenityCreated(int id) implements DomainEvent {
}
