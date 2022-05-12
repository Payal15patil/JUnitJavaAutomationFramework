package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login3 {
    WebDriver driver;
    String url = "https://demo.nopcommerce.com/";
    String emailID = "";
    String password = "";

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void loginCase2() {
        System.out.println("Test case of both fields empty");
        driver.findElement(By.xpath("//*[@class='ico-login']")).click();  //Click on login from header
        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(emailID);  //Given Email address
        driver.findElement(By.xpath("//*[@name='Password']")).sendKeys(password);  //Given password
        driver.findElement(By.xpath("//*[@class='button-1 login-button']")).submit(); //Click on login button
        System.out.println(driver.findElement(By.xpath("//*[@id='Email-error']")).getText());
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(8000);
        driver.close();
    }
}
