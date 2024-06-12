package formation.automation.FwkLibrary;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.TimeoutException;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitLibrary {

    public static ExpectedCondition<Boolean> loweredTextToBePresentInElement(final WebElementFacade element, final String text) {
        return new ExpectedCondition<Boolean>() {
            @NotNull
            @Override
            public <V> Function<V, Boolean> compose(@NotNull Function<? super V, ? extends WebDriver> before) {
                return null;
            }

            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    String elementText = element.getText().toLowerCase();
                    return elementText.contains(text.toLowerCase());
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return String.format("text ('%s') to be present in element %s", text, element);
            }
        };
    }

    public static void waitForElement(WebElementFacade element, Duration timeoutInSeconds) {
        try {
            element.withTimeoutOf(timeoutInSeconds).waitUntilVisible();
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not visible after waiting for " + timeoutInSeconds + " seconds", e);
        }
    }

    public static void waitToTextToBePresentInElement(PageObject page, WebElementFacade element, String text, int timeoutInSeconds) {
        Duration duration = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait waiter = new WebDriverWait(page.getDriver(), duration);
        waiter.until(loweredTextToBePresentInElement(element, text.toLowerCase()));
    }

    public static void waitUntilUrlContains(PageObject page, String text, int timeoutInSeconds) {
        Duration duration = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait waiter = new WebDriverWait(page.getDriver(), duration);
        waiter.until(ExpectedConditions.urlContains(text));
    }

    public static void waitUntilElementIsVisible(PageObject page, WebElementFacade element, int timeoutInSeconds) {
       Duration duration = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait waiter = new WebDriverWait(page.getDriver(), duration);
        waiter.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementIsClickable(PageObject page, WebElementFacade element, int timeoutInSeconds) {
       Duration duration = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait waiter = new WebDriverWait(page.getDriver(), duration);
        waiter.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilElementIsNotVisible(PageObject page, WebElementFacade element, int timeoutInSeconds) {
       Duration duration = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait waiter = new WebDriverWait(page.getDriver(), duration);
        waiter.until(ExpectedConditions.invisibilityOf(element));
    }
}
