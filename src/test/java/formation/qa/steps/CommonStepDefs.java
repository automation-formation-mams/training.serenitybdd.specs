package formation.qa.steps;

import formation.automation.FwkLibrary.WaitLibrary;
import formation.qa.PageObject.AcceuilPage;
import formation.qa.PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class CommonStepDefs {

    AcceuilPage accueilPage;

    @Given("Lancer URL {string}")
    public void lancer_URL(String url) {
        accueilPage.accessToPage(url);
    }

    @When("Cliquer sur le menu {string}")
    public void cliquer_sur_le_menu(String menu) {

    }

    @Then("Verifier le pathname contient {string}")
    public void verifier_le_pathname_contient(String expectedPath) {
        WaitLibrary.waitUntilUrlContains(accueilPage,expectedPath,10);
    }

}
