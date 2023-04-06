package steps.product;

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

    public String getRandomProductTitle() {
        return productGridPage.getRandomProduct().getTitle();
    }

}
