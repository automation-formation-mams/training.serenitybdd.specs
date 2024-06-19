package formation.StepDefinitions;

import formation.PageObject.MenuHeader;
import io.cucumber.java.en.When;

public class MenuBarStepDefs {

    MenuHeader menuHeader;


    @When("Cliquer sur le menu {string}")
    public void cliquer_sur_le_menu(String menu) {
        menuHeader.AccesToMenuPage(menu);
    }
}
