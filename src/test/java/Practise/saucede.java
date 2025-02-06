package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class saucede {
	
	
	@Test
	public void scrollUsingActionClass() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.get("https://www.saucedemo.com/v1/");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	
				WebElement linkedIn = driver.findElement(By.xpath("/html/body/footer/ul/li[3]"));
		WebElement foootertext = driver.findElement(By.xpath("//div[@class='footer_copy']"));
		
		Actions a=new Actions(driver);
		a.scrollToElement(foootertext).build().perform();
		driver.quit();
		
		
		
		
		
		
	}
	@Test
	public void print() {
		
		
		
		System.out.println("a");
	}
	
	


}
