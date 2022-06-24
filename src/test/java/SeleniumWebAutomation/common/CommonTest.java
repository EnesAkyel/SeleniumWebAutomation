package SeleniumWebAutomation.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import SeleniumWebAutomation.utils.Constants;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonTest {
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    Constants constants = new Constants();

    public WebDriver getDriver() { return driver.get(); }

    // @BeforeMethod
    // Runs before each method
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        getDriver().manage().window().maximize();
        getDriver().get(constants.url);
    }

    // @AfterMethod
    // Runs after each method
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
}