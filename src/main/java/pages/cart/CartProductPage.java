package pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.math.BigDecimal;

public class CartProductPage extends BasePage {
    public CartProductPage(WebDriver driver, WebElement parent) {
        super(driver, parent);
    }

    @FindBy(css = ".label")
    private WebElement title;

    @FindBy(css = ".current-price .price")
    private WebElement price;

    @FindBy(css = ".js-cart-line-product-quantity")
    private WebElement quantity;

    @FindBy(css = ".row > .price .product-price")
    private WebElement totalPrice;

    @FindBy(css = ".remove-from-cart")
    private WebElement deleteIcon;

    public String getName() {
        return title.getText();
    }

    public BigDecimal getPrice() {
        return parsePriceToBigDecimal(price.getText());
    }

    public int getQuantity() {
        return Integer.parseInt(quantity.getAttribute("value"));
    }

    public BigDecimal getTotalPrice() {
        return parsePriceToBigDecimal(totalPrice.getText());
    }

    public void clickDeleteIcon() {
        deleteIcon.click();
        wait.until(ExpectedConditions.invisibilityOf(deleteIcon));
    }
}
