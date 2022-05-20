package org.example.products;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Computers {
    WebDriver driver;
    String url = "https://demo.nopcommerce.com/";
    String passValue = "2";
    String emailID = "yogi123@gmail.com";
    String password = "123123";
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    @Test
    public void testCategory(){
        driver.findElement(By.xpath("//*[@class='ico-login']")).click();  //Click on login from header
        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(emailID);  //Given Email address
        driver.findElement(By.xpath("//*[@name='Password']")).sendKeys(password);  //Given password
        driver.findElement(By.xpath("//*[@class='button-1 login-button']")).submit(); //Click on login button
        System.out.println("I am testing computers category");
        driver.findElement(By.linkText("Computers")).click();
        driver.findElement(By.xpath("//*[@alt='Picture for category Notebooks']")).click();
        //driver.findElement(By.linkText("Sort by")).click();
        Select selectPosition = new Select(driver.findElement(By.id("products-orderby")));
        selectPosition.selectByVisibleText("Price: Low to High");
        Select selectDisplay = new Select(driver.findElement(By.id("products-pagesize")));
        selectDisplay.selectByIndex(0);
        driver.findElement(By.xpath("//div/a/img[@alt='Picture of HP Spectre XT Pro UltraBook']")).click();
//        driver.findElement(By.className("qty-input valid")).clear();
//        driver.findElement(By.className("qty-input valid")).sendKeys(passValue);
//        driver.findElement(By.id("add-to-cart-button-12")).click();
//        driver.findElement(By.id("add-to-wishlist-button-12")).click();

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
