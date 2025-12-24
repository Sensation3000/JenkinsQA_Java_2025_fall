package school.redrover.trait.project_sidebar;

import org.openqa.selenium.By;

import school.redrover.common.BasePage;
import school.redrover.trait.BaseTrait;


public interface SidebarWorkspaceTrait extends BaseTrait {

    default <ProjectWorkspacePage extends BasePage<ProjectWorkspacePage>> ProjectWorkspacePage clickSidebarWorkspace(ProjectWorkspacePage page) {
        getDriver().findElement(By.xpath("//a[contains(., 'Changes')]")).click();

        return page.waitUntilPageLoadJS();
    }
}
