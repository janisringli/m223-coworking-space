package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class EndpointResourceTest {

    @Test
    public void coffeeEndpoint200() {
        given()
          .when().get("/coffee")
          .then()
            .statusCode(200)
            .body(is("[]"));
    }
    @Test
    public void placeEndpoint200() {
        given()
          .when().get("/place")
          .then()
            .statusCode(200)
            .body(is("[]"));
    }
    @Test
    public void userEndpoint401() {
        given()
          .when().get("/user")
          .then()
            .statusCode(401);
    }
    @Test
    public void rolesEndpoint401() {
        given()
          .when().get("/roles")
          .then()
            .statusCode(401);
    }
    @Test
    public void bookingEndpoint401() {
        given()
          .when().get("/booking")
          .then()
            .statusCode(401);
    }

}