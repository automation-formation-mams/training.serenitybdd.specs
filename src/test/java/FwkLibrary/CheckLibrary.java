package FwkLibrary;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckLibrary {

    public static void check_url_contains(PageObject page, String UrlText) {
        String CurrentUrl = "";
        try {
            CurrentUrl = page.getDriver().getCurrentUrl();
            AssertLibrary.assertContains(UrlText, CurrentUrl);
        } catch (TimeoutException e) {
            throw new RuntimeException("The current Url : " + CurrentUrl + " does not contain " + UrlText, e);
        }
    }

    public static boolean CheckElementVisibility(PageObject page, WebElementFacade element, int timeoutInSeconds) {
        try {
            Duration duration = Duration.ofSeconds(timeoutInSeconds);
            WebDriverWait wait = new WebDriverWait(page.getDriver(), duration);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
