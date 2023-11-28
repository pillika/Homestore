import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver. manage().window().maximize();
        driver.get("https://themes.woocommerce.com/homestore/");
    }
    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }

}
