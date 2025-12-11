package school.redrover.page;

import org.openqa.selenium.WebDriver;
import school.redrover.common.BasePage;
import school.redrover.type.BasePageWithHeading;


public abstract class BaseProjectPage<ConfigurePage> extends BasePage<BaseProjectPage<?>> implements BasePageWithHeading {

    public BaseProjectPage(WebDriver driver) {
        super(driver);
    }

    public abstract ConfigurePage clickConfigureLinkInSideMenu();
}
