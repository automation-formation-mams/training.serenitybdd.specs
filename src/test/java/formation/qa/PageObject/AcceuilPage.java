package formation.qa.PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.WebElement;

import  formation.automation.FwkLibrary.*;

import java.time.Duration;

public class AcceuilPage extends PageObject {

    // ============================ OBJECTS ============================
    @FindBy(xpath = "//div[@class='fc-consent-root']//button[contains(.,'Autoriser')]")
    public WebElementFacade AutoriserCoockiesBtn;

    // ==================================== METHODS ==================================== //

    public void accessToPage(String url) {
        this.openUrl(url);
        WaitLibrary.waitUntilUrlContains(AcceuilPage.this,url,10);
    }

    public void AutoriserCoockiesIfVisible()
    {
        ClickLibrary.clickIfExists(AutoriserCoockiesBtn);
    }

}
