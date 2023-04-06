package tests.search;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.menu.DropdownOptionPage;
import tests.BaseTest;
import utils.CustomAssertion;

import java.util.List;

public class SearchTest extends BaseTest {

    @Test
    public void filteringProductsByTitle() {
        String randomTitle = at.productGridStep.getRandomProductTitle();
        at.menuStep.searchForText(randomTitle);
        List<String> productTitlesAfterSearch = at.productGridStep.getProductsTitles();

        CustomAssertion.assertThatAllListElements(productTitlesAfterSearch, e -> e.contains(randomTitle));
    }

    @ParameterizedTest
    @ValueSource(strings = {"HUMMINGBIRD"})
    public void searchDropdownOptionsContainsTypedValue(String textToSearch) {
        List<DropdownOptionPage> dropdownOptions = at.menuStep
                .enterSearchText(textToSearch)
                .getDropdownOptions();

        CustomAssertion.assertThatAllListElements(dropdownOptions, e -> e.containsText(textToSearch));
    }
}
