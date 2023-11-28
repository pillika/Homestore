package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    @FindBy(xpath = "//a[@aria-label='Add “Cocktail mixer” to your cart']")
    WebElement seconAddToCart;
    @FindBy(xpath = "(//a[@title='View cart'][normalize-space()='View cart'])[2]")
    WebElement secondViewCart;
    @FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[9]")
    WebElement secondProductPrice;
    @FindBy(xpath = "//ul[@id='site-header-cart']/li")
    WebElement cartBox;
    @FindBy(xpath = "(//p[@class='woocommerce-mini-cart__total total'])[1]/span") ////strong[contains(text(),'Subtotal:')])[1]/span
    WebElement subtotal;
    @FindBy (xpath = "(//p[@class='woocommerce-mini-cart__buttons buttons'])[1]/a[2]")
    WebElement checkout;
    @FindBy (xpath = "(//p[@class='woocommerce-mini-cart__buttons buttons'])[1]/a")
    WebElement viewCartHover;
    @FindBy(xpath ="(//span[@class='quantity'])[1]")
    WebElement firstItemData;
    @FindBy(xpath="(//span[@class='quantity'])[2]")
    WebElement secondItemsData;
    @FindBy(xpath = "(//li[@class='woocommerce-mini-cart-item mini_cart_item'])[1]/a[2]")
    WebElement firstItemName;
    @FindBy(xpath = "(//li[@class='woocommerce-mini-cart-item mini_cart_item'])[2]/a[2]")
    WebElement secondItemName;
    @FindBy(xpath = "(//ul[@class='products columns-4']//h2)[4]")
    WebElement secondProduct;
    @FindBy(xpath = "//ul[@id='site-header-cart']")
    WebElement cartInformationBLock;
    public void clickCartInformationBlock() {
        cartInformationBLock.click();
    }
    public String getSecondProductTitle() {
        return secondProduct.getText();
    }

    public String getFirstItemTitleInCart() {
        return firstItemName.getText();
    }
    public String getSecondItemTitleInCart() {
        return secondItemName.getText();
    }
    public String getSubtotal(){
        return subtotal.getText();
    }
    public String getSecondItemQuantityAndPrice() {
        return secondItemsData.getText();
    }
    public String getFirstItemQuantityAndPrice() {
        return firstItemData.getText();
    }

    public boolean subtotalIsDisplayed() {
        return subtotal.isDisplayed();
    }
    public boolean checkoutIsDisplayed() {
    return checkout.isDisplayed();
    }
    public boolean viewCartIsDisplayedWhenHovered() {
        return viewCartHover.isDisplayed();
    }
    public void hover(){
        Actions actions= new Actions(driver);
        actions.moveToElement(cartBox).perform();
    }
    public String getSecondProductPrice() {
        return secondProductPrice.getText();
    }
    public boolean bothViewCartIsDisplayed() {
        if (secondViewCart.isDisplayed() & viewCart.isDisplayed()) {
            return true;
        } else {return false;}
    }

    public void clickSecondAddToCart() {
        seconAddToCart.click();
    }
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

      public String getProductTitle() {
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

    public void clickViewCart() {
        viewCart.click();
    }
}