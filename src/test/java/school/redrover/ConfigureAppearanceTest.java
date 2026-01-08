package school.redrover;

import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.common.BaseTest;
import school.redrover.page.HomePage;


public class ConfigureAppearanceTest extends BaseTest {
    private final String THEME = "dark";

   @Test
    public void testSystemThemeAndApplyButtonPopUp() {
        String expectedText = "Saved";
        String popUpApplyButtonText = new HomePage(getDriver())
                .clickManageJenkinsGear()
                .clickAppearanceLink()
                .clickSystemTheme()
                .clickApplyButton()
                .getApplyPopUp()
                .getText();

        Assert.assertEquals(popUpApplyButtonText, expectedText);
    }

   @Test(dependsOnMethods = "testSystemThemeAndApplyButtonPopUp")
    public void testChangeDarkThemeAndSaveButton() {
        String expectedTeg = "dark";
        String themaHtmlText = new HomePage(getDriver())
                .clickManageJenkinsGear()
                .clickAppearanceLink()
                .clickDarkTheme()
                .checkAllowTheme()
                .clickSaveButton()
                .getHTMLAttributeThemeText();

        Assert.assertEquals(themaHtmlText, expectedTeg);
    }

    @Test(dependsOnMethods = "testChangeDarkThemeAndSaveButton")
    public void changeTheme() {
        String checking = new HomePage(getDriver())
                .clickManageJenkinsGear()
                .clickAppearanceLink()
                .changeTheme(THEME)
                .clickDoNotAllowDifferentTheme()
                .clickApplyButton()
                .getHTMLAttributeThemeText();

        Assert.assertEquals(checking, THEME);
    }

    @Test(dependsOnMethods = "changeTheme")
    public void changeThemeLight() {
        String finalTheme = "Saved";
        String checkingLight = new HomePage(getDriver())
                .clickManageJenkinsGear()
                .clickAppearanceLink()
                .clickLightTheme()
                .checkAllowTheme()
                .clickApplyButton()
                .getApplyPopUp()
                .getText();

        Assert.assertEquals(checkingLight, finalTheme);
    }
}
