package models.status;

public enum Status {
    AWAITING("Awaiting check payment");

    private String value;


    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
