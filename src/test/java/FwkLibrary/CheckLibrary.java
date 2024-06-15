package FwkLibrary;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.TimeoutException;

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
