package school.redrover.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.common.BasePage;
import school.redrover.type.BasePageWithHeading;

import java.util.List;


public class BuildHistoryOfJenkinsPage extends BasePage<BuildHistoryOfJenkinsPage> implements BasePageWithHeading {

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
}
