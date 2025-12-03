package com.learn;

import com.learn.utils.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Excel {

    @Test
    public void fillFormUsingExcel() throws InterruptedException {

        // Always use Firefox
        WebDriver driver = new FirefoxDriver();

        String file = "src/test/resources/Book1.xlsx";

        // Read Excel data
        String name = ExcelUtil.readCell(file, "Sheet1", 0, 0);
        String password = ExcelUtil.readCell(file, "Sheet1", 0, 1);

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
      //  driver.manage().window().maximize();


      Thread.sleep(3000);
        // Fill the form
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

        // Write back result to Excel
        ExcelUtil.writeCell(file, "Sheet1", 0, 2, "Form Filled");


//     String name = ExcelUtil.readCell(file, "Sheet1", 0, 0);
//    // String email = ExcelUtil.readCell(file, "Sheet1", 0, 1);

//     System.out.println("DEBUG -> Name from Excel = " + name);
//    // System.out.println("DEBUG -> Email from Excel = " + email);


        driver.quit();
    }
}
