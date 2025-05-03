package ir.otragh.applicationservice.framework.commands.data;

import ir.otragh.applicationservice.framework.commands.BaseCommand;

public interface CommandHandler<T extends BaseCommand,K> {
    K handle(T command);
}
