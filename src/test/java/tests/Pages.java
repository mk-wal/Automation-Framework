package tests;

import org.openqa.selenium.WebDriver;
import steps.category.CategoryViewStep;
import steps.menu.MenuStep;
import steps.product.ProductGridStep;

public class Pages {
    WebDriver driver;

    public Pages(WebDriver driver) {
        this.driver = driver;
        initPages();
    }

    private void initPages() {
        menuStep = new MenuStep(driver);
        productGridStep = new ProductGridStep(driver);
        categoryViewStep = new CategoryViewStep(driver);
    }

    public MenuStep menuStep;
    public ProductGridStep productGridStep;

    public CategoryViewStep categoryViewStep;
}
