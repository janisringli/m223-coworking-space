package ch.zli.m223;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;


public class RolesTest {
    @Test
    public void rolesEndpoint200() {
        given()
          .when().get("http://localhost:8080/roles")
          .then()
            .statusCode(200)
            .body(is("[{\"id\":2,\"roleName\":\"Admin\"},{\"id\":11,\"roleName\":\"Mitglied\"},{\"id\":12,\"roleName\":\"Benutzer\"}]"));
    }
}
