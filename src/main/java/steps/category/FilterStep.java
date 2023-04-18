package steps.category;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import pages.category.FilterPage;
import steps.BaseStep;

public class FilterStep extends BaseStep {

    private FilterPage filterPage;

    public FilterStep(WebDriver driver) {
        super(driver);
        filterPage = new FilterPage(driver);
    }


    public boolean isFilterVisible() {
        return filterPage.isFilterVisible();
    }


    public FilterStep changeFilterRange(int start, int end) {
        validateProvidedRange(start, end);
        filterPage.changeSliderRange(start, end);
        return this;
    }

    public FilterStep clearFilters() {
        filterPage.clickOnClearFiltersButton();
        return this;
    }

    @SneakyThrows
    private void validateProvidedRange(int start, int end) {
        if (start > end) {
            throw new Exception("Lower bound is bigger than upper bound.");
        }
        if (start < filterPage.getSliderMin() || end > filterPage.getSliderMax()) {
            throw new Exception("One of bounds is out of range.");
        }
    }
}
