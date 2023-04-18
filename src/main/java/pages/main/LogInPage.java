package pages.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LogInPage extends BasePage {
    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#login-form input[name='email']")
    private WebElement emailInput;

    @FindBy(css = "#login-form input[name='password']")
    private WebElement passwordInput;

    @FindBy(css = "#submit-login")
    private WebElement signInButton;

    public LogInPage inputEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public LogInPage inputPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public LogInPage clickSignIn() {
        signInButton.click();
        return this;
    }
}
