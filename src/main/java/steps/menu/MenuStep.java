package steps.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.menu.DropdownOptionPage;
import pages.menu.MenuPage;
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

    public List<WebElement> getCategories() {
        return menuPage.getCategories();
    }
}
