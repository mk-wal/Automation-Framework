package steps.cart;

import models.cart.Cart;
import models.cart.Product;
import models.cart.ProductLine;
import org.openqa.selenium.WebDriver;
import pages.cart.CartProductPage;
import pages.cart.ShoppingCartPage;
import steps.BaseStep;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class ShoppingCartStep extends BaseStep {

    ShoppingCartPage shoppingCartPage;

    public ShoppingCartStep(WebDriver driver) {
        super(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    public Cart getCart() {
        Cart cart = new Cart();
        shoppingCartPage.getProducts().forEach(p -> cart.addProductLineToCart(p.getName(), p.getPrice(), p.getQuantity()));
        return cart;
    }

    public HashMap<ProductLine, BigDecimal> getTotalPriceMap() {
        HashMap<ProductLine, BigDecimal> map = new HashMap<>();
        shoppingCartPage.getProducts().forEach(p -> map.put(new ProductLine(new Product(p.getName(), p.getPrice()), p.getQuantity()), p.getTotalPrice()));
        return map;
    }

    public BigDecimal getAllProductsTotalPrice() {
        return shoppingCartPage.getAllItemsPrice();
    }

    public BigDecimal getCartTotalPrice() {
        return shoppingCartPage.getTotalCartPrice();
    }

    public BigDecimal getShippingPrice() {
        return shoppingCartPage.getShippingPrice();
    }

    public BigDecimal getSumOfProductsPrices() {
        BigDecimal total = new BigDecimal("0.00");
        for (BigDecimal price : shoppingCartPage.getListOfItemsPrices()) {
            total = total.add(price);
        }
        return total;
    }

    public List<CartProductPage> getProducts() {
        return shoppingCartPage.getProducts();
    }

    public boolean isNoItemsMessageVisible() {
        return shoppingCartPage.isNoItemsMessageVisible();
    }

    public ShoppingCartStep clickProceedToCheckout() {
        shoppingCartPage.clickProceedToCheckout();
        return this;
    }
}
