package pageObject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    SelenideElement ADD_TO_CART_BUTTON = $("div[class='goods-buy'] > div > div > div > button");

    public ProductPage() {
    }

    public void addProductToCart() {
        ADD_TO_CART_BUTTON.shouldBe(Condition.enabled).click();
    }
}
