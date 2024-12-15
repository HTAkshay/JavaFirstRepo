import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class partner_form {
	
	@Test
	public void form() throws InterruptedException{
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	driver.get("https://devcrm029.echl.co.in/");
	driver.findElement(By.name("username")).sendKeys("akshay.mankar@healthians.com");
	driver.findElement(By.name("password")).sendKeys("1@password");
	driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='searchSidebarAction']")).sendKeys("lead form v2");
	driver.findElement(By.xpath("//span[text()='Booking ']")).click();
	driver.findElement(By.xpath("//ul[@class='treeview-menu']/li/a/p[text()='Lead Form V2']")).click();
	driver.findElement(By.xpath("//input[@id='b2b']")).click();
	driver.findElement(By.xpath("//span[@id='select2-channel_type-container']")).click();
	
	driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='textbox']")).sendKeys("docter");
	Thread.sleep(1000);
	
	
	}

}
