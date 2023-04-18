package models.address;

public record Address(
        String address,
        String city,
        String state,
        String postalCode) {

    public boolean ifStringContainsAllFields(String text) {
        return text.contains(address) && text.contains(city) && text.contains(state) && text.contains(postalCode);
    }
}
