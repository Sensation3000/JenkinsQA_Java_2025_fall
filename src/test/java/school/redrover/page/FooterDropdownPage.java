package school.redrover.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.common.BasePage;

import java.util.List;


public class FooterDropdownPage extends BasePage<FooterDropdownPage> {

    public FooterDropdownPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FooterDropdownPage getPage() {
        return this;
    }

    @Override
    public FooterDropdownPage waitUntilPageLoad() {
        return null;
    }

    public List<String> getDropdownList() {
        List<WebElement> dropdownElements = getWait2().until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("jenkins-dropdown__item")));

        return dropdownElements
                .stream()
                .map(WebElement::getText)
                .toList();
    }
}