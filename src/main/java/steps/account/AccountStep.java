package steps.account;

import org.openqa.selenium.WebDriver;
import pages.account.AccountPage;
import steps.BaseStep;

public class AccountStep extends BaseStep {

    AccountPage accountPage;

    public AccountStep(WebDriver driver) {
        super(driver);
        accountPage = new AccountPage(driver);
    }

    public AccountStep openOrderHistory() {
        accountPage.openOrderHistory();
        return this;
    }

    public AccountStep openOrderDetails(String orderReference) {
        getFirstMatchingElement(accountPage.getOrders(), o -> o.getOrderReference().equals(orderReference)).clickDetails();
        return this;
    }
}
