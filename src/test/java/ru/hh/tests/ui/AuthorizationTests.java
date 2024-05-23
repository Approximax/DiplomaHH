package ru.hh.tests.ui;

import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.hh.config.UserConfig;
import ru.hh.tests.TestBase;
import ru.hh.ui.pages.AuthorizationPage;

import static io.qameta.allure.Allure.step;

@Tag("authorization")
@Owner("Vladislav Kryukov")
public class AuthorizationTests extends TestBase {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    UserConfig userConfig = ConfigFactory.create(UserConfig.class);

    @Test
    @DisplayName("Authorization with correct credentials")
    void correctAuthTest() {
        step("Open authorization page", () -> {
            authorizationPage.openPage();
        });

        step("Authorize with correct email and password", () -> {
            authorizationPage.authorizationWithLoginPassword(userConfig.login(), userConfig.password());
        });

        step("Check that authorization went success", () -> {
            authorizationPage.checkAuthSuccess();
        });
    }

    @Test
    @DisplayName("Authorization with only login input")
    void onlyLoginAuthTest() {
        step("Open authorization page", () -> {
            authorizationPage.openPage();
        });

        step("Authorize only with login", () -> {
            authorizationPage.checkOnlyLoginAuth(userConfig.login());
        });
    }

    @Test
    @DisplayName("Authorization with only password input")
    void onlyPasswordAuthTest() {
        step("Open authorization page", () -> {
            authorizationPage.openPage();
        });

        step("Authorize only with password", () -> {
            authorizationPage.checkOnlyPassword(userConfig.password());
        });
    }
}
