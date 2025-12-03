package com.learn;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.learn.utils.ReportManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonHoverTest {

    ExtentReports report;
    ExtentTest test;
    WebDriver driver;

    @BeforeTest
    public void setup() {
        report = ReportManager.getReport();
        test = report.createTest("Amazon Hover Test");

        driver = new FirefoxDriver();
        test.info("Firefox launched");
    }

    @Test
    public void hoverOnAmazon() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        test.info("Amazon site opened");

        Actions action = new Actions(driver);

        WebElement accountLists = driver.findElement(By.id("nav-link-accountList"));
        action.moveToElement(accountLists).perform();
        test.pass("Hovered on Account & Lists");

        Thread.sleep(1500);

        WebElement yourOrders = driver.findElement(By.xpath("//span[text()='Your Orders']"));
        yourOrders.click();
        test.pass("Clicked on Your Orders");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        test.info("Browser closed");
        report.flush(); // Important! Generates the report
    }
}
