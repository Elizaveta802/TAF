package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProjectPage extends BasePage {

    //блок описания селекторов для элементов
    @FindBy(xpath = "//div[contains(@class, 'content-header-title page_title') and contains(text(), 'New project')]")
    public WebElement headerTitleLabelHewProject;
    @FindBy(id = "navigation-milestones")
    public WebElement headerMilestones;


    @Override
    protected WebElement getPageIdentifier() {
        return headerTitleLabelHewProject;
    }

    //блок инициализации
    public MyProjectPage(WebDriver driver) {
        super(driver);
    }
}
