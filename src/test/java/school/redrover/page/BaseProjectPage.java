package school.redrover.page;

import org.openqa.selenium.WebDriver;
import school.redrover.common.BasePage;


public abstract class BaseProjectPage<ConfigurePage> extends BasePage<BaseProjectPage<?>> {

    public BaseProjectPage(WebDriver driver) {
        super(driver);
    }

    public abstract ConfigurePage clickConfigureLinkInSideMenu();
}
