package com.epam.vika;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class CompanyLogoTest {
    WebDriver chromeDriver;
    WebDriver firefoxDriver;
    String url = "https://www.epam.com/about";
    By logoLocator = By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/header/div/div/a[1]/img[3]");

    @BeforeEach
    public void setup(){
        chromeDriver = new ChromeDriver();
        firefoxDriver = new FirefoxDriver();
    }

    @Test
    public void testLogoRedirectOnChrome() {
        chromeDriver.get(url);
        WebElement logo = chromeDriver.findElement(logoLocator);
        logo.click();
        assertEquals("https://www.epam.com/", chromeDriver.getCurrentUrl());
    }

    @Test
    public void testLogoRedirectOnFirefox() {
        firefoxDriver.get(url);
        WebElement logo = firefoxDriver.findElement(logoLocator);
        logo.click();
        assertEquals("https://www.epam.com/", firefoxDriver.getCurrentUrl());
    }

    @AfterEach
    public void tearDown() {
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
        if (firefoxDriver != null){
            firefoxDriver.quit();
        }
    }
}
