import PageObject.HomeStorePage;
import PageObject.ProductPage;
import PageObject.ShopPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class ShoplistTest extends BaseTest{
    HomeStorePage homeStorePage;
    ShopPage shopPage;
    ProductPage productPage;

    @Test
    @DisplayName("User can navigate product list pages using arrows")
    public void shopListArrowNavigationTest() {
        homeStorePage = new HomeStorePage(driver);
        shopPage = new ShopPage(driver);

        homeStorePage.clickShopButton();
        String firstPageResultCount = shopPage.getResultCountText();

        shopPage.navigateToNextPageWithArrow();
        String secondPageResultCount = shopPage.getResultCountText();

        assertThat(secondPageResultCount).isNotEqualTo(firstPageResultCount);

        shopPage.navigateToPreviousPageWithArrow();

        assertThat(shopPage.getResultCountText()).isNotEqualTo(secondPageResultCount);
    }
    @Test
    @DisplayName("User can navigate product list page using numbers")
    public void shoopListNumberNavigationTest() {
        homeStorePage = new HomeStorePage(driver);
        shopPage = new ShopPage(driver);

        homeStorePage.clickShopButton();
        String firstPageResultCount = shopPage.getResultCountText();

        shopPage.navigateToTheNextPageWithNumber();
        String secondPageResultCount = shopPage.getResultCountText();

        assertThat(secondPageResultCount).isNotEqualTo(firstPageResultCount);

        shopPage.navigateToTheNextPageWithNumber();

        assertThat(shopPage.getResultCountText()).isNotEqualTo(secondPageResultCount);
}
    @ParameterizedTest
    @DisplayName("Meniu search bar test with multiple results")
    @CsvSource ({"bed, 3",
                "rocking chair, 2",
                "pill, 2",
                "'', 21"})
    public void searchBarMultipleResultsTest(String keyword, int itemsCount) {
        homeStorePage = new HomeStorePage(driver);
        shopPage = new ShopPage(driver);

        homeStorePage.clickShopButton();
        shopPage.enterSearchKeyword(keyword);
        assertThat(shopPage.getProductTitle()).contains(keyword);
        assertThat(shopPage.getResultCountText()).contains(itemsCount + " results");

        if(itemsCount<17){
            assertThat(shopPage.actualItemsCaunt()).isEqualTo(itemsCount);
        } else {
            assertThat(shopPage.actualItemsCaunt()).isEqualTo(16);
        }
    }
    @Test
    @DisplayName("Meniu search bar test with single result")
    public void searchBarSingleResultTest() {
        homeStorePage = new HomeStorePage(driver);
        shopPage = new ShopPage(driver);
        productPage = new ProductPage(driver);

        homeStorePage.clickShopButton();
        shopPage.enterSearchKeyword("lamp");

        assertThat(productPage.getProductTitle()).contains("lamp");
    }

    @Test
    @DisplayName("Meniu search bar test with no match")
    public void searchBarNoResultsTest() {
        homeStorePage = new HomeStorePage(driver);
        shopPage = new ShopPage(driver);
        productPage = new ProductPage(driver);

        homeStorePage.clickShopButton();
        shopPage.enterSearchKeyword("123abc");

        assertThat(shopPage.getNoProductFoundMessage()).isEqualTo("No products were found matching your selection.");
    }
}
