package ru.hh.tests.ui;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.hh.tests.TestBase;
import ru.hh.tests.ui.pages.MainPage;

import static io.qameta.allure.Allure.step;

@Tag("main_page")
@Owner("Vladislav Kryukov")
public class MainPageTests extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Checking cookies policy banner")
    void cookiesPolicyTest() {
        step("Open page", () -> {
            mainPage.openPage();
        });

        step("Check policy banner", () -> {
            mainPage.checkCookiesPolicy();
        });
    }

    @Test
    @DisplayName("Check the opening of the authorization form.")
    void loginFormOpenTest() {
        step("Open page", () -> {
            mainPage.openPage();
        });

        step("Click open button", () -> {
            mainPage.loginFormOpen();
        });

        step("Check result", () -> {
            mainPage.checkLoginOpen();
        });
    }
}
