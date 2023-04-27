package tests.basketAndCheckout;

import models.cart.ProductLine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tests.BaseTest;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductTest extends BaseTest {

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("ART", "THE BEST IS YET POSTER", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void shouldSuccessfullyAddProductToCart(String category, String productTitle, int quantity) {
        at.menuStep.selectCategory(category);
        ProductLine productLine = new ProductLine(at.productGridStep.getProductWithTitle(productTitle), quantity);
        at.productGridStep.selectProductWithTitle(productTitle);
        at.productDetailsStep
                .setQuantity(quantity)
                .addToCart();
        ProductLine popupLine = at.productPopupStep.getProductLine();

        softly.assertThat(popupLine).usingRecursiveComparison().isEqualTo(productLine);
        softly.assertThat(at.productPopupStep.getProductCount()).isEqualTo(quantity);
        softly.assertThat(at.productPopupStep.getProductSubtotal()).isEqualTo(popupLine.getTotalValueOfLine());

        at.productPopupStep.clickContinueShopping();
        assertThat(at.menuStep.getProductsInCartCounter()).isEqualTo(quantity);
    }
}
