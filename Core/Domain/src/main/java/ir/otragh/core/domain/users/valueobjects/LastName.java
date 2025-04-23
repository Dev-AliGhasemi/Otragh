package ir.otragh.core.domain.users.valueobjects;

public record LastName(String lastName) {
    public LastName {
        if (lastName == null || lastName.isBlank())
            throw new IllegalArgumentException("lastName is blank");
    }
}
