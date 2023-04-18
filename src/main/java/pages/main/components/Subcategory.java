package pages.main.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Subcategory {

    private String id;

    private WebDriver driver;

    private Actions action;

    private String name;


    public Subcategory(String id, WebDriver driver, Actions action) {
        this.id = id;
        this.driver = driver;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void select() {
        hoverOverParentCategory();
        updateSubcategoryName();
        clickSubcategory();
    }

    private void hoverOverParentCategory() {
        action.moveToElement(driver.findElement(By.xpath("//*[@id='" + id + "']/ancestor::li"))).perform();
    }

    private void clickSubcategory() {
        driver.findElement(By.id(id)).click();
    }

    private void updateSubcategoryName() {
        name = driver.findElement(By.id(id)).getText();
    }
}
