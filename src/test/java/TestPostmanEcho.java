
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestPostmanEcho {

    @Test
    public void testEchoGet() {
        given()
                .baseUri("https://postman-echo.com")
                .param("foo", "bar")
            .when()
                .get("/get")
            .then()
                .assertThat()
                .body("args.foo", equalTo("bar"))
                .statusCode(200);
    }

    @Test
    public void testPostRawText() {
        String rawTextBody = "{ \"text\" : \"foobar\" }";

        given()
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.TEXT)
                .body(rawTextBody)
            .when()
                .post("/post")
            .then()
                .assertThat()
                .body("data", equalTo(rawTextBody))
                .statusCode(200);
    }

    @Test
    public void testPostFormData() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("multipart/form-data")
                .multiPart("test", "data")
            .when()
                .post("/post")
            .then()
                .assertThat()
                .body("form.test", equalTo("data"))
                .statusCode(200);
    }

    @Test
    public void testPut() {
        String bodyStr = "This is supposed to be returned id data.";
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body(bodyStr)
            .when()
                .put("/put")
            .then()
                .assertThat()
                .body("data", equalTo(bodyStr))
                .statusCode(200);
    }

    @Test
    public void testPatch() {
        String bodyStr = "This is expected to be sent back as part of response body.";
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body(bodyStr)
            .when()
                .patch("/patch")
            .then()
                .assertThat()
                .body("data", equalTo(bodyStr))
                .statusCode(200);
    }

    @Test
    public void testDelete() {
        String bodyStr = "This is expected to be returned in body response.";
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body(bodyStr)
                .when()
                .delete("/delete")
                .then()
                .assertThat()
                .body("data", equalTo(bodyStr))
                .statusCode(200);
    }
}
