package pages.main.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class Category {

    private String name;

    private String id;

    private WebDriver driver;

    private HashMap<String, String> categoriesMap = new HashMap<>();

    public Category(WebDriver driver, String name, String id) {
        this.driver = driver;
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void select() {
        driver.findElement(By.id(id)).click();
    }

    public void putCategoriesMap(List<WebElement> categories) {
        categories.forEach(c -> categoriesMap.put(c.getText(), c.getAttribute("id")));
    }


}
