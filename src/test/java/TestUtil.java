import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class TestUtil {
    public JsonPath getJsonResponse (String request) {
      return  given()
              .when()
              .get(request)
              .then()
              .extract()
              .jsonPath();
    }
}
