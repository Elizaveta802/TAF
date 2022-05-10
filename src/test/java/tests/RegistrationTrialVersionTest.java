package tests;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationTrialVersionPage;
import services.BrowsersService;

public class RegistrationTrialVersionTest {
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
    public void successRegistrationTrialVersionTest(){
        RegistrationTrialVersionPage registrationTrialVersionPage = new RegistrationTrialVersionPage(driver);
        //registrationTrialVersionPage.getCookieButton().click();
        registrationTrialVersionPage.getWebAddressInput().sendKeys(ReadProperties.webAddress());
        registrationTrialVersionPage.getFirstNameInput().sendKeys(ReadProperties.firstName());
        registrationTrialVersionPage.getLastNameInput().sendKeys(ReadProperties.lastName());
        registrationTrialVersionPage.getWorkEmailInput().sendKeys(ReadProperties.workEmail());
       //registrationTrialVersionPage.getExpectedUsersButton().click();
       // registrationTrialVersionPage.getTosButton().click();
       //registrationTrialVersionPage.getGdprButton().click();
       // registrationTrialVersionPage.getCreateTestRailTrialButton().click();
    }

    @Test
    public void incorrectWebAddressRegistrationTrialVersionTest(){
        RegistrationTrialVersionPage registrationTrialVersionPage = new RegistrationTrialVersionPage(driver);
       // registrationTrialVersionPage.getCookieButton().click();
        registrationTrialVersionPage.getWebAddressInput().sendKeys(ReadProperties.webAddress());
        registrationTrialVersionPage.getFirstNameInput().sendKeys(ReadProperties.firstName());
        registrationTrialVersionPage.getLastNameInput().sendKeys(ReadProperties.lastName());
        registrationTrialVersionPage.getWorkEmailInput().sendKeys(ReadProperties.workEmail());
        registrationTrialVersionPage.getOrganizationInput().sendKeys(ReadProperties.organization());
        registrationTrialVersionPage.getExpectedUsersButton().click();
        registrationTrialVersionPage.getTosButton().click();
        registrationTrialVersionPage.getGdprButton().click();
        registrationTrialVersionPage.getCreateTestRailTrialButton().click();
    }

    @Test
    public void incorrectWorkEmailRegistrationTrialVersionTest(){
       // RegistrationTrialVersionPage registrationTrialVersionPage = new RegistrationTrialVersionPage(driver);
       // registrationTrialVersionPage.getCookieButton().click();
       // registrationTrialVersionPage.getWebAddressInput().sendKeys(ReadProperties.webAddress());
       // registrationTrialVersionPage.getFirstNameInput().sendKeys(ReadProperties.firstName());
       // registrationTrialVersionPage.getLastNameInput().sendKeys(ReadProperties.lastName());
       // registrationTrialVersionPage.getWorkEmailInput().sendKeys(ReadProperties.workEmail());
       // registrationTrialVersionPage.getOrganizationInput().sendKeys(ReadProperties.organization());
       // registrationTrialVersionPage.getExpectedUsersButton().click();
       // registrationTrialVersionPage.getTosButton().click();
       // registrationTrialVersionPage.getGdprButton().click();
        //registrationTrialVersionPage.getCreateTestRailTrialButton().click();
    }
}
