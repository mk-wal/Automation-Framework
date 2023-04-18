package steps.category;

import org.openqa.selenium.WebDriver;
import pages.category.CategoryDetailsPage;
import steps.BaseStep;

public class CategoryDetailsStep extends BaseStep {

    private CategoryDetailsPage categoryDetailsPage;


    public CategoryDetailsStep(WebDriver driver) {
        super(driver);
        this.categoryDetailsPage = new CategoryDetailsPage(driver);
    }

    public String getCategoryMainName() {
        return categoryDetailsPage.getCategoryMainName().getText();
    }

    public int getTotalProductsCounterNumber() {
        return categoryDetailsPage.getTotalProductsCounter();
    }
}
