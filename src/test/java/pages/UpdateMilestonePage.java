package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateMilestonePage extends BasePage {
    private By editMilestoneLocator = By.xpath("//a[contains(@class, 'toolbar-button toolbar-button-last content-header-button button-edit') and contains(text(), 'Edit')]");
    private By saveMilestoneButton = By.xpath("//button[contains(@class, 'button button-left button-positive button-ok') and contains(text(), 'Save Milestone')]");
    private By successfullyUpdatedLocator = By.xpath("//div[text()='Successfully updated the milestone.']");


    public UpdateMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public WebElement getEditMilestone(){
        return waitsService.waitForExists(editMilestoneLocator);
    }

    public WebElement getSaveMilestone(){
        return waitsService.waitForExists(saveMilestoneButton);
    }
    public WebElement getSuccessfullyUpdated(){
        return waitsService.waitForExists(successfullyUpdatedLocator);
    }
}
