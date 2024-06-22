package FwkLibrary;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
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

    public static void CheckTextPresent(PageObject page,String text,int timeout) {
        try {
            WebElementFacade element = page.find(By.xpath("//*[contains(text(),'" + text + "')]"));

            if( CheckElementVisibility(page,element,timeout))
            {
                System.out.println("The Text ["+text+"] doest exist");
            }
            else {
                Assert.assertFalse("The Text ["+text+"] does'nt exist",true);
            }

        } catch (Exception e) {

            throw new RuntimeException("The Text ["+text+"] does'nt exist", e);
        }
    }

}
