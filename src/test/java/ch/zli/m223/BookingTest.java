package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class BookingTest {
    @Test
    public void userEndpoint401() {
        given()
          .when().get("http://localhost:8080/booking")
          .then()
            .statusCode(401);
    }
    @Test
    public void userEndpoint200() {
    String adminToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6Impkb2VAcXVhcmt1cy5pbyIsImdyb3VwcyI6WyJBZG1pbiJdLCJiZW4iOiJkb3ZlciIsImlhdCI6MTY2NDM2OTcxMiwiZXhwIjozODExODUzMzU5LCJqdGkiOiI0YzIzNzRlMy00M2U1LTQ0MmItYjQ2Yi04NzZmZjkwZTlkZWIifQ.ELOsWvvNxWmCTCX8jJd6eTo78JW3wzLoV0_Pr3TevOLjZkswvy0K_2aJ0GSYlmPWzSt7LH4DCNfEsI8Q-ZBYWNnuRBlsA3PQs3F3I_GA8LL92aMdI5yE2N2xF24qB4s2uExM5PGFTSqQ8ohJWAkrc1EUpTESRhaSh8DbfRFAyKefxboliP-j_aH1zJvwfdi-JaJJjEOejZuzeItyxXZYa4ebpS1rAtfgGT5zQNh9nZqirlcJnP5En0R2WR0iU64MNIabvBOdPjmEqYAjWAa4_WPAyePz11KcttTbU9exZ5a0ZJw7M61Cl5vsVkHRSI6Km5K9QUc8qiuCviMmN3ZWuQ";
        given()
        .header("Authorization", "Bearer " + adminToken)
          .when().get("http://localhost:8080/booking")
          .then()
            .statusCode(200);
    }
    // @Test
    // public void userEndpoint200OwnBooking() {
    // String mitgliedToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6Impkb2VAcXVhcmt1cy5pbyIsImdyb3VwcyI6WyJBZG1pbiJdLCJiZW4iOiJkb3ZlciIsImlhdCI6MTY2NDM3MTEwOCwiZXhwIjozODExODU0NzU1LCJqdGkiOiIyODlhNWJiMy1lZDdhLTQ1NzQtYWRiZi1lNzQxYmNhZWYzYjMifQ.ic_I4AAMf3FU4-iusI997qHb5__qUoBcatmsto3rTp2n7r14EO3RWmk5YDIau5Wg84ELpsDRNcCsyH2D4ZUHC7GeADnLesfDMUrosr1GP2WOE2Pw98dMNjFf6r3N_bVOH_l4LYk0UDdVLbCH__6PiHV4UcgERQV50ETwflL3eGofvbzj7cLbHLjEM7cCzHIsLAM8hpLZNWO2P__KpxkAVQuBve65mgzwzvT5VYQpY1Jf1b-bGyKresZqHim28C4bWeAIQ4cb79tigXEMDl2cttDKTZMUJUAUS1ktsyatVncA5dcTLQm0buh3gz4zfBoEhDeynCVBUr1T64oTD5Y6Ag";
    //     given()
    //     .contentType(ContentType.JSON)
    //     .header("Authorization", "Bearer " + mitgliedToken)
    //       .when().put("http://localhost:8080/booking")
    //       .then()
    //         .statusCode(200);
    // }

}
