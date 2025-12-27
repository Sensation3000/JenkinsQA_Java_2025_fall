package school.redrover.component;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import school.redrover.common.BaseModel;

import java.util.Objects;

public abstract class BaseComponent<Component extends BaseComponent<?>> extends BaseModel {

    public BaseComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public abstract Component getComponent();

    public abstract Component waitUntilComponentLoad();

    public Component waitUntilComponentLoadJS() {

        // delay to make sure the page starts to reload
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }

        new WebDriverWait(getDriver(), java.time.Duration.ofSeconds(10)).until(
                webDriver -> Objects.equals(((JavascriptExecutor) webDriver).executeScript("return document.readyState"), "complete")
        );

        return getComponent();
    }
}
