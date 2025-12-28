package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v137.page.Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.common.BaseTest;
import school.redrover.page.HomePage;
import school.redrover.page.JobPage;
import school.redrover.page.MultiConfigurationProjectConfigurationPage;
import school.redrover.page.MultiConfigurationProjectStatusPage;

public class MultiConfigurationProjectEnabledTest extends BaseTest {
    private static final String PROJECT_NAME = "ProjectName";

    @Test
    void testDisableAfterCreation() {
        boolean ProjectIsDisabled = createMCProject(PROJECT_NAME)
                .disableProject()
                .isDisabled();

        Assert.assertTrue(ProjectIsDisabled, "'Disabled' must be shown");

    }

    @Test
    void testDisableFromHomePage() {
        boolean ProjectIsDisabled = createMCProject(PROJECT_NAME)
                .gotoHomePage()
                .projectName()
                .gotoConfigurationPage()
                .disableProject()
                .isDisabled();

        Assert.assertTrue(ProjectIsDisabled, "'Disabled' must be shown");
    }

    @Test
    void testWarningWhenDisable() {
        boolean hasWarning = createMCProject(PROJECT_NAME)
                .disableProject()
                .clickSubmit()
                .warningIsVisible();

        Assert.assertTrue(hasWarning, "Warning text should contain 'This project is currently disabled'");
    }

    @Test
    void testIconWhenDisable() {
        boolean disabledIconDisplayed = createMCProject(PROJECT_NAME)
                .disableProject()
                .clickSubmit()
                .gotoHomePage()
                .disabledIconIsDisplayed();

        Assert.assertTrue(disabledIconDisplayed);
    }

    private MultiConfigurationProjectConfigurationPage createMCProject(String name) {
        MultiConfigurationProjectConfigurationPage actualProject = new HomePage(getDriver())
                .clickNewItemOnLeftMenu()
                .sendName(name)
                .selectMultiConfigurationProjectAndSubmit();

        return actualProject;

    }
}
