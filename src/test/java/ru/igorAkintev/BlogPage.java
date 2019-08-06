package ru.igorAkintev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BlogPage extends Settings {

    private static WebElement element = null;
    public ChromeDriver driver;

    public BlogPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public WebElement formSubmitDelete() {
        element = this.driver.findElement(By.name("post"));
        return element;
    }
}
