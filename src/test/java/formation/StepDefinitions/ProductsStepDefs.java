package formation.StepDefinitions;

import FwkLibrary.DataLibrary;
import io.cucumber.java.en.When;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class ProductsStepDefs {

    @When("Products - Rechercher Produit Par fixture")
    public void productsRechercherProduit() throws IOException {
        String name = "";
        String price ="";
        String fixturePath = DataLibrary.getGlobalPropertieByKey("fixtures.path");
        String productJson = new String(Files.readAllBytes(Paths.get(fixturePath + "/products.json")));
        List<Map<String, Object>> products= JsonPath.read(productJson, "$.products[?(@.SKU == 'WJ12')]");
        for (Map<String, Object> product : products) {
             name = (String) product.get("name");
             price = (String) product.get("price").toString();
        }

    }
}
