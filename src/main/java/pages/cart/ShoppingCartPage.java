package pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product-line-grid")
    private List<WebElement> products;

    @FindBy(css = "#cart-subtotal-products .value")
    private WebElement allItemsPrice;

    @FindBy(css = "#cart-subtotal-shipping > .value")
    private WebElement shippingPrice;

    @FindBy(css = ".cart-total .value")
    private WebElement cartTotal;

    @FindBy(css = ".no-items")
    private WebElement noItemsMessage;

    @FindBy(css = ".cart-detailed-actions .btn-primary")
    private WebElement proceedToCheckoutButton;

    public List<CartProductPage> getProducts() {
        if (isNonEmptyList(products)) {
            return products.stream().map(el -> new CartProductPage(driver, el)).toList();
        } else {
            return Collections.<CartProductPage>emptyList();
        }
    }

    public BigDecimal getAllItemsPrice() {
        return parsePriceToBigDecimal(allItemsPrice.getText());
    }

    public List<BigDecimal> getListOfItemsPrices() {
        return getProducts().stream().map(CartProductPage::getTotalPrice).toList();
    }

    public BigDecimal getTotalCartPrice() {
        return parsePriceToBigDecimal(cartTotal.getText());
    }

    public BigDecimal getShippingPrice() {
        if (isVisible(shippingPrice)) {
            return parsePriceToBigDecimal(shippingPrice.getText());
        } else {
            return new BigDecimal("0.00");
        }
    }

    public boolean isNoItemsMessageVisible() {
        return noItemsMessage.isDisplayed();
    }

    public ShoppingCartPage clickProceedToCheckout() {
        proceedToCheckoutButton.click();
        return this;
    }
}
