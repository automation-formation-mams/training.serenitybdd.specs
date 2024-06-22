package formation.StepDefinitions;

import formation.PageObject.IframePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IframeStepDefs {
    IframePage iframePage;

    @When("Iframe - Sousription avec email {string}")
    public void iframeSousriptionAvecEmail(String email) {
        iframePage.SubscribeInIframe(email);
    }

    @Then("Iframe - Verifier le texte {string}")
    public void iframeVerifierLeTexte(String texte) {
        iframePage.VerifierTexteInIframe(texte);
    }

    @When("Iframe - Switch To Iframe {string}")
    public void iframeSwitchToIframe(String iframeId) {
        iframePage.switchToIframe(iframeId);
    }
}
