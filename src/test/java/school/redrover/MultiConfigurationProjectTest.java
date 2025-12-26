package school.redrover;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import school.redrover.common.BaseTest;
import school.redrover.page.*;



public class MultiConfigurationProjectTest extends BaseTest {
    private static final String PROJECT_NAME = "Multiconfiguration project name";
    private static final String RENAMED_PROJECT = "Renamed multiconfiguration project";
    private static final String PROJECT_DESCRIPTION = "Project description...";

    @DataProvider(name = "validQuietPeriodValues")
    public Object[][] validQuietPeriodValues() {
        return new String[][]{
                {"0"},
                {"1"},
                {"30"},
                {"60"},
                {"300"},
                {"3600"},
                {"86400"},
                {""}
        };
    }

    @Test
    public void testCreateProject() {
        String actualProjectName = new HomePage(getDriver())
                .clickNewItemOnLeftMenu()
                .sendName(PROJECT_NAME)
                .selectMultiConfigurationProjectAndSubmit()
                .clickSubmit()
                .getHeader()
                .getText();

        Assert.assertEquals(actualProjectName, PROJECT_NAME);
    }

    @Test(dependsOnMethods = "testCreateProject")
    public void testAddDescriptionToProject() {
        String description = new HomePage(getDriver())
                .openProject(PROJECT_NAME, new MultiConfigurationProjectStatusPage(getDriver()))
                .waitUntilPageLoad()
                .clearDescriptionField()
                .sendDescription(PROJECT_DESCRIPTION)
                .getDescription();

        Assert.assertEquals(description, PROJECT_DESCRIPTION);
    }

    @Test
    public void testRenameViaSidebar() {
        String actualProjectName = new HomePage(getDriver())
                .clickNewItemOnLeftMenu()
                .sendName(PROJECT_NAME)
                .selectMultiConfigurationProjectAndSubmit()
                .clickSubmit()
                .clickRenameInSideMenu(new MultiConfigurationProjectRenamingPage(getDriver()))
                .clearNameField()
                .setNewProjectName(RENAMED_PROJECT)
                .getHeader()
                .getText();

        Assert.assertEquals(actualProjectName, RENAMED_PROJECT);
    }

    @Test
    public void testRenameViaDashboardDropdownMenu() {
        String actualProjectName = new HomePage(getDriver())
                .clickNewItemOnLeftMenu()
                .sendName(PROJECT_NAME)
                .selectMultiConfigurationProjectAndSubmit()
                .clickSubmit()
                .clickRenameViaDashboardDropDownMenu()
                .clearNameField()
                .setNewProjectName(RENAMED_PROJECT)
                .getHeader()
                .getText();

        Assert.assertEquals(actualProjectName, RENAMED_PROJECT);
    }

    @Test(dataProvider = "validQuietPeriodValues")
    public void testValidQuietPeriodValues(String seconds) {
        String configPage = new HomePage(getDriver())
                .clickNewItemOnLeftMenu()
                .sendName(PROJECT_NAME)
                .selectMultiConfigurationProjectAndSubmit()
                .clickAdvancedDropdownButton()
                .clickQuietPeriodCheckbox()
                .setQuietPeriodInput(seconds)
                .clickSubmit()
                .getHeader()
                .getText();

        Assert.assertEquals(configPage, PROJECT_NAME);
    }
}
