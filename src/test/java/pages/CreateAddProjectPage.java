package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAddProjectPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'content-header-title page_title') and contains(text(), 'Add Project')]")
    public WebElement headerTitleLabelAddProject;
    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameInputAddProject;
    @FindBy(xpath = "//button[contains(@class, 'button button-left button-positive button-ok') and contains(text(), 'Add Project')]")
    public WebElement addProjectButton;

    //блок инициализации
    public CreateAddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return headerTitleLabelAddProject;
    }
}
