package in.reqres.tests;

import in.reqres.api.UsersApi;
import in.reqres.models.UserDataRequestModel;
import in.reqres.models.UserDataResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.UsersSpec.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersTests extends TestBase {

    UsersApi usersApi = new UsersApi();

    @DisplayName("Verify user creation")
    @Test
    void successfulUserCreationTest() {

        UserDataRequestModel inputUserData = new UserDataRequestModel();
        inputUserData.setName("jim");
        inputUserData.setJob("plumber");

        UserDataResponseModel userCreationResponse = step("Send a request to create a user", () -> given(usersRequestSpec)
                .body(inputUserData)
                .when()
                .post("/users")
                .then()
                .spec(userCreationResponseSpec)
                .extract().as(UserDataResponseModel.class));

        step("Check response", () -> {
            assertEquals("jim", userCreationResponse.getName());
            assertEquals("plumber", userCreationResponse.getJob());
        });
    }

    @DisplayName("Create user with api methods")
    @Test
    void createUserWithApiMethod() {

        UserDataRequestModel inputUserData = new UserDataRequestModel();
        UserDataResponseModel creationResponse = new UserDataResponseModel();

        step("Set the name and job", () -> {
            inputUserData.setName("george");
            inputUserData.setJob("unemployed");
        });

        step("Send a request to create a user", () ->
               usersApi.createUser(inputUserData));

        step("Check response", () -> {
            assertEquals("george", creationResponse.getName());
            assertEquals("unemployed", creationResponse.getJob());
        });
    }

    @DisplayName("Verify user update with PATCH")
    @Test
    void successfullyUserUpdateWithPatch() {

        UserDataRequestModel updateUserData = new UserDataRequestModel();
        updateUserData.setName("jim");
        updateUserData.setJob("actor");

        UserDataResponseModel userUpdateResponse = step("Send a request to update the user's info with PATCH", () -> given(usersRequestSpec)
                .body(updateUserData)
                .when()
                .patch("/users/7")
                .then()
                .spec(userUpdateResponseSpec)
                .extract().as(UserDataResponseModel.class));

        step("Check response", () ->
                assertAll(
                        () -> assertEquals("tom", userUpdateResponse.getName()),
                        () -> assertEquals("actor", userUpdateResponse.getJob())
                ));
    }

    @DisplayName("Verify user update with PUT")
    @Test
    void successfullyUserUpdateWithPut() {

        UserDataRequestModel updateUserData = new UserDataRequestModel();
        updateUserData.setName("tom");
        updateUserData.setJob("writer");

        UserDataResponseModel userUpdateResponse = step("Send a request to update the user's info with PUT", () -> given(usersRequestSpec)
                .body(updateUserData)
                .when()
                .put("/users/7")
                .then()
                .spec(userUpdateResponseSpec)
                .extract().as(UserDataResponseModel.class));

        step("Check response", () ->
                assertAll(
                        () -> assertEquals("tom", userUpdateResponse.getName()),
                        () -> assertEquals("writer", userUpdateResponse.getJob())
                ));
    }

    @Test
    void successfullyDeleteUser() {

        step("Send a request to delete a user", () -> given(usersRequestSpec)
                .when()
                .delete("/users/7")
                .then()
                .spec(userDeletedResponseSpec));
    }
}
