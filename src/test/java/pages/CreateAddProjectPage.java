package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAddProjectPage extends BasePage {

    private By headerTitleLabelAddProjectLocator = By.xpath("//div[contains(@class, 'content-header-title page_title') and contains(text(), 'Add Project')]");
    private By nameInputAddProjectLocator = By.xpath("//input[@id='name']");
    private By addProjectButtonLocator = By.xpath("//button[contains(@class, 'button button-left button-positive button-ok') and contains(text(), 'Add Project')]");

    //блок инициализации
    public CreateAddProjectPage(WebDriver driver) {
        super(driver);
    }


    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelAddProjectLocator;
    }


    //блок атомарных методов
    public WebElement getHeaderTitleLabelAddProject() {
        return waitsService.waitForExists(headerTitleLabelAddProjectLocator);
    }

    public WebElement getNameInputAddProject(){
        return waitsService.waitForExists(nameInputAddProjectLocator);
    }

    public WebElement getAddProjectButton(){
        return waitsService.waitForExists(addProjectButtonLocator);
    }
}
