package com.automation.PageObject;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class MenuHeader extends PageObject {

    // ============================ OBJECTS ============================

    @FindBy(xpath = "//a[contains(.,'Home')]")
    public WebElement HomeMenu;

    @FindBy(xpath = "//a[contains(.,'Logged in as')]")
    public WebElement LoggedInAs;

    public WebElementFacade MenuHeaderByName(String headerName) {
        return this.find(By.xpath("//a[contains(.,'" + headerName + "')]"));
    }

    // ==================================== METHODS ==================================== //
}
