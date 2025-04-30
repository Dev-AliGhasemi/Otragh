package ir.otragh.core.domain.users.events;

import ir.otragh.core.domain.framework.events.DomainEvent;

public record UserCreated(int id) implements DomainEvent {
}
