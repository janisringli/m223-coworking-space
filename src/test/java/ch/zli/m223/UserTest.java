package ch.zli.m223;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class UserTest {
    @Test
    public void userEndpoint200() {
        given()
          .when().get("http://localhost:8080/user")
          .then()
            .statusCode(200);
    }

}
