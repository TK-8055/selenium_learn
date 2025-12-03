package com.learn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LogTest {

    private static final Logger logger = LogManager.getLogger(LogTest.class);

    @Test
    public void testLogin() throws InterruptedException {

        logger.info("Starting Browser...");
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        logger.info("Browser maximized");

        driver.get("https://opensource-demo.orangehrmlive.com/");
        logger.info("Opened OrangeHRM website");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        logger.info("Entered username");

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        logger.info("Entered password");

        driver.findElement(By.xpath("//button")).click();
        logger.info("Clicked login button");

        Thread.sleep(3000);

        logger.info("Login test completed successfully!");

        driver.quit();
        logger.info("Browser closed");
    }
}
