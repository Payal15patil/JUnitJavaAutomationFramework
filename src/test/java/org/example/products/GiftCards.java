package org.example.products;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GiftCards {
    WebDriver driver;
    String url = "https://demo.nopcommerce.com/gift-cards";
    String recipientName = "Jay Patil";
    String recipientEmail = "J106@yahoo.com";
    String senderName = "Payal Patil";
    String senderEmail = "15794payal@yahoo.com";
    String cardQuantity = "3";

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    @Test
    public void testGiftCards(){
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[1]/a/img")).click();
        driver.findElement(By.className("recipient-name")).sendKeys(recipientName);
        driver.findElement(By.className("recipient-email")).sendKeys(recipientEmail);
        driver.findElement(By.className("sender-name")).sendKeys(senderName);
        driver.findElement(By.className("sender-email")).sendKeys(senderEmail);
        driver.findElement(By.id("product_enteredQuantity_43")).clear();
        driver.findElement(By.id("product_enteredQuantity_43")).sendKeys(cardQuantity);
        driver.findElement(By.id("add-to-cart-button-43")).click();
        driver.findElement(By.className("bar-notification success")).getText();
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
