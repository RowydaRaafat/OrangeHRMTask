package org.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.stepDefinition.Hooks;
import static org.stepDefinition.Hooks.driver;


public class P01_Login {

    public WebElement userName() {
        return driver.findElement(By.name("username"));
    }

    public WebElement password() {
        return driver.findElement(By.name("password"));
    }

    public WebElement loginButton() {
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }
//    press on Admin tab
    public WebElement adminButton(){
        return driver.findElement(By.cssSelector("a[href='/web/index.php/admin/viewAdminModule']"));
    }

//    get the number of records found
    public WebElement recordFound(){
        WebElement recordsElement = driver.findElement(By.xpath("//div[contains(@class, 'orangehrm-horizontal-padding')]/span"));
        String recordsText = recordsElement.getText();  // "(75) Records Found"
        String recordsNumber = recordsText.replaceAll("[^0-9]", "");
        System.out.println("Number of Records Found: " + recordsNumber);

        return recordsElement;
    }
//    click on add button and fill the data
    public WebElement addButton(){
        return driver.findElement(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary"));

    }
}
