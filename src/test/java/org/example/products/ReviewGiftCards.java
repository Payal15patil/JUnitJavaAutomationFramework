package org.example.products;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReviewGiftCards {
    WebDriver driver;
    String url = "https://demo.nopcommerce.com/";
    String firstName = "Yogi";
    String lastName = "Patil";
    String emailID = "2289yogipatil@yahoo.com";
    String password = "010101";
    String confirmPassword = password;
    String reviewTitle = "Gift Card";
    String reviewText = "This is advantageous for people to gift like this";
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    @Test
    public void reviews(){
//        driver.findElement(By.className("ico-register")).click();
//        driver.findElement(By.id("FirstName")).sendKeys(firstName);         // Given First Name
//        driver.findElement(By.id("LastName")).sendKeys(lastName);           // Given Last Name
//        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(emailID);  // Given Email Address
//        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password); // Given password
//        driver.findElement(By.xpath("//*[@id='ConfirmPassword']")).sendKeys(confirmPassword);
//        driver.findElement(By.xpath("//*[@id='register-button']")).submit();   //Click on Register Button
//        driver.findElement(By.className("button-1 register-continue-button")).submit();
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[7]/a")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[1]/a/img")).click();
        driver.findElement(By.linkText("Add your review")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[1]/h1/a")).getText();
        driver.findElement(By.className("review-title valid")).sendKeys(reviewTitle);
        driver.findElement(By.id("AddProductReview_ReviewText")).sendKeys(reviewText);
        driver.findElement(By.id("addproductrating_5")).click();  // Choosing rate as Excellent
        driver.findElement(By.name("add-review")).submit();

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
