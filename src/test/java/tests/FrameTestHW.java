package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTestHW extends BaseTest {

    @Test
    public void frameTest(){
        driver.get("http://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(driver.findElement(By.cssSelector(".tox-edit-area__iframe")));
        Assert.assertEquals(driver.findElement(By.id("tinymce")).getText(), "Your content goes here.");
    }

}
