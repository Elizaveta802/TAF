package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseStep {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected ProjectsPage projectsPage;
    protected MilestonesPage milestonesPage;
    protected ProjectsPage ProjectsPage;
    protected AddMilestonePage addMilestonePage;
    protected UpdateMilestonePage updateMilestonePage;
    protected CreateAddProjectPage createAddProjectPage;


    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        projectsPage = new ProjectsPage(driver);
        milestonesPage = new MilestonesPage(driver);
        ProjectsPage = new ProjectsPage(driver);
        createAddProjectPage = new CreateAddProjectPage(driver);
        addMilestonePage = new AddMilestonePage(driver);
        updateMilestonePage = new UpdateMilestonePage(driver);
    }
}
