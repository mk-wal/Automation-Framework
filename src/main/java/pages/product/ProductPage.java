package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.math.BigDecimal;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver, WebElement parent) {
        super(driver, parent);
    }

    @FindBy(css = ".product-title")
    private WebElement title;

    @FindBy(css = ".price")
    private WebElement price;

    public String getTitle() {
        return title.getText();
    }

    public void click() {
        title.click();
    }

    public BigDecimal getPrice() {
        return parsePriceToBigDecimal(price.getText());
    }
}
