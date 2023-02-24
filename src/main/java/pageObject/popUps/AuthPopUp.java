package pageObject.popUps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static actionsWithWebElements.ActionsViaJavaScript.clickViaJavaScript;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AuthPopUp {
    private final SelenideElement
            REGISTER_BUTTON = $(".popup__aside > button"),
            NAME_INPUT_FIELD = $("input[name='name']"),
            SURNAME_INPUT_FIELD = $("input[name='surname']"),
            PHONE_NUMBER_INPUT_FIELD = $("div[class='popup__view'] > form > div > input[type='tel']"),
            EMAIL_INPUT_FIELD = $("input[name='email']"),
            PASSWORD_INPUT_FIELD = $$("input[type='password']").get(0),
            REPEAT_PASSWORD_INPUT_FIELD = $$("input[type='password']").get(1),
            ACCEPT_PRIVACY_CHECK_BOX = $("input[type='checkbox']"),
            SUBMIT_REGISTRATION_BUTTON = $("div[class='popup__view'] > form > .button_one");

    public AuthPopUp() {
    }

    public void registerNewUser(String name,
                                String surname,
                                String phone,
                                String email,
                                String password) {

        REGISTER_BUTTON.shouldBe(Condition.enabled).click();
        NAME_INPUT_FIELD.shouldBe(Condition.enabled).val(name);
        SURNAME_INPUT_FIELD.shouldBe(Condition.enabled).val(surname);
        PHONE_NUMBER_INPUT_FIELD.sendKeys(phone);

        EMAIL_INPUT_FIELD.shouldBe(Condition.enabled).val(email);
        Selenide.sleep(200);

        PASSWORD_INPUT_FIELD.shouldBe(Condition.enabled).val(password);
        Selenide.sleep(200);

        REPEAT_PASSWORD_INPUT_FIELD.shouldBe(Condition.enabled).val(password);
        Selenide.sleep(200);

        clickViaJavaScript(ACCEPT_PRIVACY_CHECK_BOX);
        clickViaJavaScript(SUBMIT_REGISTRATION_BUTTON);

//        Selenide.sleep(5000);
    }

}
