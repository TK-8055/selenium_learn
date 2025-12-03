package com.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ScrollTest {

    @Test
    public void scrollExample() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // SCROLL DOWN by 1500px
        js.executeScript("window.scrollBy(0,4500);");
        System.out.println("Scrolled down");

        Thread.sleep(2000);

        // Find an element visible without login
        WebElement signInMsg = driver.findElement(By.xpath("//h2[text()='See personalized recommendations']"));
        System.out.println("Found: " + signInMsg.getText());

        // SCROLL BACK TO TOP
        js.executeScript("window.scrollTo(0,0);");
        System.out.println("Scrolled back to top");

        Thread.sleep(1500);

        driver.quit();
    }
}
