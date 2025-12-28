package school.redrover.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.common.BasePage;


public class MultibranchPipelineRenamingPage extends BasePage<MultibranchPipelineRenamingPage> {

    @FindBy(name = "newName")
    private WebElement renameField;


    public MultibranchPipelineRenamingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MultibranchPipelineRenamingPage getPage() {
        return this;
    }

    @Override
    public MultibranchPipelineRenamingPage waitUntilPageLoad() {
        getWait5().until(ExpectedConditions.visibilityOf(renameField));

        return this;
    }

    public MultibranchPipelineRenamingPage renameJob(String jobName) {
        renameField.clear();
        renameField.sendKeys(jobName);

        return this;
    }

    public ErrorPage submitForm() {
        getDriver().findElement(By.tagName("form")).submit();

        return new ErrorPage(getDriver());
    }

    public MultibranchPipelineProjectStatusPage renameMultibranchPipeline(String jobName) {
        renameField.clear();
        renameField.sendKeys(jobName + Keys.ENTER);

        getWait5().until(ExpectedConditions.not(ExpectedConditions.urlContains("confirm-rename")));

        return new MultibranchPipelineProjectStatusPage(getDriver()).waitUntilPageLoadJS();
    }
}
