package school.redrover.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface IBaseModel {

    WebDriver getDriver();

    WebDriverWait getWait2();
    WebDriverWait getWait5();
    WebDriverWait getWait10();
}
