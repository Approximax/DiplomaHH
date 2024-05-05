package ru.hh.tests.ui;

import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.hh.config.UserConfig;
import ru.hh.tests.TestBase;
import ru.hh.tests.ui.pages.components.AuthorizationComponent;

import static io.qameta.allure.Allure.step;

@Tag("authorization")
@Owner("Vladislav Kryukov")
public class AuthorizationTests extends TestBase {

    AuthorizationComponent authorizationComponent = new AuthorizationComponent();
    UserConfig userConfig = ConfigFactory.create(UserConfig.class);

    @Test
    @DisplayName("Authorization with correct credentials")
    void correctAuthTest() {
        step("Open authorization page", () -> {
            authorizationComponent.openPage();
        });

        step("Authorize with correct email and password", () -> {
            authorizationComponent.emailAuthPassword(userConfig.login(), userConfig.password());
        });

        step("Check that authorization went success", () -> {
            authorizationComponent.checkAuthSuccess();
        });
    }

    @Test
    @DisplayName("Authorization with only login input")
    void onlyLoginAuthTest() {
        step("Open authorization page", () -> {
            authorizationComponent.openPage();
        });

        step("Authorize only with login", () -> {
            authorizationComponent.checkOnlyLoginAuth(userConfig.login());
        });
    }

    @Test
    @DisplayName("Authorization with only password input")
    void onlyPasswordAuthTest() {
        step("Open authorization page", () -> {
            authorizationComponent.openPage();
        });

        step("Authorize only with password", () -> {
            authorizationComponent.checkOnlyPassword(userConfig.password());
        });
    }
}
