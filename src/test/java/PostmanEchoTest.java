import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PostmanEchoTest {
    private final static String URL = "https://postman-echo.com/";
    public TestUtil utils;
    public PostmanEchoTest() {
        this.utils = new TestUtil();
    }
    @Test
    public void getMethodTest() {
        RestAssured
                .given()
                .when()
                .get(URL + "get")
                .then()
                .log().body()
                .assertThat()
                .statusCode(200)
                .and()
                .body("headers", notNullValue());
    }
    @Test
    void shouldRequestHeadersAfterGet() {
        given()
                .when()
                .get(URL + "headers")
                .then()
                .statusCode(200)
                .headers("Connection", "keep-alive",
                        "Content-Type", "application/json; charset=utf-8");
    }
    @Test
    public void getMethodWithParametersTest() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .queryParams("foo1", "bar1", "foo2", "bar2")
                .get(URL + "get/")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .body("headers", notNullValue())
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
        ;
    }

    @Test
    public void postRawDataMethodTest() {
        given()
                .body("hand-wave")
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("headers", notNullValue())
                .body("data", equalTo("hand-wave"));
    }

    @Test
    public void postFormDataMethodTest() {
        given()
                .contentType("multipart/form-data")
                .multiPart("name","Denis")
                .multiPart("age","48")
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .log().body()
                .statusCode(200)
                .body("form.name", equalTo("Denis"))
                .body("form.age", equalTo("48"));
    }

    @Test
    public void patchMethodTest() {
        given()
                .header("Content-Type", "application/json")
                .queryParam("id","1")
                .queryParam("name","Denis")
                .when()
                .patch(URL + "patch")
                .then()
                .log().all()
                .statusCode(200)
                .body("headers", notNullValue())
                .body("args.name",equalTo("Denis"))
        ;
    }

    @Test
    public void putMethodTest() {
        given()
                .header("Content-Type", "application/json")
                .body("{\"name\": \"Denis\", \"age\": 48}")
                .when()
                .put(URL + "put")
                .then()
                .log().all()
                .statusCode(200)
                .body("json.name",equalTo("Denis"))
                .body("json.age",equalTo(48));
    }

    //@Test
    public void deleteMethodTest() {
        RestAssured.delete("https://postman-echo.com/delete")
                .then()
                .statusCode(200)
                .body("url", equalTo("/delete"));
    }

}
