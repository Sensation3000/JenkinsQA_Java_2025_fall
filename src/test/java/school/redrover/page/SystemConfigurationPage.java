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
import java.util.List;
import java.util.stream.Collectors;



public class SystemConfigurationPage extends BasePage<SystemConfigurationPage> {

    @FindBy(name = "Submit")
    private WebElement clickSaveButton;

    @FindBy(css = "[id='cb3'] + label")
    private WebElement globalProperties;

    @FindBy(xpath = "//a[contains(@tooltip,'Disable deferred wipeout on this node')]")
    private WebElement checkboxTooltip;

    @FindBy(xpath = "//div[@nameref='cb3']//div[@class='help']/div[1]")
    private WebElement hintText;

    @FindBy(name = "builtin.mode")
    private WebElement usageModeDropdown;


    public SystemConfigurationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SystemConfigurationPage getPage() {
        return this;
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

    public SystemConfigurationPage clickCheckboxGlobalProperties() {
        if (!getDriver().findElement(By.cssSelector("[id='cb3'] + label")).isSelected()) {
            globalProperties.click();
    }
        return this;
    }

    public HomePage clickSaveButton() {
        clickSaveButton.click();

        return new HomePage(getDriver()).waitUntilPageLoad();
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

    public List<String> getUsageModeOptions() {
        Select select = new Select(usageModeDropdown);

        return select.getOptions()
                .stream()
                .map(WebElement::getText)
                .toList();
    }
}


