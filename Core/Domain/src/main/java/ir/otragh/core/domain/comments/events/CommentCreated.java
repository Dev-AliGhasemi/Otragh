package ir.otragh.core.domain.comments.events;

import ir.otragh.core.domain.framework.events.DomainEvent;

public record CommentCreated(long id) implements DomainEvent {
}
