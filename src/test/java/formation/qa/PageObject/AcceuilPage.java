package formation.qa.PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import  formation.automation.FwkLibrary.*;

import java.time.Duration;

public class AcceuilPage extends PageObject {

    // ============================ OBJECTS ============================


    // ==================================== METHODS ==================================== //

    public void accessToPage(String url) {
        this.openUrl(url);
        WaitLibrary.waitUntilUrlContains(AcceuilPage.this,url,10);
    }
}
