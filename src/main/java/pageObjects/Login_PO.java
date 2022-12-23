package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO {

    private @FindBy(id = "user-name")
    WebElement usernameInputField;
    private @FindBy(id = "password")
    WebElement passwordInputField;
    private @FindBy(id = "login-button")
    WebElement loginButton;

    public Login_PO() {
        super();
    }

    public void navigateToLoginPage() {
        navigateToURL("https://www.saucedemo.com");
    }

    public void setUsername(String username) {
        sendKeys(usernameInputField, username);
    }

    public void setPassword(String password) {
        sendKeys(passwordInputField, password);
    }

    public void pressLoginButton() {
        clickOnButton(loginButton);
    }

    public void validateSucessfulLogin() {
        getTheMainTextOnProductsPage("PRODUCTS");
    }

    public void validateUnsucessfulLogin() {
        getTheErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }

    public void validateIfUserIsLocked() {
        userLocked("Epic sadface: Sorry, this user has been locked out.");
    }

    public void requiredFieldUsername() {
        requiredInputFieldUsername("Epic sadface: Username is required");
    }

    public void requiredFieldPassword() {
        requiredInputFieldPassword("Epic sadface: Password is required");
    }


}
