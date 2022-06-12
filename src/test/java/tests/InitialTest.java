package tests;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InitialPage;
import services.BrowsersService;

public class InitialTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new BrowsersService().getDriver();
        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void successInitialTest(){
        InitialPage initialPage = new InitialPage(driver);
        initialPage.getCookieButton().click();
        initialPage.getTryForFreeButton().click();
    }
}
