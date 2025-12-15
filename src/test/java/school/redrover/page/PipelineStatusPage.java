package school.redrover.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PipelineStatusPage extends BaseProjectStatusPage<PipelineStatusPage> {

    @FindBy(xpath = "//a[contains(@href, '/configure')]")
    private WebElement configureMenuItem;

    @FindBy(id = "description-link")
    private WebElement descriptionButton;

    @FindBy(xpath = "//a[@href = 'editDescription']")
    private WebElement editDescriptionButton;

    @FindBy(name = "description")
    private WebElement descriptionTextarea;

    @FindBy(name = "Submit")
    private WebElement descriptionSubmitButton;

    @FindBy(id = "description-content")
    private WebElement descriptionContent;

    @FindBy(xpath = "//a[@data-build-success='Build scheduled']")
    private WebElement buildNow;

    @FindBy(xpath = "//span[text()='Delete Pipeline']/ancestor::a")
    private WebElement deletePipeline;

    @FindBy(xpath = "//a[@href='/job/PipelineName/pipeline-syntax']")
    private WebElement pipelineSyntax;

    @FindBy(name = "Submit")
    private WebElement submitButton;


    public PipelineStatusPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PipelineStatusPage waitUntilPageLoad() {
        getWait5().until(ExpectedConditions.visibilityOf(deletePipeline));

        return this;
    }

    public String getDisplayNameInStatus() {
        return getWait10().until(ExpectedConditions.visibilityOfElementLocated(By
                .tagName("h1"))).getText();
    }

    public String getDisplayNameInBreadcrumbBar(String displayName) {
        return getWait10().until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath(".//a[text()='%s']".formatted(displayName)))).getText();
    }

    public PipelineStatusPage addDescriptionAndSave(String description) {
        descriptionTextarea.sendKeys(description);
        descriptionSubmitButton.click();
        getWait5().until(ExpectedConditions.elementToBeClickable(By.id("description-link")));

        return this;
    }

    public String getDescription() {
        return getWait5().until(ExpectedConditions.visibilityOf(descriptionContent)).getText();
    }

    public PipelineStatusPage clearDescription() {
        getDriver().findElement(By.name("description")).clear();
        return this;
    }

    public String getWarningMessage() {
        return getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.id("enable-project")))
                .getText();
    }

    public PipelineStatusPage clickAddDescriptionButton() {
        descriptionButton.click();
        return this;
    }

    public PipelineStatusPage clickEditDescriptionButton() {
        editDescriptionButton.click();
        return this;
    }

    public PipelineStatusPage clickBuildNow() {
        buildNow.click();
        return this;
    }

    public PipelineStatusPage clickDeletePipeline() {
        deletePipeline.click();
        return this;
    }

    public PipelineSyntaxPage clickPipelineSyntax() {
        pipelineSyntax.click();
        return new PipelineSyntaxPage(getDriver());
    }

    public PipelineHistoryPage clickBuildHistory() {
        getWait10()
                .until(ExpectedConditions.elementToBeClickable(By.id("jenkins-build-history")))
                .click();

        return new PipelineHistoryPage(getDriver());
    }

    public HomePage confirmDeleteAtJobPage() {
        getDriver().findElement(By.cssSelector("[data-id='ok']"))
                .click();

        return new HomePage(getDriver());
    }

    public PipelineStatusPage cancelDelete() {
        WebElement yesButton = getWait2().until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//dialog[@open]//button[@data-id='cancel']"))
        );
        yesButton.click();
        getWait5().until(ExpectedConditions.stalenessOf(yesButton));

        return this;
    }
}