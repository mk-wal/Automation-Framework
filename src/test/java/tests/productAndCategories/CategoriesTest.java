package tests.productAndCategories;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.menu.MenuPage;
import tests.BaseTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CategoriesTest extends BaseTest {

//    @Test
    public void test() {
        List<WebElement> categories = at.menuStep.getCategories();
        for(WebElement category : categories) {


            String categoryName = category.getText();
            category.click();
            System.out.println(categoryName);

            String title = at.categoryViewStep.getCategoryTitle();
            assertThat(title).isEqualTo(categoryName);
        }
    }
}
