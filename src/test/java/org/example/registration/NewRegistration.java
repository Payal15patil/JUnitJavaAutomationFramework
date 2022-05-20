package org.example.registration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewRegistration {
    WebDriver driver;
    String url = "https://demo.nopcommerce.com/";
    String firstName = "Payal";
    String lastName = "Patil";
    String emailID = "patil123@gmail.com";
    String companyName = "Resourcewise.co.uk";
    String password = "987654";
    String confirmPassword = password;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    @Test
    public void testCase1(){
        System.out.println("Test case for Successful Registration");
        driver.findElement(By.className("ico-register")).click();  //Select Register from header
        driver.findElement(By.xpath("//*[@for='gender-female']")).click();   //Select Gender
        driver.findElement(By.id("FirstName")).sendKeys(firstName);         // Given First Name
        driver.findElement(By.id("LastName")).sendKeys(lastName);// Given Last Name
        Select select1 = new Select(driver.findElement(By.name("DateOfBirthDay")));
        select1.selectByIndex(15);
//        Select select2 = new Select(driver.findElement(By.name("DateOfBirthMonth")));
//        select2.selectByValue("July");
        Select select3 = new Select(driver.findElement(By.name("DateOfBirthYear")));
        select3.selectByVisibleText("1994");
        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(emailID);  // Given Email Address
        driver.findElement(By.id("Company")).sendKeys(companyName);   // Given Company name
        driver.findElement(By.id("Newsletter")).click();
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
        Thread.sleep(3000);
        driver.close();
    }
}
