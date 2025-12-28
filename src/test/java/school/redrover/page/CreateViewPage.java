package school.redrover.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.common.BasePage;

import java.util.List;


public class CreateViewPage extends BasePage<CreateViewPage> {

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(xpath = "//label[text() = 'My View']")
    private WebElement clickMyView;

    @FindBy(tagName = "h1")
    private WebElement header;

    @FindBy(id = "ok")
    private WebElement okButton;

    public CreateViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CreateViewPage getPage() {
        return this;
    }

    @Override
    public CreateViewPage waitUntilPageLoad() {
        getWait5().until(ExpectedConditions.textToBePresentInElement(header, "New view"));

        return this;
    }

    public CreateViewPage sendViewName(String name){
        nameField.sendKeys(name);

        return this;
    }

    public CreateViewPage clickMyViewName(){
        clickMyView.click();

        return this;
    }

    public HomePage clickCreateButtonForNewView() {
        okButton.click();

        return new HomePage(getDriver()).waitUntilPageLoadJS();
    }

    public List<String> getTypeViewList(){
        return getDriver().findElements(By.xpath("//div[@class='jenkins-radio']//label"))
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public EditViewPage selectListViewRadioAndCreate(){
        getDriver().findElement(By.xpath("//label[text() = 'List View']")).click();

        okButton.click();

        return new EditViewPage(getDriver()).waitUntilPageLoadJS();
    }
}
