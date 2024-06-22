package FwkLibrary;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;

public class ActionLibrary {

    public static void scrollToView(PageObject page, WebElementFacade element) {
        ((JavascriptExecutor) page.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToViewAndClick(PageObject page, WebElementFacade element) {
        ((JavascriptExecutor) page.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public static void scrollToViewAndType(PageObject page, WebElementFacade element, String TexteToType) {
        ((JavascriptExecutor) page.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        TypeLibrary.typeAndTab(element, TexteToType);
    }

    public static Object executeJsSCriptOnPage(PageObject page, String jsScript) {
        return ((JavascriptExecutor) page.getDriver()).executeScript(jsScript);
    }

    public static String getCookieValue(PageObject page, String cookieName) {
        // FIXME can't get the cookie value in the scenario
        String cookieValue = page.getDriver().manage().getCookieNamed(cookieName).getValue();
        return cookieValue;
    }

    public static void scrollByPixel(PageObject page, int x, int y) {
        ((JavascriptExecutor) page.getDriver()).executeScript(("window.scrollBy(" + x + "," + y + ")"));
    }


}
