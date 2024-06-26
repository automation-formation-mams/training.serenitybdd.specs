package formation.StepDefinitions;

import formation.PageObject.AcceuilPage;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.AfterStep;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Hooks {

    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    AcceuilPage accueilPage;

    @Before
    public void beforeScenario() {
        logger.info("Executing Before Scenario Hook");
        System.out.println("Hooks - beforeScenario");
        // Code d'initialisation avant chaque scénario
    }

    @After
    public void afterScenario() {
        logger.info("Executing After Scenario Hook");
        System.out.println("Hooks - afterScenario");
        // Code de nettoyage après chaque scénario
        accueilPage.getDriver().close();
        accueilPage.getDriver().quit();

    }

    @BeforeStep
    public void beforeStep() {
        logger.info("Executing Before Step Hook");
        System.out.println("Hooks - beforeStep");
        // Code avant chaque étape de scénario
    }

    @AfterStep
    public void afterStep() {
        logger.info("Executing After Step Hook");
        System.out.println("Hooks - afterStep");
        // Code après chaque étape de scénario
    }
}
