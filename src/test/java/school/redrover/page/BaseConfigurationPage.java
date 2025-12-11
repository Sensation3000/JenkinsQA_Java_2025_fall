package school.redrover.page;

import org.openqa.selenium.WebDriver;
import school.redrover.common.BasePage;


public class BaseConfigurationPage extends BasePage<BaseConfigurationPage> {

    public BaseConfigurationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BaseConfigurationPage waitUntilPageLoad() {
        return null;
    }
}
