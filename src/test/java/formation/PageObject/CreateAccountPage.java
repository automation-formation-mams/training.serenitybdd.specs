package formation.PageObject;

import FwkLibrary.DataLibrary;
import FwkLibrary.TypeLibrary;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.lang.reflect.Type;

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

    public void RemplirFormulaireCompte(String firstname,String lastname,String email, String password, String ConfirmPassword)
    {
        String EmailUnique = email;
        String randomData = DataLibrary.generateRandomValue("AlphaNumeric",5,"NA");
        if(email.contains("$Random"))
        {
            EmailUnique =  EmailUnique.replace("$Random",randomData);
        }
        TypeLibrary.type(this.FirstnameInput,firstname);
        TypeLibrary.type(this.LastnameInput,lastname);

        TypeLibrary.type(this.EmailAddressInput,EmailUnique);
        TypeLibrary.type(this.PasswordInput,password);
        TypeLibrary.type(this.PasswordConfirmationInput,ConfirmPassword);
    }

    public void CliquerCreateAccountBtn()
    {
        this.CreateAccountBtn.click();
    }


}
