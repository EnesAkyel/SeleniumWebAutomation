package SeleniumWebAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SeleniumWebAutomation.common.CommonTest;
import SeleniumWebAutomation.common.CommonMethods;

public class Login  extends CommonTest {
    public Login(WebDriver driver) { PageFactory.initElements(driver, this); }

    CommonMethods commonMethods = new CommonMethods();

    @FindBy( className = "country-select")
    public WebElement countrySelect;

    @FindBy( xpath = "//div/select/option[2]")
    public WebElement countryOption;

    @FindBy( className = "country-actions")
    public WebElement btnCountrySelect;

    @FindBy( css = ".link.account-user")
    public WebElement btnSignIn;

    @FindBy( id = "login-email")
    public WebElement email;

    @FindBy( id = "login-password-input")
    public WebElement password;

    @FindBy( css = "button[class='q-primary q-fluid q-button-medium q-button submit']")
    public WebElement loginButton;

    @FindBy( id = "onetrust-accept-btn-handler")
    public WebElement cookiePopUp;

    String searchBox = "search-box";

    public void selectCountry() {
        commonMethods.ImplicitlyWait(10);
        commonMethods.ClickElement(countrySelect);
        commonMethods.ClickElement(countryOption);
        commonMethods.ClickElement(btnCountrySelect);
    }

    public void loginToAccount() {
        commonMethods.ImplicitlyWait(10);
        commonMethods.ClosePopUp(cookiePopUp);
        commonMethods.ClickElement(btnSignIn);
        commonMethods.SendKeys(email, "example@email.com");
        commonMethods.SendKeys(password, "password");
        commonMethods.ClickElement(loginButton);
        commonMethods.ExplicitlyWait(10, By.className(searchBox));
    }
}