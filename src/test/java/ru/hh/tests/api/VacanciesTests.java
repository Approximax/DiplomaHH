package ru.hh.tests.api;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.hh.helpers.RandomData;
import ru.hh.tests.TestBase;
import ru.hh.tests.api.models.ErrorModel;
import ru.hh.tests.api.models.vacancies.VacanciesRequestModel;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.hh.tests.api.specs.HhSpecs.requestSpec;
import static ru.hh.tests.api.specs.HhSpecs.response403Spec;

@Tag("vacancies_API")
@Owner("Vladislav Kryukov")
public class VacanciesTests extends TestBase {
    RandomData randomData = new RandomData();
    VacanciesRequestModel body = new VacanciesRequestModel();

    @Test
    @DisplayName("Error for deleting favorite vacancy non-authorized user")
    void deleteFavouriteVacancy() {
        body.setVacancyId(randomData.getRandomId());
        ErrorModel errorModel = step("Make the request", () ->
                given(requestSpec)
                        .body(body)
                        .when()
                        .delete(String.format("/vacancies/favorited/%s", randomData.getRandomId()))
                        .then()
                        .spec(response403Spec)
                        .extract().as(ErrorModel.class));

        step("Check the result", () -> {
            assertThat(errorModel.getDescription()).isEqualTo("Forbidden");
        });
    }

    @Test
    @DisplayName("Error for adding favorite vacancy non-authorized user")
    void addingFavouriteVacancy() {
        body.setVacancyId(randomData.getRandomId());
        ErrorModel errorModel = step("Make the request", () ->
                given(requestSpec)
                        .body(body)
                        .when()
                        .put(String.format("/vacancies/favorited/%s", randomData.getRandomId()))
                        .then()
                        .spec(response403Spec)
                        .extract().as(ErrorModel.class));

        step("Check the result", () -> {
            assertThat(errorModel.getDescription()).isEqualTo("Forbidden");
        });
    }

    @Test
    @DisplayName("Error for viewing favorite vacancy non-authorized user")
    void showFavoriteVacancies() {
        body.setVacancyId(randomData.getRandomId());
        ErrorModel errorModel = step("Make the request", () ->
                given(requestSpec)
                        .body(body)
                        .when()
                        .get("/vacancies/favorited")
                        .then()
                        .spec(response403Spec)
                        .extract().as(ErrorModel.class));

        step("Check the result", () -> {
            assertThat(errorModel.getDescription()).isEqualTo("Forbidden");
        });
    }
}
