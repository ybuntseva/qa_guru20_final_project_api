package in.reqres.api;

import in.reqres.models.UserDataRequestModel;
import in.reqres.models.UserDataResponseModel;
import in.reqres.models.UserUpdateResponseModel;

import static in.reqres.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class UsersApi {

    public UserDataResponseModel createUser(UserDataRequestModel inputUserData) {
        return given()
                .log().uri()
                .log().method()
                .log().body()
                .filter(withCustomTemplates())
                .contentType(JSON)
                .body(inputUserData)
                .when()
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .extract().as(UserDataResponseModel.class);
    }

    public UserUpdateResponseModel updateUserWithPatch(UserDataRequestModel updateUserData) {
        return given()
                .log().uri()
                .log().method()
                .log().body()
                .filter(withCustomTemplates())
                .contentType(JSON)
                .body(updateUserData)
                .when()
                .patch("/users/7")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(UserUpdateResponseModel.class);
    }

    public UserUpdateResponseModel updateUserWithPut(UserDataRequestModel updateUserData) {
        return given()
                .log().uri()
                .log().method()
                .log().body()
                .filter(withCustomTemplates())
                .contentType(JSON)
                .body(updateUserData)
                .when()
                .put("/users/7")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(UserUpdateResponseModel.class);
    }

    public void deleteUser() {
        given()
                .log().uri()
                .log().method()
                .log().body()
                .filter(withCustomTemplates())
                .contentType(JSON)
                .when()
                .delete("/users/7")
                .then()
                .log().status()
                .log().body()
                .statusCode(204);
    }
}
