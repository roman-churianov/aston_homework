
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
                .statusCode(200);
    }
}
