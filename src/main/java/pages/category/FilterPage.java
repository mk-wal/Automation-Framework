package pages.category;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class FilterPage extends BasePage {
    public FilterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".faceted-slider")
    private WebElement facetedSlider;

    @FindBy(css = ".ui-slider")
    private WebElement slider;

    @FindBy(css = ".ui-slider-handle:first-of-type")
    private WebElement leftSlider;

    @FindBy(css = ".ui-slider-handle:last-of-type")
    private WebElement rightSlider;

    @FindBy(xpath = "//p[contains(@id, 'facet_label')]")
    private WebElement priceRange;

    @FindBy(css = ".spinner")
    private WebElement spinner;

    @FindBy(css = "#search_filters")
    private WebElement filters;

    @FindBy(css = "#_desktop_search_filters_clear_all button")
    private WebElement clearAllFiltersButton;


    public boolean isFilterVisible() {
        return isVisible(filters);
    }

    public int getSliderMin() {
        return Integer.parseInt(facetedSlider.getAttribute("data-slider-min"));
    }

    public int getSliderMax() {
        return Integer.parseInt(facetedSlider.getAttribute("data-slider-max"));
    }

    private int getSliderSingleMovePxValue() {
        return slider.getSize().width / (getSliderMax() - getSliderMin());
    }

    public int getLeftSliderValue() {
        String[] prices = priceRange.getText().split("-");
        return getNumericFromStringWithDot(prices[0]);
    }

    public int getRightSliderValue() {
        String[] prices = priceRange.getText().split("-");
        return getNumericFromStringWithDot(prices[1]);
    }

    public FilterPage changeSliderRange(int start, int end) {
        moveSlider(leftSlider, (start - getLeftSliderValue()) * getSliderSingleMovePxValue());
        waitForElementToDisappear(spinner);
        moveSlider(rightSlider, (end - getRightSliderValue()) * getSliderSingleMovePxValue());
        waitForElementToDisappear(spinner);
        return this;
    }

    private void moveSlider(WebElement element, int xOffset) {
        actions.dragAndDropBy(element, xOffset, 0).perform();
    }

    public FilterPage clickOnClearFiltersButton() {
        clearAllFiltersButton.click();
        waitForElementToDisappear(spinner);
        return this;
    }

}
