package school.redrover.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.common.BasePage;

import java.util.List;
import java.util.function.Consumer;


public class GlobalCredentialsPage extends BasePage<GlobalCredentialsPage> {

    @FindBy(xpath = "//a[text()='Credentials']")
    private WebElement credentialsMenuItem;

    public GlobalCredentialsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GlobalCredentialsPage waitUntilPageLoad() {
        getWait5().until(ExpectedConditions.visibilityOf(credentialsMenuItem));
        return this;
    }

    public CredentialsPage clickCredentials() {
        credentialsMenuItem.click();
        return new CredentialsPage(getDriver()).waitUntilPageLoad();
    }

    public NewCredentialsPage clickAddCredentialsButton() {
        getDriver().findElement(By.xpath("//a[@href = 'newCredentials']")).click();

        return new NewCredentialsPage(getDriver()).waitUntilPageLoad();
    }

    public List<WebElement> getGlobalCredentialsList() {
        return getDriver().findElements(By.xpath("//table[contains(@class,'jenkins-table')]//tbody//tr/td[3]"));
    }

    public GlobalCredentialsPage getGlobalCredentialsList(Consumer<List<WebElement>> listConsumer) {
        listConsumer.accept(getGlobalCredentialsList());

        return this;
    }
}
