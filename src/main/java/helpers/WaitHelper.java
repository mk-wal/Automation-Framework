package helpers;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WaitHelper {
    private static final String IMPLICIT_WAIT_VALUE_KEY = "implicit wait";

    public static void turnOnImplicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(System.getProperty(IMPLICIT_WAIT_VALUE_KEY))));
    }

    public static void turnOffImplicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

    }
}
