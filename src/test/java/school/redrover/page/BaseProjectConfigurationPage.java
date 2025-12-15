package school.redrover.page;

import org.openqa.selenium.WebDriver;
import school.redrover.common.BasePage;


public abstract class BaseProjectConfigurationPage<ConfigurationPage> extends BasePage<ConfigurationPage> {

    public BaseProjectConfigurationPage(WebDriver driver) {
        super(driver);
    }
}
