import com.codeborne.selenide.Selenide;
import lombok.Getter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pageObject.components.HeaderCenterComponent;
import pageObject.pages.CabinetPage;
import pageObject.pages.CheckoutPage;
import pageObject.pages.ProductPage;
import pageObject.pages.ProductsCatalogPage;
import pageObject.popUps.AuthPopUp;
import pageObject.popUps.CartPopUp;

@Getter
public class BaseTest {
    private HeaderCenterComponent headerCenterComponent;
    private AuthPopUp authPopUp;
    private ProductsCatalogPage productsCatalogPage;
    private ProductPage productPage;
    private CartPopUp cartPopUp;
    private CheckoutPage checkoutPage;
    private CabinetPage cabinetPage;

    @BeforeClass(alwaysRun = true)
    public void setUpPagesAndComponents() {
        headerCenterComponent = new HeaderCenterComponent();
        authPopUp = new AuthPopUp();
        productsCatalogPage = new ProductsCatalogPage();
        productPage = new ProductPage();
        cartPopUp = new CartPopUp();
        checkoutPage = new CheckoutPage();
        cabinetPage = new CabinetPage();
    }

    @BeforeMethod(alwaysRun = true)
    public void openStore() {
        Selenide.open("https://evrika.wezom.agency/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
