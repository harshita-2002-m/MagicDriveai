package utils;

import org.openqa.selenium.By;

public class MagicDriveLocators {
    // Updated locators with clear and specific xpaths
    public static final By[] sectionLocators = {
        By.xpath("//div[contains(@class, 'brz-bg-color')][1]"),
        By.xpath("//div[contains(@class, 'brz-bg-color')][2]"),
        By.xpath("//section[@id='x4imlPVQoyOT']"),
        By.xpath("//footer[contains(@class, 'brz-bg-color')]") // Footer
    };

    public static final By logo = By.xpath("(//a[@class='brz-a'])[1]");
    public static final By contactUsButton = By.linkText("Contact Us");
    public static final By emailField = By.cssSelector("[name='exCMWA06TcpS']");
    public static final By phoneField = By.cssSelector("[name='wguyE5gAq98v']");
    public static final By messageField = By.cssSelector("[name='pV4RReA0cNTo']");
    public static final By submitButton = By.xpath("(//button[@class='brz-btn brz-btn-submit brz-css-cwf5U brz-css-pZsm7'])[1]");
    public static final By successMessage = By.xpath("(//div[@class='brz-forms2__alert brz-forms2__alert--success'])[1]");
    public static final By featuresButton = By.xpath("(//a[@class='brz-a brz-anchor brz-btn brz-css-cwf5U brz-css-bK4LX'])[1]");
    public static final By featuresSection = By.xpath("(//div[@class='brz-section__content brz-section--boxed brz-css-ozn_g brz-css-cslv1'])[1]");
    public static final By exploreButton = By.xpath("(//a[@class='brz-a brz-anchor brz-btn brz-css-cwf5U brz-css-v2hXY'])[1]");
    public static final By suiteSection = By.xpath("(//section[@id='Solutions'])[1]");
    public static final By suiteSection1 = By.xpath("//div[contains(@class, 'suite-section-1')]");
    public static final By suiteSection2 = By.xpath("//div[contains(@class, 'suite-section-2')]");
}
