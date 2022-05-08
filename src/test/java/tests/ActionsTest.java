package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;
import java.util.List;

public class ActionsTest extends BaseTest {

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        List<WebElement> targetElements = wait.waitForAllVisibleElementsLocatedBy(By.cssSelector(".figure"));
        actions
                .moveToElement(targetElements.get(0), 10, 10)
                .click(wait.waitForExists(By.cssSelector("[href='/users/1']")))
                .build()
                .perform();
    }
}
