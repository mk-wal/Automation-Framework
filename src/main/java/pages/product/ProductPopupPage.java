package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.math.BigDecimal;

public class ProductPopupPage extends BasePage {
    public ProductPopupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".modal-dialog .product-name")
    private WebElement title;

    @FindBy(css = ".modal-dialog .product-price")
    private WebElement price;

    @FindBy(css = ".modal-dialog .product-quantity")
    private WebElement quantity;

    @FindBy(css = ".modal-dialog .cart-products-count")
    private WebElement productCount;

    @FindBy(css = ".modal-dialog .subtotal")
    private WebElement subtotalProductValue;

    @FindBy(css = ".cart-content-btn .btn-secondary")
    private WebElement continueShoppingButton;

    @FindBy(css = ".cart-content-btn .btn-primary")
    private WebElement proceedToCheckoutButton;

    public BigDecimal getPrice() {
        return parsePriceToBigDecimal(waitForTextToNotBeEmpty(price));
    }

    public String getTitle() {
        return waitForTextToNotBeEmpty(title);
    }

    public int getQuantity() {
        return getNumericFromString(waitForTextToNotBeEmpty(quantity));
    }

    public int getProductCount() {
        return getNumericFromString(waitForTextToNotBeEmpty(productCount));
    }

    public BigDecimal getProductSubtotal() {
        return parsePriceToBigDecimal(waitForTextToNotBeEmpty(subtotalProductValue));
    }

    public ProductPopupPage clickContinueShopping() {
        continueShoppingButton.click();
        return this;
    }

    public ProductPopupPage clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
        return this;
    }
}
