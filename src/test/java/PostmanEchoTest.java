import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PostmanEchoTest {
    private final static String URL = "https://postman-echo.com/";
    public TestUtil utils;
    public PostmanEchoTest(){
        this.utils = new TestUtil();
    }
  //  @Test
    public void getMethodTest () {
        RestAssured
                .given()
                .when()
                .get(URL + "get")
                .then()
                .log().body()
                .assertThat()
                .statusCode(200)
                .and()
                .body("headers",notNullValue());
    }
     @Test
    public void getMethodWithParametersTest () {
        given()
                .contentType(ContentType.JSON)
                .when()
                .queryParams("foo1","bar1","foo2","bar2")
                .get(URL + "get/")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .body("headers",notNullValue())
                .body("args.foo1",equalTo("bar1"))
                .body("args.foo2",equalTo("bar2"));;
    }
    @Test
    public void postMethodTest () {
        given()
                .param("name", "Denis")
                .param("age", "34")
                .contentType(ContentType.JSON)
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(201)
                .body("form.name", equalTo("Denis"))
                .body("form.age", equalTo("35"));
    }
    //@Test
    public void putMethodTest () {
        given()
                .header("Content-Type", "application/json")
                .body("{\"name\": \"John\", \"age\": 30}")
                .when()
                .put("https://postman-echo.com/put")
                .then()
                .statusCode(200)
                ;
    }
    //@Test
    public void deleteMethodTest () {
        RestAssured.delete("https://postman-echo.com/delete")
                .then()
                .statusCode(200)
                .body("url", equalTo("/delete"));
    }
}
