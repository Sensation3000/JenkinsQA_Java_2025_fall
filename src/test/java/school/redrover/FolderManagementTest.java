package school.redrover;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import school.redrover.common.BaseTest;
import school.redrover.page.*;

public class FolderManagementTest extends BaseTest {

    private static final String FOLDER_NAME = "MyFolder";
    private static final String VIEW_NAME = "MyView";

    @DataProvider
    public Object[][] itemsData() {
        return new Object[][]{
                {"freestyle01", "Freestyle project"},
                {"pipeline01", "Pipeline"},
                {"multiConfig01", "Multi-configuration project"},
                {"folder01", "Folder"},
                {"Multibranch01", "Multibranch Pipeline"},
                {"orgFolder01", "Organization Folder"}
        };
    }

    public void createFolder() {
        new HomePage(getDriver())
                .clickCreateJob()
                .sendName(FOLDER_NAME)
                .selectFolderAndSubmit()
                .gotoHomePage();
    }

    @Test(dataProvider = "itemsData")
    public void testConfigureMenuItemInDropdownForEachJob(String itemName, String itemType) {
        final String menuItem = "Configure";

        createFolder();

        boolean isConfigureMenuItemDisplayed = new HomePage(getDriver())
                .clickFolder(FOLDER_NAME)
                .clickSidebarNewItem()
                .sendName(itemName)
                .selectItemTypeAndSubmitAndGoHome(itemType)
                .clickFolder(FOLDER_NAME)
                .openItemDropdownMenu(itemName)
                .isMenuItemInDropdownDisplayed(menuItem);

        Assert.assertTrue(isConfigureMenuItemDisplayed);
    }

    @Test
    public void testNavigateToConfigurationViaSideMenuForPipeline() {
        final String itemName = "pipeline01";

        createFolder();

        String actualHeadingText = new HomePage(getDriver())
                .clickFolder(FOLDER_NAME)
                .clickSidebarNewItem()
                .sendName(itemName)
                .selectPipelineAndSubmit()
                .gotoHomePage()
                .clickFolder(FOLDER_NAME)
                .openSubItemPage(itemName, new PipelinePage(getDriver()))
                .clickConfigureLinkInSideMenu()
                .getHeadingText();

        Assert.assertEquals(actualHeadingText, "Configure");
    }

    @Test()
    public void testViewCreationForm() {
        createFolder();

        new HomePage(getDriver())
                .clickFolder(FOLDER_NAME)
                .clickNewView()
                .sendName(VIEW_NAME)
                .selectTypeGlobalView()
                .selectTypeListView()
                .selectTypeMyView()
                .clickCreate();
    }
}
