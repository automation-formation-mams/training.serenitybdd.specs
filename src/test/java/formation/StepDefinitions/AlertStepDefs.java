package formation.StepDefinitions;

import FwkLibrary.ActionLibrary;
import formation.PageObject.AlertePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class AlertStepDefs {
    AlertePage alertePage;

    @When("Alert - Verifier Text dans Alert {string}")
    public void alertVerifierTextDansAlert(String ExpectedMessage) {
        alertePage.validateAlertWindow(alertePage.AlertBtn ,ExpectedMessage);
    }

    @And("Alert - Valider Alert window")
    public void alertValiderAlertWindow() {
        ActionLibrary.validerAlertWindow(alertePage);
    }

    @And("Alert - Verifier Text dans Confirm {string}")
    public void alertVerifierTextDansConfirm(String ExpectedMessage) {
        alertePage.validateAlertWindow(alertePage.ConfirmBtn ,ExpectedMessage);
    }

    @And("Alert - Cancel Alert window")
    public void alertCancelAlertWindow() {
        ActionLibrary.dismissAlertWindow(alertePage);
    }

    @When("Alert - Saisir {string} dans Prompt")
    public void alertSaisirDansPrompt(String TextToType) {
        ActionLibrary.writeInPromptWindow(alertePage,TextToType);
    }

    @When("Alert - Verifier Text dans Prompt {string}")
    public void alertVerifierTextDansPrompt(String ExpectedMessage) {
        alertePage.validateAlertWindow(alertePage.PromptBtn ,ExpectedMessage);
    }
}
