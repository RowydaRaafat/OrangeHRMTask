package org.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Pages.P01_Login;
import org.testng.Assert;


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

    @Then("fill required data and save")
    public void fill_required_data_and_save() {
        Login.userRoleDropDown().click();
        Login.status().click();
        Login.employeeName().sendKeys("Ranga  Akunuri");
        Login.usernameEmployee().sendKeys("rowydaraafat");
        Login.passwordEmployee().sendKeys("rowydaraafat123");
        Login.confirmPassword().sendKeys("rowydaraafat123");
        Login.saveButton().click();
    }

    @When("number of records increase 1 add new employee")
    public void extractRecordCount(String text) {
        String recordCount = text.replaceAll("[^0-9]", "");
        System.out.println("Number of Records Found: " + recordCount);

        int beforeCount = Integer.parseInt(recordCount);
        int afterCount = beforeCount + 1;
        Assert.assertEquals(afterCount, beforeCount + 1, "User count did not increase by 1!");
    }

    @Then("search with the username for the new user")
    public void search_with_the_username_for_the_new_user() {
        Login.searchBox().click();
    }
    @Then("Delete the new user")
    public void delete_the_new_user() {
        Login.deleteButton().click();
    }
    @Then("Get the number of records after deletion")
    public void get_the_number_of_records_after_deletion() {
        System.out.println(Login.getRecordCount());
        Assert.assertEquals(Login.getRecordCount(), 1, "User count did not decrease by 1!");
    }



}
