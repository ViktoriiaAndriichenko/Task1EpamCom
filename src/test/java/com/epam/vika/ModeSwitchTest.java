package com.epam.vika;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
public class ModeSwitchTest {
    WebDriver chromeDriver;
    WebDriver firefoxDriver;
    String url = "https://epam.com";
    By themeSwitchLocator = By.xpath("/html/body/div/div[2]/div[2]/div[1]/header/div/div/section/div/div");

    @BeforeEach
    public void setUp(){
        chromeDriver = new ChromeDriver();
        firefoxDriver = new FirefoxDriver();
    }

    @Test
    public void checkThemeSwitchOnChrome() throws InterruptedException {
        chromeDriver.get(url);
        Thread.sleep(5000);
        WebElement switchButton = chromeDriver.findElement(themeSwitchLocator);
        String oldTheme = chromeDriver.findElement(By.tagName("body")).getAttribute("class");
        switchButton.click();
        String newTheme = chromeDriver.findElement(By.tagName("body")).getAttribute("class");
        assertNotEquals(oldTheme, newTheme);
    }

    @Test
    public void checkThemeSwitchOnFirefox() throws InterruptedException {
        firefoxDriver.get(url);
        Thread.sleep(3000);
        WebElement switchButton = firefoxDriver.findElement(themeSwitchLocator);
        String oldTheme = firefoxDriver.findElement(By.tagName("body")).getAttribute("class");
        switchButton.click();
        String newTheme = firefoxDriver.findElement(By.tagName("body")).getAttribute("class");
        assertNotEquals(oldTheme, newTheme);
    }

    @AfterEach
    public void tearDown(){
        if (chromeDriver != null){
            chromeDriver.quit();
        }
        if (firefoxDriver != null){
            firefoxDriver.quit();
        }
    }
}
