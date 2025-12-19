package school.redrover.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import school.redrover.common.BasePage;


public class CredentialsPage extends BasePage<CredentialsPage> {

    public CredentialsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CredentialsPage waitUntilPageLoad() {
        return null;
    }

    public WebElement getCredentialsName(String name) {

        return getDriver().findElement(By.xpath("//a[contains(., '" + name + "')]"));
    }


    public GlobalCredentialsPage clickGlobalLink() {

        new Actions(getDriver())
                .doubleClick(getDriver().findElement(By.xpath("//a[contains(text(), 'global')]")))
                .perform();

        return new GlobalCredentialsPage(getDriver());
    }
}
