package steps.account;

import org.openqa.selenium.WebDriver;
import pages.account.OrderDetailsPage;
import steps.BaseStep;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderDetailsStep extends BaseStep {
    OrderDetailsPage orderDetailsPage;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public OrderDetailsStep(WebDriver driver) {
        super(driver);
        orderDetailsPage = new OrderDetailsPage(driver);
    }

    public String getStatus() {
        return orderDetailsPage.getStatus();
    }

    public LocalDate getOrderDate() {
        return LocalDate.parse(orderDetailsPage.getDate(), formatter);
    }

    public BigDecimal getTotalPrice() {
        return orderDetailsPage.getTotalPrice();
    }

    public String getInvoiceAddressDetails() {
        return orderDetailsPage.getInvoiceAddressDetails();
    }

    public String getDeliveryAddressDetails() {
        return orderDetailsPage.getDeliveryAddressDetails();
    }
}
