package tests.productAndCategories;

import org.junit.jupiter.api.Test;
import pages.main.components.Category;
import pages.main.components.Subcategory;
import tests.BaseTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CategoriesTest extends BaseTest {

    @Test
    public void categoryShouldLoadCorrect() {
        List<Category> categories = at.menuStep.getCategories();
        for (Category category : categories) {
            category.select();
            String categoryName = category.getName();
            assertThat(at.categoryDetailsStep.getCategoryMainName()).isEqualTo(categoryName);
            assertThat(at.filterStep.isFilterVisible()).isTrue();
            assertThat(at.categoryDetailsStep.getTotalProductsCounterNumber())
                    .isEqualTo(at.productGridStep.getProductsTitles().size());
        }
    }

    @Test
    public void subcategoryShouldLoadCorrect() {
        List<Subcategory> subcategories = at.menuStep.getSubcategories();
        for (Subcategory subcategory : subcategories) {
            subcategory.select();
            String categoryName = subcategory.getName();
            assertThat(at.categoryDetailsStep.getCategoryMainName()).isEqualTo(categoryName);
            assertThat(at.filterStep.isFilterVisible()).isTrue();
            assertThat(at.categoryDetailsStep.getTotalProductsCounterNumber())
                    .isEqualTo(at.productGridStep.getProductsTitles().size());
        }
    }
}
