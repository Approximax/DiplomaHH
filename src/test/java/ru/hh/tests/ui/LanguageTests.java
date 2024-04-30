package ru.hh.tests.ui;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.hh.data.Language;
import ru.hh.tests.TestBase;
import ru.hh.tests.ui.pages.MainPage;

import static io.qameta.allure.Allure.step;

public class LanguageTests extends TestBase {

    @ParameterizedTest
    @EnumSource(Language.class)
    void languageSwitch(Language language) {
        MainPage mainPage = new MainPage();

        step("Test", () -> {
            mainPage.switchLanguageWithCheck(language);
        });
    }
}
