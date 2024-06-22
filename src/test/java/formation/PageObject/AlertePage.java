package formation.PageObject;

import FwkLibrary.ActionLibrary;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AlertePage extends PageObject {

    // ==================================== OBJECTS ====================================

    @FindBy(id = "alert")
    public WebElementFacade AlertBtn;

    @FindBy(id = "confirm")
    public WebElementFacade ConfirmBtn;

    @FindBy(id = "prompt")
    public WebElementFacade PromptBtn;

    // ==================================== METHODS ====================================

    public void validateAlertWindow(WebElementFacade triggerAlert, String expectedText) {
        ActionLibrary.validateMessageAlertWindow(AlertePage.this, triggerAlert, expectedText);
    }
}
