package org.stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Pages.P01_Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TC01_Login {
    P01_Login Login = new P01_Login();
//    public static WebDriver driver;
//
//    @Before
//    public static void openBrowser() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
//    }

    @Given("enter username and password")
    public void enter_username_and_password() {
        Login.userName().sendKeys("Admin");
        Login.password().sendKeys("admin123");
    }

    @When("click on login button")
    public void click_on_login_button() {
        Login.loginButton().click();

    }
//    @After
//    public static void quitBrowser() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.quit();
//
//    }
}
