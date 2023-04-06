package pages.category;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class CategoryViewPage extends BasePage {

    public CategoryViewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#main h1")
    private WebElement categoryTitle;

    public WebElement getCategoryTitle() {
        return categoryTitle;
    }
}
