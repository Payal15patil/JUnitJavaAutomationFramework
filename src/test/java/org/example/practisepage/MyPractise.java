package org.example.practisepage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MyPractise {
    WebDriver driver;
    String url = "https://courses.letskodeit.com/practice";
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    @Test
    public void selectClass(){
        Select select1 = new Select(driver.findElement(By.id("carselect")));
        select1.selectByIndex(1);
        select1.selectByVisibleText("Benz");
        select1.deselectByVisibleText("Benz");
    }
    @Test
    public void multipleSelect(){
        Select select2 = new Select(driver.findElement(By.id("multiple-select-example")));
        select2.selectByIndex(1);
        select2.selectByVisibleText("Peach");
        select2.deselectAll();
    }
    @Test
    public void radioButton(){
        driver.findElement(By.id("benzradio")).click();
        driver.findElement(By.id("bmwradio")).click();
        driver.findElement(By.id("hondaradio")).click();
    }
    @Test
    public void checkBox(){
        driver.findElement(By.id("bmwcheck")).click();
        driver.findElement(By.name("cars")).click();   // by using name it is not selecting exact value
        driver.findElement(By.id("hondacheck")).click();
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
