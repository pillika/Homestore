package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".entry-title")
    WebElement pageTitle;
    @FindBy(css = ".checkout-button")
    WebElement checkoutButton;
    public void clickCheckoutButton() {
        checkoutButton.click();
    }
    public boolean  pageTitleIsDisplayed() {
        return pageTitle.isDisplayed();
    }
}
