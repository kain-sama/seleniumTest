package ru.igorAkintev;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Settings {

    public ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "../seleniumTest/resources/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void closer() {
        driver.quit();
    }
}
