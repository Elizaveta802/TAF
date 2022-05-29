package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewProjectPage extends BasePage {

    //блок описания селекторов для элементов
    private By headerTitleLabelHewProjectLocator = By.xpath("//div[contains(@class, 'content-header-title page_title') and contains(text(), 'New project')]");


    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelHewProjectLocator;
    }

    //блок инициализации
    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    //блок атомарных методов
    public WebElement getHeaderTitleLabelHewProject(){

        return driver.findElement(headerTitleLabelHewProjectLocator);
    }


}
