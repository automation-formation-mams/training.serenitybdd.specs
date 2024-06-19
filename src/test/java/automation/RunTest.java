package automation;

import formation.StepDefinitions.Hooks;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"formation.StepDefinitions"},
        plugin = {"pretty"}
)
public class RunTest {

    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @BeforeClass
    public static void setup() {
        // Code d'initialisation spécifique à la suite de tests (exécuté une fois)
        logger.info("Executing Before Before Run");
        System.out.println("Hooks - BeforeClass");
    }

    @AfterClass
    public static void cleanup() {
        // Code de nettoyage global (exécuté une fois après l'ensemble des tests)
        logger.info("Executing Before After Run");
        System.out.println("Hooks - AfterClass");
    }
}
