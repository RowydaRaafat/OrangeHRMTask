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
}
