package steps.main;

import models.user.User;
import org.openqa.selenium.WebDriver;
import pages.main.LogInPage;
import steps.BaseStep;

public class LogInStep extends BaseStep {

    LogInPage logInPage;

    public LogInStep(WebDriver driver) {
        super(driver);
        logInPage = new LogInPage(driver);
    }

    public LogInStep logIn(String email, String password) {
        logInPage.inputEmail(email)
                .inputPassword(password)
                .clickSignIn();
        return this;
    }

    public LogInStep logIn(User user) {
        logIn(user.getEmail(), user.getPassword());
        return this;
    }
}
