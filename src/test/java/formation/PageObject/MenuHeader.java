package formation.PageObject;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MenuHeader extends PageObject {

    // ============================ OBJECTS ============================

    @FindBy(xpath = "//a[contains(.,'Home')]")
    public WebElementFacade HomeMenu;

    @FindBy(xpath = "//a[contains(.,'Logged in as')]")
    public WebElementFacade LoggedInAs;

    public WebElementFacade MenuHeaderByName(String headerName) {
        return this.find(By.xpath("//a[contains(.,'" + headerName + "')]"));
    }

    // ==================================== METHODS ==================================== //

    public void AccesToMenuPage(String MenuTitle) {
        this.MenuHeaderByName(MenuTitle).click();
    }
}
