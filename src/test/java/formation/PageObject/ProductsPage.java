package formation.PageObject;

import FwkLibrary.ClickLibrary;
import FwkLibrary.TypeLibrary;
import FwkLibrary.WaitLibrary;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductsPage extends PageObject {

    // ============================ OBJECTS ============================

    @FindBy(id = "search_product")
    public WebElementFacade searchProductsInput;

    @FindBy(id = "submit_search")
    public WebElementFacade LoupeBtn;

    public WebElementFacade ProductCardByName(String ProductName) {
        return this.find(By.xpath("//div[contains(@class,'productinfo') and contains(.,'" + ProductName + "')]"));
    }

    public WebElementFacade ViewProduct(String ProductName) {
        return this.find(By.xpath("//div[contains(@class,'product-image-wrapper') and contains(.,'" + ProductName + "')]//a[contains(.,'View Product')]"));
    }

    // ==================================== METHODS ====================================

    public void RechercherProduit(String ProductName) {
        TypeLibrary.type(this.searchProductsInput, ProductName);
        this.LoupeBtn.click();
        WaitLibrary.waitUntilUrlContains(ProductsPage.this, "products?search", 10);
    }

    public void VerifierPresenceProduit(String ProductName) {
        WaitLibrary.waitUntilElementIsVisible(ProductsPage.this, this.ProductCardByName(ProductName), 10);
    }
}
