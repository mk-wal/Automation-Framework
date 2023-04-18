package steps.product;

import models.cart.Product;
import org.openqa.selenium.WebDriver;
import pages.product.ProductGridPage;
import pages.product.ProductPage;
import steps.BaseStep;

import java.util.List;

public class ProductGridStep extends BaseStep {

    private ProductGridPage productGridPage;

    public ProductGridStep(WebDriver driver) {
        super(driver);
        productGridPage = new ProductGridPage(driver);
    }

    public List<String> getProductsTitles() {
        return productGridPage.getProducts().stream().map(ProductPage::getTitle).toList();
    }

    public List<ProductPage> getProducts() {
        return productGridPage.getProducts();
    }

    public String getRandomProductTitle() {
        return productGridPage.getRandomProduct().getTitle();
    }

    public ProductGridStep selectProductWithTitle(String title) {
        getFirstMatchingElement(productGridPage.getProducts(), p -> p.getTitle().equals(title)).click();
        return this;
    }

    public Product getProductWithTitle(String title) {
        ProductPage productPage = getFirstMatchingElement(productGridPage.getProducts(), p -> p.getTitle().equals(title));
        return new Product(productPage.getTitle(), productPage.getPrice());
    }

    public ProductGridStep selectRandomProduct() {
        productGridPage.getRandomProduct().click();
        return this;
    }

}
