package steps.main;

import org.openqa.selenium.WebDriver;
import pages.main.DropdownOptionPage;
import pages.main.MenuPage;
import pages.main.components.Category;
import pages.main.components.Subcategory;
import steps.BaseStep;

import java.util.List;

public class MenuStep extends BaseStep {

    private MenuPage menuPage;


    public MenuStep(WebDriver driver) {
        super(driver);
        this.menuPage = new MenuPage(driver);
    }

    public MenuStep searchForText(String text) {
        menuPage.enterSearchText(text)
                .clickSearchButton();
        return this;
    }

    public MenuStep enterSearchText(String text) {
        menuPage.enterSearchText(text);
        return this;
    }

    public List<DropdownOptionPage> getDropdownOptions() {
        return menuPage.getDropdownOptions();
    }

    public List<Category> getCategories() {
        return menuPage.getCategories();
    }

    public List<Subcategory> getSubcategories() {
        return menuPage.getSubcategories();
    }

    public MenuStep selectCategory(String name) {
        menuPage.selectCategoryByName(name);
        return this;
    }

    public int getProductsInCartCounter() {
        return menuPage.getCartProductsCounter();
    }

    public MenuStep goToMainPage() {
        menuPage.clickMyStoreLogo();
        return this;
    }

    public MenuStep clickSignIn() {
        menuPage.clickSignIn();
        return this;
    }

    public MenuStep clickMyAccount() {
        menuPage.clickMyAccount();
        return this;
    }
}
