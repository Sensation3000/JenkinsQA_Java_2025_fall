package school.redrover.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import school.redrover.common.BasePage;


public class CloudsPage extends BasePage<CloudsPage> {

    public CloudsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CloudsPage waitUntilPageLoad() {
        return null;
    }

    public String getParagraphText() {
        return getDriver().findElement(By.xpath("//p")).getText();
    }
}
