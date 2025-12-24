package school.redrover.project_status_page_interface;

import org.openqa.selenium.By;

import school.redrover.common.BasePage;
import school.redrover.common.IBaseModel;
import school.redrover.common.TestUtils;


public interface ClickableSidebarChanges extends IBaseModel {

    default <ProjectChangesPage extends BasePage<ProjectChangesPage>> ProjectChangesPage clickSidebarChanges(ProjectChangesPage page) {
        getDriver().findElement(By.xpath("//a[contains(., 'Changes')]")).click();

        return page.waitUntilPageLoadJS();
    }
}
