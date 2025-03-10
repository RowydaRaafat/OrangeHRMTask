package org.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLInputElement;

import java.time.Duration;
import java.time.Instant;

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
//    fill all required data
    public WebElement userRoleDropDown(){
        WebElement role = driver.findElement((By.xpath("//label[text()='User Role']/following::div[contains(@class,'oxd-select-wrapper')]")));
        role.click();
        WebElement userRoleOption = driver.findElement(By.xpath("//div[@role='listbox']//div[text()='Admin']")); // تغيير 'Admin' حسب المطلوب
        return role;
    }

    public WebElement employeeName(){
        WebElement employee = driver.findElement(By.xpath("//label[text()='Employee Name']/following::input"));
        return employee;
    }
    public WebElement status(){
        WebElement status =driver.findElement(By.xpath("//label[text()='Status']/following::div[contains(@class,'oxd-select-wrapper')]"));
        status.click();
        WebElement statusOption = driver.findElement(By.xpath("//div[@role='listbox']//div[text()='Enabled']")); // تغيير 'Enabled' حسب المطلوب
        return statusOption;

    }
    public WebElement usernameEmployee(){
        return driver.findElement(By.xpath("//label[text()='Username']/following::input"));
    }

    public WebElement passwordEmployee(){
        return driver.findElement(By.xpath("//label[text()='Password']/following::input"));
    }
    public WebElement confirmPassword(){
        return driver.findElement(By.xpath("//label[text()='Confirm Password']/following::input"));
    }

    public WebElement saveButton(){
        return driver.findElement(By.xpath("//button[text()=' Save ']"));
    }
    public int beforeCount() {
        WebElement recordCountElement = driver.findElement(By.xpath("//div[contains(text(),'Records Found')]"));
        int beforeCount = extractRecordCount(recordCountElement.getText());
        return beforeCount;
    }

    public int extractRecordCount() {
        WebElement updatedRecordCountElement = driver.findElement(By.xpath("//div[contains(text(),'Records Found')]"));
        int afterCount = extractRecordCount(updatedRecordCountElement.getText());
        return afterCount;
    }
    private int extractRecordCount(String text) {
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

//    search by username
    public WebElement searchBox(){
        WebElement user_name = driver.findElement(By.cssSelector("input.oxd-input"));
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
        WebElement searchResult =driver.findElement( By.xpath("//div[text()='" + user_name + "']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult(user_name)));
        if (searchResult.isDisplayed()) {
            System.out.println("User found: " + user_name);
        } else {
            System.out.println("User not found: " + user_name);
        }
        return searchResult;
    }

    private By searchResult(WebElement userName) {
        return By.xpath("//div[text()='" + userName + "']");
    }
//    delete
    public WebElement deleteButton(){
        return driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[@role='row'][1]//button[contains(@class,'oxd-icon-button') and contains(@class,'oxd-table-cell-action-space')][1]"));
    }
 

    public int getRecordCount() {
        WebElement recordsCount= driver.findElement(By.xpath("//div[contains(text(), 'Records Found')]"));
        WebElement firstDeletionButton= driver.findElement(By.xpath("(//button[contains(@class, 'oxd-icon-button')])[1]"));
        WebElement confirmationDeletionButton= driver.findElement( By.xpath("//button[text()=' Yes, Delete ']"));
        WebElement recordElement = driver.findElement((By) recordsCount);
        String text = recordElement.getText();
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));

    }


}
