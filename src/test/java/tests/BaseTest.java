package tests;

import configuration.DriverFactory;
import configuration.EnvironmentProperty;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import steps.BaseStep;

@Slf4j
public class BaseTest {
    protected WebDriver driver;

    protected Pages at;

    @BeforeAll
    static void setup() {
        EnvironmentProperty.getInstance();
    }

    @BeforeEach
    void setupDriver() {
        driver = new DriverFactory().getDriver();
        at = new Pages(driver);
        log.debug("Driver initialized.");
    }

    @AfterEach
    void teardown() {
        driver.quit();
        log.debug("Driver closed.");
    }

    @SneakyThrows
    public <T extends BaseStep> T with(Class<T> page) {
        return page.getDeclaredConstructor(WebDriver.class).newInstance(driver);
    }

}
