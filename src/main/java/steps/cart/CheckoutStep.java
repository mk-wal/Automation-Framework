package steps.cart;

import models.address.Address;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.cart.CheckoutPage;
import steps.BaseStep;

import java.util.List;

public class CheckoutStep extends BaseStep {

    CheckoutPage checkoutPage;

    public CheckoutStep(WebDriver driver) {
        super(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    public CheckoutStep clickDiffersBillingAddressLink() {
        checkoutPage.clickDiffersBillingAddressLink();
        return this;
    }

    public CheckoutStep fillShippingAddress(String address, String city, String postcode, String state) {
        checkoutPage.inputAddress(address)
                .inputCity(city)
                .inputPostcode(postcode)
                .selectState(state)
                .clickContinueShippingAddress();
        return this;
    }

    public CheckoutStep selectShippingMethod() {
        checkoutPage.clickContinueShippingMethod();
        return this;
    }

    public CheckoutStep fillShippingAddress(Address address) {
        return fillShippingAddress(address.address(), address.city(), address.postalCode(), address.state());
    }

    public CheckoutStep clearInvoiceAddresses() {
        List<WebElement> deleteIcons = checkoutPage.getInvoiceAddressDeleteIcons();
        for (int i = deleteIcons.size() - 1; i > 0; i--) {
            deleteIcons.get(i).click();
        }
        return this;
    }

    public CheckoutStep selectPaymentMethod() {
        checkoutPage.clickPayByCheck()
                .acceptTermOfService();
        return this;
    }

    public CheckoutStep placeOrder() {
        checkoutPage.clickPlaceOrderButton();
        return this;
    }

}
