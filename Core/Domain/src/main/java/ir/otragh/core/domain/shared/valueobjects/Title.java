package ir.otragh.core.domain.shared.valueobjects;

public record Title(String value) {
    public Title{
        if (value == null || value.isBlank())
            throw new IllegalArgumentException("Title value cannot be null or empty");
    }
}
