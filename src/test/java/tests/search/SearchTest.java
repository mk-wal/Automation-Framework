package tests.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.main.DropdownOptionPage;
import tests.BaseTest;

import java.util.List;


public class SearchTest extends BaseTest {

    @Test
    public void filteringProductsByTitle() {
        String randomTitle = at.productGridStep.getRandomProductTitle();
        at.menuStep.searchForText(randomTitle);
        List<String> productTitlesAfterSearch = at.productGridStep.getProductsTitles();

        Assertions.assertThat(productTitlesAfterSearch).allMatch(e -> e.contains(randomTitle));
    }

    @ParameterizedTest
    @ValueSource(strings = {"HUMMINGBIRD"})
    public void searchDropdownOptionsContainsTypedValue(String textToSearch) {
        List<DropdownOptionPage> dropdownOptions =
                at.menuStep
                        .enterSearchText(textToSearch)
                        .getDropdownOptions();

        Assertions.assertThat(dropdownOptions).allMatch(e -> e.containsText(textToSearch));
    }
}
