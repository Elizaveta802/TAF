package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateMilestonePage extends BasePage {

    @FindBy(xpath = "//a[contains(@class, 'toolbar-button toolbar-button-last content-header-button button-edit') and contains(text(), 'Edit')]")
    public WebElement editMilestone;
    @FindBy(xpath = "//button[contains(@class, 'button button-left button-positive button-ok') and contains(text(), 'Save Milestone')]")
    public WebElement saveMilestone;
    @FindBy(xpath = "//div[text()='Successfully updated the milestone.']")
    public WebElement successfullyUpdated;


    public UpdateMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return editMilestone;
    }
}
