package steps;

import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.function.Predicate;

public class BaseStep {
    protected WebDriver driver;

    public BaseStep(WebDriver driver) {
        this.driver = driver;
    }

    public <T> T getFirstMatchingElement(List<T> listOfElements, Predicate<T> predicate) {
        return listOfElements.stream().filter(predicate).toList().get(0);
    }
}
