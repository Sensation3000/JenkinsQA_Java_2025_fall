package school.redrover.trait.project_sidebar;

import org.openqa.selenium.By;

import school.redrover.common.BasePage;
import school.redrover.trait.BaseTrait;


public interface SidebarBuildHistoryTrait extends BaseTrait {

    default <ProjectBuildHistoryPage extends BasePage<ProjectBuildHistoryPage>> ProjectBuildHistoryPage clickSidebarBuildHistory(ProjectBuildHistoryPage page) {
        getDriver().findElement(By.xpath("//a[contains(., 'Build History')]")).click();

        return page.waitUntilPageLoadJS();
    }
}
