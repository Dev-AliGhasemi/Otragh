package ir.otragh.applicationservice.framework.commands;

public interface CommandHandler<T extends BaseCommand> {
    void handle(T t);
}

