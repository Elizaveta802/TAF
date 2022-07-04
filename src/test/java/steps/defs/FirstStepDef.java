package steps.defs;

import configuration.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import services.BrowsersService;

public class FirstStepDef {
    WebDriver driver;
    LoginPage loginPage;

    @Given("Открыт браузер")
    public void openBrowser() {
        System.out.println("Открываю браузер");
        driver = new BrowsersService().getDriver();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @When("login page is opened")
    public void loginPageIsOpened() {
        driver.get(ReadProperties.getUrl());
        loginPage = new LoginPage(driver);
    }

    @Then("username field is displayed")
    public void usernameFieldIsDisplayed() {
        Assert.assertTrue(loginPage.getEmailInput().isDisplayed());
    }

    @When("user with email{string} and psw {string} logged in")
    public void userWithEmailAndPswLoggedIn(String email, String psw) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPswInput().sendKeys(psw);
        loginPage.getLogInButton().click();
    }

    @And("username is {string}")
    public void usernameIs(String username){
        Assert.assertTrue();
    }

    @And("projects count is {int}")
    public void projectsCountIs(int count) {
        Assert.assertEquals(count, 15);
    }
}

    @And("project is {boolean}")
    public void projectIsTrue() {
    }