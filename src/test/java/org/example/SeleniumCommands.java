package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCommands {
    WebDriver driver;
    String url = "https://demo.nopcommerce.com/";
    String firstName = "payal";
    WebElement regibtn = driver.findElement(By.className("ico-register"));
    WebElement enterFirstName = driver.findElement(By.id("FirstName"));

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void openWebsite(){
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        regibtn.click();
        enterFirstName.sendKeys(firstName);
        System.out.println("Code executed");
    }
    public void goToRegistration(){
        openWebsite();

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.close();
    }
}
