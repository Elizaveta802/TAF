package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddMilestonePage extends BasePage {

    //блок описания селекторов для элементов
    @FindBy (xpath = "\"//div[contains(@class, 'content-header-title page_title') and contains(text(), 'Add Milestone')]\"" )
    public WebElement headerTitleLabelAddMilestone;
    @FindBy (xpath = "//input[@id='name']")
    public WebElement nameInput;
    @FindBy (xpath = "//button[contains(@class, 'button button-left button-positive button-ok') and contains(text(), 'Add Milestone')]")
    public WebElement addMilestoneAddButton;
    @FindBy (xpath = "//div[contains(@class, 'message message-success') and contains(text(), 'Successfully added the new milestone.')]")
    public WebElement successfullyText;
    @FindBy (xpath = "//a[text()='TestOne']")
    public WebElement visibleMilestone;
    @FindBy (css = "[class='form-control field-editor form-control-full ']")
    public WebElement descriptionText;

    @Override
    protected WebElement getPageIdentifier() {
        return nameInput;
    }

    //блок инициализации
    public AddMilestonePage(WebDriver driver) {
        super(driver);
    }
}

