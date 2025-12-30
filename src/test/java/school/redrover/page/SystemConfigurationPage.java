package school.redrover.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import school.redrover.common.BasePage;
import school.redrover.common.PageUtils;

import java.util.List;


public class SystemConfigurationPage extends BasePage<SystemConfigurationPage> {

    @FindBy(name = "Submit")
    private WebElement saveButton;

    @FindBy(xpath = "//label[text()='Disable deferred wipeout on this node']")
    private WebElement globalPropertiesDisableWipeoutCheckboxToClick;

    @FindBy(id = "cb3")
    private WebElement globalPropertiesDisableWipeoutCheckboxIsEnabled;

    @FindBy(xpath = "//a[contains(@tooltip,'Disable deferred wipeout on this node')]")
    private WebElement globalPropertiesDisableWipeoutCheckboxQuestion;

    @FindBy(css = "[data-tippy-root]")
    private WebElement globalPropertiesDisableWipeoutCheckboxTooltip;

    @FindBy(xpath = "//div[@nameref='cb3']//div[@class='help']/div[1]")
    private WebElement hintText;

    @FindBy(name = "builtin.mode")
    private WebElement usageModeDropdown;

    @FindBy(id = "metrics")
    private WebElement metrics;

    @FindBy(name = "_.computerRetentionCheckInterval")
    private WebElement inputComputerRetentionCheckInterval;

    @FindBy(name = "_.quietPeriod")
    private WebElement quietPeriodInput;

    @FindBy(name = "Apply")
    private WebElement applyButton;

    @FindBy(xpath = "//div[text()='This value should be between 1 and 60']/..")
    private WebElement hintForInvalidComputerRetentionCheckInterval;


    public SystemConfigurationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SystemConfigurationPage getPage() {
        return this;
    }

    @Override
    public SystemConfigurationPage waitUntilPageLoad() {
        getWait5().until(ExpectedConditions.elementToBeClickable(globalPropertiesDisableWipeoutCheckboxQuestion));

        return this;
    }

    public HomePage clickSave() {
        saveButton.click();

        return new HomePage(getDriver()).waitUntilPageLoadJS();
    }

    public SystemConfigurationPage setSystemMessage(String systemMessage) {
        WebElement systemMessageTextArea = getDriver().findElement(By.name("system_message"));
        systemMessageTextArea.sendKeys(systemMessage);

        return this;
    }

    public SystemConfigurationPage clearSystemMessage() {
        WebElement systemMessageTextArea = getDriver().findElement(By.name("system_message"));
        systemMessageTextArea.clear();

        return this;
    }

    public String getPreviewSystemMessage() {
        getDriver().findElement(By.className("textarea-show-preview")).click();

        return getWait2().until(ExpectedConditions.visibilityOfElementLocated(
                By.className("textarea-preview"))).getText();
    }

    public SystemConfigurationPage setNumberOfExecutors(String numberOfExecutors) {
        WebElement systemMessageTextArea = getDriver().findElement(By.name("_.numExecutors"));
        systemMessageTextArea.clear();
        systemMessageTextArea.sendKeys(numberOfExecutors);

        return this;
    }

    public Integer getNumberOfOpenTooltips() {
        return getDriver().findElements(By.cssSelector("div .help[style='display: block;']")).size();
    }

    public SystemConfigurationPage clickTooltip(String tooltipName) {
        WebElement tooltip = getDriver().findElement(By.cssSelector("a[tooltip= 'Help for feature: %s']".formatted(tooltipName)));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", tooltip);
        tooltip.click();

        return this;
    }

    public SystemConfigurationPage checkGlobalPropertiesDisableWipeoutCheckbox() {
        if (!globalPropertiesDisableWipeoutCheckboxIsEnabled.isSelected()) {
            new Actions(getDriver())
                    .moveToElement(metrics)
                    .perform();

            globalPropertiesDisableWipeoutCheckboxToClick.click();
        }

        return this;
    }

    public boolean isGlobalPropertiesDisableWipeoutCheckboxSelected() {
        return globalPropertiesDisableWipeoutCheckboxIsEnabled.isSelected();
    }

    public WebElement getGlobalPropertiesDisableWipeoutCheckboxTooltipOnHover() {
        new Actions(getDriver()).moveToElement(metrics).perform();
        new Actions(getDriver()).moveToElement(globalPropertiesDisableWipeoutCheckboxQuestion).perform();

        return getWait5().until(ExpectedConditions.visibilityOf(globalPropertiesDisableWipeoutCheckboxTooltip));
    }

    public SystemConfigurationPage clickCheckboxTooltip() {
        new Actions(getDriver()).moveToElement(metrics).perform();
        new Actions(getDriver())
                .moveToElement(globalPropertiesDisableWipeoutCheckboxQuestion)
                .click()
                .perform();

        return this;
    }

    public String getHintText() {
        return hintText.getText().trim();
    }

    public List<String> getUsageModeOptions() {
        Select select = new Select(usageModeDropdown);

        return select.getOptions()
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public String getInputComputerRetentionCheckIntervalValue() {
        return inputComputerRetentionCheckInterval.getAttribute("value");
    }

    public SystemConfigurationPage setInputComputerRetentionCheckIntervalValue(String intervalValue) {
        inputComputerRetentionCheckInterval.clear();
        inputComputerRetentionCheckInterval.sendKeys(intervalValue);

        return this;
    }

    public SystemConfigurationPage clearQuietPeriod() {
        PageUtils.scrollToElement(getDriver(), quietPeriodInput);
        quietPeriodInput.clear();

        return this;
    }

    public SystemConfigurationPage setQuietPeriod(String seconds) {
        quietPeriodInput.sendKeys(seconds);

        return this;
    }

    public String getInputQuietPeriodValue() {
        return quietPeriodInput.getAttribute("value");
    }

    public ErrorPage clickSaveButtonWithInvalidValue() {
        saveButton.click();

        return new ErrorPage(getDriver());
    }

    public SystemConfigurationPage clickApply() {
        applyButton.click();

        return this;
    }

    public WebElement getHintForInvalidComputerRetentionCheckIntervalElement() {
        return hintForInvalidComputerRetentionCheckInterval;
    }
}