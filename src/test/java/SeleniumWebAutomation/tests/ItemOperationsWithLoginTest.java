package SeleniumWebAutomation.tests;

import org.testng.annotations.Test;
import SeleniumWebAutomation.pages.Login;
import SeleniumWebAutomation.pages.HomePage;
import SeleniumWebAutomation.pages.SelectItem;
import SeleniumWebAutomation.common.CommonTest;
import SeleniumWebAutomation.pages.BasketOperations;

public class ItemOperationsWithLoginTest extends CommonTest {
    @Test
    public void Control() throws InterruptedException {
        Login login = new Login(getDriver());
        login.selectCountry();
        login.loginToAccount();

        HomePage homePage = new HomePage(getDriver());
        homePage.Control();

        SelectItem selectItem = new SelectItem(getDriver());
        selectItem.selection();

        BasketOperations basketOperations = new BasketOperations(getDriver());
        basketOperations.basketChanges();
    }
}