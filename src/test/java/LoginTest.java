import PageObject.HomeStorePage;
import PageObject.LoginPage;
import PageObject.LostPasswordPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class LoginTest extends BaseTest{
HomeStorePage homeStorePage;
LoginPage loginPage;
LostPasswordPage lostPasswordPage;

@ParameterizedTest
@DisplayName("Login test using invalid credentials")
@CsvSource ({
        "Jonas123654, 789_qwert, 'Error: The username jonas123654 is not registered on this site. If you are unsure of your username, try your email address instead.'",
        "jonas@jonaitis.lt, 789_qwert, 'Unknown email address. Check again or try your username.'",
        "Jonas123654, ' ', 'Error: The password field is empty.'",
        "' ', 789_qwert, 'Error: Username is required.'",
        "' ', ' ', 'Error: Username is required.'"})

public void invalidCredentialsLoginTest(String username, String password, String expectedErrorMessage){
    homeStorePage = new HomeStorePage(driver);
    loginPage = new LoginPage(driver);

    homeStorePage.clickMyAccountLink();

    loginPage.enterUsernameOrEmail(username);
    loginPage.enterPassword(password);
    loginPage.checkRememberMe();
    loginPage.clickLogin();

    assertThat(loginPage.actualErrorMessageText()).isEqualTo(expectedErrorMessage);
}
@ParameterizedTest
@DisplayName("Lost password test with invalid credentials")
@CsvSource({"Jonas123654, 'Invalid username or email.'",
        "jonas@jonaitis.lt, 'Invalid username or email.',",
                "' ', 'Enter a username or email address.'"

})
    public void lostPasswordTest(String username, String expectedErrorMessage) {
    homeStorePage = new HomeStorePage(driver);
    loginPage = new LoginPage(driver);
    lostPasswordPage = new LostPasswordPage(driver);


    homeStorePage.clickMyAccountLink();
    loginPage.clickLostPassword();

    lostPasswordPage.enterUsernameOrEmail(username);
    lostPasswordPage.clickResetPassword();

    assertThat(lostPasswordPage.actualErrorMessageText()).isEqualTo(expectedErrorMessage);
}
}
