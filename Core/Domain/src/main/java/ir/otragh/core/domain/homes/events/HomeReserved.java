package ir.otragh.core.domain.homes.events;

import ir.otragh.core.domain.framework.events.DomainEvent;

public record HomeReserved(int id) implements DomainEvent {
}
