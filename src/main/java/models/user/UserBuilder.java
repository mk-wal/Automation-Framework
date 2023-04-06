package models.user;

public class UserBuilder {
    private SocialTitle socialTitle;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthdate; // optional

    public UserBuilder() {
    }

    public User build() {
        User user = new User();
        user.setSocialTitle(socialTitle);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setBirthdate(birthdate);
        return user;
    }

    public UserBuilder socialTitle(SocialTitle socialTitle) {
        this.socialTitle = socialTitle;
        return this;
    }

    public UserBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }
    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }
    public UserBuilder birthdate(String birthdate) {
        this.birthdate = birthdate;
        return this;
    }
}
