package school.redrover.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MultibranchPipelineConfigurationPage extends BaseProjectConfigurationPage<MultibranchPipelineConfigurationPage> {

    @FindBy(name = "_.description")
    private WebElement descriptionField;

    @FindBy(name = "Submit")
    private WebElement submitButton;

    @FindBy(css = "[data-title='Disabled']")
    private WebElement toggleSwitcher;

    @FindBy(id = "toggle-switch-enable-disable-project")
    private WebElement toggleTooltipOnHover;


    public MultibranchPipelineConfigurationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MultibranchPipelineConfigurationPage getPage() {
        return this;
    }

    @Override
    public MultibranchPipelineConfigurationPage waitUntilPageLoad() {
        getWait5().until(ExpectedConditions.elementToBeClickable(toggleSwitcher));

        return this;
    }

    public MultibranchPipelineConfigurationPage sendDisplayName(String name) {
        getDriver().findElement(By.xpath("//input[@name='_.displayNameOrNull']")).sendKeys(name);

        return this;
    }

    public MultibranchPipelineProjectStatusPage clickSaveButton() {
        submitButton.click();

        return new MultibranchPipelineProjectStatusPage(getDriver()).waitUntilPageLoad();
    }

    public MultibranchPipelineConfigurationPage clickApply() {
        getWait2().until(ExpectedConditions.visibilityOfElementLocated(By.name("Apply"))).click();

        return this;
    }

    public String getSavedMessage() {
        return getWait5().until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//span[text() = 'Saved']"))).getText();
    }

    public MultibranchPipelineConfigurationPage clickToggle() {
        toggleSwitcher.click();

        return this;
    }

    public String getToggleState() {
        try {
            return getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.className("jenkins-toggle-switch__label__unchecked-title")))
                    .getText();
        } catch (Exception ignore) {
        }

        return "Enabled";
    }

    public String getToggleTooltipTextOnHover() {
        new Actions(getDriver()).moveToElement(toggleTooltipOnHover).perform();

        return getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.className("tippy-content")))
                .getText();
    }

    public MultibranchPipelineConfigurationPage sendDescription(String description) {
        descriptionField.clear();
        descriptionField.sendKeys(description);

        return this;
    }

    public String getJobDescriptionPreviewText() {
        getDriver().findElement(By.className("textarea-show-preview")).click();

        return getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.className("textarea-preview")))
                .getText();
    }

    public String getBreadcrumbItem() {
        return getWait10().until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//span[contains(text(),'Configuration')]"))).getText();
    }
}
