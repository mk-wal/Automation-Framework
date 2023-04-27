package tests.productAndCategories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.main.components.Category;
import pages.main.components.Subcategory;
import tests.BaseTest;

import java.util.List;

public class CategoriesTest extends BaseTest {

    @Test
    public void categoryShouldLoadCorrect() {
        List<Category> categories = at.menuStep.getCategories();

        Assertions.assertThat(categories.size()).isPositive();

        for (Category category : categories) {
            category.select();
            String categoryName = category.getName();

            softly.assertThat(at.categoryDetailsStep.getCategoryMainName()).isEqualTo(categoryName);
            softly.assertThat(at.filterStep.isFilterVisible()).isTrue();
            softly.assertThat(at.categoryDetailsStep.getTotalProductsCounterNumber())
                    .isEqualTo(at.productGridStep.getProductsTitles().size());
        }
    }

    @Test
    public void subcategoryShouldLoadCorrect() {
        List<Subcategory> subcategories = at.menuStep.getSubcategories();

        Assertions.assertThat(subcategories.size()).isPositive();

        for (Subcategory subcategory : subcategories) {
            subcategory.select();
            String categoryName = subcategory.getName();

            softly.assertThat(at.categoryDetailsStep.getCategoryMainName()).isEqualTo(categoryName);
            softly.assertThat(at.filterStep.isFilterVisible()).isTrue();
            softly.assertThat(at.categoryDetailsStep.getTotalProductsCounterNumber())
                    .isEqualTo(at.productGridStep.getProductsTitles().size());
        }
    }
}
