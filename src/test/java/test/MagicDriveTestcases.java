package test;

import helper.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MagicDriveMethods;
import utils.MagicDriveLocators;

public class MagicDriveTestcases extends BaseTest {

    private MagicDriveMethods methods;
    private static final String EXPECTED_TITLE = "MagicDrive";

    // Initialize the methods object before each test
    @BeforeMethod
    public void setUp() {
        methods = new MagicDriveMethods(driver); // Initialize the methods object
    }

    @Test(priority = 1)
    public void TC_01() {
        methods.validateTitle(EXPECTED_TITLE);
        methods.validateSections(MagicDriveLocators.sectionLocators);
    }

    @Test(priority = 2)
    public void TC_02() {
        methods.validateTitle(EXPECTED_TITLE);
        methods.verifyLogoClickable(EXPECTED_TITLE);
    }

    @Test(priority = 3)
    public void TC_03() {
        methods.validateTitle(EXPECTED_TITLE);
        methods.fillAndSubmitContactForm("test@example.com", "1234567890", "Test message");
    }

    @Test(priority = 4)
    public void TC_04() {
        methods.validateTitle(EXPECTED_TITLE);
        methods.verifyFeaturesDisplayed();
    }

    @Test(priority = 5)
    public void TC_05() {
        methods.validateTitle(EXPECTED_TITLE);
        methods.exploreSuite();
    }

    @Test(priority = 6)
    public void TC_06() {
        methods.validateTitle(EXPECTED_TITLE);
        methods.verifyAllSuiteSections();
    }
}
