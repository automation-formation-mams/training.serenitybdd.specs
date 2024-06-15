package formation.StepDefinitions;

import FwkLibrary.CheckLibrary;
import formation.PageObject.AcceuilPage;
import formation.PageObject.MenuHeader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CommonStepDefs {

    AcceuilPage accueilPage;
    MenuHeader menuHeader;


    @Given("Lancer URL {string}")
    public void lancer_URL(String url) {
        accueilPage.accessToPage(url);
        accueilPage.AutoriserCoockiesIfVisible();
    }

    @When("Cliquer sur le menu {string}")
    public void cliquer_sur_le_menu(String menu) {
        menuHeader.AccesToMenuPage(menu);
    }

    @Then("Verifier le pathname contient {string}")
    public void verifier_le_pathname_contient(String expectedPath) {
        CheckLibrary.check_url_contains(accueilPage,expectedPath);
    }

}
