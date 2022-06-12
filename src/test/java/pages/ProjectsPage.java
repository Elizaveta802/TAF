package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/overview";

    public SideMenuPage sideMenuPage;

    private By headerMilestonesLocator = By.id("navigation-milestones");
    private By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Projects')]");
    private By successfullyUpdatedLocator = By.xpath("//div[text()='Successfully updated the milestone.']");

    public ProjectsPage(WebDriver driver) {
        super(driver);

        sideMenuPage = new SideMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getHeaderMilestones(){
        return driver.findElement(headerMilestonesLocator);
    }

    public WebElement getSuccessfullyUpdated(){
        return driver.findElement(successfullyUpdatedLocator);
    }
}
