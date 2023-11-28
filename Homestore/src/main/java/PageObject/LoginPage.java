package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomeStorePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
@FindBy(css = "#username")
    WebElement usernameInput;
    @FindBy(css = "#password")
    WebElement passwordInput;
    @FindBy(css = "#rememberme")
    WebElement rememberMeCheckBox;
    @FindBy(css = "button[value='Log in']")
    WebElement loginButton;
    @FindBy(css = "ul[role='alert']")
    WebElement errorMessage;
    @FindBy(xpath ="//a[normalize-space()='Lost your password?']")
    WebElement lostPasswordLink;
    public void clickLostPassword() {
        lostPasswordLink.click();
    }

public void enterUsernameOrEmail(String username) {
    usernameInput.sendKeys(username);
}

public void enterPassword(String password) {
    passwordInput.sendKeys(password);
}
public void checkRememberMe() {
    rememberMeCheckBox.click();
}
public void clickLogin() {
    loginButton.click();
}
public String actualErrorMessageText() {
   return errorMessage.getText();
}
}
