package school.redrover.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.common.BasePage;
import school.redrover.common.TestUtils;


public class FolderRenamingPage extends BasePage<FolderRenamingPage> {

    @FindBy(name = "newName")
    private WebElement newNameField;

    @FindBy(name = "Submit")
    private WebElement renameButton;


    public FolderRenamingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FolderRenamingPage getPage() {
        return this;
    }

    @Override
    public FolderRenamingPage waitUntilPageLoad() {
        getWait5().until(ExpectedConditions.visibilityOf(newNameField));

        return this;
    }

    public FolderRenamingPage sendNewName (String name) {
        getWait2().until(ExpectedConditions.visibilityOf(newNameField)).sendKeys(name);

        return this;
    }

    public FolderStatusPage renameButtonClick () {
        renameButton.click();

        return new FolderStatusPage(getDriver()).waitUntilPageLoadJS();
    }

    public FolderRenamingPage clearName () {
        getWait2().until(ExpectedConditions.visibilityOf(newNameField)).clear();

        return this;
    }
}
