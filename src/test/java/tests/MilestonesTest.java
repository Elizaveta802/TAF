package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
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
        milestonesStep.clickOnMyProject();
        milestonesStep.clickOnAddMilestone();
        milestonesStep.writeInAllFieldsMilestone();

        Assert.assertEquals(addMilestonePage.successfullyText.getText(), "Successfully added the new milestone." );
        Assert.assertEquals(addMilestonePage.visibleMilestone.getText(), "TestOne");
    }

    @Test
    public void updateMilestonesTest(){
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        milestonesStep.clickOnMyProject();
        milestonesStep.updatesMilestone();

        Assert.assertEquals(updateMilestonePage.successfullyUpdated.getText(), "Successfully updated the milestone.");
    }

    @Test
    public void deleteMilestoneTest() throws InterruptedException{
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        milestonesStep.clickOnMyProject();
        milestonesStep.deleteMilestone();

        Thread.sleep(3000);

        Assert.assertEquals(milestonesPage.deleteMilestones.getText(), "Successfully deleted the milestone (s).");
    }
}
