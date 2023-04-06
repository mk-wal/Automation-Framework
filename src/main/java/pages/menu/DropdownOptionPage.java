package pages.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class DropdownOptionPage extends BasePage {
    public DropdownOptionPage(WebDriver driver, WebElement parent) {
        super(driver, parent);
    }

    @FindBy(css = ".category")
    private WebElement category;

    @FindBy(css = ".product")
    private WebElement product;

    public boolean containsText(String text) {
        return category.getText().contains(text) || product.getText().contains(text);
    }
}
