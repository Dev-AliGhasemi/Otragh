package ir.otragh.core.domain.homes.valueobjects;

public record Description(String value) {
    public Description{
        if (value == null || value.isBlank())
            throw new IllegalArgumentException("Value cannot be null or empty");
    }
}
