package ir.otragh.applicationservice.rents.events;

import ir.otragh.applicationservice.framework.events.Event;

public record RentConfirmed(long id) implements Event {

}
