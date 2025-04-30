package ir.otragh.core.domain.framework.entities;

import ir.otragh.core.domain.framework.events.DomainEvent;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Getter
public abstract class BaseAggregate<ID extends Number> {
    protected ID id;
    private List<DomainEvent> events = new LinkedList<>();

    public BaseAggregate(ID id) {
        this.id = id;
    }
    public void addDomainEvent(DomainEvent event) {
        events.add(event);
    }
    public void clearDomainEvents() {
        events.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseAggregate<?> that = (BaseAggregate<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
