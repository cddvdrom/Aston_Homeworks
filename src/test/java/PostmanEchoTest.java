import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    public void getMethodTest () {
        RestAssured
                .get("https://postman-echo.com/get")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void getMethodWithParametersTest () {
        RestAssured
                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void postMethodTest () {
        RestAssured.given()
                .param("name", "Denis")
                .param("age", "34")
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(200)
                .body("form.name", equalTo("Denis"))
                .body("form.age", equalTo("35"));
    }
    @Test
    public void putMethodTest () {
        RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{\"name\": \"John\", \"age\": 30}")
                .when()
                .put("https://postman-echo.com/put")
                .then()
                .statusCode(200)
                .body("json.name", equalTo("John"))
                .body("json.age", equalTo(30));
    }
    @Test
    public void deleteMethodTest () {
        RestAssured.delete("https://postman-echo.com/delete")
                .then()
                .statusCode(200)
                .body("url", equalTo("/delete"));
    }
}
