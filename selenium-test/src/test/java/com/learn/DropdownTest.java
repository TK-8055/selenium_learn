package com.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropdownTest {

    @Test
    public void selectDropdown() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Open dropdown page
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        Thread.sleep(2000);

        // Switch to iframe (VERY IMPORTANT)
        driver.switchTo().frame("iframeResult");   // or driver.switchTo().frame(0);

        // Locate dropdown
        WebElement dropdown = driver.findElement(By.id("cars"));

        // Use Select class
        Select select = new Select(dropdown);

        // Select by visible text
        select.selectByVisibleText("Saab");
        System.out.println("Selected: Saab");
        Thread.sleep(1000);

        // Select by value attribute
        select.selectByValue("opel");
        System.out.println("Selected: Opel");
        Thread.sleep(1000);

        // Select by index
        select.selectByIndex(3); // Audi
        System.out.println("Selected: Audi");

        driver.quit();
    }
}
