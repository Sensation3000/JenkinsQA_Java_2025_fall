package school.redrover.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import school.redrover.component.SearchComponent;
import school.redrover.page.*;

import java.util.Objects;


public abstract class BasePage<Page> extends BaseModel {

    @FindBy(id = "root-action-ManageJenkinsAction")
    private WebElement manageJenkinsButton;

    @FindBy(id = "root-action-UserAction")
    private WebElement userAccountIcon;

    @FindBy(xpath = "//a[@href='api/']")
    private WebElement restApiLink;

    @FindBy(css = ".page-footer__links > button")
    private WebElement jenkinsVersion;

    @FindBy(css = ".jenkins-dropdown__item:last-child")
    private WebElement signOutButton;


    public BasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public abstract Page getPage();

    public abstract Page waitUntilPageLoad();

    public Page waitUntilPageLoadJS() {

        // delay to make sure the page starts to reload
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }

        new WebDriverWait(getDriver(), java.time.Duration.ofSeconds(10)).until(
                webDriver -> Objects.equals(((JavascriptExecutor) webDriver).executeScript("return document.readyState"), "complete")
        );

        return getPage();
    }

    public WebElement getHeader() {
        return getWait5().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.tagName("h1"))));
    }

    public HomePage gotoHomePage() {
        getWait5().until(ExpectedConditions.elementToBeClickable(By.className("app-jenkins-logo"))).click();

        return new HomePage(getDriver());
    }

    public JenkinsManagementPage clickManageJenkinsGear() {
        manageJenkinsButton.click();

        return new JenkinsManagementPage(getDriver()).waitUntilPageLoad();
    }

    public UserStatusPage clickUserAccountViaDropDownMenu(String userName) {
        WebElement userIcon = getWait10().until(ExpectedConditions.visibilityOfElementLocated(
                By.id("root-action-UserAction")));
        PageUtils.mouseEnterJS(getDriver(), userIcon);

        WebElement userInDropDown = getWait10().until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//a[contains(@class, 'jenkins-dropdown__item') and contains(., '%s')]".formatted(userName))));
        PageUtils.clickJS(getDriver(), userInDropDown);

        return new UserStatusPage(getDriver());
    }

    public SearchComponent clickSearchButton() {
        getDriver().findElement(By.id("root-action-SearchAction")).click();

        return new SearchComponent(getDriver()).waitUntilComponentLoadJS();
    }

    public LoginPage clickSignOut() {
        Actions actions = new Actions(getDriver());

        actions.moveToElement(userAccountIcon).perform();
        signOutButton.click();

        return new LoginPage(getDriver());
    }

    public String getJenkinsVersion() {
        return jenkinsVersion.getText();
    }

    public FooterDropdownPage clickJenkinsVersion() {
        getDriver().findElement(By.cssSelector(".page-footer__links > button")).click();
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.className("jenkins-dropdown")));

        return new FooterDropdownPage(getDriver());
    }

    public String getRestApiLinkText() {
        WebElement footer = getDriver().findElement(By.tagName("footer"));

        return footer.findElement(By.linkText("REST API")).getText();
    }

    public RestApiPage clickRestApiLink() {
        PageUtils.clickJS(getDriver(), restApiLink);

        return new RestApiPage(getDriver()).waitUntilPageLoadJS();
    }

    public String getCurrentUrl() {

        return getDriver().getCurrentUrl();
    }

    public UserStatusPage clickUserAccountIcon() {
        userAccountIcon.click();

        return new UserStatusPage(getDriver()).waitUntilPageLoad();
    }

    public String getUserNameFromDropDownMenu() {
        WebElement userIcon = getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.id("root-action-UserAction")));
        PageUtils.mouseEnterJS(getDriver(), userIcon);

        WebElement userInDropDown = getWait10().until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector(".jenkins-dropdown__item:first-child")));

        return PageUtils.getTextJS(getDriver(), userInDropDown);
    }

    public String getLogoText() {
        return getWait5().until(ExpectedConditions.
                visibilityOfElementLocated(By.className("app-jenkins-logo"))).getText();
    }
}
