package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddMilestonePage;
import pages.DashboardPage;
import pages.MyProjectPage;

public class MilestonesStep extends BaseStep {
    public String nameAddProject = "My Project";
    public String name = "TestOne";
    public String description = "I created Milestones";
    public String updateDescription = "I changed Milestones";

    public MilestonesStep(WebDriver driver) {
        super(driver);
    }

    public DashboardPage clickAddProject(){
        dashboardPage.getAddProject().click();
        createAddProjectPage.getNameInputAddProject().sendKeys(nameAddProject);
        createAddProjectPage.getAddProjectButton().click();

        return dashboardPage;
    }

    public MyProjectPage clickOnMyProject(){
        dashboardPage.getNameProjectMyProjectOnDashboard().click();

        return myProjectPage;
    }

    public AddMilestonePage clickOnAddMilestone(){
        milestonesPage.getAddMilestone().click();
        return addMilestonePage;

    }

    public AddMilestonePage writeInAllFieldsMilestone(){
        addMilestonePage.getNameInput().click();
        addMilestonePage.getNameInput().clear();
        addMilestonePage.getNameInput().sendKeys(name);
        addMilestonePage.getDescription().sendKeys(description);
        addMilestonePage.getAddMilestoneButton().click();

        return addMilestonePage;
    }

    public MyProjectPage updatesMilestone(){
        myProjectPage.getHeaderMilestones().click();
        addMilestonePage.getVisibleMilestone().click();
        updateMilestonePage.getEditMilestone().click();
        addMilestonePage.getDescription().clear();
        addMilestonePage.getDescription().sendKeys(updateDescription);
        updateMilestonePage.getSaveMilestone().click();

        return myProjectPage;
    }
    public MyProjectPage deleteMilestone(){
        myProjectPage.getHeaderMilestones().click();
        milestonesPage.getTestOne().click();
        milestonesPage.getDelete().click();
        milestonesPage.getClickConfirmationOK().click();

        return myProjectPage;
    }
}
