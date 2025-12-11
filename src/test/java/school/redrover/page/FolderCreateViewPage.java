package school.redrover.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.common.BasePage;


public class FolderCreateViewPage extends BasePage<FolderCreateViewPage> {

    @FindBy(id = "name")
    private WebElement inputViewName;

    @FindBy(css = "[for='hudson.model.ProxyView']")
    private WebElement inputGlobalView;

    @FindBy(css = "[for='hudson.model.ListView']")
    private WebElement inputListView;

    @FindBy(css = "[for='hudson.model.MyView']")
    private WebElement inputMyView;


    public FolderCreateViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FolderCreateViewPage waitUntilPageLoad() {
        getWait5().until(ExpectedConditions.visibilityOf(inputGlobalView));

        return this;
    }

    public FolderCreateViewPage sendName(String name) {
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.className("help-sibling")));

        inputViewName.sendKeys(name);
        return this;
    }

    public FolderCreateViewPage selectTypeGlobalView() {
        inputGlobalView.click();

        return this;
    }

    public FolderCreateViewPage selectTypeListView() {
        inputListView.click();

        return this;
    }

    public FolderCreateViewPage selectTypeMyView() {
        inputMyView.click();

        return this;
    }

    public FolderViewPage clickCreate() {
        getDriver().findElement(By.id("ok")).click();

        return new FolderViewPage(getDriver());
    }
}
