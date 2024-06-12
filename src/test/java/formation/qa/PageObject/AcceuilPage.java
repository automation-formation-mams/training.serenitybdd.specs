package formation.qa.PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import  formation.automation.FwkLibrary.*;

import java.time.Duration;

public class AcceuilPage extends PageObject {

    // ============================ OBJECTS ============================

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement loginInput;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement LoginBtn;

    // ==================================== METHODS ==================================== //

    public void accessToPage(String url) {
        this.openUrl(url);
//        WaitLibrary.waitUntilUrlContains(AcceuilPage.this,url,10);
    }
}
