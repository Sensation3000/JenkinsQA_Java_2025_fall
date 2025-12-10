package school.redrover;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.common.BaseTest;
import school.redrover.page.HomePage;

public class CheckSidePanelFolderTest extends BaseTest {

    @Test
    public void checkSidePanelJobs_Configure() {
        String dirName = "newFolder";

        new HomePage(getDriver())
                .clickCreateJob()
                .sendName(dirName)
                .selectFolder()
                .clickOkButton()
                .gotoHomePage()
                .clickFolder(dirName)
                .clickConfigureLinkInSideMenu();

        String configureURL = getDriver().getCurrentUrl();
        Assert.assertTrue(configureURL.endsWith("/configure"));
    }
}
