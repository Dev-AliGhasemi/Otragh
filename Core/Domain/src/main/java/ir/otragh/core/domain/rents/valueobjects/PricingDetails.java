package ir.otragh.core.domain.rents.valueobjects;

import ir.otragh.core.domain.shared.valueobjects.Money;

public record PricingDetails(Money priceForPeriod, Money amenitiesUpCharge) {
}
