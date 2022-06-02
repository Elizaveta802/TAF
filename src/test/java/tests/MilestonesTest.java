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
        milestonesStep.clickOnMyProject();//перейти на страницу My project
        milestonesStep.clickOnAddMilestone();//клик по Add Milestone
        milestonesStep.writeInAllFieldsMilestone();//вести имя Milestone

        Assert.assertEquals(addMilestonePage.getSuccessfullyText().getText(), "Successfully added the new milestone." );
        Assert.assertEquals(addMilestonePage.getVisibleMilestone().getText(), "TestOne");
    }

}
