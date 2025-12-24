package school.redrover.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.trait.project_sidebar.SidebarBuildHistoryTrait;
import school.redrover.trait.project_sidebar.SidebarCredentialsTrait;
import school.redrover.trait.project_sidebar.SidebarMoveTrait;


public class OrganizationFolderStatusPage extends BaseProjectStatusPage<OrganizationFolderStatusPage>
        implements SidebarBuildHistoryTrait, SidebarMoveTrait, SidebarCredentialsTrait {

    @FindBy(xpath = "//span[text()='Delete Organization Folder']/ancestor::a")
    private WebElement deleteMenuItem;

    @FindBy(name = "Submit")
    private WebElement submitButton;


    public OrganizationFolderStatusPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public OrganizationFolderStatusPage getPage() {
        return this;
    }

    @Override
    public OrganizationFolderStatusPage waitUntilPageLoad() {
        getWait10().until(ExpectedConditions.visibilityOf(deleteMenuItem));

        return this;
    }

    public String getDisplayNameOrganizationFolder() {
        return getWait2().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1"))).getText();
    }

    public String getDescriptionOrganizationFolder() {
        return getWait2().until(ExpectedConditions.visibilityOfElementLocated(
                By.id("view-message"))).getText();
    }

    public OrganizationFolderStatusPage clickDelete() {
         getWait2().until(ExpectedConditions.elementToBeClickable(By.className("icon-edit-delete"))).click();

         return this;
    }

    public HomePage clickYesConfirmationDelete() {
        getWait2().until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-id='ok']"))).click();

        return new HomePage(getDriver());
    }
}