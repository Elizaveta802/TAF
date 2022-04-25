package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class XpathSelectots {

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
    public void basicXPatchSelectors(){
        driver.get(ReadProperties.getUrl());

        // Абсолютный xpath
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[1]/div/div[2]")).isDisplayed());

        // Все эелемнты на странице начина с HTML
        driver.findElements(By.xpath("//*"));

        //Аналог поиска по tegName
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

        //Поиск родительского div  и на уровень ниже h1
        Assert.assertTrue(driver.findElement(By.xpath("//div/h1")).isDisplayed());

        //Поиск родительского div  и на любом уровне ниже div
        Assert.assertTrue(driver.findElement(By.xpath("//div//div")).isDisplayed());

        //Поиск элемента с тэгом div у которого есть атрибут id
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());

        //Поиск элемента у которого есть атрибут id со значением 'top-logo'
        Assert.assertTrue(driver.findElement(By.xpath("//div*[@id='top-logo']")).isDisplayed());

        //Поиск элемента у которого есть method со значением 'post' and '_blank
        Assert.assertTrue(driver.findElement(By.xpath("//*[@method='post' and @target='_blank]")).isDisplayed());

        //Поиск элемента у которого значение атрибута начинается с 'new'
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@id,'new')]")).isDisplayed());

        //Поиск элемента у которого значение атрибута содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id,'Template')]")).isDisplayed());

        //Поиск элемента у которого текстовое значение содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='All Projects']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[. ='Todos']")).isDisplayed());

        //Поиск элемента у которого текстовое значение содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text()='All Projects')]")).isDisplayed());
        //или div заменить на *(любой тэг)

        //Поиск элемента по индексу
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'summary-links text-secondary']/a[2]")).isDisplayed());

    }

    @Test
    public void axesXPathTest(){
        driver.get(ReadProperties.getUrl());

        //Поиск родителя у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/..")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h1/parent::div")).isDisplayed());

        //Поиск всех предков с тэгом div у элемента с тэгом hq
        Assert.assertTrue(driver.findElement(By.xpath("//h1/ancestor::div")).isDisplayed());

        //Использование child всех дочерних элементов с тэгом а от div
        Assert.assertTrue(driver.findElement(By.xpath("//div/child::a")).isDisplayed());

        //Использование following Выбирает все в документе после закрытие тэга текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following::form")).isDisplayed());

        //Использование following Выбирает все узлы, которые появляются перед текущим узлом в документе
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/pr::form")).isDisplayed());

        //Использование following-sibling Выбирает все в документе до закрытие тэга текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following-sibling::form")).isDisplayed());

    }
}
