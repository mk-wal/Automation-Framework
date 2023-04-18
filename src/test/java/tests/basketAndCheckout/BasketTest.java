package tests.basketAndCheckout;

import configuration.UrlProvider;
import models.cart.Cart;
import models.cart.ProductLine;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class BasketTest extends BaseTest {

    @Test
    public void addMultipleProductToBasket() {
        Cart cart = new Cart();
        for (int i = 0; i < 10; i++) {
            at.menuStep.goToMainPage();
            at.productGridStep.selectRandomProduct();
            at.productDetailsStep
                    .setQuantity(new Random().nextInt(5) + 1)
                    .addToCart();
            cart.addProductLineToCart(at.productPopupStep.getProductLine());
            at.productPopupStep.clickContinueShopping();
        }
        driver.get(UrlProvider.getCartUrl());
        Cart shoppingCart = at.shoppingCartStep.getCart();
        assertThat(shoppingCart).usingRecursiveComparison().isEqualTo(cart);

        HashMap<ProductLine, BigDecimal> productsTotalPrice = at.shoppingCartStep.getTotalPriceMap();
        for (ProductLine productLine : productsTotalPrice.keySet()) {
            assertThat(productsTotalPrice.get(productLine)).isEqualTo(productLine.getTotalValueOfLine());
        }

    }

    @Test
    public void removeProducts() {
        Cart cart = new Cart();
        while (cart.getProducts().size() != 2) {
            at.menuStep.goToMainPage();
            at.productGridStep.selectRandomProduct();
            at.productDetailsStep.addToCart();
            cart.addProductLineToCart(at.productPopupStep.getProductLine());
            at.productPopupStep.clickContinueShopping();
        }
        driver.get(UrlProvider.getCartUrl());

        assertThat(at.shoppingCartStep.getSumOfProductsPrices()).isEqualTo(at.shoppingCartStep.getAllProductsTotalPrice());
        assertThat(at.shoppingCartStep.getAllProductsTotalPrice().add(at.shoppingCartStep.getShippingPrice()))
                .isEqualTo(at.shoppingCartStep.getCartTotalPrice());

        at.shoppingCartStep.getProducts().get(0).clickDeleteIcon();

        assertThat(at.shoppingCartStep.getSumOfProductsPrices()).isEqualTo(at.shoppingCartStep.getAllProductsTotalPrice());
        assertThat(at.shoppingCartStep.getAllProductsTotalPrice().add(at.shoppingCartStep.getShippingPrice()))
                .isEqualTo(at.shoppingCartStep.getCartTotalPrice());

        at.shoppingCartStep.getProducts().get(0).clickDeleteIcon();

        assertThat(at.shoppingCartStep.getSumOfProductsPrices()).isEqualTo(at.shoppingCartStep.getAllProductsTotalPrice());
        assertThat(at.shoppingCartStep.getAllProductsTotalPrice().add(at.shoppingCartStep.getShippingPrice()))
                .isEqualTo(at.shoppingCartStep.getCartTotalPrice());
        assertThat(at.shoppingCartStep.isNoItemsMessageVisible()).isTrue();
    }

}
