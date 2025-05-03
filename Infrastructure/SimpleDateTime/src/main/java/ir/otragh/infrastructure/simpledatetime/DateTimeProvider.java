package ir.otragh.infrastructure.simpledatetime;

import ir.otragh.applicationservice.contracts.DateTimePicker;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DateTimeProvider implements DateTimePicker {
    @Override
    public LocalDateTime getUTCNow() {
        return LocalDateTime.now();
    }
}
