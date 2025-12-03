package com.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void selectRadioButtons() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Open W3Schools radio button example
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_input_radio");
        Thread.sleep(2000);

        // Switch to iframe (VERY IMPORTANT)
        driver.switchTo().frame("iframeResult");   // OR driver.switchTo().frame(0);

        // Select radio = HTML
        driver.findElement(By.xpath("//input[@value='HTML']")).click();
        System.out.println("Selected HTML");

        Thread.sleep(1000);

        // Select radio = CSS
        driver.findElement(By.xpath("//input[@value='CSS']")).click();
        System.out.println("Selected CSS");

        Thread.sleep(1000);

        // Select radio = JavaScript
        driver.findElement(By.xpath("//input[@value='JavaScript']")).click();
        System.out.println("Selected JavaScript");

        driver.quit();
    }
}
