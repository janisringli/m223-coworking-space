package ch.zli.m223;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class CoffeeTest {
    @Test
    public void coffeeEndpoint200() {
        given()
          .when().get("http://localhost:8080/coffee")
          .then()
            .statusCode(200)
            .body(is("[{\"id\":1,\"price\":2.9,\"time\":\"2018-11-03T12:45:30\",\"user\":null}]"));
    }
    @Test
    public void coffeeEndpoint404() {
        given()
          .when().get("http://localhost:8080/coffe")
          .then()
            .statusCode(404); 
    }

}
