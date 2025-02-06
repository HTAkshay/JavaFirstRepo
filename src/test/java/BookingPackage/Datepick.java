package BookingPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Datepick {
	
	@Test
	public void calenderAuto() throws InterruptedException {
		
	
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\HealthiansProj\\Drivers\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://demo.automationtesting.in/Datepicker.html");
		 driver.findElement(By.id("datepicker2")).click();
		WebElement month = driver.findElement(By.xpath("//select[@class='datepick-month-year'][1]"));
		//WebElement year = driver.findElement(By.xpath("//select[@class='datepick-month-year'][2]"));
		Thread.sleep(2000);
		Select s=new Select(month);
		s.selectByVisibleText("January");
		Thread.sleep(2000);
		//Select p=new Select(year);
	
		//p.selectByVisibleText("2015");
		String b="15";
		List<WebElement> dates = driver.findElements(By.xpath("(//table/tbody)[2]//td"));
		for (WebElement Ele : dates) {
			//System.out.println(	Ele.getText());
		
			String a=Ele.getText();
			System.out.println(a);
			if(a.equals(b)) {
				Ele.click();
				Thread.sleep(5000);
				break;	
			}
			
		}
		
		driver.close();
		

		
		 
		 
		 
	}
	

}
