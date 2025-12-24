package school.redrover.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.common.BasePage;


public class CloudsPage extends BasePage<CloudsPage> {

    public CloudsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CloudsPage getPage() {
        return this;
    }

    @Override
    public CloudsPage waitUntilPageLoad() {
        getWait5().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.tagName("h1"))));

        return this;
    }

    public String getParagraphText() {
        return getDriver().findElement(By.xpath("//p")).getText();
    }
}
