package org.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Pages.P01_Login;


public class TC01_Login {
    P01_Login Login = new P01_Login();


    @Given("enter username and password")
    public void enter_username_and_password() {
        Login.userName().sendKeys("Admin");
        Login.password().sendKeys("admin123");
    }

    @When("click on login button")
    public void click_on_login_button() {
        Login.loginButton().click();

    }

    @Given("press on Admin tab")
    public void press_on_admin_tab() {
        Login.adminButton().click();
    }
    @Then("get number of records")
    public void get_number_of_records() {
        System.out.println(Login.recordFound().getText());
    }

    @Then("Click on add button")
    public void click_on_add_button() {
        Login.addButton().click();
    }

}
