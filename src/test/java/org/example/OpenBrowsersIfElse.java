package org.example;

import com.sun.deploy.cache.BaseLocalApplicationProperties;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class OpenBrowsersIfElse {
    WebDriver driver;
    String browser = "Chrome";
    @Test
    public void openBrowser(){
        if(browser.equalsIgnoreCase("IE")){
            System.out.println("Internet Explorer is opening now");
        }
        else if(browser.equalsIgnoreCase("Apple Safari")){
            System.out.println("Apple Safari is opening now");
        }
        else if(browser.equalsIgnoreCase("Opera")){
            System.out.println("Opera is opening now");
        }
        else if(browser.equalsIgnoreCase("Firefox")){
            System.out.println("Firefox is opening now");
        }
        else {
            System.out.println("Chrome is opening now");
        }
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
