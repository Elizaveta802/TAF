package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddMilestonePage;
import pages.NewProjectPage;

public class MilestonesStep extends BaseStep {
    public String name = "TestOne";

    public MilestonesStep(WebDriver driver) {
        super(driver);
    }

    //ФУНКЦИОНАЛЬНОСТЬ

    //нажать на ссылку New project
    public NewProjectPage clickOnNewProject(){

        milestonesPage.getNameProjectLocator().click();
        return newProjectPage;

    }

    //Add Milestone
    public AddMilestonePage clickOnAddMilestone(){
        milestonesPage.getAddMilestone().click();
        return addMilestonePage;

    }
    //заполнить поле Name в Milestone
    public AddMilestonePage writeInAllFieldsMilestone(){
        addMilestonePage.getNameInput().click();
        addMilestonePage.getNameInput().clear();
        addMilestonePage.getNameInput().sendKeys(name);
        addMilestonePage.getAddMilestoneButton().click();

        return addMilestonePage;
    }
}
