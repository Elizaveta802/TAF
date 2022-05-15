package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    @Test
    public void frameTest(){
        driver.get("http://the-internet.herokuapp.com/iframe");

        //driver.switchTo().frame(0);//нахождение фрейма по порядковому номеру
        //driver.switchTo().frame("mce_0_ifr");//нахождение фрейма по Id or Name
        driver.switchTo().frame(driver.findElement(By.cssSelector(".tox-edit-area__iframe")));//нахождение фрейма по Web
        Assert.assertTrue(driver.findElement(By.id("tinymce")).isDisplayed());

        driver.switchTo().parentFrame();//переключение на родительский фрейм(на один уровень выше)
        driver.switchTo().defaultContent();//переключение сразу на начальную страницу

        Assert.assertTrue(driver.findElement(By.className("tox-editor-container")).isDisplayed());


    }

}
