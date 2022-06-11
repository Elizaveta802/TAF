package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MilestonesPage extends BasePage {

    @FindBy(xpath = "//a[contains(@style, 'padding-left: 25px') and contains(text(), 'New project')]")
    public WebElement nameProject;
    @FindBy(xpath = "//a[contains(@class, 'button button-left button-add') and contains(text(), 'Add')]")
    public WebElement addMilestone;
    @FindBy(css = "[name=entity_milestones]")
    public WebElement testOneCheckbox;
    @FindBy(css = "[class='icon-small-delete ']")
    public WebElement deleteButton;
    @FindBy(xpath = "//*[@class = 'ui-dialog ui-widget ui-widget-content ui-corner-all dialog ui-draggable']/descendant::a[contains(text(), 'OK')]")
    public WebElement clickConfirmationOKButton;
    @FindBy(css = "[class = 'message message-success']")
    public WebElement deleteMilestones;

    //Блок инициализации
    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return nameProject;
    }
}

