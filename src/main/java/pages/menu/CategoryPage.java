package pages.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class CategoryPage extends BasePage {
    public CategoryPage(WebDriver driver, WebElement parent) {
        super(driver, parent);
    }

    @FindBy(css = "li")
    private List<WebElement> subcategories;

    public List<WebElement> getSubcategories() {
        return subcategories;
    }
}
