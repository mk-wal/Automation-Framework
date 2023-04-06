package pages.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.product.ProductPage;

import java.util.List;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[type='text']")
    private WebElement searchInput;

    @FindBy(css = "button[type='submit']")
    WebElement searchLoopSubmitButton;

    @FindBy(css = ".ui-autocomplete li")
    List<WebElement> dropdownFields;

    @FindBy(css = "#top-menu > li")
    List<WebElement> categories;

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

    public List<WebElement> getDropdownFields() {
        return dropdownFields;
    }

    public List<WebElement> getCategories() {
//        actions.moveToElement(categories.get(0)).perform();
//        return categories.stream().map(el -> new CategoryPage(driver, el)).toList();
        return categories;
    }
}
