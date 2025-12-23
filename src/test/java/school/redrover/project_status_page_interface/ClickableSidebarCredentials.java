package school.redrover.project_status_page_interface;

import org.openqa.selenium.By;

import school.redrover.common.BasePage;
import school.redrover.common.IBaseModel;
import school.redrover.common.TestUtils;


public interface ClickableSidebarCredentials extends IBaseModel {

    default <ProjectCredentialsPage extends BasePage<?>> ProjectCredentialsPage clickSidebarCredentials(ProjectCredentialsPage page) {
        getDriver().findElement(By.xpath("//a[contains(., 'Credentials')]")).click();

        return TestUtils.waitUntilPageLoad(page);
    }
}
