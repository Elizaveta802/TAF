package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestonesTest extends BaseTest {

    @Test(description = "Create project")
    public void addProjectTest(){
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        milestonesStep.clickAddProject();
    }

    @Test
    @Description("Create Milestone: 1.move to My project page; 2.click on Add Milestone; 3.enter the name Milestone")
    public void createMilestonesTest(){
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        milestonesStep.clickOnMyProject();
        milestonesStep.clickOnAddMilestone();
        milestonesStep.writeInAllFieldsMilestone();

        Assert.assertEquals(addMilestonePage.getSuccessfullyText().getText(), "Successfully added the new milestone." );
        Assert.assertEquals(addMilestonePage.getVisibleMilestone().getText(), "TestOne");
    }

    @Test(description = "Update Milestones: 1.move to My project page; 2.move to TestOne; 3.click to Edit; 4. update Milestones")
    @Severity(SeverityLevel.TRIVIAL)
    public void updateMilestonesTest(){
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        milestonesStep.clickOnMyProject();//перейти на страницу My project
        milestonesStep.updatesMilestone();

        Assert.assertEquals(updateMilestonePage.getSuccessfullyUpdated().getText(), "Successfully updated the milestone.");
    }

    @Test(description = "Delete milestones: 1.move to My project page; 2.move to Milestones; 3.delete TestOne")
    public void deleteMilestoneTest () {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        milestonesStep.clickOnMyProject();
        milestonesStep.deleteMilestone();

        Assert.assertEquals(driver.findElement(By.cssSelector("[class = 'message message-success']")).getText(), "Successfully deleted the milestone (s).");
    }
}
