import Bases.BaseTest;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Epic("Petstore API Tests")
@Feature("User API Endpoints")
public class UserTests extends BaseTest {

    @Test(description = "Create a new user", priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Create a new user")
    @Description("Creates a user with username 'aysegul_user2' and checks if it's successfully created.")
    public void CreateUser() {
        Map<String, Object> user = new HashMap<>();
        user.put("id", 1002);
        user.put("username", "aysegul_user2");
        user.put("firstName", "Ayşegül");
        user.put("lastName", "Test");
        user.put("email", "aysegul2@test.com");
        user.put("password", "123456");
        user.put("phone", "5551234567");
        user.put("userStatus", 1);

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(URL + "/user")
                .then()
                .statusCode(200);
    }

    @Test(description = "Update existing user", priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Update user information")
    @Description("Updates the user 'aysegul_user2' with new email, phone, and name data.")
    public void UpdateUser() {
        Map<String, Object> user = new HashMap<>();
        user.put("id", 1002);
        user.put("username", "aysegul_user2");
        user.put("firstName", "AyşegülUpdated");
        user.put("lastName", "TestUpdated");
        user.put("email", "aysegul2@updated.com");
        user.put("password", "654321");
        user.put("phone", "5550000000");
        user.put("userStatus", 2);

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .put(URL + "/user/aysegul_user2")
                .then()
                .statusCode(200);
    }

    @Test(description = "Delete user by username", priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Story("Delete a user")
    @Description("Deletes the user 'aysegul_user2' and confirms that the deletion is successful.")
    public void DeleteUser() {
        RestAssured
                .given()
                .when()
                .delete(URL + "/user/aysegul_user2")
                .then()
                .statusCode(200);
    }
    @Test(description = "Login with valid user credentials", priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Story("User login")
    @Description("Logs in with correct username and password for 'aysegul_user2'.")
    public void LoginUser() {
        RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .get(URL + "/user/login?username=aysegul_user2&password=654321")
                .then()
                .statusCode(200);
    }

    @Test(description = "Logout the user", priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Story("User logout")
    @Description("Logs out the currently logged-in user.")
    public void LogoutUser() {
        RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .get(URL + "/user/logout")
                .then()
                .statusCode(200);
    }


}
