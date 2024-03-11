package com.epam.vika;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class ReportDownloadTest {
    WebDriver chromeDriver;
    WebDriver firefoxDriver;
    String url = "https://www.epam.com/about";
    String downloadFolderPath = "C:\\Users\\Viktoriia_Andriichen\\OneDrive - EPAM\\Downloads";
    By downloadButtonLocator = By.xpath("");

    @BeforeEach
    public void setUp() {

         Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", downloadFolderPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.dir", downloadFolderPath);
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(firefoxProfile);

        chromeDriver = new ChromeDriver(chromeOptions);
        firefoxDriver = new FirefoxDriver(firefoxOptions);
    }

    @Test
    public void testDownloadOnChrome() {
        checkDownload(chromeDriver);
    }

    @Test
    public void testDownloadOnFirefox() {
        checkDownload(firefoxDriver);
    }

    private void checkDownload(WebDriver driver) {
        driver.get(url);
        driver.findElement(downloadButtonLocator).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        File file = new File(downloadFolderPath + "EPAM Corporate Overview 2023.pdf");
        assertTrue(file.exists());
    }

    @AfterEach
    public void tearDown() {
        if (chromeDriver != null){
            chromeDriver.quit();
        }
        if (firefoxDriver != null){
            firefoxDriver.quit();
        }
    }
}
