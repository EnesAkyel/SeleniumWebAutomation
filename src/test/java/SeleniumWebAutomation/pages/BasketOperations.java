package SeleniumWebAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import SeleniumWebAutomation.utils.Constants;
import org.openqa.selenium.support.PageFactory;
import SeleniumWebAutomation.common.CommonTest;
import SeleniumWebAutomation.common.CommonMethods;
import SeleniumWebAutomation.common.AssertOperations;

public class BasketOperations extends CommonTest {
	public BasketOperations(WebDriver driver) { PageFactory.initElements(driver, this); }

	Constants constants = new Constants();
	CommonMethods commonMethods = new CommonMethods();
	AssertOperations assertOperations = new AssertOperations();

	@FindBy( className = "i-trash")
	public WebElement removeItem;

	@FindBy( className = "counter-content")
	public WebElement quantity;

	@FindBy( css = "button[class='ty-font-w-semi-bold ty-button ty-bordered ty-transition ty-input-medium ty-primary']")
	public WebElement btnDelete;

	@FindBy( xpath = "//div[@class='pb-empty-basket']/div/span")
	public WebElement title;

    public void basketChanges() throws InterruptedException {
		commonMethods.ThreadSleep(5000);

    	assertOperations.CheckAssertEquals(
				constants.increasedBasketAmount, commonMethods.GetAttributeValue(quantity), constants.wrongCount);

		commonMethods.ClickElement(removeItem);
		commonMethods.ImplicitlyWait(10);
		commonMethods.ClickElement(btnDelete);
		commonMethods.ThreadSleep(5000);
		commonMethods.waitForPageLoaded();

		assertOperations.CheckAssertEquals(
				constants.emptyCart, commonMethods.GetText(title), constants.wrongCartMessage);
    }
}