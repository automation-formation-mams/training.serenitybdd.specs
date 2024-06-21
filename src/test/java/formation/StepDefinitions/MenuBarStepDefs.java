package formation.StepDefinitions;

import formation.PageObject.MenuHeader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenuBarStepDefs {

    MenuHeader menuHeader;

    @When("Menu Bar - Acceder page via link {string}")
    public void menuBarAccederPageViaLink(String LinkName) {
        menuHeader.AccesToMenuPage(LinkName);
    }


}
