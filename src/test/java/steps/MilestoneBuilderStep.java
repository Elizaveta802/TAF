package steps;

import baseEntities.BaseStep;
import models.MilestoneBuilder;
import org.openqa.selenium.WebDriver;
import pages.MilestoneBuilderPage;

public class MilestoneBuilderStep extends BaseStep {

    public MilestoneBuilderStep(WebDriver driver) {
        super(driver);
    }
    public MilestoneBuilderPage createMilestones(MilestoneBuilder milestone) {
        milestoneBuilderPage.getName().sendKeys(milestone.getName());
        milestoneBuilderPage.getReference().sendKeys(milestone.getReference());
        milestoneBuilderPage.getDescriptionDisplay().sendKeys(milestone.getDescription());
        milestoneBuilderPage.getStartDate().sendKeys(milestone.getStartDate());
        milestoneBuilderPage.getEndDate().sendKeys(milestone.getEndDate());
        milestoneBuilderPage.getAddMilestoneButton().click();
        return milestoneBuilderPage;
    }
}
