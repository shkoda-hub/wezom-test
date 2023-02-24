package pageObject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$;

public class ProductsCatalogPage {
    private final ElementsCollection PRODUCTS_CARDS = $$("div[class='goods-grid js-catalog-goods'] > div");

    public ProductsCatalogPage() {
    }

    public void openProductPageOfFirsProduct() {
        PRODUCTS_CARDS.get(0).shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }
}
