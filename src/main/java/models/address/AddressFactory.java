package models.address;

public class AddressFactory {
    public static Address getHomeAddress() {
        return new Address(System.getProperty("home address"), System.getProperty("home city"),
                System.getProperty("home state"), System.getProperty("home zipcode"));
    }

    public static Address getInvoiceAddress() {
        return new Address(System.getProperty("invoice address"), System.getProperty("invoice city"),
                System.getProperty("invoice state"), System.getProperty("invoice zipcode"));
    }
}
