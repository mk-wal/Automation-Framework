package tests;

import org.openqa.selenium.WebDriver;
import steps.account.AccountStep;
import steps.account.OrderDetailsStep;
import steps.cart.CheckoutStep;
import steps.cart.OrderConfirmationStep;
import steps.cart.ShoppingCartStep;
import steps.category.CategoryDetailsStep;
import steps.category.FilterStep;
import steps.main.LogInStep;
import steps.main.MenuStep;
import steps.product.ProductDetailsStep;
import steps.product.ProductGridStep;
import steps.product.ProductPopupStep;

public class Steps {
    WebDriver driver;

    public Steps(WebDriver driver) {
        this.driver = driver;
        initPages();
    }

    private void initPages() {
        menuStep = new MenuStep(driver);
        productGridStep = new ProductGridStep(driver);
        categoryDetailsStep = new CategoryDetailsStep(driver);
        filterStep = new FilterStep(driver);
        productDetailsStep = new ProductDetailsStep(driver);
        productPopupStep = new ProductPopupStep(driver);
        shoppingCartStep = new ShoppingCartStep(driver);
        logInStep = new LogInStep(driver);
        checkoutStep = new CheckoutStep(driver);
        orderConfirmationStep = new OrderConfirmationStep(driver);
        accountStep = new AccountStep(driver);
        orderDetailsStep = new OrderDetailsStep(driver);
    }

    public MenuStep menuStep;

    public ProductGridStep productGridStep;

    public CategoryDetailsStep categoryDetailsStep;

    public FilterStep filterStep;

    public ProductDetailsStep productDetailsStep;

    public ProductPopupStep productPopupStep;

    public ShoppingCartStep shoppingCartStep;

    public LogInStep logInStep;

    public CheckoutStep checkoutStep;

    public OrderConfirmationStep orderConfirmationStep;

    public AccountStep accountStep;

    public OrderDetailsStep orderDetailsStep;
}
