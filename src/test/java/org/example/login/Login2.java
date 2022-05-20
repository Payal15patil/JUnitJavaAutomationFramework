package org.example.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login2 {

        WebDriver driver;
        String url = "https://demo.nopcommerce.com/";
        String emailID = "12345@gmail.com";
        String password = "987654";

        @Before
        public void setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(url);
            driver.manage().window().maximize();
        }

        @Test
        public void loginCase2() {
            System.out.println("Test case for Unsuccessful login with wrong email and correct password");
            driver.findElement(By.xpath("//*[@class='ico-login']")).click();  //Click on login from header
            driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(emailID);  //Given Email address
            driver.findElement(By.xpath("//*[@name='Password']")).sendKeys(password);  //Given password
            driver.findElement(By.xpath("//*[@class='button-1 login-button']")).submit(); //Click on login button
            System.out.println(driver.findElement(By.xpath("//*[@class='message-error validation-summary-errors']")).getText());
        }

        @After
        public void tearDown() throws InterruptedException {
            Thread.sleep(3000);
            driver.close();
        }
    }

