package in.reqres.api;

import in.reqres.models.UserDataRequestModel;
import in.reqres.models.UserDataResponseModel;
import io.restassured.response.Response;

import static in.reqres.specs.UsersSpec.userCreationResponseSpec;
import static in.reqres.specs.UsersSpec.usersRequestSpec;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class UsersApi {

    public void createUser(UserDataRequestModel inputUserData) {
        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .body(inputUserData)
                .when()
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201);
    }
}
