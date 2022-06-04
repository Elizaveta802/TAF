package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class HerokuAppTest extends BaseTest {

    @Test
    public void ContextMenuTest(){
        driver.get("http://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement targetElement = wait.waitForVisibilityLocatedBy(By.id("hot-spot"));
        actions.moveToElement(targetElement)
                .contextClick(targetElement)
                .build()
                .perform();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        
        alert.accept();
    }

    @Test
    public void DynamicControlsTest(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        Actions actions = new Actions(driver);
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(1000));

        WebElement targetElement = wait.waitForVisibilityLocatedBy(By.cssSelector("[label='blah']"));
        actions.moveToElement(targetElement)
                .click(targetElement)
                .build()
                .perform();
        WebElement remove = wait.waitForVisibilityLocatedBy(By.cssSelector("[onclick='swapCheckbox()']"));
        actions.moveToElement(remove)
                .click(remove)
                .build()
                .perform();
        //Assert.assertEquals(By.cssSelector("[id='message']"), "It's gone!");
    }
}
