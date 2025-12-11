package school.redrover.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.common.BasePage;

import java.util.List;


public class PipelineSyntaxPage extends BasePage<PipelineSyntaxPage> {

    @FindBy(className = "task")
    private List<WebElement> sideMenuButtons;


    public PipelineSyntaxPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PipelineSyntaxPage waitUntilPageLoad() {
        return null;
    }

    public List<String> getListOfButtonsInSideMenu() {

        return sideMenuButtons
                .stream()
                .map(WebElement::getText)
                .toList();
    }
}
