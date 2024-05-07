package ru.hh.tests.api;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import ru.hh.tests.TestBase;
import ru.hh.tests.api.models.dictionares.LanguagesModel;

import java.util.Arrays;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static ru.hh.tests.api.specs.HhSpecs.requestSpec;
import static ru.hh.tests.api.specs.HhSpecs.responseSpec;

public class DictionariesTests extends TestBase {

    @Test
    void possibleLanguages() {
        LanguagesModel languagesModel = step("Make the request of possible languages", () ->
            given(requestSpec)
                    .when()
                    .get("/languages")
                    .then()
                    .spec(responseSpec)
                    .extract().as(LanguagesModel.class));
        SoftAssertions languagesInfo = new SoftAssertions();
        languagesInfo.assertThat(languagesModel.getLanguages().iterator().toString()).isNotNull();

        step("Check that the required fields aren`t empty", () -> languagesInfo.assertAll());
    }
}
