package school.redrover.trait.project_sidebar;

import org.openqa.selenium.By;

import school.redrover.common.BasePage;
import school.redrover.trait.BaseTrait;


public interface SidebarMoveTrait extends BaseTrait {

    default <ProjectMovePage extends BasePage<ProjectMovePage>> ProjectMovePage clickSidebarMove(ProjectMovePage page) {
        getDriver().findElement(By.xpath("//a[contains(., 'Move')]")).click();

        return page.waitUntilPageLoadJS();
    }
}
