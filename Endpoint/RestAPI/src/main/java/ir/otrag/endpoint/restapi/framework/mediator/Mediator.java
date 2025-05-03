package ir.otrag.endpoint.restapi.framework.mediator;

import ir.otragh.applicationservice.framework.commands.BaseCommand;
import ir.otragh.applicationservice.framework.commands.data.Command;
import ir.otragh.applicationservice.framework.commands.data.CommandHandler;
import ir.otragh.applicationservice.framework.queries.Query;
import ir.otragh.applicationservice.framework.queries.QueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
@AllArgsConstructor
public class Mediator {

    private ApplicationContext applicationContext;

    public <T extends Command<K>, K> K send(T t) {
        CommandHandler<T, K> commandHandler = findCommandHandler(t);
        return commandHandler.handle(t);
    }

    public <T extends ir.otragh.applicationservice.framework.commands.Command> void send(T t) {
        ir.otragh.applicationservice.framework.commands.CommandHandler<T> commandHandler = findCommandHandler(t);
        commandHandler.handle(t);
    }

    public <T extends Query<K>, K> K send(T t) {
        QueryHandler<T, K> queryHandler = findQueryHandler(t);
        return queryHandler.handle(t);
    }

    private <T extends Command<K>, K> CommandHandler<T, K> findCommandHandler(T t) {
        String handlerName = t.getClass().getSimpleName() + "Handler";
        return (CommandHandler<T, K>) applicationContext.getBean(handlerName);
    }

    private <T extends ir.otragh.applicationservice.framework.commands.Command>
    ir.otragh.applicationservice.framework.commands.CommandHandler<T> findCommandHandler(T t) {
        String handlerName = t.getClass().getSimpleName() + "Handler";

        return (ir.otragh.applicationservice.framework.commands.CommandHandler<T>) applicationContext.getBean(handlerName);

    }

    private <T extends Query<K>,K> QueryHandler<T,K> findQueryHandler(T t) {
        String handlerName = t.getClass().getSimpleName() + "Handler";
        return (QueryHandler<T, K>) applicationContext.getBean(handlerName);
    }
}
