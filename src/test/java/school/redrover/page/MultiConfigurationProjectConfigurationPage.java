package school.redrover.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.common.BasePage;
import school.redrover.type.BasePageWithHeading;


public class MultiConfigurationProjectConfigurationPage extends BasePage<MultiConfigurationProjectConfigurationPage> implements BasePageWithHeading {

    @FindBy(name = "Submit")
    private WebElement submitButton;

    @FindBy(id = "configuration-matrix")
    private WebElement configurationMatrix;


    public MultiConfigurationProjectConfigurationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MultiConfigurationProjectConfigurationPage waitUntilPageLoad() {
        getWait5().until(ExpectedConditions.visibilityOf(configurationMatrix));

        return this;
    }

    public MultiConfigurationProjectPage clickSubmit() {
        submitButton.click();
        getWait5().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.className("permalinks-header")));

        return new MultiConfigurationProjectPage(getDriver());
    }

    public String getConfigurationMatrixText() {
        return getWait5().until(ExpectedConditions.visibilityOf(configurationMatrix)).getText().trim();
    }
}
