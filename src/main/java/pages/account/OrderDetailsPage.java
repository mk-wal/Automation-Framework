package pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.math.BigDecimal;

public class OrderDetailsPage extends BasePage {
    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#order-history td:first-of-type")
    private WebElement date;

    @FindBy(css = "#order-history td:last-of-type")
    private WebElement status;

    @FindBy(xpath = "//*[@id='order-products']//td[contains(text(), 'Total')]/following-sibling::td")
    private WebElement totalPrice;

    @FindBy(css = "#invoice-address")
    private WebElement invoiceAddressDetails;

    @FindBy(css = "#delivery-address")
    private WebElement deliveryAddressDetails;

    public String getDate() {
        return date.getText();
    }

    public String getStatus() {
        return status.getText();
    }

    public BigDecimal getTotalPrice() {
        return parsePriceToBigDecimal(totalPrice.getText());
    }

    public String getInvoiceAddressDetails() {
        return invoiceAddressDetails.getText();
    }

    public String getDeliveryAddressDetails() {
        return deliveryAddressDetails.getText();
    }
}
