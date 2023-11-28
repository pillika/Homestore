import PageObject.CartPage;
import PageObject.HomeStorePage;
import PageObject.ShopPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static Utils.wait.Utils.DEFAULT_DURATION;
import static Utils.wait.Utils.waitForElementVisibility;
import static org.assertj.core.api.Assertions.*;

public class AddToCartTest extends BaseTest{
    HomeStorePage homeStorePage;
    ShopPage shopPage;
    CartPage cartPage;

    @Test
    @DisplayName("Add item from a list to cart Test")
    public void addItemToCart() {
        homeStorePage=new HomeStorePage(driver);
        shopPage = new ShopPage(driver);

        homeStorePage.clickShopButton();
        shopPage.clickAddtoCart();
        waitForElementVisibility(driver,shopPage.getElement(), DEFAULT_DURATION);
        assertThat(shopPage.viewCartIsDisplayed()).isTrue();
        assertThat(shopPage.getCartPrice()).isEqualTo(shopPage.getProductPrice());
        assertThat(shopPage.getItemcount()).isEqualTo("1 item");
    }
    @Test
    @DisplayName("Add two same items from a list to cart Test")
    public void addItemsToCart() {
        homeStorePage=new HomeStorePage(driver);
        shopPage = new ShopPage(driver);

        homeStorePage.clickShopButton();
        shopPage.clickAddtoCart();
        shopPage.clickAddtoCart();
        waitForElementVisibility(driver,shopPage.getElement(), DEFAULT_DURATION);
        assertThat(shopPage.viewCartIsDisplayed()).isTrue();

        String numericPrice= shopPage.getProductPrice().substring(1);
        float price = Float.parseFloat(numericPrice); //pabandome iskelti i atskira metoda
        float setAmount=2;
        String calculatedPrice = String.format("%.2f",price*setAmount).replace(",",".");

        assertThat(shopPage.getCartPrice()).isEqualTo("£" +calculatedPrice+"");
        assertThat(shopPage.getItemcount()).isEqualTo("2 items");
    }
    @Test
    @DisplayName("Add two different items from a list to cart and hover Test")
        public void addDifferentItemsToCart() {
        homeStorePage=new HomeStorePage(driver);
        shopPage = new ShopPage(driver);

        homeStorePage.clickShopButton();
        shopPage.clickAddtoCart();
        shopPage.clickSecondAddToCart();

        waitForElementVisibility(driver,shopPage.getElement(), DEFAULT_DURATION);
        assertThat(shopPage.bothViewCartIsDisplayed()).isTrue();

        String numericPrice= shopPage.getProductPrice().substring(1);
        float price = Float.parseFloat(numericPrice);
        String secondNumericPrice = shopPage.getSecondProductPrice().substring(1);
        float price2 = Float.parseFloat(secondNumericPrice);
        String calculatedPrice = String.format("%.2f",(price+price2)).replace(",",".");

        assertThat(shopPage.getCartPrice()).isEqualTo("£" +calculatedPrice+"");
        assertThat(shopPage.getItemcount()).isEqualTo(2+" items");

        shopPage.hover(); 
        assertThat(shopPage.viewCartIsDisplayedWhenHovered()).isTrue();
        assertThat(shopPage.checkoutIsDisplayed()).isTrue();
        assertThat(shopPage.getFirstItemQuantityAndPrice()).isEqualTo("1 × "+shopPage.getProductPrice()+"");
        assertThat(shopPage.getSecondItemQuantityAndPrice()).isEqualTo("1 × "+shopPage.getSecondProductPrice()+"");
        assertThat(shopPage.getSubtotal()).isEqualTo("£" +calculatedPrice+"");
        assertThat(shopPage.getFirstItemTitleInCart()).isEqualTo(shopPage.getProductTitle());
        assertThat(shopPage.getSecondItemTitleInCart()).isEqualTo(shopPage.getSecondProductTitle());
    }

    @Test
    @DisplayName("Navigate to cart by clicking ViewCart Test")
    public void clickViewCartNavigatesToCart() {
        homeStorePage=new HomeStorePage(driver);
        shopPage = new ShopPage(driver);
        cartPage =new CartPage(driver);

        homeStorePage.clickShopButton();
        shopPage.clickAddtoCart();

        waitForElementVisibility(driver,shopPage.getElement(), DEFAULT_DURATION);
        shopPage.clickViewCart();

        assertThat(cartPage.pageTitleIsDisplayed()).isTrue();
    }
    @Test
    @DisplayName("Navigate to cart by clicking cart information block Test")
    public void clickCartInfoBoxNavigateToCart() {
        homeStorePage=new HomeStorePage(driver);
        shopPage = new ShopPage(driver);
        cartPage =new CartPage(driver);

        homeStorePage.clickShopButton();
        shopPage.clickAddtoCart();
        shopPage.clickCartInformationBlock();

        assertThat(cartPage.pageTitleIsDisplayed()).isTrue();
    }
}
