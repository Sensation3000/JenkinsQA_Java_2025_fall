package school.redrover.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class TestUtils {

    public static void clickJS(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void clickJS(WebDriver driver, By locator) {
        clickJS(driver, driver.findElement(locator));
    }

    public static void mouseEnterJS(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].dispatchEvent(new Event('mouseenter'));", element);
    }

    public static void focusAndEnterByKeyboard(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", element);
        WebElement activeElement = driver.switchTo().activeElement();
        activeElement.sendKeys(Keys.ENTER);
    }

    public static String getTextJS(WebDriver driver, WebElement element) {
        return (String) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].innerText;", element);
    }

    public static <Page extends BasePage<?>> Page waitUntilPageLoad(Page page) {

        // delay to make sure the page starts to reload
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }

        new WebDriverWait(page.getDriver(), java.time.Duration.ofSeconds(10)).until(
                webDriver -> Objects.equals(((JavascriptExecutor) webDriver).executeScript("return document.readyState"), "complete")
        );

        return page;
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});",
                element);
    }
}
