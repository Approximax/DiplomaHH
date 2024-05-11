package ru.hh.tests.api;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.hh.tests.TestBase;
import ru.hh.tests.api.models.ErrorModel;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.hh.tests.api.specs.HhSpecs.requestSpec;
import static ru.hh.tests.api.specs.HhSpecs.response403Spec;

@Tag("user_info_API")
@Owner("Vladislav Kryukov")
public class UserInfoTests extends TestBase {

    @Test
    @DisplayName("Error for requesting user info as unauthorized user")
    void userInfoRequestError() {
        ErrorModel errorModel = step("Make the request", () ->
                given(requestSpec)
                        .when()
                        .get("/me")
                        .then()
                        .spec(response403Spec)
                        .extract().as(ErrorModel.class));

        step("Check the result", () -> {
            assertThat(errorModel.getDescription()).isEqualTo("Forbidden");
        });
    }
}
