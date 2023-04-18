package pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[data-link-action='different-invoice-address']")
    private WebElement differsBillingAddressLink;

    @FindBy(css = "input[name='address1']")
    private WebElement addressInput;

    @FindBy(css = "input[name='city']")
    private WebElement cityInput;

    @FindBy(css = "input[name='postcode']")
    private WebElement postcodeInput;

    @FindBy(css = "select[name='id_state']")
    private WebElement stateSelect;

    @FindBy(css = "#invoice-address button[type='submit']")
    private WebElement continueShippingAddressButton;

    @FindBy(css = "#invoice-addresses .delete-address")
    private List<WebElement> invoiceAddressDeleteIcons;

    @FindBy(css = "#checkout-delivery-step button[type='submit']")
    private WebElement continueShippingMethodButton;

    @FindBy(css = "#payment-option-1")
    private WebElement payByCheckInput;

    @FindBy(css = "[id='conditions_to_approve[terms-and-conditions]']")
    private WebElement termOfServiceCheckbox;

    @FindBy(css = "#payment-confirmation button[type='submit']")
    private WebElement placeOrderButton;

    public CheckoutPage clickDiffersBillingAddressLink() {
        differsBillingAddressLink.click();
        return this;
    }

    public CheckoutPage inputAddress(String address) {
        addressInput.sendKeys(address);
        return this;
    }

    public CheckoutPage inputCity(String city) {
        cityInput.sendKeys(city);
        return this;
    }

    public CheckoutPage inputPostcode(String postcode) {
        postcodeInput.sendKeys(postcode);
        return this;
    }

    public CheckoutPage selectState(String state) {
        new Select(stateSelect).selectByVisibleText(state);
        return this;
    }

    public CheckoutPage clickContinueShippingAddress() {
        continueShippingAddressButton.click();
        return this;
    }

    public List<WebElement> getInvoiceAddressDeleteIcons() {
        return invoiceAddressDeleteIcons;
    }

    public CheckoutPage clickContinueShippingMethod() {
        continueShippingMethodButton.click();
        return this;
    }

    public CheckoutPage clickPayByCheck() {
        payByCheckInput.click();
        return this;
    }

    public CheckoutPage acceptTermOfService() {
        termOfServiceCheckbox.click();
        return this;
    }

    public CheckoutPage clickPlaceOrderButton() {
        placeOrderButton.click();
        return this;
    }
}
