package pageObject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static actionsWithWebElements.ActionsViaJavaScript.clickViaJavaScript;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckoutPage {
    private final ElementsCollection
            CHECKOUT_SERVICES_CHAPTERS = $$("div[class='checkout-services'] > div"),
            TYPES_OF_DELIVERY_BUTTONS = CHECKOUT_SERVICES_CHAPTERS.get(0).$$("div > div > div > label > input"),
            TYPES_OF_PAYMENT_BUTTONS = CHECKOUT_SERVICES_CHAPTERS.get(1).$$("div > div > div > label > input");

    private final SelenideElement
            MIDDLE_NAME_INPUT_FIELD = $$("div > div[class='form-control'] > input").get(2);

    private final SelenideElement
            STORE_PICKUP_BUTTON = TYPES_OF_DELIVERY_BUTTONS.get(0),
            PAYMENT_BY_CREDIT_CARD_BUTTON = TYPES_OF_PAYMENT_BUTTONS.get(1);

    private final SelenideElement
            STORES_DROP_DOWN = $("div[class='pickup__selected']"),
            FIRST_STORE = $$("div[class='pickup__dropdown is-open'] > label").get(0);

    private final SelenideElement
            ACCEPT_ORDER_BUTTON = $("div[class='order__submit'] > button");

    public CheckoutPage() {
    }

    public CheckoutPage inputMiddleName(String middleName) {
        MIDDLE_NAME_INPUT_FIELD.shouldBe(Condition.enabled).val(middleName);
        return this;
    }

    public CheckoutPage selectStorePickup() {
        STORE_PICKUP_BUTTON.shouldBe(Condition.visible);
        clickViaJavaScript(STORE_PICKUP_BUTTON);
        return this;
    }

    public CheckoutPage selectFirstStoreToPickup() {
        STORES_DROP_DOWN.shouldBe(Condition.visible).click();
        FIRST_STORE.shouldBe(Condition.visible).click();
        return this;
    }

    public CheckoutPage selectPaymentMethodByCreditCard() {
        PAYMENT_BY_CREDIT_CARD_BUTTON.shouldBe(Condition.visible);
        clickViaJavaScript(PAYMENT_BY_CREDIT_CARD_BUTTON);
        return this;
    }

    public CheckoutPage acceptOrder() {
        ACCEPT_ORDER_BUTTON.shouldBe(Condition.visible).click();
        return this;
    }

    public CheckoutPage validateThatErrorPopUpIsNotDisplayed() {
        $(byText("Ошибка создания заказа. Повторите попытку чуть позже")).shouldNotBe(Condition.enabled, Duration.ofSeconds(15));
        return this;
    }
}
