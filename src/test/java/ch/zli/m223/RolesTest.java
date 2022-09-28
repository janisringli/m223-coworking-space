package ch.zli.m223;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;



public class RolesTest {
    @Test
    public void rolesEndpoint200() {
    String adminToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6Impkb2VAcXVhcmt1cy5pbyIsImdyb3VwcyI6WyJBZG1pbiJdLCJiZW4iOiJkb3ZlciIsImlhdCI6MTY2NDM2OTcxMiwiZXhwIjozODExODUzMzU5LCJqdGkiOiI0YzIzNzRlMy00M2U1LTQ0MmItYjQ2Yi04NzZmZjkwZTlkZWIifQ.ELOsWvvNxWmCTCX8jJd6eTo78JW3wzLoV0_Pr3TevOLjZkswvy0K_2aJ0GSYlmPWzSt7LH4DCNfEsI8Q-ZBYWNnuRBlsA3PQs3F3I_GA8LL92aMdI5yE2N2xF24qB4s2uExM5PGFTSqQ8ohJWAkrc1EUpTESRhaSh8DbfRFAyKefxboliP-j_aH1zJvwfdi-JaJJjEOejZuzeItyxXZYa4ebpS1rAtfgGT5zQNh9nZqirlcJnP5En0R2WR0iU64MNIabvBOdPjmEqYAjWAa4_WPAyePz11KcttTbU9exZ5a0ZJw7M61Cl5vsVkHRSI6Km5K9QUc8qiuCviMmN3ZWuQ";

        given()
        .header("Authorization", "Bearer " + adminToken)
          .when().get("http://localhost:8080/roles")
          .then()
            .statusCode(200)
            .body(is("[{\"id\":2,\"roleName\":\"Admin\"},{\"id\":11,\"roleName\":\"Mitglied\"},{\"id\":12,\"roleName\":\"Benutzer\"}]"));
    }

    @Test
    public void userEndpointDelete() {
    String adminToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6Impkb2VAcXVhcmt1cy5pbyIsImdyb3VwcyI6WyJBZG1pbiJdLCJiZW4iOiJkb3ZlciIsImlhdCI6MTY2NDM2OTcxMiwiZXhwIjozODExODUzMzU5LCJqdGkiOiI0YzIzNzRlMy00M2U1LTQ0MmItYjQ2Yi04NzZmZjkwZTlkZWIifQ.ELOsWvvNxWmCTCX8jJd6eTo78JW3wzLoV0_Pr3TevOLjZkswvy0K_2aJ0GSYlmPWzSt7LH4DCNfEsI8Q-ZBYWNnuRBlsA3PQs3F3I_GA8LL92aMdI5yE2N2xF24qB4s2uExM5PGFTSqQ8ohJWAkrc1EUpTESRhaSh8DbfRFAyKefxboliP-j_aH1zJvwfdi-JaJJjEOejZuzeItyxXZYa4ebpS1rAtfgGT5zQNh9nZqirlcJnP5En0R2WR0iU64MNIabvBOdPjmEqYAjWAa4_WPAyePz11KcttTbU9exZ5a0ZJw7M61Cl5vsVkHRSI6Km5K9QUc8qiuCviMmN3ZWuQ";

        given()
        .contentType(ContentType.JSON)
        .header("Authorization", "Bearer " + adminToken)
          .when().delete("http://localhost:8080/roles/2")
          .then()
            .statusCode(204);
    }
}
