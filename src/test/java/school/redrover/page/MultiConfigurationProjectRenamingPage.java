package school.redrover.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.common.BasePage;


public class MultiConfigurationProjectRenamingPage extends BasePage<MultiConfigurationProjectRenamingPage> {

    @FindBy(name = "newName")
    private WebElement nameField;


    public MultiConfigurationProjectRenamingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MultiConfigurationProjectRenamingPage waitUntilPageLoad() {
        getWait5().until(ExpectedConditions.visibilityOf(nameField));

        return this;
    }

    public MultiConfigurationProjectRenamingPage clearNameField() {
        nameField.clear();

        return this;
    }

    public MultiConfigurationProjectStatusPage setNewProjectName(String jobName) {
        nameField.sendKeys(jobName + Keys.ENTER);

        return new MultiConfigurationProjectStatusPage(getDriver()).waitUntilPageLoad();
    }

}
