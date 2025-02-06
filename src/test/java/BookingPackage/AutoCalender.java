package BookingPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AutoCalender {
	
	WebDriver driver;
	
	@Test
	public void calenderAuto() throws InterruptedException {
		
		try {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\HealthiansProj\\Drivers\\chromedriver.exe");
		  driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.redbus.in/");
		
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println(Seclist.isEmpty());

        if(!Seclist.isEmpty()) {
    		
    		
    		Seclist.get(0).click();
    	       Thread.sleep(2000);
    		
    	}
        
        
//        for (WebElement ele2 : Seclist) {
//        	
//        	
//        	ele2.click();
//        	break;
//		}
        
        WebElement datefield = wait.until(ExpectedConditions.elementToBeClickable(By.id("onwardCal")));
        datefield.click();
//         WebElement datefield = driver.findElement(By.id("onwardCal"));
//         datefield.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
	
    List<WebElement> datelist = driver.findElements(By.xpath("//div/div[@class='DayTilesWrapper__RowWrap-sc-19pz9i8-1 fGGTDM']/span/div"));
	
    //body > section:nth-child(1) > div:nth-child(3) > main:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3)
	////body/section[@id='rh_main']/div[@id='mBWrapper']/main[@class='rh_content']/div[@id='homeV2-root']/div[@class='topSection']/div[@id='autoSuggestContainer']/div[@class='sc-hSdWYo cMISeA']/div[@class='sc-jWBwVP hyJWPH']/div[@id='onwardCal']/div[@class='labelCalendarContainer']/div[@class='sc-jzJRlG hrJoeL']/div[@class='DatePicker__CalendarContainer-sc-1kf43k8-0 jQCNYF']/div[@class='DatePicker__MainBlock-sc-1kf43k8-1 hHKFiR']/div[3]/div/span/div
	////body/section[@id='rh_main']/div[@id='mBWrapper']/descendant::/div[3]/div/span/div

        try {
		/*
		 while (true) {
             // Find all enabled date elements
             List<WebElement> enabledDates = driver.findElements(By.xpath("//body/section[@id='rh_main']/div[@id='mBWrapper']/descendant::/div[3]/div/span/div")); // Change the selector

             // Check if there are any enabled dates
             if (enabledDates.isEmpty()) {
                 break; // Exit the loop if no enabled dates
             }

             // Click on the first enabled date
             enabledDates.get(0).click();

             // Click on the date field again to refresh the date picker
             datefield.click();
         }
         
         */
		
	
	for (WebElement ele3 : datelist) {
		
		
		if(ele3.isEnabled()) {
			System.out.println(ele3.getText()); 
			ele3.click();
			
			  Thread.sleep(1000);
			  
			 
			
			continue;
			
		}
		 datefield.click();
			
		  Thread.sleep(2000);
		  
		
		}
	
        }catch(Exception e) {
		
	System.out.println(e);
	}
	}
		
	
	
	
	finally {
	
        driver.quit(); 
		
	}
	}

}
