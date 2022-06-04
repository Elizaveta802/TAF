package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {

    private By nameProjectLocator = By.xpath("//a[contains(@style, 'padding-left: 25px') and contains(text(), 'New project')]");
    private By addMilestoneLocator = By.xpath("//a[contains(@class, 'button button-left button-add') and contains(text(), 'Add')]");
    private By testOneCheckbox = By.cssSelector("[name=entity_milestones]");
    private By deleteButton = By.cssSelector("[class='icon-small-delete ']");
    private By clickConfirmationOKButton = By.xpath("//*[@class = 'ui-dialog ui-widget ui-widget-content ui-corner-all dialog ui-draggable']/descendant::a[contains(text(), 'OK')]");

    //Блок инициализации
    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    //Блок атомарных методов
    public WebElement getAddMilestone(){

        return waitsService.waitForExists(addMilestoneLocator);
    }

    public WebElement getTestOne(){
        return waitsService.waitForExists(testOneCheckbox);
    }

    public WebElement getDelete() {
        return waitsService.waitForExists(deleteButton);
    }
    public WebElement getClickConfirmationOK(){
        return waitsService.waitForExists(clickConfirmationOKButton);
    }

    @Override
    protected By getPageIdentifier() {
        return nameProjectLocator;
    }
}

