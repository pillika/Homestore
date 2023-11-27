import PageObject.HomeStorePage;
import PageObject.ProductPage;
import PageObject.ShopPage;
import Utils.wait.Utils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static Utils.wait.Utils.waitForElementVisibility;
import static org.assertj.core.api.Assertions.*;

public class AddToCartTest extends BaseTest{
    HomeStorePage homeStorePage;

    ShopPage shopPage;

    @Test
    @DisplayName("Add item from a list to cart Test")
    public void addItemToCart() {
        homeStorePage=new HomeStorePage(driver);
        shopPage = new ShopPage(driver);


        homeStorePage.clickShopButton();
        shopPage.clickAddtoCart();
        waitForElementVisibility(driver,shopPage.getElement(), Duration.ofSeconds(3));
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
        waitForElementVisibility(driver,shopPage.getElement(), Duration.ofSeconds(3));
        assertThat(shopPage.viewCartIsDisplayed()).isTrue();

        assertThat(shopPage.getCartPrice()).isEqualTo(shopPage.getProductPrice());
        assertThat(shopPage.getItemcount()).isEqualTo("2 items");
    }
}
