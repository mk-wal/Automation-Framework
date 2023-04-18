package steps.product;

import org.openqa.selenium.WebDriver;
import pages.product.ProductDetailsPage;
import steps.BaseStep;

public class ProductDetailsStep extends BaseStep {

    ProductDetailsPage productDetailsPage;

    public ProductDetailsStep(WebDriver driver) {
        super(driver);
        productDetailsPage = new ProductDetailsPage(driver);
    }

    public ProductDetailsStep setQuantity(int quantity) {
        productDetailsPage.setQuantity(quantity);
        return this;
    }

    public ProductDetailsStep addToCart() {
        productDetailsPage.clickAddToCartButton();
        return this;
    }
}
