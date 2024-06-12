package formation.qa.PageObject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import  formation.automation.FwkLibrary.*;

public class LoginPage extends PageObject {

    // ============================ OBJECTS ============================

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElementFacade loginInput;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElementFacade passwordInput;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElementFacade LoginBtn;

    // ==================================== METHODS ==================================== //

}
