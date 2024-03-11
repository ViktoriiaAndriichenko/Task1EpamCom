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
public class PoliciesListTest {
    WebDriver chromeDriver;
    WebDriver firefoxDriver;
    String url = "https://epam.com";
    By policyLinksLocator = By.linkText("https://www.epam.com/cookie-policy");
    List<String> expectedPolicies = Arrays.asList("INVESTORS", "COOKIE POLICY", "OPEN SOURCE", "APPLICANT PRIVACY NOTICE", "PRIVACY POLICY", "WEB ACCESSIBILITY");

    @BeforeEach
    public void setUp(){
        chromeDriver = new ChromeDriver();
        firefoxDriver = new FirefoxDriver();
    }

    @Test
    public void checkPoliciesListOnChrome() {
        chromeDriver.get(url);
        List<WebElement> policyLinks = chromeDriver.findElements(policyLinksLocator);
        List<String> actualPolicies = policyLinks.stream().map(WebElement::getText).collect(Collectors.toList());
        assertEquals(true, actualPolicies.containsAll(expectedPolicies));
    }

    @Test
    public void checkPoliciesListOnFirefox() {
        firefoxDriver.get(url);
        List<WebElement> policyLinks = firefoxDriver.findElements(policyLinksLocator);
        List<String> actualPolicies = policyLinks.stream().map(WebElement::getText).collect(Collectors.toList());
        assertTrue(actualPolicies.containsAll(expectedPolicies));
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
