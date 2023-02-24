package pageObject.components;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HeaderCenterComponent {
    private final SelenideElement
            AUTHORIZE_REGISTER_USER_BUTTON = $(".header__actions-item_user > div");

    public HeaderCenterComponent() {
    }

    public void openAuthPopUp() {
        AUTHORIZE_REGISTER_USER_BUTTON.shouldBe(Condition.enabled).click();
    }
}
