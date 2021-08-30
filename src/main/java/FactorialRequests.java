import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class FactorialRequests extends AuthCommon {
    private final String path;

    public FactorialRequests() {
        RestAssured.baseURI = String.format("https://%s", factorialUrl);
        path = "/factorial";
    }

    @Step("Send requests to calculate factorial. Parameter = {0}")
    public Response postRequestFactorial(String number) {
        return given()
                .log().all()
                .auth()
                .preemptive()
                .basic(user, pass)
                .header("Accept", ContentType.URLENC.getAcceptHeader())
                .contentType(ContentType.URLENC)
                .body(String.format("number=%s", number))
                .post(path)
                .then().extract().response();
    }
}
