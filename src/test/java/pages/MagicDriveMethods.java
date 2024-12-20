package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MagicDriveLocators;

public class MagicDriveMethods {

    private WebDriver driver;
    private WebDriverWait wait;

    public MagicDriveMethods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjusted timeout to a reasonable duration
    }

    public void validateTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title Validation Passed: " + actualTitle);
        } else {
            System.out.println("Title Validation Failed. Expected: " + expectedTitle + ", Found: " + actualTitle);
        }
    }

    public void validateSections(By[] locators) {
        boolean allSectionsDisplayed = true;
        for (By locator : locators) {
            try {
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                if (!element.isDisplayed()) {
                    allSectionsDisplayed = false;
                    System.out.println("Section not visible: " + locator);
                }
            } catch (TimeoutException e) {
                allSectionsDisplayed = false;
                System.out.println("Section not found within timeout: " + locator);
            }
        }
        System.out.println(allSectionsDisplayed ? "All sections are visible." : "Some sections are missing.");
    }

    public void verifyLogoClickable(String expectedTitle) {
        try {
            WebElement logo = wait.until(ExpectedConditions.elementToBeClickable(MagicDriveLocators.logo));
            logo.click();
            String actualTitle = driver.getTitle();
            System.out.println(actualTitle.equals(expectedTitle) ? "Logo is clickable and title matched." : "Logo click failed or title mismatch.");
        } catch (Exception e) {
            System.out.println("Error while verifying logo: " + e.getMessage());
        }
    }

    public void fillAndSubmitContactForm(String email, String phone, String message) {
        try {
            driver.findElement(MagicDriveLocators.emailField).sendKeys(email);
            driver.findElement(MagicDriveLocators.phoneField).sendKeys(phone);
            driver.findElement(MagicDriveLocators.messageField).sendKeys(message);

            WebElement submitButton = driver.findElement(MagicDriveLocators.submitButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(MagicDriveLocators.successMessage));
            System.out.println("Form Submission Successful: " + successMessage.getText());
        } catch (Exception e) {
            System.out.println("Error while submitting contact form: " + e.getMessage());
        }
    }

    public void verifyFeaturesDisplayed() {
        try {
            WebElement featuresButton = wait.until(ExpectedConditions.elementToBeClickable(MagicDriveLocators.featuresButton));
            featuresButton.click();
            boolean featuresVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(MagicDriveLocators.featuresSection)).isDisplayed();
            System.out.println(featuresVisible ? "Features section is displayed." : "Features section is not displayed.");
        } catch (Exception e) {
            System.out.println("Error while verifying features: " + e.getMessage());
        }
    }

    public void exploreSuite() {
        scrollTo(1700);
        try {
            WebElement exploreButton = wait.until(ExpectedConditions.elementToBeClickable(MagicDriveLocators.exploreButton));
            exploreButton.click();
            boolean suiteVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(MagicDriveLocators.suiteSection)).isDisplayed();
            System.out.println(suiteVisible ? "Suite section is displayed." : "Suite section is not displayed.");
        } catch (Exception e) {
            System.out.println("Error while exploring suite: " + e.getMessage());
        }
    }

    public void verifyAllSuiteSections() {
        exploreSuite();
        try {
            // Verify additional sections of the suite
            WebElement section1 = wait.until(ExpectedConditions.visibilityOfElementLocated(MagicDriveLocators.suiteSection1));
            WebElement section2 = wait.until(ExpectedConditions.visibilityOfElementLocated(MagicDriveLocators.suiteSection2));
            System.out.println(section1.isDisplayed() && section2.isDisplayed() ? "All suite sections are visible." : "Some suite sections are missing.");
        } catch (Exception e) {
            System.out.println("Error while verifying all suite sections: " + e.getMessage());
        }
    }

    // Helper method for scrolling
    private void scrollTo(int yOffset) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, arguments[0]);", yOffset);
        try {
            Thread.sleep(1000); // Optional: To allow visual scrolling effect
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
