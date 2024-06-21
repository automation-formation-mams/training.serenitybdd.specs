package FwkLibrary;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class ClickLibrary {

    public static void clickIfExists(PageObject page, WebElementFacade element, int timeout) {
        try {
            if (CheckLibrary.CheckElementVisibility(page, element, timeout)) {
                element.click();
            } else {
                System.out.println("Element is not visible: " + element);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + element);
        }
    }

}
