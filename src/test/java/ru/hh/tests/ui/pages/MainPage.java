package ru.hh.tests.ui.pages;

import com.codeborne.selenide.SelenideElement;
import ru.hh.data.Language;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    SelenideElement searchInput = $("[data-qa = 'search-input']"),
                    submitSearch = $("[data-qa = 'search-button']"),
                    titleJobForEvery = $("[data-qa = 'bloko-header-3']");

    public void openPage() {
        open("/?hhtmFrom=");
    }

    public void switchLanguageWithCheck(Language language) {
        openPage();
        $("[data-qa = 'change-locale-" + language + "']").click();

        titleJobForEvery.shouldHave(text(language.description));
    }
}


