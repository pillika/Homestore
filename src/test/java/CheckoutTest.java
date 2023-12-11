import PageObject.CartPage;
import PageObject.CheckoutPage;
import PageObject.HomeStorePage;
import PageObject.ShopPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static Utils.wait.Utils.DEFAULT_DURATION;
import static Utils.wait.Utils.waitForElementVisibility;
import static org.assertj.core.api.Assertions.*;

public class CheckoutTest extends BaseTest{
    HomeStorePage homeStorePage;
    ShopPage shopPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    @Test
    @DisplayName("User can navigate to checkout Test")
    public void navigationToCheckout() {
        homeStorePage= new HomeStorePage(driver);
        shopPage = new ShopPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        homeStorePage.clickShopButton();
        shopPage.clickAddtoCart();
        waitForElementVisibility(driver,shopPage.getElement(), DEFAULT_DURATION);
        shopPage.clickViewCart();
        cartPage.clickCheckoutButton();

        assertThat(checkoutPage.checkoutPageTitleIsDisplayed()).isTrue();
    }
    @Test
    @DisplayName("Product info block and message Test")
    public void productInfoBlock() {
        homeStorePage= new HomeStorePage(driver);
        shopPage = new ShopPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        homeStorePage.clickShopButton();
        String productTitle =shopPage.getProductTitle();
        String productPrice = shopPage.getProductPrice();
        shopPage.clickAddtoCart();
        waitForElementVisibility(driver,shopPage.getElement(), DEFAULT_DURATION);
        shopPage.clickViewCart();
        cartPage.clickCheckoutButton();

        assertThat(checkoutPage.productTitleIsDisplayed()).isTrue();
        assertThat(checkoutPage.productTitle()).contains(productTitle);
        assertThat(checkoutPage.productTitle()).contains("1");
        assertThat(checkoutPage.getItemsSubtotal()).isEqualTo(productPrice);
        assertThat(checkoutPage.cartsSubtotalisDisplayed()).isTrue();
        assertThat(checkoutPage.cartTotalisDisplayed()).isTrue();
        assertThat(checkoutPage.getMessage()).isEqualTo("Please fill in your details above to see available payment methods.");
        assertThat(checkoutPage.placeOrderIsDisplayed()).isTrue();
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/formFillData.csv")
    @DisplayName("User form with required fields fill Test")
    public void fromFillCheckout(String name, String lastname, String company,String country, String street, String house, String city, String county, String postcode, String phonenumber, String email, String message ){
        homeStorePage= new HomeStorePage(driver);
        shopPage = new ShopPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        homeStorePage.clickShopButton();
        shopPage.clickAddtoCart();
        waitForElementVisibility(driver,shopPage.getElement(), DEFAULT_DURATION);
        shopPage.clickViewCart();
        cartPage.clickCheckoutButton();

        checkoutPage.enterName(name);
        checkoutPage.enterLastname(lastname);
        checkoutPage.enterCompany(company);
        checkoutPage.clickCountryDropDown();
        checkoutPage.enterCountry(country);
        checkoutPage.enterStreet(street);
        checkoutPage.enterHouse(house);
        checkoutPage.enterCity(city);
        checkoutPage.enterCounty(county);
        checkoutPage.enterPostcode(postcode);
        checkoutPage.enterPhone(phonenumber);
        checkoutPage.enterEmail(email);
        checkoutPage.clickPlaceOrder();
        waitForElementVisibility(driver,checkoutPage.getElement(), DEFAULT_DURATION);

        assertThat(checkoutPage.getAlertMessage()).contains(message);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/countryFill.csv")
    @DisplayName("form dorpdow Test")
    public void countryDropDownTest(String name, String lastname, String company,String value, String street, String house, String city, String postcode, String phonenumber, String email, String countryName ) {
        homeStorePage= new HomeStorePage(driver);
        shopPage = new ShopPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        homeStorePage.clickShopButton();
        shopPage.clickAddtoCart();
        waitForElementVisibility(driver,shopPage.getElement(), DEFAULT_DURATION);
        shopPage.clickViewCart();
        cartPage.clickCheckoutButton();

        checkoutPage.enterName(name);
        checkoutPage.enterLastname(lastname);
        checkoutPage.enterCompany(company);
        checkoutPage.selectCountry(value);
        checkoutPage.enterStreet(street);
        checkoutPage.enterHouse(house);
        checkoutPage.enterCity(city);
        checkoutPage.enterPostcode(postcode);
        checkoutPage.enterPhone(phonenumber);
        checkoutPage.enterEmail(email);
        checkoutPage.clickPlaceOrder();
        assertThat(checkoutPage.countryName().equals(countryName));
    }
@ParameterizedTest
@DisplayName("Leave country empty Test")
@CsvSource({"Petras,Petraitis, Petras ir Co, Pievu, 20-3, Kaunas,54378, 861500000, petrras@laisve.lt,Billing Country / Region is a required field."})
    public void countryEmpty(String name, String lastname, String company, String street, String house, String city, String postcode, String phonenumber, String email, String message) {
    homeStorePage= new HomeStorePage(driver);
    shopPage = new ShopPage(driver);
    cartPage = new CartPage(driver);
    checkoutPage = new CheckoutPage(driver);

    homeStorePage.clickShopButton();
    shopPage.clickAddtoCart();
    waitForElementVisibility(driver,shopPage.getElement(), DEFAULT_DURATION);
    shopPage.clickViewCart();
    cartPage.clickCheckoutButton();

    checkoutPage.enterName(name);
    checkoutPage.enterLastname(lastname);
    checkoutPage.enterCompany(company);
    checkoutPage.enterStreet(street);
    checkoutPage.enterHouse(house);
    checkoutPage.enterCity(city);
    checkoutPage.enterPostcode(postcode);
    checkoutPage.enterPhone(phonenumber);
    checkoutPage.enterEmail(email);
    checkoutPage.clickPlaceOrder();

    waitForElementVisibility(driver,checkoutPage.getElement(), DEFAULT_DURATION);
    assertThat(checkoutPage.getAlertMessage()).contains(message);
}
}
