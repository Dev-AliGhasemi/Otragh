package ir.otragh.applicationservice.rents.commands.reserve;

import ir.otragh.applicationservice.framework.commands.data.Command;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;


public record ReserveCommand(
        @NotNull
        long homeId,
        @NotNull
        long userId,
        @NotNull
        @FutureOrPresent
        Date startDate,
        @Future
        Date endDate) implements Command<Long> {
}
