package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPageV2 {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");
    private SelenideElement errorMessageInvalidInfo = $("[data-test-id=error-notification] .notification__content");
    private SelenideElement errorMessageBlockedSystem = $("[data-test-id=error-notification] .notification__content");


    public void errorMessageTypeOne() {
        errorMessageInvalidInfo.shouldBe(visible).shouldHave(text("Ошибка! Неверно указан логин или пароль"));
    }



    public VerificationPage validInfo(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }

    public void invalidInfo(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        errorMessageTypeOne();
    }


}
