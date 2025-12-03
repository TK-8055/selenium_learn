package com.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandlingTest {

    @Test
    public void handleWindows() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");

        Thread.sleep(4000); // let page load fully

        // MAIN WINDOW
        String mainWindow = driver.getWindowHandle();

        // CLICK SIGNUP (opens new tab/window)
        WebElement signup = driver.findElement(By.xpath("//div[text()='Signup']"));
        signup.click();

        Thread.sleep(3000);

        // GET ALL WINDOWS
        Set<String> allWindows = driver.getWindowHandles();

        String childWindow = null;

        // FIND CHILD WINDOW
        for (String win : allWindows) {
            if (!win.equals(mainWindow)) {
                childWindow = win;
                break;
            }
        }

        // SWITCH TO CHILD WINDOW
        driver.switchTo().window(childWindow);
        Thread.sleep(2000);

        // ENTER PHONE NUMBER
        WebElement phoneBox = driver.findElement(By.xpath("//input[@type='tel']"));
        phoneBox.sendKeys("1234567890");
        Thread.sleep(1000);

        // SWITCH BACK TO MAIN WINDOW
        driver.switchTo().window(mainWindow);
        Thread.sleep(2000);

        // CHECK "Welcome aboard"
        WebElement welcomeText = driver.findElement(By.xpath("//div[text()='Welcome aboard']"));
        if (welcomeText.isDisplayed()) {
            System.out.println("PASS: 'Welcome aboard' is visible on main window");
        } else {
            System.out.println("FAIL: Text not found");
        }

        driver.quit();
    }
}
