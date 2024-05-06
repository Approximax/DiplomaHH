package ru.hh.tests.ui;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import ru.hh.tests.TestBase;
import ru.hh.tests.ui.pages.SearchPage;

import java.util.Locale;

import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {
    SearchPage searchPage = new SearchPage();
    Faker faker = new Faker();

    String jobTitle = faker.job().title();

    @Test
    void searchHaveResults() {
        step("Open page", () -> {
            searchPage.openPage();
        });

        step("Input job title for searching", () -> {
            searchPage.searchInput(jobTitle);
            searchPage.submitSearch();
        });

        step("Check the result", () -> {
            searchPage.checkThatResultsExist();
        });

    }

    @Test
    void vacanciesHaveCompensation() {
        step("Open page", () -> {
            searchPage.openPage();
        });

        step("Click compensation filter", () -> {
            searchPage.onlyWithCompensation();
            searchPage.submitSearch();
        });

        step("Check the result", () -> {
            searchPage.checkCompensation();
        });
    }
}
