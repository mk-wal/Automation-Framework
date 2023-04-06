package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}
