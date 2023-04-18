package pages.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.main.components.Category;
import pages.main.components.Subcategory;

import java.util.List;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[type='text']")
    private WebElement searchInput;

    @FindBy(css = "button[type='submit']")
    private WebElement searchLoopSubmitButton;

    @FindBy(css = ".ui-autocomplete li")
    private List<WebElement> dropdownFields;

    @FindBy(css = "#top-menu > li")
    private List<WebElement> categories;

    @FindBy(css = "#top-menu > li li")
    private List<WebElement> subcategories;

    @FindBy(css = ".header .cart-products-count")
    private WebElement cartProductsCounter;

    @FindBy(css = ".logo")
    private WebElement myStoreLogo;

    @FindBy(css = ".user-info .hidden-sm-down")
    private WebElement signInButton;

    @FindBy(css = ".account")
    private WebElement account;

    public MenuPage enterSearchText(String text) {
        searchInput.sendKeys(text);
        return this;
    }

    public MenuPage clickSearchButton() {
        searchLoopSubmitButton.click();
        return this;
    }

    public List<DropdownOptionPage> getDropdownOptions() {
        return dropdownFields.stream().map(el -> new DropdownOptionPage(driver, el)).toList();
    }

    public List<Category> getCategories() {
        return categories.stream().map(c -> new Category(driver, c.getText(), c.getAttribute("id"))).toList();
    }

    public MenuPage selectCategoryByName(String name) {
        getCategories().stream().filter(c -> c.getName().equals(name)).toList().get(0).select();
        return this;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories.stream().map(s -> new Subcategory(s.getAttribute("id"), driver, actions)).toList();
    }

    public int getCartProductsCounter() {
        return getNumericFromString(cartProductsCounter.getText());
    }

    public MenuPage clickMyStoreLogo() {
        myStoreLogo.click();
        return this;
    }

    public MenuPage clickSignIn() {
        signInButton.click();
        return this;
    }

    public MenuPage clickMyAccount() {
        account.click();
        return this;
    }
}
