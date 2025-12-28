package school.redrover.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.common.BasePage;


public class JobPage extends BasePage<JobPage> {

    public JobPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Configure")
    private WebElement configure;

    @Override
    public JobPage getPage() {
        return this;
    }

    @Override
    public JobPage waitUntilPageLoad() {
        return null;
    }

    public String checkUrlContains(String projectName) {
        return getDriver().findElement(By.cssSelector("#main-panel > div.jenkins-app-bar > div.jenkins-app-bar__content.jenkins-build-caption > h1")).getText();
    }

    public HomePage gotoHomePage() {
        getDriver().findElement(By.cssSelector("#page-header > div.jenkins-header__main > div > a > span"));
        return new HomePage(getDriver());
    }

    public MultiConfigurationProjectConfigurationPage gotoConfigurationPage(){
        configure.click();
        return new MultiConfigurationProjectConfigurationPage(getDriver());
    }
}
