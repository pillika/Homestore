package PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    Actions actions =new Actions(driver);
    @FindBy(xpath = "//*[@id=\"main\"]//h1")
    WebElement productTitle;
    @FindBy(css = "#tab-description")
    WebElement productDescription;
    @FindBy(xpath = "//a[@rel='tag']")
    WebElement productCategory;
    @FindBy(xpath = "//p[@class='price']")
    WebElement productPrice;
    @FindBy(xpath = "//button[@name='add-to-cart']")
    WebElement addToCart;
    @FindBy(xpath = "//div[@class='woocommerce-message']/a")
    WebElement viewCart;
    @FindBy(xpath = "//div[@class='woocommerce-message']")
    WebElement message;
    @FindBy(xpath = "//div[@class='quantity']/input")
    WebElement amount;
public String getProductsPrice(){
    return productPrice.getText();
}
    public String getMessage() {

        String[] fullMessage = message.getText().split("\n");
        return fullMessage[1];
    }
    public boolean viewCartIsDisplayed() {
        return viewCart.isDisplayed();
    }
    public void clickAddToCart() {
        addToCart.click();
    }
    public boolean productPriceIsDisplayed() {
        return productPrice.isDisplayed();
    }
    public boolean productCategoryIsDisplayed() {
        return productCategory.isDisplayed();
    }
    public boolean productDescriptionIsDisplayed() {
        return productDescription.isDisplayed();
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public void enterAmount(String quantity) {
        amount.sendKeys(quantity);
    }

    public void clearAmount() {
        amount.clear();
    }

    public void clickAmount() {
        amount.click();
    }

    public void clickArrowUP() {
        amount.sendKeys(Keys.ARROW_UP);
    }

    public void clickEnter() {
        amount.sendKeys(Keys.ENTER);
    }

    public void clickArrowDOWN() {
        amount.sendKeys(Keys.ARROW_DOWN);
    }

    public void clickBackSpace() {
        amount.sendKeys(Keys.BACK_SPACE);
    }

    public void moveLeft() {
        amount.sendKeys(Keys.ARROW_LEFT);
    }

    public void clickDelete() {
        amount.sendKeys(Keys.DELETE);
    }

    public void enterAdditionalNumber(String quantity) {
        amount.sendKeys(quantity);
    }


}
