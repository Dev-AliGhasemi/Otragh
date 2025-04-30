package ir.otragh.core.domain.users.valueobjects;

public record FirstName(String firstName) {
    public FirstName{
        if (firstName == null || firstName.isBlank())
            throw new IllegalArgumentException("lastName is blank");
    }
}
