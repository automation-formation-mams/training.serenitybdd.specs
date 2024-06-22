package formation.PageObject;

import FwkLibrary.TypeLibrary;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import java.lang.reflect.Type;

public class LoginPage extends PageObject {

    // ==================================== OBJECTS ====================================

    @FindBy(id = "email")
    public WebElementFacade loginInput;

    @FindBy(id = "pass")
    public WebElementFacade passwordInput;

    @FindBy(id = "send2")
    public WebElementFacade SignInBtn;

    // ==================================== METHODS ====================================

    public void RemplirLoginForm(String email, String password) {
        TypeLibrary.type(this.loginInput, email);
        TypeLibrary.type(this.passwordInput, password);
    }

    public void cliquerSurSeConnecter() {
        SignInBtn.click();
    }
}
