package SeleniumWebAutomation.pages;

import org.openqa.selenium.WebDriver;
import SeleniumWebAutomation.utils.Constants;
import org.openqa.selenium.support.PageFactory;
import SeleniumWebAutomation.common.CommonTest;
import SeleniumWebAutomation.common.CommonMethods;
import SeleniumWebAutomation.common.AssertOperations;

public class HomePage extends CommonTest {
    public HomePage(WebDriver driver) { PageFactory.initElements(driver, this); }

    CommonMethods commonMethods = new CommonMethods();
    Constants constants = new Constants();
    AssertOperations assertOperations = new AssertOperations();

    public void Control() {
        commonMethods.ImplicitlyWait(10);
    	assertOperations.CheckAssertTrue(getDriver().getCurrentUrl(), constants.url);
    }
}