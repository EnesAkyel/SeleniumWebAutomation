package SeleniumWebAutomation.common;

import java.util.List;
import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import SeleniumWebAutomation.utils.Constants;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommonMethods extends CommonTest {
    Constants constants = new Constants();
    Logger logger = Logger.getLogger(CommonMethods.class.getName());

    public List<WebElement> FindElements(By webElement){ return getDriver().findElements(webElement); }

    public void ClickElement(WebElement webElement){ webElement.click(); }

    public String GetAttribute(WebElement webElement, String attribute) { return webElement.getAttribute(attribute); }

    public String GetAttributeValue(WebElement webElement) { return GetAttribute(webElement, "value"); }

    public String GetTextAttribute(WebElement webElement) { return GetAttribute(webElement, "innerHTML"); }

    public String GetText(WebElement webElement) { return webElement.getText(); }

    public void SendKeys(WebElement webElement, String string) { webElement.sendKeys(string); }

    public void SendEnter(WebElement webElement) { webElement.sendKeys(Keys.ENTER); }

    public boolean IsElementVisible(WebElement webElement) { return webElement.isDisplayed(); }

    public void ThreadSleep(int time) throws InterruptedException { Thread.sleep(time); }

    public void ImplicitlyWait(int time) { getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(time)); }

    public void ExplicitlyWait(int time, By webElement) {
        Duration durationTime = Duration.ofSeconds(time);
        WebDriverWait wait = new WebDriverWait(getDriver(), durationTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) getDriver())
                .executeScript("return document.readyState").toString().equals("complete");
        try {
            Duration durationTime = Duration.ofSeconds(30);
            WebDriverWait wait = new WebDriverWait(getDriver(), durationTime);
            wait.until(expectation);
        } catch (Throwable error) {
            WarningLogger();
        }
    }

    public void ClosePopUp(WebElement element) {
        if(IsElementVisible(element))
            ClickElement(element);
        else {
            InfoLogger(constants.elementNotVisible);
        }
    }

    public void switchToTab() {
        ArrayList<String> newTb = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(newTb.get(1));
    }

    public void javaScriptExecutor(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click()", webElement);
    }

    public void WarningLogger() {
        logger.log(Level.WARNING, constants.warningLoggerMessage);
    }

    public void InfoLogger(String message) {
        logger.log(Level.INFO, message);
    }
}