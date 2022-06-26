package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AddMilestonePage;
import pages.DashboardPage;
import pages.MilestonesPage;
import pages.UpdateMilestonePage;
import services.BrowsersService;
import steps.LoginStep;
import steps.MilestoneBuilderStep;
import steps.MilestonesStep;
import steps.NavigationStep;

public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;
    protected NavigationStep navigationStep;
    protected MilestonesStep milestonesStep;
    protected AddMilestonePage addMilestonePage;
    protected UpdateMilestonePage updateMilestonePage;
    protected MilestonesPage milestonesPage;
    protected DashboardPage dashboardPage;
    protected MilestoneBuilderStep milestoneBuilderStep;

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();

        loginStep = new LoginStep(driver);

        navigationStep = new NavigationStep(driver);

        milestonesStep = new MilestonesStep(driver);

        addMilestonePage = new AddMilestonePage(driver);

        updateMilestonePage = new UpdateMilestonePage(driver);

        milestonesStep = new MilestonesStep(driver);

        dashboardPage = new DashboardPage(driver);

        milestoneBuilderStep = new MilestoneBuilderStep(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
