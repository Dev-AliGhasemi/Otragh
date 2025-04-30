package ir.otragh.core.domain.rents.entities;

import ir.otragh.core.domain.framework.errors.Error;

public class RentErrors {
    public static final Error NOT_FOUND = new Error("Booking.NotFound", "Booking not found");
    public static final Error NOT_RESERVED = new Error("Booking.NotReserved", "Booking not reserved");
    public static final Error NOT_CONFIRMED = new Error("Booking.NotConfirmed", "Booking not confirmed");
    public static final Error NOT_FINISHED = new Error("Booking.NotFinished", "Booking not finished");
    public static final Error ALREADY_STARTED = new Error("Booking.AlreadyStarted", "Booking already started");
}
