package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CoffeeResourceTest {

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
    

}