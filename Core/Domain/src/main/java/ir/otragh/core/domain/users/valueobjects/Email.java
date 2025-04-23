package ir.otragh.core.domain.users.valueobjects;

public record Email(String email) {
    public Email{
        if (email == null || email.isBlank())
            throw new IllegalArgumentException("email is null or empty");

    }
}
