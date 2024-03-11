package com.epam.vika;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class SearchFunctionTest {
    WebDriver chromeDriver;
    WebDriver firefoxDriver;
    String url = "https://epam.com";
    By searchLocator = By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/header/div/div/ul/li[3]/div/button/span[1]");

    @BeforeEach
    public void setup(){
        chromeDriver = new ChromeDriver();
        firefoxDriver = new FirefoxDriver();
    }

    @Test
    public void testSearchOnChrome() {
        chromeDriver.get(url);
        WebElement searchInput = chromeDriver.findElement(searchLocator);
        searchInput.sendKeys("AI", Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("query=AI"));
        assertTrue(chromeDriver.getPageSource().toLowerCase().contains("ai"), "AI not found in search results");
    }

    @Test
    public void testSearchOnFirefox() {
        firefoxDriver.get(url);
        WebElement searchInput = firefoxDriver.findElement(searchLocator);
        searchInput.sendKeys("AI", Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(firefoxDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("query=AI"));
        assertTrue(firefoxDriver.getPageSource().toLowerCase().contains("ai"), "AI not found in search results");
    }

    @AfterEach
    public void teardown() {
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
        if (firefoxDriver != null){
            firefoxDriver.quit();
        }
    }
}
