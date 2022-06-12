package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddMilestonePage;
import pages.MilestonesPage;
import pages.UpdateMilestonePage;

public class MilestonesTest extends BaseTest {

    @Test
    public void createMilestonesTest(){
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        Assert.assertTrue(
                new AddMilestonePage(driver)
                        .writeInAllFieldsMilestone()
                        .getSuccessfullyText()
                        .isDisplayed()
        );
    }

    @Test
    public void updateMilestonesTest() throws InterruptedException{
        Thread.sleep(3000);
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        Assert.assertTrue(
                new UpdateMilestonePage(driver)
                        .updatesMilestone()
                        .getSuccessfullyUpdated()
                        .isDisplayed()
        );
    }

    @Test
    public void deleteMilestoneTest (){

        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());

        Assert.assertTrue(
                new MilestonesPage(driver)
                        .deleteMilestone()
                        .getTextSuccessfullyDeleted()
                        .isDisplayed()
        );
    }
}
