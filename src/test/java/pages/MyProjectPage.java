package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyProjectPage extends BasePage {

    //блок описания селекторов для элементов
    private By headerTitleLabelHewProjectLocator = By.xpath("//div[contains(@class, 'content-header-title page_title') and contains(text(), 'New project')]");
    private By headerMilestonesLocator = By.id("navigation-milestones");


    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelHewProjectLocator;
    }

    //блок инициализации
    public MyProjectPage(WebDriver driver) {
        super(driver);
    }

    //блок атомарных методов
    public WebElement getHeaderTitleLabelHewProject(){
        return driver.findElement(headerTitleLabelHewProjectLocator);
    }
    public WebElement getHeaderMilestones(){
        return driver.findElement(headerMilestonesLocator);
    }

}
