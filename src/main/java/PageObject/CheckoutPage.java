package PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".entry-title")
    WebElement pageTitle;
    @FindBy(xpath = "//tbody/tr/td[@class='product-name']")
    WebElement cartItemTitle;
    @FindBy(css = "td.product-total")
    WebElement itemsSubtotal;
    @FindBy(css= ".cart-subtotal td")
    WebElement cartSubtotal;
    @FindBy(css= ".order-total")
    WebElement cartTotal;
    @FindBy(xpath = "//div[@id='payment']//li")
    WebElement message;
    @FindBy(css = "#place_order")
    WebElement placeOrder;
    @FindBy(css="#billing_first_name")
    WebElement firstName;
    @FindBy(css="#billing_last_name")
    WebElement lastName;
    @FindBy(css = "#billing_company")
    WebElement companyName;
    @FindBy(css = "#select2-billing_country-container")
    WebElement countryRegion;
    @FindBy(css = "#billing_country")
    WebElement countryDropBox;
    @FindBy(xpath = "//input[@role='combobox']")
    WebElement countryRegionInput;
    @FindBy(css = "#billing_address_1")
    WebElement streetAddress;
    @FindBy (css = "#billing_address_2")
    WebElement streetAddressSecondRow;
    @FindBy (css = "#billing_city")
    WebElement cityName;
    @FindBy (css = "#billing_state")
    WebElement countyName;
    @FindBy (css = "#billing_postcode")
    WebElement postcodeInput;
    @FindBy(css = "#billing_phone")
    WebElement phone;
    @FindBy(css = "#billing_email")
    WebElement emailInput;
    @FindBy(css ="ul[role='alert']")
    WebElement alertMessage;
    @FindBy(css= "#select2-billing_country-container")
    WebElement countryDisplayed;

    public String countryName() {
        return countryDisplayed.getText();
    }
    public void selectCountry (String country){
        countryRegion.click();
        Select dropdown = new Select(countryDropBox);
        dropdown.selectByValue(country);
    }

    public String getAlertMessage () {
        return  alertMessage.getText();
    }

    public boolean placeOrderIsDisplayed() {
        return placeOrder.isDisplayed();
    }
    public String getMessage() {
        return message.getText();
    }
    public boolean cartTotalisDisplayed() {
        return cartTotal.isDisplayed();
    }
    public boolean cartsSubtotalisDisplayed() {
        return cartSubtotal.isDisplayed();
    }
    public String getItemsSubtotal() {
        return itemsSubtotal.getText();
    }
    public boolean checkoutPageTitleIsDisplayed() {
        return pageTitle.isDisplayed();
    }

    public boolean productTitleIsDisplayed() {
        return cartItemTitle.isDisplayed();
    }
    public String productTitle() {
        return cartItemTitle.getText();
    }

    public void enterName(String name) {
        firstName.sendKeys(name);
    }

    public void enterLastname(String lastname) {
        lastName.sendKeys(lastname);
    }

    public void enterCompany(String company) {
        companyName.sendKeys(company);
    }

    public void clickCountryDropDown() {
        countryRegion.click();
    }

    public void enterCountry(String country) {
        countryRegionInput.sendKeys(country + Keys.ENTER);
    }

    public void enterStreet(String street) {
        streetAddress.sendKeys(street);
    }

    public void enterHouse(String house) {
        streetAddressSecondRow.sendKeys(house);
    }

    public void enterCity(String city) {
        cityName.sendKeys(city);
    }

    public void enterCounty(String county) {
        countyName.sendKeys(county);
    }

    public void enterPhone(String phonenumber) {
        phone.sendKeys(phonenumber);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPostcode(String postcode) {
        postcodeInput.sendKeys(postcode);
    }
    public void clickPlaceOrder() {
        placeOrder.click();
    }
    public WebElement getElement() {
        return alertMessage;
    }
}
