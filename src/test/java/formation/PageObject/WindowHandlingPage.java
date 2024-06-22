package formation.PageObject;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class WindowHandlingPage extends PageObject {

    // ==================================== OBJECTS ====================================

    public WebElementFacade OpenWindowByLabel(String LabelBtn) {
        return this.find(By.xpath("//button[contains(.,'"+LabelBtn+"')]"));
    }

    // ==================================== METHODS ====================================



}
