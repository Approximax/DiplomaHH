package ru.hh.tests.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    SelenideElement searchInput = $("[data-qa = 'search-input']"),
                    submitSearch = $("[data-qa = 'search-button']");

    public void openPage() {
        open("");
    }

    public void searchInput(String value) {
        searchInput.setValue(value);
        submitSearch.click();
    }
}


