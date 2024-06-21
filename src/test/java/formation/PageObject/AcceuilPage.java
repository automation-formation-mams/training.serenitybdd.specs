package formation.PageObject;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import FwkLibrary.*;

public class AcceuilPage extends PageObject {

    // ============================ OBJECTS ============================

    public WebElementFacade linkByText(String texte) {
        return this.find(By.xpath("//a[contains(.,'" + texte + "')]"));
    }

    // ==================================== METHODS ====================================

    public void accessToPage(String url) {
        this.openUrl(url);
        WaitLibrary.waitUntilUrlContains(AcceuilPage.this, url, 5);
    }

    public void openUrlFromConfig() {
        this.open();
        WaitLibrary.waitUntilUrlContains(AcceuilPage.this, this.getDriver().getCurrentUrl(), 5);
    }

    public void OpenLinkByText(String linkText) {
        this.linkByText(linkText);
    }

}
