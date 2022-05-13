package tests;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import services.BrowsersService;

public class LoginTest {
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
    public void successLoginPage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPswInput().sendKeys(ReadProperties.password());
        loginPage.getLogButtonInput().click();
    }

    @Test
    public void incorrectEmailLoginPage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPswInput().sendKeys(ReadProperties.password());
        loginPage.getLogButtonInput().click();
    }

    @Test
    public void incorrectPswLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPswInput().sendKeys(ReadProperties.password());
        loginPage.getLogButtonInput().click();
    }


}
