package com.learn;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CookiesAlertsTest {

    @Test
    public void testCookiesAndAlerts() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/alerts.html");

        // ---------------------
        // HANDLE COOKIES
        // ---------------------
        try {
            WebElement acceptCookies = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Accept')]"))
            );
            acceptCookies.click();
            System.out.println("Cookies Accepted!");
        } catch (Exception e) {
            System.out.println("No cookies popup, continuing...");
        }

        // ---------------------
        // ALERT 1: Simple Alert
        // ---------------------
        driver.findElement(By.id("alert")).click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println("Alert 1 says: " + alert1.getText());
        alert1.accept();

        // ---------------------
        // ALERT 2: Confirm Alert
        // ---------------------
        driver.findElement(By.id("confirm")).click();
        Alert confirm = driver.switchTo().alert();
        System.out.println("Confirm says: " + confirm.getText());
        confirm.dismiss(); // cancel

        // ---------------------
        // ALERT 3: Prompt Alert
        // ---------------------
        driver.findElement(By.id("prompt")).click();
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("TK");
        prompt.accept();

        driver.quit();
    }
}
