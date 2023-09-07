package in.reqres.tests;

import in.reqres.models.ResourceListResponseModel;
import in.reqres.models.SingleResourceResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.ResourcesSpec.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ResourceTests extends TestBase {

    @DisplayName("Verify the list of all resources")
    @Test
    void getResourcesList() {

        ResourceListResponseModel resourcesListResponse = step("Send a request to get a list of resources", () -> given(resourcesRequestSpec)
                .when()
                .get("/unknown")
                .then()
                .spec(resourcesListResponseSpec)
                .extract().as(ResourceListResponseModel.class));

        step("Check response", () -> {
            assertThat(resourcesListResponse.getTotal()).isEqualTo(12);
            assertThat(resourcesListResponse.getTotalPages()).isEqualTo(2);
        });
    }

    @DisplayName("Verify a single resource card")
    @Test
    void getSingleResource() {

        SingleResourceResponseModel singleResource = step("Send a request to get a card of a singular resource", () -> given(resourcesRequestSpec)
                .when()
                .get("/unknown/5")
                .then()
                .spec(singleResourceResponseSpec)
                .extract().as(SingleResourceResponseModel.class));

        step("Check response", () -> {
            assertThat(singleResource.getData().getId()).isEqualTo(5);
            assertThat(singleResource.getData().getName()).isEqualTo("tigerlily");
        });
    }
}
