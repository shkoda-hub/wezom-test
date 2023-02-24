import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static utils.AllureLogger.stepInfo;

@Listeners({ScreenShooter.class})
public class TestEndToEndToBuyProduct extends BaseTest {

    @DataProvider(name = "validUserInfoDataProvider")
    public Object[][] validUserInfoDataProvider() {
        return new Object[][]{
                {
                        "TestName" + randomNumeric(5),
                        "TestSurname" + randomNumeric(5),
                        randomNumeric(10),
                        randomAlphabetic(10) + "@gmail.com",
                        "123" + randomAlphabetic(5)
                }
        };

    }

    @Test(dataProvider = "validUserInfoDataProvider")
    public void testEndToEndToBuyProduct(String name, String surname, String phone, String email, String password) {
        stepInfo(1, "Register new user");
        getHeaderCenterComponent().openAuthPopUp();
        getAuthPopUp().registerNewUser(name, surname, phone, email, password);
        getCabinetPage().validateThatCabinetContentIsVisible();

        stepInfo(2, "Add product to cart");
        Selenide.open("https://evrika.wezom.agency/catalog/noutbuki1/c207");
        getProductsCatalogPage().openProductPageOfFirsProduct();
        getProductPage().addProductToCart();

        stepInfo(3, "Go to checkout");
        getCartPopUp().checkout();

        stepInfo(4, "Select all required info. Accept order and validate that there are not any errors");
        getCheckoutPage()
                .inputMiddleName("AutoTest")
                .selectStorePickup()
                .selectFirstStoreToPickup()
                .selectPaymentMethodByCreditCard()
                .acceptOrder()
                .validateThatErrorPopUpIsNotDisplayed();
    }
}
