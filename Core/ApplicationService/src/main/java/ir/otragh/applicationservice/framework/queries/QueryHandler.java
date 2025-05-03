package ir.otragh.applicationservice.framework.queries;

public interface QueryHandler<T extends Query<K> ,K> {
    K handle(T query);
}
