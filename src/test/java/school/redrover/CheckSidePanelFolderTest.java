package school.redrover;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import school.redrover.common.BaseTest;
import school.redrover.page.FolderConfigurationPage;
import school.redrover.page.HomePage;

public class CheckSidePanelFolderTest extends BaseTest {

    @Ignore
    @Test
    public void checkSidePanelJobs_Configure() {
        String dirName = "newFolder";

        String breadcrumbItem = new HomePage(getDriver())
                .clickCreateJob()
                .sendName(dirName)
                .selectFolder()
                .clickOkButton()
                .gotoHomePage()
                .clickFolder(dirName)
                .clickConfigureInSideMenu(new FolderConfigurationPage(getDriver()))
                .getBreadcrumbItem();

        Assert.assertEquals(breadcrumbItem, "Configuration");
    }
}
