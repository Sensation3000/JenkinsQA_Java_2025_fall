package school.redrover.project_status_page_interface;

import org.openqa.selenium.By;

import school.redrover.common.BasePage;
import school.redrover.common.IBaseModel;
import school.redrover.common.TestUtils;


public interface ClickableSidebarWorkspace extends IBaseModel {

    default <ProjectWorkspacePage extends BasePage<?>> ProjectWorkspacePage clickSidebarWorkspace(ProjectWorkspacePage page) {
        getDriver().findElement(By.xpath("//a[contains(., 'Changes')]")).click();

        return TestUtils.waitUntilPageLoad(page);
    }
}
