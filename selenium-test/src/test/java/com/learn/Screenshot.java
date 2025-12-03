package com.learn;

import com.learn.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Screenshot {

    @Test
    public void openGoogle() {

        // Always use FirefoxDriver (geckodriver)
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());

        // Take screenshot
        ScreenshotUtil.takeScreenshot(driver, "google_homepage");

        driver.quit();
    }
}
