package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ProductGridPage extends BasePage {
    public ProductGridPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product-miniature")
    private List<WebElement> products;

    public List<ProductPage> getProducts() {
        // tu moze jakis wait?
        return products.stream().map(el -> new ProductPage(driver, el)).toList();
    }

    public ProductPage getRandomProduct() {
        return getRandomElementFromList(getProducts());
    }
}
