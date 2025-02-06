package v2_Form;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.ReadData;
import io.github.bonigarcia.wdm.WebDriverManager;

public class B2B_Form {
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public static void main (String args[]) throws IOException, InterruptedException {
	try {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		 wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(ReadData.getConfigData("Url"));
		WebElement username_txtbox = driver.findElement(By.xpath("//input[@name='username']"));
		username_txtbox.sendKeys(ReadData.getConfigData("username"));
		WebElement password_txtbox = driver.findElement(By.xpath("//input[@name='password']"));
		password_txtbox.sendKeys(ReadData.getConfigData("password"));
//		WebElement login_btn = driver.findElement(By.xpath("//button[@id='login_submit']"));
//		login_btn.click();
		password_txtbox.sendKeys(Keys.ENTER);
		System.out.println(driver.getCurrentUrl());
		

		WebElement partner_managemen_element = driver.findElement(By.xpath("//span[text()='Partner Management ']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", partner_managemen_element);
		partner_managemen_element.click();
		driver.findElement(By.xpath("//p[text()='B2B Custom Gross Margin']")).click();
		WebElement plus_sign_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-plus-circle']")));
		plus_sign_button.click();
		WebElement hiddendrop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='select2-selection__arrow'])[7]")));
		hiddendrop.click();
		WebElement new_type_dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@role='textbox']")));
		new_type_dropdown.sendKeys("API TEST");
		Actions a=new Actions(driver);
		a.keyDown(Keys.CONTROL);
		a.sendKeys(Keys.ENTER);
		a.keyUp(Keys.CONTROL).build().perform();
		
	
		
//		
//	WebElement select_option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='select2-partner_id-container']")));
//	select_option.sendKeys("API TEST");
	WebElement radio_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='type1']")));
	radio_button.click();
		
		WebElement citydrop = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='city_id']")));
		
		Select select=new Select(citydrop);
		select.selectByVisibleText("puri");
		driver.findElement(By.xpath("//input[@id='type0']")).click();
		WebElement dropdown_category = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='category_id']")));
		Select s =new Select(dropdown_category);
		Thread.sleep(2000);
		
	
		s.selectByVisibleText(ReadData.getConfigData("data"));
		driver.findElement(By.xpath("//input[@id='gross_margin']")).sendKeys("10");
		WebElement submit_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='save_btn'])[1]")));
		submit_button.click();
		Thread.sleep(5000);
		
		//driver.findElement(By.xpath("(//input[@id='save_btn'])[1]")).click();
	    }finally {
		 WebElement asm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Akshay Mankar']")));
		asm.click();
		//	driver.findElement(By.xpath("//span[text()='Akshay Mankar']")).click();
		 
		 driver.findElement(By.xpath("//a[@class='btn btn-default']")).click();
	
		driver.close();
		
		
		
	}
		
		
		
	}

}
