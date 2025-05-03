package ir.otragh.applicationservice.rents.queries.getrent;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public final class RentResponse {
    private final int id;
    private final int userId;
    private final int apartmentId;
    private final int status;
    private final int priceForPeriod;
    private final int amenitiesUpCharge;
    private final int totalPriceAmount;
    private final LocalDate durationStart;
    private final LocalDate durationEnd;
    private final LocalDateTime createdOnUtc;
}
