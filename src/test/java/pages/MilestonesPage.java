package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {

    private By nameProjectLocator = By.xpath("//a[contains(@style, 'padding-left: 25px') and contains(text(), 'New project')]");
    private By testOneCheckbox = By.cssSelector("[name=entity_milestones]");
    private By deleteButton = By.cssSelector("[class='icon-small-delete ']");
    private By clickConfirmationOKButton = By.xpath("//*[@class = 'ui-dialog ui-widget ui-widget-content ui-corner-all dialog ui-draggable']/descendant::a[contains(text(), 'OK')]");
    private By successfullyTextLocator = By.xpath("//div[contains(@class, 'message message-success') and contains(text(), 'Successfully added the new milestone.')]");
    private By headerMilestonesLocator = By.id("navigation-milestones");
    private By nameProjectMyProjectOnDashboardLocator = By.xpath("//a[contains(@style, 'padding-left: 25px') and contains(text(), 'My Project')]");
    private By textSuccessfullyDeletedLocator = By.cssSelector("[class = 'message message-success']");

    //Блок инициализации
    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    //Блок атомарных методов

    public WebElement getTestOne(){
        return driver.findElement(testOneCheckbox);
    }

    public WebElement getDelete() {
        return driver.findElement(deleteButton);
    }
    public WebElement getClickConfirmationOK(){
        return driver.findElement(clickConfirmationOKButton);
    }

    public WebElement getSuccessfullyText(){
        return driver.findElement(successfullyTextLocator);
    }

    public WebElement getHeaderMilestones(){
        return driver.findElement(headerMilestonesLocator);
    }

    public WebElement getNameProjectMyProjectOnDashboard(){
        return driver.findElement(nameProjectMyProjectOnDashboardLocator);
    }

    public WebElement getTextSuccessfullyDeleted(){
        return driver.findElement(textSuccessfullyDeletedLocator);
    }

    @Override
    protected By getPageIdentifier() {
        return nameProjectLocator;
    }

    public MilestonesPage deleteMilestone(){
        getNameProjectMyProjectOnDashboard().click();
        getHeaderMilestones().click();
        getTestOne().click();
        getDelete().click();
        getClickConfirmationOK().click();

        return new MilestonesPage(driver);
    }
}

