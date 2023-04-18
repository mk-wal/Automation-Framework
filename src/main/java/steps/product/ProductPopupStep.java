package steps.product;

import models.cart.Product;
import models.cart.ProductLine;
import org.openqa.selenium.WebDriver;
import pages.product.ProductPopupPage;
import steps.BaseStep;

import java.math.BigDecimal;

public class ProductPopupStep extends BaseStep {

    ProductPopupPage productPopupPage;

    public ProductPopupStep(WebDriver driver) {
        super(driver);
        productPopupPage = new ProductPopupPage(driver);
    }

    public ProductLine getProductLine() {
        return new ProductLine(new Product(productPopupPage.getTitle(), productPopupPage.getPrice()), productPopupPage.getQuantity());
    }

    public int getProductCount() {
        return productPopupPage.getProductCount();
    }

    public BigDecimal getProductSubtotal() {
        return productPopupPage.getProductSubtotal();
    }

    public ProductPopupStep clickContinueShopping() {
        productPopupPage.clickContinueShopping();
        return this;
    }

    public ProductPopupStep clickProceedToCheckout() {
        productPopupPage.clickProceedToCheckoutButton();
        return this;
    }
}
