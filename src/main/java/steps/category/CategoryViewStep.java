package steps.category;

import org.openqa.selenium.WebDriver;
import pages.category.CategoryViewPage;
import steps.BaseStep;

public class CategoryViewStep extends BaseStep {

    private CategoryViewPage categoryViewPage;

    public CategoryViewStep(WebDriver driver) {
        super(driver);
        categoryViewPage = new CategoryViewPage(driver);
    }

    public String getCategoryTitle() {
        return categoryViewPage.getCategoryTitle().getText();
    }
}
