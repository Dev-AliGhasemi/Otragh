package ir.otragh.core.domain.rents.commands;

import ir.otragh.core.domain.framework.commands.Command;

import java.sql.Date;
import java.util.LinkedList;

public record Create(long homeId, long userId, Date startRent, Date endRent,
                     LinkedList<Long> selectedAmenities) implements Command {
}
