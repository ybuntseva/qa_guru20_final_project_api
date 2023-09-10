package in.reqres.tests;

import in.reqres.models.UserDataRequestModel;
import in.reqres.models.UserDataResponseModel;
import in.reqres.models.UserUpdateResponseModel;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.UsersSpec.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersTests extends TestBase {

    @Test
    void successfulUserCreationTest() {

        UserDataRequestModel inputUserData = new UserDataRequestModel();
        inputUserData.setName("george");
        inputUserData.setJob("unemployed");

        UserDataResponseModel userCreationResponse = step("Send a request to create a user", () -> given(usersRequestSpec)
                .body(inputUserData)
                .when()
                .post("/users")
                .then()
                .spec(userCreationResponseSpec)
                .extract().as(UserDataResponseModel.class));

        step("Check response", () -> {
            assertEquals("george", userCreationResponse.getName());
            assertEquals("unemployed", userCreationResponse.getJob());
        });
    }

    @Test
    void successfulUserUpdateWithPatch() {

        UserDataRequestModel updateUserData = new UserDataRequestModel();
        updateUserData.setName("george");
        updateUserData.setJob("actor");

        UserUpdateResponseModel userUpdateResponse = step("Send a request to update the user's info with PATCH", () -> given(usersRequestSpec)
                .body(updateUserData)
                .when()
                .patch("/users/2")
                .then()
                .spec(userUpdateResponseSpec)
                .extract().as(UserUpdateResponseModel.class));

        step("Check response", () ->
                assertAll(
                        () -> assertEquals("george", userUpdateResponse.getName()),
                        () -> assertEquals("actor", userUpdateResponse.getJob())
                ));
    }

    @Test
    void successfulUserUpdateWithPut() {

        UserDataRequestModel updateUserData = new UserDataRequestModel();
        updateUserData.setName("tom");
        updateUserData.setJob("writer");

        UserUpdateResponseModel userUpdateResponse = step("Send a request to update the user's info with PUT", () -> given(usersRequestSpec)
                .body(updateUserData)
                .when()
                .put("/users/2")
                .then()
                .spec(userUpdateResponseSpec)
                .extract().as(UserUpdateResponseModel.class));

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
                .delete("/users/2")
                .then()
                .spec(userDeletedResponseSpec));
    }
}
