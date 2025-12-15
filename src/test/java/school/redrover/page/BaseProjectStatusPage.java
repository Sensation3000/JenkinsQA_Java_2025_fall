package school.redrover.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.common.BasePage;


public abstract class BaseProjectStatusPage<ProjectStatusPage> extends BasePage<ProjectStatusPage> {

    @FindBy(xpath = "//a[contains(., 'Status')]")
    private WebElement statusMenuItem;

    @FindBy(xpath = "//a[contains(@href, '/configure')]")
    private WebElement configureMenuItem;

    @FindBy(xpath = "//a[contains(., 'Rename')]")
    private WebElement renameMenuItem;

    @FindBy(xpath = "//a[contains(., 'Delete')]")
    private WebElement deleteMenuItem;


    public BaseProjectStatusPage(WebDriver driver) {
        super(driver);
    }

    public ProjectStatusPage clickStatusInSideMenu() {
        statusMenuItem.click();

        return this.waitUntilPageLoad();
    }

    public <ConfigurationPage extends BaseProjectConfigurationPage<ConfigurationPage>>
        ConfigurationPage clickConfigureInSideMenu(ConfigurationPage configurationPage) {

        configureMenuItem.click();

        return configurationPage.waitUntilPageLoad();
    }

    public <RenamingPage extends BasePage<RenamingPage>> RenamingPage clickRenameInSideMenu(RenamingPage renamingPage) {
        renameMenuItem.click();

        return renamingPage.waitUntilPageLoad();
    }

    public HomePage clickDeleteInSideMenu() {
        deleteMenuItem.click();

        return new HomePage(getDriver()).waitUntilPageLoad();
    }
}
