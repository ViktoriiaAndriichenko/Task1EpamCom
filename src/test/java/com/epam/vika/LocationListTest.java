package com.epam.vika;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class LocationListTest {
    WebDriver chromeDriver;
    WebDriver firefoxDriver;
    String url = "https://epam.com";
    By locationsLocator = By.xpath("/html/body/div[1]/div[2]/main/div[1]/div[16]/section/div[3]/div[2]/div/p/span/span");
    List<String> expectedLocations = Arrays.asList("AMERICAS", "EMEA", "APAC");

    @BeforeEach
    public void setup(){
        chromeDriver = new ChromeDriver();
        firefoxDriver = new FirefoxDriver();
    }

    @Test
    public void checkLocationsSwitchOnChrome() {
        chromeDriver.get(url);
        List<String> actualLocations = chromeDriver.findElements(locationsLocator).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertTrue(actualLocations.containsAll(expectedLocations));
    }

    @Test
    public void checkLocationsSwitchOnFirefox() {
        firefoxDriver.get(url);
        List<String> actualLocations = firefoxDriver.findElements(locationsLocator).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertTrue(actualLocations.containsAll(expectedLocations));
    }

    @AfterEach
    public void teardown(){
        if (chromeDriver != null){
            chromeDriver.quit();
        }
        if (firefoxDriver != null){
            firefoxDriver.quit();
        }
    }
}
