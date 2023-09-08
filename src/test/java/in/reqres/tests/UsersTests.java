package in.reqres.tests;

import in.reqres.api.UsersApi;
import in.reqres.models.UserDataRequestModel;
import in.reqres.models.UserDataResponseModel;
import in.reqres.models.UserUpdateResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersTests extends TestBase {

    UsersApi usersApi = new UsersApi();

    @DisplayName("Verify user creation")
    @Tag("user")
    @Test
    void createUser() {

        UserDataRequestModel inputUserData = new UserDataRequestModel();

        step("Set the name and job", () -> {
            inputUserData.setName("george");
            inputUserData.setJob("unemployed");
        });

        UserDataResponseModel creationResponse = usersApi.createUser(inputUserData);

        step("Check response", () -> {
            assertEquals("george", creationResponse.getName());
            assertEquals("unemployed", creationResponse.getJob());
        });
    }

    @DisplayName("Verify user update with PATCH")
    @Tag("user")
    @Test
    void successfulUserUpdateWithPatch() {

        UserDataRequestModel updateUserData = new UserDataRequestModel();

        step("Set the name and job", () -> {
            updateUserData.setName("jim");
            updateUserData.setJob("actor");
        });

        UserUpdateResponseModel updateResponse = usersApi.updateUserWithPatch(updateUserData);

        step("Check response", () ->
                assertAll(
                        () -> assertEquals("jim", updateResponse.getName()),
                        () -> assertEquals("actor", updateResponse.getJob())
                ));
    }

    @DisplayName("Verify user update with PUT")
    @Tag("user")
    @Test
    void successfulUserUpdateWithPut() {

        UserDataRequestModel updateUserData = new UserDataRequestModel();

        step("Set the name and job", () -> {
            updateUserData.setName("tom");
            updateUserData.setJob("writer");
        });

        UserUpdateResponseModel updateResponse = usersApi.updateUserWithPut(updateUserData);

        step("Check response", () ->
                assertAll(
                        () -> assertEquals("tom", updateResponse.getName()),
                        () -> assertEquals("writer", updateResponse.getJob())
                ));
    }

    @DisplayName("Verify deleting a user")
    @Tag("user")
    @Test
    void successfullyDeleteUser() {

        step("Send a request to delete a user", () ->
                usersApi.deleteUser());
    }
}
