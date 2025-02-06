package BookingPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Calender {
	
	
	@Test
	public void calenderAuto() throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\HealthiansProj\\Drivers\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.redbus.in/");
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		 
		 
		 /*
		 driver.findElement(By.xpath("(//span[@class='lbl_input appendBottom10'])[3]")).click();
		List<WebElement> datelist = driver.findElements(By.xpath("//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Body']/div[@class='DayPicker-Week']/div"));
		
		 
		 for (WebElement ele : datelist) {
			
			 if(ele.isEnabled()) {
				 
				 ele.click();
				 Thread.sleep(2000);
				 continue;
				 
			 }
		}
	
	
	
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	   List<WebElement> datelist;
        
        while (true) {
            // Find the date field and click it to load the calendar
            WebElement dateField = driver.findElement(By.xpath("(//span[@class='lbl_input appendBottom10'])[3]"));
            dateField.click();
            Thread.sleep(2000); 
            // Re-fetch the list of dates
            datelist = driver.findElements(By.xpath("//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Body']/div[@class='DayPicker-Week']/div"));
            boolean foundEnabledDate = false;
            
            for (WebElement ele : datelist) {
                if (ele.isEnabled()) {
                	
                	js.executeScript("arguments[0].click();", ele);
                  //  ele.click();
                    Thread.sleep(2000); // Wait for any animations or loading
                    foundEnabledDate = true;
                    break; // Exit the loop after clicking an enabled date
                }
            }
            
            // If no enabled date was found in this iteration, break the loop
            if (!foundEnabledDate) {
                break;
            }
        }
        
        driver.quit(); // Close the browser
        	 */
		  Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='src']")).sendKeys("mumbai");
        Thread.sleep(2000);
        List<WebElement> fistlist = driver.findElements(By.xpath("//ul[@class='sc-dnqmqq dZhbJF']/li"));
        
        for (WebElement ele1 : fistlist) {
        	ele1.click();
        	break;
        	
			
		}
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("pune");
        Thread.sleep(2000);
        List<WebElement> Seclist = driver.findElements(By.xpath("//ul[@class='sc-dnqmqq dZhbJF']/li"));
        
        for (WebElement ele2 : Seclist) {
        	ele2.click();
        	break;
		}
        
        
         WebElement datefield = driver.findElement(By.id("onwardCal"));
         datefield.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
	List<WebElement> datelist = driver.findElements(By.xpath("//div/div[@class='DayTilesWrapper__RowWrap-sc-19pz9i8-1 fGGTDM']/span/div"));
	try {
	for (WebElement ele3 : datelist) {
		
		
		if(ele3.isEnabled()) {
			System.out.println(ele3.getText()); 
			ele3.click();
			
			  Thread.sleep(1000);
			  
			  datefield.click();
		
			  Thread.sleep(1000);
			  
			
			continue;
			
		}		
		
	}
	}catch(Exception e) {
		
//		/
//		for(int i=0;i<datelist.size();i++) {
//			
//			if(int(i)) {
//				ele3.click();
//				continue;
//				
//				
//				
//			}
//			
//			
//			
//		}
		
		
		
		
//	}
	
	System.out.println(e);
	}
	finally {
	
	
	
	
	
        driver.quit(); 
		//ul[@class='sc-dnqmqq dZhbJF']/li
		//ul[@class='sc-dnqmqq dZhbJF']/li
		//div/div[@class='DayTilesWrapper__RowWrap-sc-19pz9i8-1 fGGTDM']/span/div
	
	}
	}
}
