package ir.otragh.core.domain.rents.valueobjects;

import ir.otragh.core.domain.framework.exceptions.DomainValidationException;

import java.sql.Date;
import java.time.temporal.ChronoUnit;

public record DateRange(Date start, Date end) {

    public DateRange(Date start, Date end) {
        if (start.after(end))
            throw new DomainValidationException("Start date can not be after end.");
        this.start = start;
        this.end = end;
    }

    public long lengthInDays() {
        return ChronoUnit.DAYS.between(start.toLocalDate(), end.toLocalDate());
    }

    public boolean isInProgressAt(Date date) {
        return isStartedAt(date) && date.before(end);
    }

    public boolean isStartedAt(Date date) {
        return date.after(start);
    }

    public boolean isNotStartedAt(Date date) {
        return date.before(start);
    }

    public boolean isFinishedAt(Date date) {
        return date.after(end);
    }

}
