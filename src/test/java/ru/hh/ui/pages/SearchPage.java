package ru.hh.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage {

    private final SelenideElement searchInput = $("[data-qa = 'vacancysearch__keywords-input']"),
            submitSearch = $("[data-qa = 'advanced-search-submit-button']"),
            onlyWithCompensation = $(".bloko-checkbox__text"),
            compensation = $("[data-qa = 'vacancy-serp__vacancy-compensation']"),
            searchResults = $("[data-qa = 'vacancy-serp__results']");

    public void openPage() {
        open("search/vacancy/advanced");
    }

    public void searchInput(String value) {
        searchInput.setValue(value);
    }

    public void onlyWithCompensation() {
        onlyWithCompensation.click();
    }

    public void submitSearch() {
        submitSearch.click();
    }

    public void checkCompensation() {
        compensation.shouldBe(visible);
    }

    public void checkThatResultsExist() {
        searchResults.shouldBe(visible);
    }
}