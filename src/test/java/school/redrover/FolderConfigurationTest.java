package school.redrover;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import school.redrover.common.BaseTest;
import school.redrover.page.*;
import java.util.Arrays;
import java.util.List;

public class FolderConfigurationTest extends BaseTest {

   private static final String FOLDER_NAME = "MyFolder";

    @Test
    public void testHealthMetricLinkIsDisplayed(){
        String linkDisplayed = new HomePage(getDriver())
                .clickCreateJob()
                .sendName(FOLDER_NAME)
                .selectFolderAndSubmit()
                .getHealthMetricsSidebarLink();

        Assert.assertEquals(linkDisplayed, "Health metrics");
    }

    @Test(dependsOnMethods = "testHealthMetricLinkIsDisplayed")
    public void testHealthMetricButtonIsDisplayed(){
        String buttonDisplayed = new HomePage(getDriver())
                .openProject(FOLDER_NAME, new FolderStatusPage(getDriver()))
                .clickConfigureInSideMenu(new FolderConfigurationPage(getDriver()))
                .getHealthMetricsButton();

        Assert.assertEquals(buttonDisplayed,"Health metrics");
    }

    @Test(dependsOnMethods = "testHealthMetricLinkIsDisplayed")
    public void testHealthMetricSectionNavigation(){
        String sectionName = new HomePage(getDriver())
                .openProject(FOLDER_NAME, new FolderStatusPage(getDriver()))
                .clickConfigureInSideMenu(new FolderConfigurationPage(getDriver()))
                .clickHealthMetricsSidebarLink()
                .getSectionName();

        Assert.assertEquals(sectionName,"Health metrics");
    }

    @Test(dependsOnMethods = "testHealthMetricLinkIsDisplayed")
    public void testVerifyMetricTypeList(){

        final List<String> expectedMetricTypes= Arrays.asList("Child item with the given name","Child item with worst health");

        List<String> actualMetricTypes = new HomePage(getDriver())
                .openProject(FOLDER_NAME, new FolderStatusPage(getDriver()))
                .clickConfigureInSideMenu(new FolderConfigurationPage(getDriver()))
                .clickHealthMetricsSidebarLink()
                .clickHealthMetricsButton()
                .clickAddMetricButton()
                .getAllMetricTypeNames();

        Assert.assertEquals(actualMetricTypes, expectedMetricTypes,
                "The list of displayed metric types in the dropdown did not match the expected list.");
    }

    @Ignore
    @Test(dependsOnMethods = "testHealthMetricLinkIsDisplayed")
    public void testAddWorstHealth() {

        final String expectedMetric = "Child item with worst health";

        String actualMetricAdded = new HomePage(getDriver())
                .openProject(FOLDER_NAME, new FolderStatusPage(getDriver()))
                .clickConfigureInSideMenu(new FolderConfigurationPage(getDriver()))
                .clickHealthMetricsButton()
                .clickAddMetricButton()
                .clickWorstHealthButton()
                .getMetricRowName();

        Assert.assertEquals(actualMetricAdded, expectedMetric);
    }

    @Test(dependsOnMethods = "testHealthMetricLinkIsDisplayed")
    public void testAddGivenName() {

        final String expectedMetric = "Child item with the given name";

        String actualMetricAdded = new HomePage(getDriver())
                .openProject(FOLDER_NAME, new FolderStatusPage(getDriver()))
                .clickConfigureInSideMenu(new FolderConfigurationPage(getDriver()))
                .clickHealthMetricsButton()
                .clickAddMetricButton()
                .clickGivenNameButton()
                .getMetricRowName();

        Assert.assertEquals(actualMetricAdded, expectedMetric);
    }

    @Ignore
    @Test(dependsOnMethods = "testHealthMetricLinkIsDisplayed")
    public void testDragWorstHealthToTop() {

        final String expectedTopMetric = "Child item with worst health";

        String actualTopMetric = new HomePage(getDriver())
                .openProject(FOLDER_NAME, new FolderStatusPage(getDriver()))
                .clickConfigureInSideMenu(new FolderConfigurationPage(getDriver()))
                .clickHealthMetricsButton()
                .clickAddMetricButton()
                .clickGivenNameButton()
                .clickAddMetricButton()
                .clickWorstHealthButton()
                .dragWorstHealthRowToTop()
                .getMetricRowName();

        Assert.assertEquals(actualTopMetric, expectedTopMetric);
    }

    @Ignore
    @Test(dependsOnMethods = "testHealthMetricLinkIsDisplayed")
    public void testDeleteMetric() {
        List <String> metricList = new HomePage(getDriver())
                .openProject(FOLDER_NAME, new FolderStatusPage(getDriver()))
                .clickConfigureInSideMenu(new FolderConfigurationPage(getDriver()))
                .clickHealthMetricsButton()
                .clickAddMetricButton()
                .clickGivenNameButton()
                .clickAddMetricButton()
                .clickWorstHealthButton()
                .deleteMetric()
                .getMetricList();

        Assert.assertNotEquals(metricList.size(), 0);
        Assert.assertEquals(metricList.size(), 1);
    }

    @Ignore
    @Test(dependsOnMethods = "testHealthMetricLinkIsDisplayed")
    public void testChildNameTooltip() {

        final String textOnHover = "Help for feature: Child Name";

        String actualText = new HomePage(getDriver())
                .openProject(FOLDER_NAME, new FolderStatusPage(getDriver()))
                .clickConfigureInSideMenu(new FolderConfigurationPage(getDriver()))
                .clickHealthMetricsButton()
                .clickAddMetricButton()
                .clickGivenNameButton()
                .hoverChildNameTooltip()
                .getChildNameHelpText();

        Assert.assertEquals(actualText, textOnHover);
    }

    @Ignore
    @Test(dependsOnMethods = "testHealthMetricLinkIsDisplayed")
    public void testChildNameTooltipContent() {

        final String expectedTooltip = "Controls the child item within this folder representing to the health of this folder.";

        String actualText = new HomePage(getDriver())
                .openProject(FOLDER_NAME, new FolderStatusPage(getDriver()))
                .clickConfigureInSideMenu(new FolderConfigurationPage(getDriver()))
                .clickHealthMetricsButton()
                .clickAddMetricButton()
                .clickGivenNameButton()
                .clickChildNameTooltip()
                .getChildNameTooltipText();

        Assert.assertEquals(actualText, expectedTooltip);
    }

    @Ignore
    @Test(dependsOnMethods = "testHealthMetricLinkIsDisplayed")
    public void testWorstHealthTooltip() {

        final String textOnHover = "Help";

        String actualText = new HomePage(getDriver())
                .openProject(FOLDER_NAME, new FolderStatusPage(getDriver()))
                .clickConfigureInSideMenu(new FolderConfigurationPage(getDriver()))
                .clickHealthMetricsButton()
                .clickAddMetricButton()
                .clickWorstHealthButton()
                .hoverRecursiveTooltip()
                .getTooltipTitle();

        Assert.assertEquals(actualText, textOnHover);
    }

    @Ignore
    @Test(dependsOnMethods = "testHealthMetricLinkIsDisplayed")
    public void testRecursiveTooltipContent() {

        final String expectedTooltip = "Controls whether items within sub-folders will be considered as contributing to the health of this folder.";

        String actualText = new HomePage(getDriver())
                .openProject(FOLDER_NAME, new FolderStatusPage(getDriver()))
                .clickConfigureInSideMenu(new FolderConfigurationPage(getDriver()))
                .clickHealthMetricsButton()
                .clickAddMetricButton()
                .clickWorstHealthButton()
                .clickRecursiveTooltip()
                .getRecursiveTooltipText();

        Assert.assertEquals(actualText, expectedTooltip);
    }
}