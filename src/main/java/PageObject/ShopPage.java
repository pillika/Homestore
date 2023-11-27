package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends BasePage{
    public ShopPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".next")
    WebElement arrowNext;
    @FindBy (xpath = "//a[@class='page-numbers']")
    WebElement numberNext;
    @FindBy (css =".woocommerce-result-count")
    WebElement resultCount;
    @FindBy (xpath = "//input[@type='search']")
    WebElement searchField;
    @FindBy(xpath = "//ul[@class='products columns-4']//h2")
    WebElement product;
    @FindBy(xpath = "//*[@id=\"main\"]//p")
    WebElement noProductFoundMessage;
    @FindBy(xpath = "//a[@class='prev page-numbers']")
    WebElement arrowPrevious;
    @FindBy(xpath = "//a[text()='Add to cart']")
    WebElement addToChart;
    @FindBy(xpath = "//ul[@class='products columns-4']//li/a[3]")
    WebElement viewCart;
    @FindBy(xpath = "//a[@class='cart-contents']//span")
    WebElement priceInCart;
    @FindBy(xpath = "//span[@class='count']")
    WebElement itemInCartCount;
    @FindBy (xpath = "//span[@class='price']/ins")
    WebElement productPrice;
    public String getItemcount() {
        return itemInCartCount.getText();
    }
    public String getProductPrice(){
        return productPrice.getText();
    }

    public String getCartPrice() {
    return priceInCart.getText();
    }

    public void clickAddtoCart() {
        addToChart.click();
    }

    public void navigateToPreviousPageWithArrow() {

        arrowPrevious.click();
    }
    public String getNoProductFoundMessage() {
        return noProductFoundMessage.getText();
    }

      public String getProductsTitle() {
        return product.getText();
    }

    public void enterSearchKeyword(String keyword) {
        searchField.sendKeys(keyword + Keys.ENTER);
    }
    public void navigateToTheNextPageWithNumber() {
        numberNext.click();
    }
    public String getResultCountText() {
        return resultCount.getText();
    }
    public void navigateToNextPageWithArrow() {
        arrowNext.click();
    }
    public int actualItemsCaunt() {
       return driver.findElements(By.xpath("//ul[@class='products columns-4']//h2")).size();
    }

    public void clickProduct() {
        product.click();
    }

    public boolean viewCartIsDisplayed() {
        return viewCart.isDisplayed();
    }

    public WebElement getElement() {return viewCart;
    }
}
