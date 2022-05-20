package org.example.next;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateNext {
    WebDriver driver;
    String url = "https://www.next.co.uk/";
        @Before
        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
            driver.get(url);
            driver.manage().window().maximize();
        }
        @Test
        public void test1(){
            System.out.println("Searching products on Next");
            driver.findElement(By.id("header-big-screen-search-box")).sendKeys("Summer Dress"); //given input
            driver.findElement(By.xpath("//*[@class='component__Span-qpq5s7-0 bBFOjW']")).click();
        }
        @After
        public void tearDown() throws InterruptedException {
            Thread.sleep(3000);
            driver.close();
        }
}

