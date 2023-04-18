package tests.basketAndCheckout;

import models.address.Address;
import models.address.AddressFactory;
import models.status.Status;
import models.user.User;
import models.user.UserFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tests.BaseTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckoutTest extends BaseTest {

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(UserFactory.getAlreadyRegisteredUser(), "THE BEST IS YET POSTER",
                        AddressFactory.getInvoiceAddress(), AddressFactory.getHomeAddress())
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void orderDetailsShouldContainsCorrectData(User user, String productTitle, Address invoiceAddress, Address deliveryAddress) {
        at.menuStep.clickSignIn();
        at.logInStep.logIn(user);
        at.menuStep.goToMainPage();
        at.productGridStep.selectProductWithTitle(productTitle);
        at.productDetailsStep.addToCart();
        at.productPopupStep.clickProceedToCheckout();

        BigDecimal totalPrice = at.shoppingCartStep.getCartTotalPrice();

        at.shoppingCartStep.clickProceedToCheckout();
        at.checkoutStep
                .clickDiffersBillingAddressLink()
                .clearInvoiceAddresses()
                .fillShippingAddress(invoiceAddress)
                .selectShippingMethod()
                .selectPaymentMethod()
                .placeOrder();

        String orderReferenceNumber = at.orderConfirmationStep.getOrderReferenceNumber();

        at.menuStep.clickMyAccount();
        at.accountStep
                .openOrderHistory()
                .openOrderDetails(orderReferenceNumber);

        assertThat(at.orderDetailsStep.getStatus()).isEqualTo(Status.AWAITING.getValue());
        assertThat(at.orderDetailsStep.getOrderDate()).isEqualTo(LocalDate.now());
        assertThat(at.orderDetailsStep.getTotalPrice()).isEqualTo(totalPrice);
        assertThat(invoiceAddress.ifStringContainsAllFields(at.orderDetailsStep.getInvoiceAddressDetails())).isTrue();
        assertThat(deliveryAddress.ifStringContainsAllFields(at.orderDetailsStep.getDeliveryAddressDetails())).isTrue();
    }
}
