package school.redrover.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.common.TestUtils;

import java.util.List;


public class MultiConfigurationProjectConfigurationPage extends BaseProjectConfigurationPage<MultiConfigurationProjectConfigurationPage> {

    @FindBy(name = "Submit")
    private WebElement submitButton;

    @FindBy(id = "configuration-matrix")
    private WebElement configurationMatrix;

    @FindBy(css = "[suffix=axis]")
    private WebElement addAxisButton;

    @FindBy(className = "jenkins-dropdown__item")
    private List<WebElement> addAxisDropdownList;

    @FindBy(xpath = "//section[2]//button[contains(@class, 'advanced-button')]")
    private WebElement advancedDropdownButton;

    @FindBy(xpath = "//label[text()='Quiet period']")
    private WebElement quietPeriodCheckbox;

    @FindBy(name = "quiet_period")
    private WebElement quietPeriodInput;

    public MultiConfigurationProjectConfigurationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MultiConfigurationProjectConfigurationPage waitUntilPageLoad() {
        getWait5().until(ExpectedConditions.visibilityOf(configurationMatrix));

        return this;
    }

    public MultiConfigurationProjectStatusPage clickSubmit() {
        submitButton.click();
        getWait5().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.className("permalinks-header")));

        return new MultiConfigurationProjectStatusPage(getDriver()).waitUntilPageLoad();
    }

    public String getConfigurationMatrixText() {
        return getWait5().until(ExpectedConditions.visibilityOf(configurationMatrix)).getText().trim();
    }

    public MultiConfigurationProjectConfigurationPage clickAddAxisButton() {
        TestUtils.scrollToElement(getDriver(), addAxisButton);
        getWait10().until(ExpectedConditions.elementToBeClickable(addAxisButton));
        addAxisButton.click();

        getWait10().until(ExpectedConditions.visibilityOf(addAxisDropdownList.get(0)));

        return this;
    }

    public List<String> getAddAxisDropdownItemTextList() {
        return addAxisDropdownList.stream().map(WebElement::getText).toList();
    }

    public MultiConfigurationProjectConfigurationPage clickAdvancedDropdownButton() {
        advancedDropdownButton.click();

        return this;
    }

    public MultiConfigurationProjectConfigurationPage clickQuietPeriodCheckbox() {
        quietPeriodCheckbox.click();

        return this;
    }

    public MultiConfigurationProjectConfigurationPage setQuietPeriodInput(String seconds) {
        WebElement input = quietPeriodInput;
        input.clear();
        input.sendKeys(seconds);

        return this;
    }
}
