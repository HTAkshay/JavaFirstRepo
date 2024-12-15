package SyncronizeTwoScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumSecondScript {
	
	 @Test(dependsOnMethods = {"SyncronizeTwoScript.SeleniumFirstScript.setup"})

	    public void testSecondScript() {
	        
	        String dynamicDataFromFirstScript=SeleniumFirstScript.dynamicData;

	        System.out.println("Using dynamic data from First Script: " + dynamicDataFromFirstScript);

	        WebDriver driver = new ChromeDriver();
	        driver.get("https://omayo.blogspot.com/");

	        WebElement cartTotalElement = driver.findElement(By.xpath("//a[text()='Page One']"));
	        
	        String cartTotal = cartTotalElement.getText();

	        Assert.assertEquals(cartTotal, dynamicDataFromFirstScript, "The cart total should match the price from the product page.");

	        driver.quit();
	    }
	
	
	
	
	
	
	
	

}
