package pages.category;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class CategoryDetailsPage extends BasePage {
    public CategoryDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".h1")
    private WebElement categoryMainName;

    @FindBy(css = "#js-product-list-top p")
    private WebElement totalProductsCounter;

    public WebElement getCategoryMainName() {
        return categoryMainName;
    }

    public int getTotalProductsCounter() {
        return getNumericFromString(totalProductsCounter.getText());
    }
}
