package tests;

import configuration.DriverFactory;
import configuration.EnvironmentProperty;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

@Slf4j
public class BaseTest {
    protected WebDriver driver;

    protected Steps at;

    protected SoftAssertions softly;

    @BeforeAll
    static void setup() {
        EnvironmentProperty.getInstance();
    }

    @BeforeEach
    void setupDriver() {
        driver = new DriverFactory().getDriver();
        at = new Steps(driver);
        softly = new SoftAssertions();
        log.debug("Driver initialized.");
    }

    @AfterEach
    void teardown() {
        driver.quit();
        log.debug("Driver closed.");
    }

}
