package school.redrover.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.common.BasePage;


public class SystemConfigurationPage extends BasePage<SystemConfigurationPage> {

    @FindBy(tagName = "h1")
    private WebElement headingText;

    @FindBy(name = "Submit")
    private WebElement clickSaveButton;

    @FindBy(css = "[id='cb3'] + label")
    private WebElement globalProperties;

    @FindBy(xpath = "//a[contains(@tooltip,'Disable deferred wipeout on this node')]")
    private WebElement checkboxTooltip;

    @FindBy(xpath = "//div[@nameref='cb3']//div[@class='help']/div[1]")
    private WebElement hintText;


    public SystemConfigurationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SystemConfigurationPage waitUntilPageLoad() {
        getWait5().until(ExpectedConditions.elementToBeClickable(checkboxTooltip));

        return this;
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

    public void clickSave() {
        WebElement saveButton = getDriver().findElement(By.name("Submit"));
        saveButton.click();
    }

    public String getHeadingText() {
        return headingText.getText().trim();
    }

    public SystemConfigurationPage clickCheckboxGlobalProperties() {
        globalProperties.click();

        return this;
    }

    public HomePage clickSaveButton() {
        clickSaveButton.click();

        getWait2().until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        return new HomePage(getDriver());
    }

    public boolean checkCheckboxSelected() {
        return getDriver().findElement(By.cssSelector("[id='cb3']")).isSelected();
    }

    public String getCheckboxTooltipTextOnHover() {
        new Actions(getDriver()).moveToElement(checkboxTooltip).perform();

        return getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.className("tippy-content")))
                .getText();
    }

    public SystemConfigurationPage clickCheckboxTooltip() {
        checkboxTooltip.click();

        return this;
    }

    public String getHintText() {
        return hintText.getText().trim();
    }
}
