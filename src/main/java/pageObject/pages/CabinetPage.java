package pageObject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class CabinetPage {
    private final SelenideElement CABINET_CONTENT = $("div[class='cabinet__content']");

    public CabinetPage() {

    }

    public void validateThatCabinetContentIsVisible() {
        CABINET_CONTENT.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}
