package Practise;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Irctc {
	
	
	
	@Test // (enabled=false)
	public void nestedScroll() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
//		driver.get("https://www.irctc.co.in/nget/train-search");
//		Thread.sleep(5000);
//		WebElement selectElement = driver.findElement(By.xpath("//input[@class='ng-tns-c65-12']"));
//		selectElement.click();
//		driver.findElement(By.xpath("//span[text()='PREMIUM TATKAL']")).click();
//		div[class='ui-dropdown-items-wrapper ng-tns-c65-12'])
//		Select s=new Select(selectElement);
//		s.selectByVisibleText("premium tatkal");
		
		
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		Thread.sleep(5000);
		WebElement s = driver.findElement(By.xpath("//td[text()='Full Name']"));
		
		 Assert.assertEquals(s.getText(), "Full Name");
//		Select sel=new Select(s);
//		Thread.sleep(5000);
//		sel.selectByVisibleText("26");
//		Thread.sleep(5000);
//		driver.close();
		try {
		//Actions a =new Actions(driver);
		WebElement submit =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("class-plus"))); 
		//a.click(submit);
		submit.click();
		}
		catch(Exception e)	{
			
			e.printStackTrace();
			
		}
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")).sendKeys("akshay");
				
				
		driver.close();
		
	}
	
	

	public void oprerators() {
		
		int x=8;
		x%=3;
		int y=9;
		int z=10;
		int w=2;
		
		
		if(!false) {
			
			System.out.println("both conditions are true");
		}
		
		
		//System.out.println(x);
	
	}
	
	@Test
	public void webtable() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		driver.get("https://omayo.blogspot.com/");
	
		
		 
		List<WebElement> tabledata = driver.findElements(By.xpath("//table[@id='table1']//td"));
		
//	for (WebElement Element : tabledata) {
//		object name="Praveen";
//		
//		if (Element.getText().equals(name)) {
//			
//			System.out.println(Element.getText());
//			
//			
//		}
//		
//		
//	}
		
		
		
	
		
		driver.close();
	}
	
	
	
	
	
	@Test
	public void twodarray()	{
		
		
		
		int a [][]= {{2,4,6},{8,9,10}};
		
		System.out.println("row ="+a.length);
		System.out.println("coloum ="+a[0].length);
		
		

		
		
		
		for	(int i=0;i<a.length;i++) {
			
			
			for(int j=0;j<a[0].length;j++) {
				
				
				System.out.print(a[i][j]+" ");
				
				
				
				
				
				
				
				
				
				
			}
			
			System.out.println();
			
			
			
		}
		
		
		
		
		
		
	}
	
	
	
	

}
