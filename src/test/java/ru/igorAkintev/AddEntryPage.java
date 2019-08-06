package ru.igorAkintev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddEntryPage extends Settings {

    private static WebElement element = null;
    public ChromeDriver driver;

    public AddEntryPage(ChromeDriver driver) {
        this.driver = driver;
    }


    public WebElement titleInput() {
        element = this.driver.findElement(By.id("id_title"));
        return element;
    }

    public WebElement slugInput() {
        element = this.driver.findElement(By.id("id_slug"));
        return element;
    }

    public WebElement textMarkdownInput() {
        element = this.driver.findElement(By.id("id_text_markdown"));
        return element;
    }

    public WebElement textInput() {
        element = this.driver.findElement(By.id("id_text"));
        return element;
    }

    public WebElement formSubmitSave() {
        element = this.driver.findElement(By.name("_save"));
        return element;
    }
}
