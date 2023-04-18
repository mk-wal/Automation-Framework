package pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#history-link i")
    private WebElement orderHistoryIcon;

    @FindBy(css = "#content tbody tr")
    private List<WebElement> orders;

    public AccountPage openOrderHistory() {
        orderHistoryIcon.click();
        return this;
    }

    public List<OrderPage> getOrders() {
        return orders.stream().map(order -> new OrderPage(driver, order)).toList();
    }
}
