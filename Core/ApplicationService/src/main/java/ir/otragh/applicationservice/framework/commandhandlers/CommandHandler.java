package ir.otragh.applicationservice.framework.commandhandlers;

import ir.otragh.core.domain.framework.commands.Command;

public interface CommandHandler<COMMAND extends Command,RETURN_VALUE>{
    RETURN_VALUE handle(COMMAND command);
}
