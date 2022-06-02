package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseStep {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected ProjectsPage projectsPage;
    protected MilestonesPage milestonesPage;
    protected MyProjectPage newProjectPage;
    protected AddMilestonePage addMilestonePage;
    protected CreateAddProjectPage createAddProjectPage;


    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);//инициальзация конструктора
        dashboardPage = new DashboardPage(driver);
        projectsPage = new ProjectsPage(driver);
        milestonesPage = new MilestonesPage(driver);
        newProjectPage = new MyProjectPage(driver);
        addMilestonePage = new AddMilestonePage(driver);
        createAddProjectPage = new CreateAddProjectPage(driver);

    }
}
