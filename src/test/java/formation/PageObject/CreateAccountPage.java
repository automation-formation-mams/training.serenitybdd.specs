package formation.PageObject;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CreateAccountPage extends PageObject {

    // ============================ OBJECTS ============================

    @FindBy(id = "firstname")
    WebElementFacade FirstnameInput;

    @FindBy(name = "lastname")
    WebElementFacade LastnameInput;

    @FindBy(id = "email_address")
    WebElementFacade EmailAddressInput;

    @FindBy(id = "password")
    WebElementFacade PasswordInput;

    @FindBy(id = "password-confirmation")
    WebElementFacade PasswordConfirmationInput;

    @FindBy(xpath = "//button[contains(.,'Create an Account')]")
    WebElementFacade CreateAccountBtn;

    // ==================================== METHODS ====================================



}
