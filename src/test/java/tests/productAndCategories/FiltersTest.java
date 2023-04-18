package tests.productAndCategories;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tests.BaseTest;
import utils.CustomAssertion;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FiltersTest extends BaseTest {

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("ACCESSORIES", 13, 15)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void productsAreFilteredByPrice(String category, int lowerFilterRange, int upperFilterRange) {
        at.menuStep.selectCategory(category);
        int quantity = at.categoryDetailsStep.getTotalProductsCounterNumber();

        at.filterStep.changeFilterRange(lowerFilterRange, upperFilterRange);

        CustomAssertion.assertThatAllListElements(at.productGridStep.getProducts(),
                e -> e.getPrice().intValue() >= lowerFilterRange && e.getPrice().intValue() <= upperFilterRange);

        at.filterStep.clearFilters();
        assertThat(at.productGridStep.getProducts().size()).isEqualTo(quantity);
    }


}
