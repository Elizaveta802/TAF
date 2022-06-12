package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateMilestonePage extends BasePage {

    public String updateDescription = "I changed Milestones";

    private By editMilestoneLocator = By.xpath("//a[contains(@class, 'toolbar-button toolbar-button-last content-header-button button-edit') and contains(text(), 'Edit')]");
    private By saveMilestoneButton = By.xpath("//button[contains(@class, 'button button-left button-positive button-ok') and contains(text(), 'Save Milestone')]");
    private By successfullyUpdatedLocator = By.xpath("//div[text()='Successfully updated the milestone.']");
    private By headerMilestonesLocator = By.xpath("//a[text()='Milestones']");
    private By visibleMilestoneLocator = By.xpath("//a[text()='TestOne']");
    private By descriptionLocator = By.cssSelector("[class='form-control field-editor form-control-full ']");
    private By nameProjectMyProjectOnDashboardLocator = By.xpath("//a[contains(@style, 'padding-left: 25px') and contains(text(), 'My Project')]");


    public UpdateMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public WebElement getEditMilestone(){
        return driver.findElement(editMilestoneLocator);
    }

    public WebElement getSaveMilestone(){
        return driver.findElement(saveMilestoneButton);
    }
    public WebElement getSuccessfullyUpdated(){
        return driver.findElement(successfullyUpdatedLocator);
    }

    public WebElement getHeaderMilestones(){
        return driver.findElement(headerMilestonesLocator);
    }

    public WebElement getVisibleMilestone(){
        return driver.findElement(visibleMilestoneLocator);
    }

    public WebElement getDescription(){
        return driver.findElement(descriptionLocator);
    }

    public WebElement getNameProjectMyProjectOnDashboard(){
        return driver.findElement(nameProjectMyProjectOnDashboardLocator);
    }

    //блок комплексных методов
    public ProjectsPage updatesMilestone(){
        getNameProjectMyProjectOnDashboard().click();
        getHeaderMilestones().click();
        getVisibleMilestone().click();
        getEditMilestone().click();
        getDescription().clear();
        getDescription().sendKeys(updateDescription);
        getSaveMilestone().click();

        return new ProjectsPage(driver);
    }
}
