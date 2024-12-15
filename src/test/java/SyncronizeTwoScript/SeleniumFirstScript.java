package SyncronizeTwoScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumFirstScript {

	 WebDriver driver;
    public static String dynamicData = "";

    @BeforeClass
    @Test
    public void setup() {
   
    	 driver = new ChromeDriver();
         driver.get("https://omayo.blogspot.com/");
        WebElement priceElement = driver.findElement(By.xpath("//a[text()='Page One']"));
        dynamicData = priceElement.getText(); 

        System.out.println("Dynamic data captured by First Script: " + dynamicData);
        driver.quit();
    }

    @Test
    public void testFirstScript() {
       
        System.out.println("Running First Script: Dynamic data fetched from the webpage.");
    }
	
	
	
	
	
	
	
	
	
	

}
