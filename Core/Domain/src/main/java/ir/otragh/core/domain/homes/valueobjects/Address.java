package ir.otragh.core.domain.homes.valueobjects;

public record Address(String city,String addressLine, String zipCode) {
    public Address{
        if (city == null || city.isBlank())
            throw new IllegalArgumentException("city is blank");
        if (addressLine == null || addressLine.isBlank())
            throw new IllegalArgumentException("addressLine is blank");
        if (zipCode == null || zipCode.isBlank())
            throw new IllegalArgumentException("zipCode is blank");
    }
}
