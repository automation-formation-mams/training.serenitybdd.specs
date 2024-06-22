package formation.StepDefinitions;

import FwkLibrary.ActionLibrary;
import formation.PageObject.WindowHandlingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class WindowStepDefs {

WindowHandlingPage windowHandlingPage;

    @When("Fenetre - Ouvrir Nouvel Onglet By {string}")
    public void fenetreOuvrirNouvelOnglet(String label) {
        windowHandlingPage.OpenWindowByLabel(label).click();
    }

    @And("Fenetre - Basculer vers l'onglet {string}")
    public void fenetreBasculerVersLOnglet(String WindowTitle) {
        ActionLibrary.switchToWindowWithTitle(windowHandlingPage,WindowTitle);
    }


    @And("Fenetre - Fermer l'onglet {string}")
    public void fenetreFermerLOnglet(String WindowTitle) {
        ActionLibrary.closeWindowWithTitle(windowHandlingPage,WindowTitle);
    }


}
