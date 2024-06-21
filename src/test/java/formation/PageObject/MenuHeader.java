package formation.PageObject;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MenuHeader extends PageObject {

    // ============================ OBJECTS ============================

    @FindBy(xpath = "//a[contains(.,\"What's New\")]")
    public WebElementFacade WhatsNewMenu;

    @FindBy(className = "logged-in")
    public WebElementFacade LoggedInAs;

    @FindBy(id = "search")
    public WebElementFacade SearchInput;

    @FindBy(className = "action showcart")
    public WebElementFacade CartBtn;

    public WebElementFacade MenuHeaderByName(String headerName) {
        return this.find(By.xpath("//a[contains(.,'" + headerName + "')]"));
    }

    public WebElementFacade MenuByName(String MenuName) {
        return this.find(By.xpath("//a[contains(.,'" + MenuName + "')]"));
    }

    public WebElementFacade SubMenuHeaderByName(String SubMenuName) {
        return this.find(By.xpath("//a[contains(.,'" + SubMenuName + "')]"));
    }

    // ==================================== METHODS ====================================

    public void AccesToMenuPage(String MenuTitle) {
        this.MenuHeaderByName(MenuTitle).click();
    }
}
