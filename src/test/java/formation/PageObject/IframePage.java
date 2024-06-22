package formation.PageObject;

import FwkLibrary.ActionLibrary;
import FwkLibrary.CheckLibrary;
import FwkLibrary.TypeLibrary;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class IframePage extends PageObject {
    // ==================================== OBJECTS ====================================

    public WebElementFacade subscriptionIframe(String iframeId) {
        return this.find(By.xpath("//iframe[@id='" + iframeId + "']"));
    }

    @FindBy(id = "email")
    public WebElementFacade loginInput;

    @FindBy(id = "btn-subscribe")
    public WebElementFacade subscribebtn;


    // ==================================== METHODS ====================================

    public void switchToIframe(String IdIframe){
        //scroll to iframe
        ActionLibrary.scrollToView(IframePage.this, this.subscriptionIframe(IdIframe));

        //switch to iframe
        IframePage.this.getDriver().switchTo().frame(IdIframe);
    }

    public void SubscribeInIframe(String email) {
        TypeLibrary.type(this.loginInput, email);
        this.subscribebtn.click();
    }

    public void VerifierTexteInIframe(String text) {
        CheckLibrary.CheckTextPresent(IframePage.this, text, 10);
    }

}
