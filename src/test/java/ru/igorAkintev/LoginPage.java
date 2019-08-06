package ru.igorAkintev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends Settings {

    private static WebElement element = null;
    public ChromeDriver driver;

    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
    }


    public WebElement loginInput() {
        element = this.driver.findElement(By.id("id_username"));
        return element;
    }

    public WebElement passwordInput() {
        element = this.driver.findElement(By.id("id_password"));
        return element;
    }

    public WebElement formSubmit() {
        element = this.driver.findElement(By.id("login-form"));
        return element;
    }
}
