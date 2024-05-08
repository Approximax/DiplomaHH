package ru.hh.tests.api;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.hh.helpers.RandomData;
import ru.hh.tests.TestBase;
import ru.hh.tests.api.models.employers.EmployerRequestModel;
import ru.hh.tests.api.models.employers.EmployersModel;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.hh.tests.api.specs.HhSpecs.requestSpec;
import static ru.hh.tests.api.specs.HhSpecs.responseSpec;

@Tag("employers_API")
@Owner("Vladislav Kryukov")
public class EmployersTests extends TestBase {
    RandomData randomData = new RandomData();

    @Test
    @DisplayName("Search results for employers more than 0")
    void employersFoundCountTest() {
        EmployerRequestModel body = new EmployerRequestModel();
        body.setText(randomData.getRandomEmployer());
        body.setArea(randomData.getRandomArea());
        EmployersModel employersModel = step("Make request", () ->
                given(requestSpec)
                        .body(body)
                        .when()
                        .get("/employers")
                        .then()
                        .spec(responseSpec)
                        .extract().as(EmployersModel.class));

        step("Check the result", () -> {
            assertThat(employersModel.getFound()).isGreaterThanOrEqualTo(0);
        });
    }
}
