package pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class OrderPage extends BasePage {
    public OrderPage(WebDriver driver, WebElement parent) {
        super(driver, parent);
    }

    @FindBy(css = "th")
    private WebElement orderReference;

    @FindBy(css = "[data-link-action]")
    private WebElement detailsLink;

    public String getOrderReference() {
        return orderReference.getText();
    }

    public void clickDetails() {
        detailsLink.click();
    }
}
