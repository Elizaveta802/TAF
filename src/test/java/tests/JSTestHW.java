package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JSTestHW extends BaseTest {

    @Test
    public void updateJSTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        jsExecutor.executeScript("history.go(0)");

        Thread.sleep(5000);
    }

    @Test
    public void titleTextJSTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/jqueryui/menu#");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        Thread.sleep(5000);
    }

    @Test
    public void scrollJSTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/jqueryui/menu#");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String titleText =  jsExecutor.executeScript("return document.title;").toString();
        System.out.println(titleText);

        Thread.sleep(5000);
    }

    @Test
    public void newWindowJSTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/jqueryui/menu#");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        jsExecutor.executeScript("alert('Welcome To Selenium Testing');");

        Thread.sleep(5000);
    }
}