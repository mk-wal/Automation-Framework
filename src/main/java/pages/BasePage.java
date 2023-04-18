package pages;

import helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;
    protected Actions actions;

    private final String EXPLICIT_WAIT_VALUE_KEY = "explicit wait";


    public BasePage(WebDriver driver) {
        initDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public BasePage(WebDriver driver, WebElement parent) {
        initDriver(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(parent), this);
    }

    private void initDriver(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty(EXPLICIT_WAIT_VALUE_KEY))));
        actions = new Actions(driver);
    }

    public <T> T getRandomElementFromList(List<T> listOfElements) {
        return listOfElements.get(new Random().nextInt(listOfElements.size()));
    }

    public BigDecimal parsePriceToBigDecimal(String price) {
        return new BigDecimal(price.replace("$", ""));
    }

    public int getNumericFromString(String text) {
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    public int getNumericFromStringWithDot(String text) { //TODO: Refactor
        return Integer.parseInt(text.replaceAll("[^0-9.]", "").split("\\.")[0]);
    }

    public String waitForTextToNotBeEmpty(WebElement element) {
        wait.until(driver -> !element.getText().isEmpty());
        return element.getText();
    }

    public boolean isVisible(WebElement element) {
        boolean visible = true;
        WaitHelper.turnOffImplicitWait(driver);
        try {
            element.isDisplayed();
        } catch (Exception e) {
            visible = false;
        } finally {
            WaitHelper.turnOnImplicitWait(driver);
        }
        return visible;
    }

    public boolean isNonEmptyList(List<WebElement> listOfElements) {
        WaitHelper.turnOffImplicitWait(driver);
        boolean empty = true;
        if (listOfElements.size() == 0) {
            empty = false;
        }
        WaitHelper.turnOnImplicitWait(driver);
        return empty;
    }

    public void waitForElementToDisappear(WebElement element) {
        WaitHelper.turnOffImplicitWait(driver);
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(10000))
                .pollingEvery(Duration.ofMillis(250));
        fluentWait.until(ExpectedConditions.invisibilityOf(element));
        WaitHelper.turnOnImplicitWait(driver);
    }
}
