package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "quantity_wanted")
    private WebElement quantity;

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartButton;

    public ProductDetailsPage setQuantity(int value) {
        quantity.clear();
        quantity.sendKeys(String.valueOf(value));
        return this;
    }

    public ProductDetailsPage clickAddToCartButton() {
        addToCartButton.click();
        return this;
    }
}
