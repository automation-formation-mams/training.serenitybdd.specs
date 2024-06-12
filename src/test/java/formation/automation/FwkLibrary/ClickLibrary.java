package formation.automation.FwkLibrary;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class ClickLibrary {

    public static void clickIfExists(WebElement element) {
        try {
            if (element.isDisplayed()) {
                element.click();
            } else {
                System.out.println("Element is not visible: " + element);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + element);
        }
    }

}
