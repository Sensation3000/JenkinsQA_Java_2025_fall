package school.redrover.project_status_page_interface;

import org.openqa.selenium.By;

import school.redrover.common.BasePage;
import school.redrover.common.IBaseModel;
import school.redrover.common.TestUtils;


public interface ClickableSidebarMove extends IBaseModel {

    default <ProjectMovePage extends BasePage<ProjectMovePage>> ProjectMovePage clickSidebarMove(ProjectMovePage page) {
        getDriver().findElement(By.xpath("//a[contains(., 'Move')]")).click();

        return page.waitUntilPageLoadJS();
    }
}
