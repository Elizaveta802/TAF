package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMilestonePage extends BasePage {

    //блок описания селекторов для элементов
    private By headerTitleLabelAddMilestoneLocator = By.xpath("//div[contains(@class, 'content-header-title page_title') and contains(text(), 'Add Milestone')]");

    public By nameInputLocator = By.xpath("//input[@id='name']");
    public By addMilestoneButtonLocator = By.xpath("//button[contains(@class, 'button button-left button-positive button-ok') and contains(text(), 'Add Milestone')]");

    @Override
    protected By getPageIdentifier() {
        return nameInputLocator;
    }

    //блок инициализации
    public AddMilestonePage(WebDriver driver) {
        super(driver);
    }

    //блок атомарных методов
    public WebElement getHeaderTitleLabelAddMilestone(){

        return driver.findElement(headerTitleLabelAddMilestoneLocator);
    }

    public WebElement getNameInput(){

        return driver.findElement(nameInputLocator);
    }

    public WebElement getAddMilestoneButton(){

        return driver.findElement(addMilestoneButtonLocator);
    }
}

