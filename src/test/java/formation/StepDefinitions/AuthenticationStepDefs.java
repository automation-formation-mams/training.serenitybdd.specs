package formation.StepDefinitions;

import formation.PageObject.AcceuilPage;
import formation.PageObject.CreateAccountPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class AuthenticationStepDefs {
    CreateAccountPage createAccountPage;

    @When("Authentication - Créer un compte")
    public void authenticationCreerUnCompte(DataTable UserdataTable) {
        List<Map<String, String>> rows = UserdataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            createAccountPage.RemplirFormulaireCompte(row.get("Firstname"),row.get("Lastname"),row.get("email"),row.get("password"),row.get("ConfirmPassword"));
        }
        createAccountPage.CliquerCreateAccountBtn();
    }
}
