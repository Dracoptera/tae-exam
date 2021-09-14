package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
    }

    // General utility methods

    public void clickElement(By locator) {
        waitForElementToBeClickable(locator);
        driver.findElement(locator).click();
    }

    public List<WebElement> getWebElementList(By element) {
        return driver.findElements(element);
    }

    public String extractDigits(String src) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (Character.isDigit(c)) {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    // Waits

    public void waitForElementToBeClickable(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForWebElementToBeClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToDisappear(By locator) {
        getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForAnnouncementText(By locator, String text) {
        getWait().until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public void waitForElementToBeVisible(By locator) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementTest(WebElement element) {
        getWait().until(ExpectedConditions.stalenessOf(element));
    }

    public void waitImplicitly() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void switchToNewTab() {
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        for (String handle : handles) {

            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
            }
        }
    }

    public WebDriverWait getWait() {
        return this.wait;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void scrollToBottom() {
        ((JavascriptExecutor)driver).executeScript(
                "document.body.scrollTop = -1 >>> 1");
    }

    public void closeModalIfPresent(By modalLocator, By closeLocator) {
        try {
            waitForElementToBeVisible(modalLocator);
            clickElement(closeLocator);
        } catch (Exception e) {
            System.out.print("The promotion modal is not present.");
        }
    }
}
