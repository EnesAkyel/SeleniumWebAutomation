package SeleniumWebAutomation.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import SeleniumWebAutomation.utils.Constants;
import org.openqa.selenium.support.PageFactory;
import SeleniumWebAutomation.common.CommonTest;
import SeleniumWebAutomation.common.CommonMethods;

public class SelectItem extends CommonTest {
	public SelectItem(WebDriver driver) { PageFactory.initElements(driver, this); }

	CommonMethods commonMethods = new CommonMethods();
	Constants constants = new Constants();

	@FindBy( className = "search-box")
	public WebElement searchData;

	@FindBy( css = "button[class='add-to-basket']")
	public WebElement btnAddBasket;

	@FindBy( css = ".link.account-basket")
	public WebElement myBasket;

	String listOfItems = "//*[@class='prdct-cntnr-wrppr']/div";

    public void selection() throws InterruptedException {
		commonMethods.ThreadSleep(5000);
		commonMethods.SendKeys(searchData, constants.searchTerm);
		commonMethods.ImplicitlyWait(1000);
		commonMethods.SendEnter(searchData);

		List<WebElement> itemNameList = commonMethods.FindElements(By.xpath(listOfItems));

		commonMethods.ClickElement(itemNameList.get(1));
		commonMethods.switchToTab();
		commonMethods.waitForPageLoaded();
		commonMethods.ClickElement(btnAddBasket);
		commonMethods.ThreadSleep(3000);
		commonMethods.ClickElement(myBasket);
    }
}