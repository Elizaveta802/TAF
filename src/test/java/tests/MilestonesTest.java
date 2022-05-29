package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestonesTest extends BaseTest {


    @Test
    public void successTransition() {//открытие страницы DashboardPage

        Assert.assertTrue(
                loginStep.successLogin(
                                ReadProperties.username(),
                                ReadProperties.password()
                        )
                        .isPageOpened());
    }

    @Test
    public void clickOnNewProjectTest(){
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        Assert.assertTrue(milestonesStep.clickOnNewProject().isPageOpened());//перейти на страницу New project, проверка клик по New project
        Assert.assertTrue(milestonesStep.clickOnAddMilestone().isPageOpened());//клик по Add Milestone

        milestonesStep.writeInAllFieldsMilestone();

        Assert.assertEquals(addMilestonePage.getNameInput().getText(), milestonesStep.name, "Successfully added the new milestone.");
        System.out.println("Successfully added the new milestone.");

    }

}
