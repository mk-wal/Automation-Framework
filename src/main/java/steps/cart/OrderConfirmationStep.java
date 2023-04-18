package steps.cart;

import org.openqa.selenium.WebDriver;
import pages.cart.OrderConfirmationPage;
import steps.BaseStep;

public class OrderConfirmationStep extends BaseStep {
    OrderConfirmationPage orderConfirmationPage;

    public OrderConfirmationStep(WebDriver driver) {
        super(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
    }

    public String getOrderReferenceNumber() {
        String order = orderConfirmationPage.getOrderReference().getText();
        return order.split(":")[1].trim();
    }
}
