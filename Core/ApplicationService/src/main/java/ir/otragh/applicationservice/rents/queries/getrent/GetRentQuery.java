package ir.otragh.applicationservice.rents.queries.getrent;

import ir.otragh.applicationservice.framework.queries.Query;

public record GetRentQuery(long rentId) implements Query<RentResponse> {
}
