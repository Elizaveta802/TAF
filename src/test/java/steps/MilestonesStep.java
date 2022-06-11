package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddMilestonePage;
import pages.DashboardPage;
import pages.MyProjectPage;

public class MilestonesStep extends BaseStep {
    public String nameAddProject = "My Project";
    public String name = "TestOne";
    public String descriptionText = "I created Milestones";
    public String updateDescription = "I changed Milestones";

    public MilestonesStep(WebDriver driver) {
        super(driver);
    }

    public DashboardPage clickAddProject(){
        dashboardPage.addProject.click();
        createAddProjectPage.nameInputAddProject.sendKeys(nameAddProject);
        createAddProjectPage.addProjectButton.click();

        return dashboardPage;
    }

    public MyProjectPage clickOnMyProject(){
        dashboardPage.nameProjectMyProjectOnDashboard.click();

        return myProjectPage;
    }

    public AddMilestonePage clickOnAddMilestone(){
        milestonesPage.addMilestone.click();
        return addMilestonePage;

    }

    public AddMilestonePage writeInAllFieldsMilestone(){
        addMilestonePage.nameInput.click();
        addMilestonePage.nameInput.clear();
        addMilestonePage.nameInput.sendKeys(name);
        addMilestonePage.descriptionText.sendKeys(descriptionText);
        addMilestonePage.addMilestoneAddButton.click();

        return addMilestonePage;
    }

    public MyProjectPage updatesMilestone(){
        myProjectPage.headerMilestones.click();
        addMilestonePage.visibleMilestone.click();
        updateMilestonePage.editMilestone.click();
        addMilestonePage.descriptionText.clear();
        addMilestonePage.descriptionText.sendKeys(updateDescription);
        updateMilestonePage.saveMilestone.click();

        return myProjectPage;
    }
    public MyProjectPage deleteMilestone(){
        myProjectPage.headerMilestones.click();
        milestonesPage.testOneCheckbox.click();
        milestonesPage.deleteButton.click();
        milestonesPage.clickConfirmationOKButton.click();

        return myProjectPage;
    }
}
