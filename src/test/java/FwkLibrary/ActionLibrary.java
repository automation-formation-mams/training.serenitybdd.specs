package FwkLibrary;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Set;

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

    public static boolean validateMessageAlertWindow(PageObject page, WebElementFacade alertTrrigerBtn, String expectedText) {
        try {
            alertTrrigerBtn.click();
            // Attendre que l'alerte soit présente
            page.waitFor(ExpectedConditions.alertIsPresent());
            Alert alert = page.getDriver().switchTo().alert();
            String alertText = alert.getText();
            AssertLibrary.assertContains(alertText,expectedText);
//            alert.accept();  // Fermer l'alert
            return alertText.equals(expectedText);
        } catch (Exception e) {
            System.out.println("Alert window not found: " + e.getMessage());
            Assert.assertFalse("Alert Problem does'nt exist",true);
            return false;
        }
    }

    public static boolean validerAlertWindow(PageObject page) {
        try {
            // Attendre que l'alerte soit présente
            page.waitFor(ExpectedConditions.alertIsPresent());
            Alert alert = page.getDriver().switchTo().alert();
            alert.accept();  // Fermer l'alert
            return true;
        } catch (Exception e) {
            System.out.println("Alert window not found: " + e.getMessage());
            Assert.assertFalse("Alert Problem does'nt exist",true);
            return false;
        }
    }

    public static boolean dismissAlertWindow(PageObject page) {
        try {
            // Attendre que l'alerte soit présente
            page.waitFor(ExpectedConditions.alertIsPresent());
            Alert alert = page.getDriver().switchTo().alert();
            alert.dismiss();  // Fermer l'alert
            return true;
        } catch (Exception e) {
            System.out.println("Alert window not found: " + e.getMessage());
            Assert.assertFalse("Alert Problem does'nt exist",true);
            return false;
        }
    }
    public static boolean writeInPromptWindow(PageObject page,String TextToType) {
        try {
            // Attendre que l'alerte soit présente
            page.waitFor(ExpectedConditions.alertIsPresent());
            Alert alert = page.getDriver().switchTo().alert();
            alert.sendKeys(TextToType);  // Fermer l'alert
            return true;
        } catch (Exception e) {
            System.out.println("Alert window not found: " + e.getMessage());
            Assert.assertFalse("Alert Problem does'nt exist",true);
            return false;
        }
    }

    public static void switchToWindowWithTitle(PageObject page,String windowTitle) {
        Set<String> allWindows = page.getDriver().getWindowHandles();
        for (String windowHandle : allWindows) {
            page.getDriver().switchTo().window(windowHandle);
            if ( page.getDriver().getTitle().equals(windowTitle)) {
                break;
            }
        }
    }

    public static void closeWindowWithTitle(PageObject page,String windowTitle) {
        Set<String> allWindows = page.getDriver().getWindowHandles();
        for (String windowHandle : allWindows) {
            page.getDriver().switchTo().window(windowHandle);
            if ( page.getDriver().getTitle().equals(windowTitle)) {
                page.getDriver().close();
            }
        }
    }


}
