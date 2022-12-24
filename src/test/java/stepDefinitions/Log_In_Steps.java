package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.Base_PO;
import pageObjects.Login_PO;

public class Log_In_Steps extends Base_PO {

    private Login_PO login_po;

    public Log_In_Steps(Login_PO login_po) {
        this.login_po = login_po;
    }

    @Given("I access website login page")
    public void i_access_website_login_page() {
        login_po.navigateToLoginPage();
    }

    @And("I enter a specific correct username {word}")
    public void i_enter_a_username_standard_user(String correctUsername) {
        login_po.setUsername(correctUsername);
    }

    @And("I enter a specific correct password {word}")
    public void i_enter_a_password_secret_sauce(String correctPassword) {
        // secret_sauce
        login_po.setPassword(correctPassword);
    }

    @And("I click on login button")
    public void i_click_on_login_button() {
        login_po.pressLoginButton();
    }

    @Then("I should be presented with user products page")
    public void i_should_be_presented_with_user_products_page() {
        login_po.validateSucessfulLogin();
    }


    @When("I enter a wrong username {word}")
    public void i_enter_a_wrong_username(String incorrectUsername) {
        login_po.setUsername(incorrectUsername);
    }

    @When("I enter a wrong password {word}")
    public void i_enter_a_wrong_password(String incorrectPassword) {
        login_po.setPassword(incorrectPassword);
    }

    @Then("I should be presented with unsuccessful login message")
    public void i_should_be_presented_with_unsuccessful_login_message() {
        login_po.validateUnsucessfulLogin();
    }

    @When("I enter a blank username")
    public void i_enter_a_blank_username() {
        login_po.setUsername("");
    }
    @When("I enter a blank password")
    public void i_enter_a_blank_password() {
        login_po.setPassword("");
    }
    @Then("I should be presented with message that input fields are required")
    public void i_should_be_presented_with_message_that_input_fields_are_required() {
        login_po.requiredFieldUsername();
    }

    //Scenario unsuccessful login with an empty username input field
    @And("I enter a password {word}")
    public void i_enter_a_password(String password) {
        login_po.setPassword(password);
    }
    @Then("I should be presented with message that input field username is required")
    public void i_should_be_presented_with_message_that_input_field_username_is_required() {
        login_po.requiredFieldUsername();
    }

    //Scenario unsuccessful login with an empty password input field
    @And("I enter a username {word}")
    public void i_enter_a_username(String username) {
        login_po.setUsername(username);
    }
    @Then("I should be presented with message that input field password is required")
    public void i_should_be_presented_with_message_that_input_field_password_is_required() {
        login_po.requiredFieldPassword();
    }

    //Scenario outline
    @When("I enter a correct username {word}")
    public void i_enter_a_correct_username(String username) {
        login_po.setUsername(username);
    }
    @When("I enter a correct password {word}")
    public void i_enter_a_correct_password(String password) {
        login_po.setPassword(password);
    }

    @Then("I should be presented with message that account has been locked out")
    public void i_should_be_presented_with_message_that_account_has_been_locked_out() {
        login_po.validateIfUserIsLocked();
    }
}
