package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {

    private By nameProjectLocator = By.xpath("//a[contains(@style, 'padding-left: 25px') and contains(text(), 'New project')]");
    private By addMilestoneLocator = By.xpath("//a[contains(@class, 'button button-left button-add') and contains(text(), 'Add')]");
    private By testOneCheckbox = By.cssSelector("[name=entity_milestones]");
    private By deleteSelectedButton = By.xpath("//span[contains(@class, 'button button-negative button-delete') and contains(text(), 'Delete selected')]");
    private By clickConfirmationCheckbox = By.id("confirm-check");
    private By deleteConfirmationButton = By.xpath("//a[contains(@class, 'button button-black button-left button-positive dialog-action-default') and contains(text(), 'Delete')]");
    private By successfullyDeletedLocator = By.xpath("//div[contains(@class, 'message message-success') and contains(text(), 'Successfully deleted the milestone (s).')]");
    //Блок инициализации
    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    //Блок атомарных методов
    public WebElement getNameProjectLocator(){

        return driver.findElement(nameProjectLocator);
    }

    public WebElement getAddMilestone(){

        return driver.findElement(addMilestoneLocator);
    }

    public WebElement getTestOne(){
        return driver.findElement(testOneCheckbox);
    }

    public WebElement getDeleteSelected(){
        return driver.findElement(deleteSelectedButton);
}
    public WebElement getClickConfirmation() {
        return driver.findElement(clickConfirmationCheckbox);
    }

    public WebElement getDeleteConfirmation(){
        return driver.findElement(deleteConfirmationButton);
    }
    public WebElement getSuccessfullyDeleted(){
        return driver.findElement(successfullyDeletedLocator);
    }


    @Override
    protected By getPageIdentifier() {

        return nameProjectLocator;
    }
}

