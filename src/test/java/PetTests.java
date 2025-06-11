import Bases.BaseTest;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Epic("Petstore API Tests")
@Feature("Pet API Endpoints")
public class PetTests extends BaseTest {

    int petId = 987654321;

    @Test(description = "Create a new pet")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Create a new pet")
    @Description("Creates a new pet with a given ID and name, and verifies creation.")
    public void createPet() {
        Map<String, Object> pet = new HashMap<>();
        pet.put("id", petId);
        pet.put("name", "Leo");
        pet.put("status", "available");

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post(URL + "/pet")
                .then()
                .statusCode(200);
    }

    @Test(description = "Get pet by ID")
    @Severity(SeverityLevel.NORMAL)
    @Story("Get pet details")
    @Description("Fetches the pet details using petId.")
    public void getPetById() {
        RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .get(URL + "/pet/" + petId)
                .then()
                .statusCode(200);
    }

    @Test(description = "Update pet details")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Update pet")
    @Description("Updates the pet's name and status.")
    public void updatePet() {
        Map<String, Object> pet = new HashMap<>();
        pet.put("id", petId);
        pet.put("name", "LeoUpdated");
        pet.put("status", "sold");

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put(URL + "/pet")
                .then()
                .statusCode(200);
    }

    @Test(description = "Delete pet by ID")
    @Severity(SeverityLevel.NORMAL)
    @Story("Delete pet")
    @Description("Deletes the pet with the specified ID.")
    public void deletePet() {
        RestAssured
                .given()
                .when()
                .delete(URL + "/pet/" + petId)
                .then()
                .statusCode(200);
    }
}
