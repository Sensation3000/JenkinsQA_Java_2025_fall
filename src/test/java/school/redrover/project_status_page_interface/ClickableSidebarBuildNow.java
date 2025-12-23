package school.redrover.project_status_page_interface;

import org.openqa.selenium.By;

import school.redrover.common.BasePage;
import school.redrover.common.IBaseModel;
import school.redrover.common.TestUtils;


public interface ClickableSidebarBuildNow extends IBaseModel {

    default <ProjectStatusPage extends BasePage<?>> ProjectStatusPage clickSidebarBuildNow(ProjectStatusPage page) {
        getDriver().findElement(By.xpath("//a[contains(., 'Build Now')]")).click();

        return TestUtils.waitUntilPageLoad(page);
    }
}
