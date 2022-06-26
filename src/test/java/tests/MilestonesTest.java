package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.MilestoneBuilder;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestonesTest extends BaseTest {

    @Test
    public void addProjectTest(){
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        milestonesStep.clickAddProject();
    }

    @Test
    public void createMilestonesTest(){
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        milestonesStep.clickOnMyProject();//перейти на страницу My project
        milestonesStep.clickOnAddMilestone();//клик по Add Milestone
        milestonesStep.writeInAllFieldsMilestone();//вести имя Milestone

        Assert.assertEquals(addMilestonePage.getSuccessfullyText().getText(), "Successfully added the new milestone." );
        Assert.assertEquals(addMilestonePage.getVisibleMilestone().getText(), "TestOne");
    }

    @Test
    public void updateMilestonesTest(){
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        milestonesStep.clickOnMyProject();//перейти на страницу My project
        milestonesStep.updatesMilestone();

        Assert.assertEquals(updateMilestonePage.getSuccessfullyUpdated().getText(), "Successfully updated the milestone.");
    }

    @Test
    public void deleteMilestoneTest () {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        milestonesStep.clickOnMyProject();
        milestonesStep.deleteMilestone();

        Assert.assertEquals(driver.findElement(By.cssSelector("[class = 'message message-success']")).getText(), "Successfully deleted the milestone (s).");
    }

    @Test
    public void createMilestonesBuilderTest(){
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardPage.getAddProject().click();

        MilestoneBuilder milestoneBuilder = new MilestoneBuilder.Builder()
                .withName("Liza")
                        .withDescription("35647595t")
                                .build();
    }
}
