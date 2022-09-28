package ch.zli.m223;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class BookingTest {
    @Test
    public void userEndpoint200() {
        given()
          .when().get("http://localhost:8080/booking")
          .then()
            .statusCode(401);
    }

}
