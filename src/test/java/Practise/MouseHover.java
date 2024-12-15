package Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {
	
	@Test
 public void mouseActions() {
	 
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");
	WebElement sbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	Actions a=new Actions(driver);
//	a.moveToElement(sbox).click().sendKeys("mobile phones").doubleClick(sbox).perform();
//	a.contextClick(sbox).perform();
	
	
	a.moveToElement(sbox).click().keyDown(Keys.SHIFT).sendKeys("mobile phones").perform(); //press and hold
	a.keyDown(Keys.BACK_SPACE).perform();  //use sendkeys instead keydown ,press and release
	
 }
 

}
