package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestonesTest extends BaseTest {

    @Test
    public void createMilestonesTest(){
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        milestonesStep.clickOnNewProject();//перейти на страницу New project
        milestonesStep.clickOnAddMilestone();//клик по Add Milestone
        milestonesStep.writeInAllFieldsMilestone();//вести имя Milestone

        Assert.assertEquals(addMilestonePage.getSuccessfullyText().getText(), "Successfully added the new milestone." );
        System.out.println("cooll");

        //Assert.assertEquals(addMilestonesSteps.addNewMilestone(ReadProperties.milestoneName(),"Some Text","Some Text","05/01/2022","05/01/2022").getSuccessMessage().getText(), "Successfully added the new milestone.");
    }

}
