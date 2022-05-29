package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {

    private By nameProjectLocator = By.xpath("//a[contains(@style, 'padding-left: 25px') and contains(text(), 'New project')]");
    private By addMilestoneLocator = By.xpath("//a[contains(@class, 'button button-left button-add') and contains(text(), 'Add')]");

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

    @Override
    protected By getPageIdentifier() {

        return nameProjectLocator;
    }
}

