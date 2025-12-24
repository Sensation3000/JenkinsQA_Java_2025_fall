package school.redrover.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.common.BasePage;
import java.util.List;


public class BuildHistoryOfJenkinsPage extends BasePage<BuildHistoryOfJenkinsPage> {

    @FindBy(xpath = "//table[@id='projectStatus']/tbody/tr")
    private List<WebElement> buildHistoryTableRows;

    @FindBy(css = "thead th a.sortheader")
    private List<WebElement> tableHeaders;

    @FindBy(tagName = "h1")
    private WebElement header;


    public BuildHistoryOfJenkinsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BuildHistoryOfJenkinsPage getPage() {
        return this;
    }

    @Override
    public BuildHistoryOfJenkinsPage waitUntilPageLoad() {
        getWait5().until(ExpectedConditions.textToBePresentInElement(header, "Build History of Jenkins"));

        return this;
    }

    public boolean isBuildHistoryEmpty() {
        return buildHistoryTableRows.isEmpty();
    }

    public List<String> getTableHeadersText() {
        return tableHeaders
                .stream()
                .map(webElement -> webElement.getText()
                        .replaceAll("[↓↑\\s\\u00A0]+$", "")
                        .trim())
                .toList();
    }

    public BuildHistoryOfJenkinsPage changeIconSize(String size) {
        int z = 0;
        if (size.equals("Small")) {
            z = 1;
        } else if (size.equals("Medium")) {
            z = 2;
        } else z = 3;

        getDriver().findElement(By.cssSelector("#main-panel > div.jenkins-icon-size > div.jenkins-icon-size__items.jenkins-buttons-row > ol > li:nth-child(%s) > a".formatted(z))).click();
        return new BuildHistoryOfJenkinsPage(getDriver());
    }

    public String checkIconSize() {
        return getDriver().findElement(By.cssSelector(".jenkins-icon-size > :nth-child(1) > ol > li[tooltip]")).getAttribute("title");
    }
}
