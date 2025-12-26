package school.redrover;

import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.common.BaseTest;
import school.redrover.page.BuildHistoryOfJenkinsPage;
import school.redrover.page.HomePage;

import java.util.Arrays;
import java.util.List;

public class BuildHistoryAccessTest extends BaseTest {

    @Test
    public void testQuickAccessBuildHistory() {
        String actualHeading = new HomePage(getDriver())
                .clickBuildHistory()
                .getHeader()
                .getText();

        Assert.assertEquals(actualHeading, "Build History of Jenkins");
    }

    @Test
    public void testValidateBuildHistoryEmptyTable() {
        final List<String> expectedHeaders = Arrays.asList("S", "Build", "Time Since", "Status");

        BuildHistoryOfJenkinsPage buildHistoryOfJenkinsPage = new HomePage(getDriver())
                .clickBuildHistory();

        Assert.assertTrue(buildHistoryOfJenkinsPage.isBuildHistoryEmpty());
        Assert.assertEquals(buildHistoryOfJenkinsPage.getTableHeadersText(), expectedHeaders);
    }


    final List<String> allSizes = List.of("Small", "Medium", "Large");

    @Test
    public void testChangeIconSize() {

        for (int i = 0; i < allSizes.size(); i++) {
            String checks = new HomePage(getDriver())
                    .clickBuildHistory()
                    .changeIconSize(allSizes.get(i))
                    .checkIconSize();

            Assert.assertEquals(checks, allSizes.get(i));
        }
    }
}
