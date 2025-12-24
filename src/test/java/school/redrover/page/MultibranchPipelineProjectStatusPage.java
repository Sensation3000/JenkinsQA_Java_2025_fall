package school.redrover.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.project_status_page_interface.ClickableSidebarBuildHistory;
import school.redrover.project_status_page_interface.ClickableSidebarCredentials;
import school.redrover.project_status_page_interface.ClickableSidebarMove;


public class MultibranchPipelineProjectStatusPage extends BaseProjectStatusPage<MultibranchPipelineProjectStatusPage>
        implements ClickableSidebarBuildHistory, ClickableSidebarMove, ClickableSidebarCredentials {

    @FindBy(id = "view-message")
    private WebElement description;

    @FindBy(css = "a[href$='/confirm-rename']")
    private WebElement sidebarRenameLink;

    @FindBy(id = "description-link")
    private WebElement addDescriptionLink;

    @FindBy(name = "description")
    private WebElement descriptionField;

    @FindBy(id = "disabled-message")
    private WebElement disabledMessage;

    @FindBy(xpath = "//span[text()='Delete Multibranch Pipeline']/ancestor::a")
    private WebElement deleteMenuItem;

    @FindBy(name = "Submit")
    private WebElement submitButton;


    public MultibranchPipelineProjectStatusPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MultibranchPipelineProjectStatusPage getPage() {
        return this;
    }

    @Override
    public MultibranchPipelineProjectStatusPage waitUntilPageLoad() {
        getWait5().until(ExpectedConditions.visibilityOf(deleteMenuItem));

        return this;
    }

    public String getDescription() {
        return description.getText();
    }

    public String getDisabledText() {
        return disabledMessage.getText();
    }

    public MultibranchPipelineProjectStatusPage clickAddDescriptionLink() {
        getWait2().until(ExpectedConditions.elementToBeClickable(addDescriptionLink)).click();

        return this;
    }

    public MultibranchPipelineProjectStatusPage sendDescription(String description) {
        descriptionField.clear();
        descriptionField.sendKeys(description);

        return this;
    }

    public String getDescriptionFieldText() {
        return descriptionField
                .getShadowRoot()
                .findElement(By.cssSelector("div"))
                .getText();
    }

    public boolean isAddDescriptionLinkEnabled() {
        return addDescriptionLink.isEnabled();
    }
}
