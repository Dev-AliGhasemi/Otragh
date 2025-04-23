package ir.otragh.core.domain.rents.commands;

import ir.otragh.core.domain.framework.commands.Command;

public record SubmitComment(long rentId,String comment) implements Command {
}
