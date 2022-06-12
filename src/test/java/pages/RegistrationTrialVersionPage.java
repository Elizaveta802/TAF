package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationTrialVersionPage {
    private WebDriver driver;

    //Блок описания селекторов для элементов

    private By cookieButtonLocator = By.cssSelector("#gk-cookie-proceed");

    private By webAddressInputLocator = By.cssSelector("[placeholder='Choose a name']");
    private By firstNameInputLocator = By.id("#first_name");
    private By lastNameInputLocator = By.id("#last_name");
    private By workEmailInputLocator = By.id("#email");
    private By organizationInputLocator = By.id("#organization");
    private By expectedUsersButtonLocator = By.cssSelector("select [value='1']");
    private By tosButtonLocator = By.cssSelector("[name='tos']");
    private By gdprButtonLocator = By.cssSelector("[name='gdpr']");
    private By createTestRailTrialButtonLocator = By.cssSelector("[class='btn btn-success']");


    //Блок инициализации
    public RegistrationTrialVersionPage(WebDriver driver) {
        this.driver = driver;
    }

    //Блок атомарных методов

    public WebElement getCookieButton(){
        return driver.findElement(cookieButtonLocator);
    }
    public WebElement getWebAddressInput() {
        return driver.findElement(webAddressInputLocator);
    }

    public WebElement getFirstNameInput() {
        return driver.findElement(firstNameInputLocator);
    }

    public WebElement getLastNameInput() {
        return driver.findElement(lastNameInputLocator);
    }

    public WebElement getWorkEmailInput() {
        return driver.findElement(workEmailInputLocator);
    }

    public WebElement getOrganizationInput() {
        return driver.findElement(organizationInputLocator);
    }

    public WebElement getExpectedUsersButton() {
        return driver.findElement(expectedUsersButtonLocator);
    }

    public WebElement getTosButton() {
        return driver.findElement(tosButtonLocator);
    }

    public WebElement getGdprButton() {
        return driver.findElement(gdprButtonLocator);
    }

    public WebElement getCreateTestRailTrialButton() {
        return driver.findElement(createTestRailTrialButtonLocator);
    }
}

