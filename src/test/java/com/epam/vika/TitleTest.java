package com.epam.vika;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TitleTest {
    WebDriver chromeDriver;
    WebDriver firefoxDriver;
    String url = "https://epam.com";
    String expectedTitle = "EPAM | Software Engineering & Product Development Services";

    @BeforeEach
    public void setUpBrowser(){
        chromeDriver = new ChromeDriver();
        firefoxDriver = new FirefoxDriver();
    }

    @Test
    public void checkTitleOnChrome() throws InterruptedException {
        chromeDriver.get(url);
        Thread.sleep(3000);
        String actualTitle = chromeDriver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void checkTitleOnFirefox() throws InterruptedException {
        firefoxDriver.get(url);
        Thread.sleep(3000);
        String actualTitle = firefoxDriver.getTitle();
        assertEquals(expectedTitle, actualTitle);
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