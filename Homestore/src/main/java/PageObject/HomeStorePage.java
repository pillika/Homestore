package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomeStorePage extends BasePage {
    public HomeStorePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "li[id='menu-item-228'] a")
    WebElement myAccountLink;
@FindBy(css = "#menu-item-225")
WebElement shopButton;
public void clickShopButton() {
    shopButton.click();
}
    public void clickMyAccountLink() {myAccountLink.click();
    }
}
