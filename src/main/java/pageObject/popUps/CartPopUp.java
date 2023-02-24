package pageObject.popUps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPopUp {
    SelenideElement CHECKOUT_BUTTON = $("div[class='cart-resume__button-order']");

    public CartPopUp() {
    }

    public void checkout() {
        CHECKOUT_BUTTON.shouldBe(Condition.enabled).click();
    }
}
