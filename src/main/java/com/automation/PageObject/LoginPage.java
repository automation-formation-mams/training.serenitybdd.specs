package com.automation.PageObject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageObject {

    // ============================ OBJECTS ============================

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement loginInput;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement LoginBtn;

    // ==================================== METHODS ==================================== //


}
