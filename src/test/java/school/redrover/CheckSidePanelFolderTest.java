package school.redrover;

import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.common.BaseTest;
import school.redrover.page.HomePage;

public class CheckSidePanelFolderTest extends BaseTest {

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
                .clickConfigureLinkInSideMenu()
                .getBreadcrumbItem();

        Assert.assertEquals(breadcrumbItem, "Configuration");
    }
}
