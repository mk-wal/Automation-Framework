package pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class OrderConfirmationPage extends BasePage {
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='order-details']//*[contains(text(), 'reference')]")
    private WebElement orderReference;

    public WebElement getOrderReference() {
        return orderReference;
    }
}
