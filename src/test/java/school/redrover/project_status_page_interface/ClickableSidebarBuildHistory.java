package school.redrover.project_status_page_interface;

import org.openqa.selenium.By;

import school.redrover.common.BasePage;
import school.redrover.common.IBaseModel;
import school.redrover.common.TestUtils;


public interface ClickableSidebarBuildHistory extends IBaseModel {

    default <ProjectBuildHistoryPage extends BasePage<?>> ProjectBuildHistoryPage clickSidebarBuildHistory(ProjectBuildHistoryPage page) {
        getDriver().findElement(By.xpath("//a[contains(., 'Build History')]")).click();

        return TestUtils.waitUntilPageLoad(page);
    }
}
