package ru.igorAkintev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminPage extends Settings {
    private static WebElement element = null;
    public ChromeDriver driver;

    public AdminPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public WebElement addEntriesButton() {
        element = this.driver.findElement(By.xpath("//a[@href='/admin/blog/entry/add/']"));
        return element;
    }
}
