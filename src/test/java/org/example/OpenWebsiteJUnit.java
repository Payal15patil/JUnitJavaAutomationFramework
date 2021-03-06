package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenWebsiteJUnit {
    WebDriver driver;
    String url = "https://demo.nopcommerce.com/register";
    //WebElement regiBtn = driver.findElement(By.className("ico-register"));
    WebElement firstName = driver.findElement(By.id("FirstName"));

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @Test
    public void openWebsite(){
        driver.get(url);
        driver.manage().window().maximize();
        //driver.findElement(By.className("ico-register")).click();
        //regiBtn.click();
        firstName.sendKeys("payal");
        System.out.println("Code executed");

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.close();
    }
}
