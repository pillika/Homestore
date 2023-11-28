package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LostPasswordPage extends BasePage{
    public LostPasswordPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#user_login")
    WebElement usernameInput;
    @FindBy(css = "button[value='Reset password']")
    WebElement resetPasswordButton;
    @FindBy(css ="ul[role='alert']")
    WebElement errorMessage;
    public void enterUsernameOrEmail(String username) {
        usernameInput.sendKeys(username);
    }
    public void clickResetPassword() {
        resetPasswordButton.click();
    }
    public String actualErrorMessageText() {
        return errorMessage.getText();
    }
}
