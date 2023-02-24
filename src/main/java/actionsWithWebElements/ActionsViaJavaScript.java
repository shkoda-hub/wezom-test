package actionsWithWebElements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public final class ActionsViaJavaScript {
    private ActionsViaJavaScript() {
    }

    public static void clickViaJavaScript(SelenideElement element) {
        Selenide.executeJavaScript("arguments[0].click()", element);
    }
}
