package formation.PageObject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {

    // ============================ OBJECTS ============================

    @FindBy(id = "email")
    public WebElementFacade loginInput;

    @FindBy(id = "pass")
    public WebElementFacade passwordInput;

    @FindBy(id = "send2")
    public WebElementFacade SignInBtn;

    // ==================================== METHODS ====================================


}
