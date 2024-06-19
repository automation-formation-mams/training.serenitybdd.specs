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

    @Then("Verifier le pathname contient {string}")
    public void verifier_le_pathname_contient(String expectedPath) {
        CheckLibrary.check_url_contains(accueilPage,expectedPath);
    }

    @Given("Lancer application web")
    public void lancer_URL_depuis_config() {
        accueilPage.openUrlFromConfig();
        accueilPage.AutoriserCoockiesIfVisible();
    }

}
