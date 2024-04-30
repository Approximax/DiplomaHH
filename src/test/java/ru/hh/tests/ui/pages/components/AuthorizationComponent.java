package ru.hh.tests.ui.pages.components;

import com.codeborne.selenide.SelenideElement;
import ru.hh.tests.ui.pages.MainPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationComponent {

    SelenideElement loginButton = $("[data-qa = 'login']"),
                    emailLogin = $("[data-qa = 'account-signup-email']"),
                    loginWithPassword = $("[data-qa = 'expand-login-by-password']"),
                    passwordInput = $("[data-qa = 'login-input-password']"),
                    loginSubmit = $("[data-qa = 'account-login-submit']"),
                    vacanciesForYou = $("[data-qa = 'bloko-header-2']");

    MainPage mainPage = new MainPage();

    public void emailAuthPassword (String email, String password) {
        mainPage.openPage();
        loginButton.click();
        emailLogin.setValue(email);
        loginWithPassword.click();
        passwordInput.setValue(password);
        loginSubmit.click();

    }

    public void checkAuthSuccess() {
        vacanciesForYou.shouldBe(visible);

    }

    public AuthorizationComponent checkOnlyLoginAuth(String email) {
        mainPage.openPage();
        loginButton.click();
        emailLogin.setValue(email);
        loginSubmit.click();

        vacanciesForYou.shouldNotBe(visible);

        return this;
    }

    public AuthorizationComponent checkOnlyPassword(String password) {
        mainPage.openPage();
        loginButton.click();
        passwordInput.setValue(password);
        loginSubmit.click();

        vacanciesForYou.shouldNotBe(exist);

        return this;
    }

}