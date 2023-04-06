package models.user;

public enum SocialTitle {
    MR("1"),
    MRS( "2");

    private String value;

    SocialTitle(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
