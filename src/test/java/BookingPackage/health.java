package BookingPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class health {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		 WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
		WebDriverWait	 wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			driver.get("https://devcrm002.echl.co.in");
			WebElement username_txtbox = driver.findElement(By.xpath("//input[@name='username']"));
			username_txtbox.sendKeys("akshay.mankar@healthians.com");
			WebElement password_txtbox = driver.findElement(By.xpath("//input[@name='password']"));
			password_txtbox.sendKeys("password");
//			WebElement login_btn = driver.findElement(By.xpath("//button[@id='login_submit']"));
//			login_btn.click();
			password_txtbox.sendKeys(Keys.ENTER);
			//Thread.sleep(5000);
			//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='sidebar-menu-action']/ul/li")));
		List<WebElement> firstList = driver.findElements(By.xpath("//div[@id='sidebar-menu-action']/ul/li"));
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
//		for (WebElement e : firstList) {
//			 js.executeScript("arguments[0].scrollIntoView(true);", e); 
//			 System.out.println(e.getText());
//		
//
//			
//			
//		}
		
		for (WebElement e : firstList) {
			 js.executeScript("arguments[0].scrollIntoView(true);", e); 
		 if(e.getText().equals("DMS")) {
			
			 
			 e.click();
			 System.out.println("click on DMS action");
		
			 Thread.sleep(2000);
			 break;
		 }
		}
		
		
	
			
driver.close();
	}

}
