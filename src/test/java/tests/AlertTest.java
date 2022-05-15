package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    @Test
    public void infoAlertTest(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();

        Alert alert = driver.switchTo().alert();//переключение на этот обьект
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();//принимает

    }

    @Test
    public void confirmationAlertTest(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick = 'jsConfirm()']")).click();

        Alert alert = driver.switchTo().alert();//переключение на этот обьект

        Assert.assertEquals(alert.getText(), "I am a JS Confirm");

        alert.accept();//отклонить

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Ok");

    }

    @Test
    public void confirmationDeclineAlertTest(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick = 'jsConfirm()']")).click();

        Alert alert = driver.switchTo().alert();//переключение на этот обьект

        Assert.assertEquals(alert.getText(), "I am a JS Confirm");

        alert.dismiss();//отклонить

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");

    }

    @Test
    public void promptAlertTest(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick = 'jsPrompt()']")).click();

        Alert alert = driver.switchTo().alert();//переключение на этот обьект

        alert.sendKeys("Test message!!!");
        alert.accept();//отклонить

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: Test message!!!");

    }

}
