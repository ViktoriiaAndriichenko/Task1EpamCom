package com.epam.vika;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangeLanguageTest {
    WebDriver chromeDriver;
    WebDriver firefoxDriver;
    String url = "https://epam.com";
    By languageSwitchButtonLocator = By.xpath("/html/body/div/div[2]/div[2]/div[1]/header/div/div/ul/li[2]/div/div/button/span");
    By uaOptionLocator = By.linkText("https://careers.epam.ua/");//*[contains(text(), 'Україна (Українська)')]");

    @BeforeEach
    public void setUp(){
        chromeDriver = new ChromeDriver();
        firefoxDriver = new FirefoxDriver();
    }

   /* @Test
   public void checkLanguageSwitchOnChrome() {
        chromeDriver.get(url);
        WebDriverWait wait = new WebDriverWait(chromeDriver, 10);
        WebElement switchButton = wait.until(ExpectedConditions.elementToBeClickable(languageSwitchButtonLocator));
        switchButton.click();
        WebElement uaOption = wait.until(ExpectedConditions.elementToBeClickable(uaOptionLocator));
        uaOption.click();
        String pageSource = chromeDriver.getPageSource();
        assertTrue(pageSource.contains("Україна"));
    }
*/
    @Test
    public void checkLanguageSwitchOnFirefox() throws InterruptedException {
        firefoxDriver.get(url);
        Thread.sleep(9000);
        WebElement switchButton = firefoxDriver.findElement(languageSwitchButtonLocator);
        switchButton.click();
      //  String dropDownList = firefoxDriver.findElement(By.tagName("body")).getAttribute("class");
        WebElement uaOption = firefoxDriver.findElement(uaOptionLocator);
        uaOption.click();
        assertEquals("https://careers.epam.ua/", firefoxDriver.getCurrentUrl());
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

