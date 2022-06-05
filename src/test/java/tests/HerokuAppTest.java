package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
                .contextClick()
                .build()
                .perform();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        
        alert.accept();
    }

    @Test
    public void DynamicControlsTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        Actions actions = new Actions(driver);
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement targetElement = wait.waitForVisibilityLocatedBy(By.cssSelector("[label='blah']"));
        actions.moveToElement(targetElement)
                .click()
                .build()
                .perform();


        WebElement remove = wait.waitForVisibilityLocatedBy(By.cssSelector("[onclick='swapCheckbox()']"));
        actions.click(remove)
                .build()
                .perform();

        WebElement loader = wait.waitForVisibilityLocatedBy(By.cssSelector("[src='/img/ajax-loader.gif']"));
        loader.isDisplayed();

        Assert.assertTrue(wait.waitForElementInvisible(targetElement));

        WebElement input = wait.waitForVisibilityLocatedBy(By.cssSelector("[type='text']"));
        actions.click(input)
                .build()
                .perform();

        Assert.assertTrue(wait.waitForVisibilityLocatedBy(By.xpath("//*[@disabled]")).isDisplayed());

        WebElement enabledButton = wait.waitForVisibilityLocatedBy(By.xpath("//form/button[contains(text(), 'Enable')]"));
        enabledButton.click();

        WebElement enabledMessage = wait.waitForVisibilityLocatedBy(By.cssSelector("[id='message']"));

        Assert.assertTrue(wait.waitForVisibility(input).isEnabled());
    }

    @Test
    public void FileUploadTest(){
        driver.get("http://the-internet.herokuapp.com/upload");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement fileUploadPath = wait.waitForVisibilityLocatedBy(By.cssSelector("[id=file-upload]"));
        fileUploadPath.sendKeys("E:\\java\\lessons\\TAF\\src\\test\\resources\\text1.txt");
        wait.waitForExists(By.id("file-submit")).submit();
        Assert.assertEquals(wait.waitForVisibilityLocatedBy(By.id("uploaded-files")).getText(), "text1.txt");
    }

    @Test
    public void FramesTest(){
        driver.get("http://the-internet.herokuapp.com/iframe");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        driver.switchTo().frame(driver.findElement(By.cssSelector(".tox-edit-area__iframe")));

        Assert.assertEquals(wait.waitForVisibilityLocatedBy(By.cssSelector("[id='tinymce']")).getText(), "Your content goes here.");
    }

    @Test
    public void JavaScriptAlertsTest(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement clickForJSConfirmLocator = wait.waitForVisibilityLocatedBy(By.cssSelector("[onclick='jsConfirm()']"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", clickForJSConfirmLocator);

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertEquals(wait.waitForVisibilityLocatedBy(By.cssSelector("[id='result']")).getText(), "You clicked: Ok");
    }

    @Test
    public void JavaScriptExecutorTest(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("history.go(0)");

        String url=  javascriptExecutor.executeScript("return document.URL;").toString();
        System.out.println(url);

        String domainName=  javascriptExecutor.executeScript("return document.domain;").toString();
        System.out.println(domainName);

        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    }
}
