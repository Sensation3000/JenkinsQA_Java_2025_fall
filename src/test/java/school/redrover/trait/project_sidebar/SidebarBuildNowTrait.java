package school.redrover.trait.project_sidebar;

import org.openqa.selenium.By;

import school.redrover.common.BasePage;
import school.redrover.trait.BaseTrait;


public interface SidebarBuildNowTrait extends BaseTrait {

    default <ProjectStatusPage extends BasePage<ProjectStatusPage>> ProjectStatusPage clickSidebarBuildNow(ProjectStatusPage page) {
        getDriver().findElement(By.xpath("//a[contains(., 'Build Now')]")).click();

        return page.waitUntilPageLoadJS();
    }
}
