package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class CssSelectorsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new BrowsersService().getDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void cssSelectorsTest()  {
        driver.get("E:\\java\\lessons\\TAF\\src\\test\\resources\\index.html");

        //Поиск по ID
        Assert.assertTrue(driver.findElement(By.cssSelector("#my-Address")).isDisplayed());

        //Поиск по class name
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter")).isDisplayed());

        //Поиск по нескольким значениям в атрибуте class
        Assert.assertTrue(driver.findElement(By.cssSelector(".noSel.newsletter")).isDisplayed());

        //Поиск по tag name
        Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed());

        //Поиск по tag and значению из атрибута class
        Assert.assertTrue(driver.findElement(By.cssSelector("div.intro")).isDisplayed());

        //Поиск по tag and значению из атрибута class
        Assert.assertEquals(2, driver.findElements(By.cssSelector("#Lastname .markup")).size());

        //Поиск всех элементов с тэгом h1 или р
        Assert.assertEquals(8, driver.findElements(By.cssSelector("h1, p")).size());

        //Поиск всех элементов с тэгом р у которых непосредственный родитель с тегом div
        Assert.assertEquals(6, driver.findElements(By.cssSelector("div > p")).size());

        //Поиск всех элементов с тэгом р у которые идут сразу за элементом с тэгом ul
        Assert.assertEquals(1, driver.findElements(By.cssSelector("ul + p")).size());

        //Поиск всех элементов с тэгом div которые являются братьями элементу с тэгом р
        Assert.assertEquals(2, driver.findElements(By.cssSelector("p ~ div")).size());

        //Поиск всех элементов у которых пресутствует аттрибут title
        Assert.assertEquals(2, driver.findElements(By.cssSelector("[title]]")).size());

        // Поиск всех элементов у которых присутствует аттрибут style с конкретным значением
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style='overflow: auto;']")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением заканчивающимся на какое-то value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id$=ess]")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то value-
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=my]")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id^=L]")).size());

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим слово целиком
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title~=beautiful]")).size());

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим какой-то тест слово целиком
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title*=beautif]")).size());

        // Поиск всех disabled элементов
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":disabled")).size());

        // Поиск всех enabled элементов
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":enabled")).size());

        // Поиск всех выборанных элементов
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":checked")).size());

        // Поиск всех элементов c пустым телом
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":empty")).size());

        // Поиск элемента с тэгом p и которым является первым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:first-child")).size());

        // Поиск элемента с тэгом p и которым является последним дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:last-child")).size());

        // Поиск элемента с тэгом p и которым является n-ым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:nth-child(2)")).size());

    }
}
