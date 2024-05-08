package ru.hh.tests.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationPage {

    SelenideElement emailLogin = $("[data-qa = 'login-input-username']"),
            loginWithPassword = $("[data-qa = 'expand-login-by-password']"),
            passwordInput = $("[data-qa = 'login-input-password']"),
            loginSubmit = $("[data-qa = 'account-login-submit']"),
            vacanciesForYou = $("[data-qa = 'bloko-header-2']");

    public void openPage() {
        open("/account/login");
    }

    public void emailAuthPassword(String email, String password) {
        loginWithPassword.click();
        emailLogin.setValue(email);
        passwordInput.setValue(password);
        loginSubmit.click();
    }

    public void checkAuthSuccess() {
        vacanciesForYou.shouldBe(visible);

    }

    public void checkOnlyLoginAuth(String email) {
        loginWithPassword.click();
        emailLogin.setValue(email);
        loginSubmit.click();

        vacanciesForYou.shouldNotBe(exist);

    }

    public void checkOnlyPassword(String password) {
        loginWithPassword.click();
        passwordInput.setValue(password);
        loginSubmit.click();

        vacanciesForYou.shouldNotBe(exist);

    }

}