package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestoneBuilderPage extends BasePage {

    public  MilestoneBuilderPage(WebDriver driver) {
        super(driver);
    }
    //локаторы
    private By nameLocator = By.id("name");
    private By referenceLocator = By.id("reference");
    private By descriptionDisplayLocator = By.id("description_display");
    private By startDateLocator = By.id("start_on");
    private By endDateLocator = By.id("due_on");
    private By addMilestoneButtonLocator = By.id("accept");


    //локатор проверки
    private By successStartMilestoneButtonLocator = By.xpath(
            "//div[@class='message message-success' and text()='Successfully added the new milestone.']");

    @Override
    protected By getPageIdentifier() {
        return successStartMilestoneButtonLocator;
    }

    //атомарные методы
    public WebElement getName() {
        return waitsService.waitForExists(nameLocator);
    }

    public WebElement getReference() {
        return waitsService.waitForExists(referenceLocator);
    }

    public WebElement getDescriptionDisplay() {
        return waitsService.waitForExists(descriptionDisplayLocator);
    }

    public WebElement getStartDate() {
        return waitsService.waitForExists(startDateLocator);
    }

    public WebElement getEndDate() {
        return waitsService.waitForExists(endDateLocator);
    }

    public WebElement getAddMilestoneButton() {
        return waitsService.waitForExists(addMilestoneButtonLocator);
    }
}

