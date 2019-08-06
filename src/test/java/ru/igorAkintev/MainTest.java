package ru.igorAkintev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

public class MainTest extends Settings {

    private String title = "Title" + randString();


    //start testing
    @Test
    public void mainTest() {
        driver.get("http://igorakintev.ru/admin");
        this.testLoginPage();
        this.testAdminPage();
        this.testAddEntryPage();
        this.testBlogPage();
    }

    //login testing
    private void testLoginPage() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginInput().click();
        loginPage.loginInput().sendKeys("selenium");

        loginPage.passwordInput().click();
        loginPage.passwordInput().sendKeys("super_password");

        loginPage.formSubmit().submit();
    }

    //admin page testing
    private void testAdminPage() {
        AdminPage adminPage = new AdminPage(driver);
        String titlePage = driver.getTitle();
        Assert.assertTrue(titlePage.equals("Администрирование сайта | Панель управления"));
        adminPage.addEntriesButton().click();
    }

    //add entry testing
    private void testAddEntryPage() {
        AddEntryPage addEntryPage = new AddEntryPage(driver);

        String titlePage = driver.getTitle();
        Assert.assertTrue(titlePage.equals("Добавить entry | Панель управления"));

        addEntryPage.titleInput().click();
        addEntryPage.titleInput().sendKeys(title);

        addEntryPage.slugInput().click();
        addEntryPage.slugInput().clear();
        addEntryPage.slugInput().sendKeys("Slug" + randString());

        addEntryPage.textMarkdownInput().click();
        addEntryPage.textMarkdownInput().sendKeys("TextMarkdown" + randString());

        //данные подставляются из TextMarkdown на этапе отправки запроса, следовательно, какое-то другое значение не подставить
        addEntryPage.textInput().click();
        addEntryPage.textInput().sendKeys("Text" + randString());

        addEntryPage.formSubmitSave().submit();
    }

    private void testBlogPage() {
        BlogPage blogPage = new BlogPage(driver);
        driver.get("http://igorakintev.ru/blog");

        String findTitle = driver.findElement(By.linkText(title)).getText();
        if (findTitle.contains(title)) {
            driver.get("http://igorakintev.ru/admin/blog/entry/");
            driver.findElement(By.linkText(title)).click();
            driver.findElement(By.linkText("Удалить")).click();
            blogPage.formSubmitDelete().submit();
        }


    }

    private String randString() {
        String symbols = "0123456789qazwsxedcrfvtgbyhnujmikolp";

        Random rand = new Random();
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            buf.append(symbols.charAt(rand.nextInt(symbols.length())));
        }

        return buf.toString();
    }
}
