package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTestHW extends BaseTest {

    @Test
    public void infoAlertTest(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("[onclick='jsPrompt()']")).click();

        Alert alert = driver.switchTo().alert();

        alert.sendKeys("Test one");
        alert.accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: Test one");
    }
}
