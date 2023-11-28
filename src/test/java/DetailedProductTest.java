import PageObject.HomeStorePage;
import PageObject.ProductPage;
import PageObject.ShopPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedList;

import static java.awt.SystemColor.text;
import static org.assertj.core.api.Assertions.*;

public class DetailedProductTest extends BaseTest {
    HomeStorePage homeStorePage;
    ShopPage shopPage;
    ProductPage productPage;


    @Test
    @DisplayName("Detailed product page items test")
    public void detailedProductPageItemsTest() {
        homeStorePage = new HomeStorePage(driver);
        shopPage = new ShopPage(driver);
        productPage = new ProductPage(driver);

        homeStorePage.clickShopButton();

        String selectedProductTitle = shopPage.getProductTitle();
        shopPage.clickProduct();

        assertThat(productPage.getProductTitle()).isEqualTo(selectedProductTitle);
        assertThat(productPage.productDescriptionIsDisplayed()).isTrue();
        assertThat(productPage.productCategoryIsDisplayed()).isTrue();
        assertThat(productPage.productPriceIsDisplayed()).isTrue();
    }

    @Test
    @DisplayName("Select Product Amount Test")
    public void selectAmountTest() {
        homeStorePage = new HomeStorePage(driver);
        shopPage = new ShopPage(driver);
        productPage = new ProductPage(driver);

        homeStorePage.clickShopButton();
        shopPage.clickProduct();

        String productTitle = productPage.getProductTitle();
        int amount = 2;
        productPage.clearAmount();
        productPage.enterAmount(String.valueOf(amount));
        productPage.clickAddToCart();
        assertThat(productPage.getMessage()).isEqualTo(amount + " × “" + productTitle + "” have been added to your cart.");
        assertThat(productPage.viewCartIsDisplayed()).isTrue();

        int amount2 = 3;

        productPage.clearAmount();
        productPage.enterAmount(String.valueOf(amount2));
        productPage.clickEnter();
        assertThat(productPage.getMessage()).isEqualTo(amount2 + " × “" + productTitle + "” have been added to your cart.");
        assertThat(productPage.viewCartIsDisplayed()).isTrue();
    }

    @Test
    @DisplayName("Select product amount using arrows Test")
    public void selectAmountByArrows() {
        homeStorePage = new HomeStorePage(driver);
        shopPage = new ShopPage(driver);
        productPage = new ProductPage(driver);

        homeStorePage.clickShopButton();
        shopPage.clickProduct();

        String productTitle = productPage.getProductTitle();
        int defaultAmount = 1;
        productPage.clickAmount();
        productPage.clickArrowUP();

        productPage.clickAddToCart();
        assertThat(productPage.getMessage()).isEqualTo((defaultAmount + 1) + " × “" + productTitle + "” have been added to your cart.");
        assertThat(productPage.viewCartIsDisplayed()).isTrue();

        int amount2 = 3;

        productPage.clearAmount();
        productPage.enterAmount(String.valueOf(amount2));
        productPage.clickAmount();
        productPage.clickArrowDOWN();
        productPage.clickAddToCart();
        assertThat(productPage.getMessage()).isEqualTo((amount2 - 1) + " × “" + productTitle + "” have been added to your cart.");
        assertThat(productPage.viewCartIsDisplayed()).isTrue();
    }

    @Test
    @DisplayName("Edit products amount by delete and backspace Test")
    public void editAmountByDeleteandBackspace() {
        homeStorePage = new HomeStorePage(driver);
        shopPage = new ShopPage(driver);
        productPage = new ProductPage(driver);

        homeStorePage.clickShopButton();
        shopPage.clickProduct();

        String productTitle = productPage.getProductTitle();

        productPage.clickAmount();
        productPage.clickBackSpace();
        int amount = 20;

        productPage.enterAmount(String.valueOf(amount));
        productPage.clickAddToCart();
        assertThat(productPage.getMessage()).isEqualTo(amount + " × “" + productTitle + "” have been added to your cart.");
        assertThat(productPage.viewCartIsDisplayed()).isTrue();

        productPage.clickAmount();
        productPage.moveLeft();
        productPage.clickDelete();
        productPage.clickAddToCart();

        String amountString= String.valueOf(amount);
        String result= amountString.substring(0,amountString.length()-1);

        assertThat(productPage.getMessage()).isEqualTo(result + " × “" + productTitle + "” have been added to your cart.");
        assertThat(productPage.viewCartIsDisplayed()).isTrue();
    }

    @Test
    @DisplayName("Edit products amount by additionalNumbers Test")
    public void editAmountByAdditionalNumbers() {
        homeStorePage = new HomeStorePage(driver);
        shopPage = new ShopPage(driver);
        productPage = new ProductPage(driver);

        homeStorePage.clickShopButton();
        shopPage.clickProduct();
        String productTitle = productPage.getProductTitle();

        productPage.clickAmount();
        int amount = 5;
        productPage.enterAdditionalNumber(String.valueOf(amount));
        productPage.clickAddToCart();
        assertThat(productPage.getMessage()).isEqualTo("1" + amount + " × “" + productTitle + "” have been added to your cart.");
        assertThat(productPage.viewCartIsDisplayed()).isTrue();

        productPage.clickAmount();
        productPage.moveLeft();
        productPage.moveLeft();
        int amount2 = 1;
        productPage.enterAdditionalNumber(String.valueOf(amount2));
        productPage.clickAddToCart();
        assertThat(productPage.getMessage()).isEqualTo(amount2 + "1" + amount + " × “" + productTitle + "” have been added to your cart.");
        assertThat(productPage.viewCartIsDisplayed()).isTrue();
    }

    @Test
    @DisplayName("Cant delete products amount completely Test")
    public void deleteAmountCompletely() {
        homeStorePage = new HomeStorePage(driver);
        shopPage = new ShopPage(driver);
        productPage = new ProductPage(driver);

        homeStorePage.clickShopButton();
        shopPage.clickProduct();

        String productTitle = productPage.getProductTitle();

        productPage.clickAmount();
        productPage.moveLeft();
        productPage.clickDelete();

        productPage.clickAddToCart();
        assertThat(productPage.getMessage()).isEqualTo("“" + productTitle + "” has been added to your cart.");
        assertThat(productPage.viewCartIsDisplayed()).isTrue();
    }
 @ParameterizedTest
 @ValueSource(strings ={"*", "a"})
 @DisplayName("Invalid 'Amount' inputs Test")
 public void invalidAmountInputs(String invalidAmount) {
     homeStorePage = new HomeStorePage(driver);
     shopPage = new ShopPage(driver);
     productPage = new ProductPage(driver);

     homeStorePage.clickShopButton();
     shopPage.clickProduct();

     String productTitle = productPage.getProductTitle();

     productPage.clearAmount();
     productPage.enterAmount(invalidAmount);
     productPage.clickAddToCart();
     assertThat(productPage.getMessage()).isEqualTo("“" + productTitle + "” has been added to your cart.");
     assertThat(productPage.viewCartIsDisplayed()).isTrue();
 }
}
