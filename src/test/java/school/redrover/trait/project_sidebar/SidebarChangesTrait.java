package school.redrover.trait.project_sidebar;

import org.openqa.selenium.By;

import school.redrover.common.BasePage;
import school.redrover.trait.BaseTrait;


public interface SidebarChangesTrait extends BaseTrait {

    default <ProjectChangesPage extends BasePage<ProjectChangesPage>> ProjectChangesPage clickSidebarChanges(ProjectChangesPage page) {
        getDriver().findElement(By.xpath("//a[contains(., 'Changes')]")).click();

        return page.waitUntilPageLoadJS();
    }
}
