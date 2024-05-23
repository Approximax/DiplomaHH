package ru.hh.ui.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPage {

    private final SelenideElement cookiesPolicy = $("[data-qa = 'cookies-policy-informer']"),
            loginForm = $("[data-qa = 'login']");

    String authUrl = "https://spb.hh.ru/account/login?backurl=%2F&hhtmFrom=main";

    public void openPage() {
        open("");
    }

    public void checkCookiesPolicy() {
        cookiesPolicy.shouldBe(visible);
    }

    public void loginFormOpen() {
        loginForm.click();
    }

    public void checkLoginOpen() {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertThat(currentUrl).isEqualTo(authUrl);
    }
}


