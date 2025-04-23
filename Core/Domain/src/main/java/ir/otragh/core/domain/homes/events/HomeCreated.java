package ir.otragh.core.domain.homes.events;

import ir.otragh.core.domain.framework.events.DomainEvent;

public record HomeCreated(int id) implements DomainEvent {
}
