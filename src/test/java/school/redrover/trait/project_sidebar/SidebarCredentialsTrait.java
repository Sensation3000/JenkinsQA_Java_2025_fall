package school.redrover.trait.project_sidebar;

import org.openqa.selenium.By;

import school.redrover.common.BasePage;
import school.redrover.trait.BaseTrait;


public interface SidebarCredentialsTrait extends BaseTrait {

    default <ProjectCredentialsPage extends BasePage<ProjectCredentialsPage>> ProjectCredentialsPage clickSidebarCredentials(ProjectCredentialsPage page) {
        getDriver().findElement(By.xpath("//a[contains(., 'Credentials')]")).click();

        return page.waitUntilPageLoadJS();
    }
}
