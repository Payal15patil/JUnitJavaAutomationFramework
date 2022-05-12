package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.PublicKey;

public class Registration {
    WebDriver driver;
    String url = "https://demo.nopcommerce.com/";
    String firstName = "Payal";
    String lastName = "Patil";
    String emailID = "patil123@gmail.com";
    String password = "987654";
    String confirmPassword = password;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.className("ico-register")).click();  //Select Register from header
    }
    @Test
    public void testCase1(){
        System.out.println("Test case for Successful Registration");
        driver.findElement(By.xpath("//*[@for='gender-female']")).click();   //Select Gender
        driver.findElement(By.id("FirstName")).sendKeys(firstName);         // Given First Name
        driver.findElement(By.id("LastName")).sendKeys(lastName);           // Given Last Name
        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(emailID);  // Given Email Address
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password); // Given password
        driver.findElement(By.xpath("//*[@id='ConfirmPassword']")).sendKeys(confirmPassword);
        driver.findElement(By.xpath("//*[@id='register-button']")).submit();   //Click on Register Button
        driver.findElement(By.xpath("//*[@class='result']")).getText();
        System.out.println("Your Registration completed");
        driver.findElement(By.xpath("//*[@class='button-1 register-continue-button']")).click(); //Click on Continue button
        driver.findElement(By.xpath("//*[@class='ico-logout']")).click();  //Click on Logout

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(8000);
        driver.close();
    }
}
