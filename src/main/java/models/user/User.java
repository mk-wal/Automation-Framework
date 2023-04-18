package models.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private SocialTitle socialTitle;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthdate;

    @Override
    public String toString() {
        return "" + socialTitle.toString() + " " + firstName + " " + lastName + " " + email;
    }
}
