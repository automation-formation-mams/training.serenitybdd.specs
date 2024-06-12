package formation.automation.FwkLibrary;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.questions.CurrentlyEnabled;
import org.openqa.selenium.TimeoutException;
import static org.junit.Assert.*;

public class CheckLibrary {

    public static void check_url_contains(PageObject page,String UrlText) {
        String CurrentUrl="";
        try {
        CurrentUrl = page.getDriver().getCurrentUrl();
        AssertLibrary.assertContains(UrlText,CurrentUrl);
        } catch (TimeoutException e) {
            throw new RuntimeException("The current Url : "+ CurrentUrl+" does not contain "+UrlText, e);
        }
    }
}
