package BookingPackage;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class crossBrowsing {
	
	WebDriver driver;
	
	@Test
	@Parameters("browser")
	
	public void variousBrowserTesting(String b) {
		
		String browser="b";
	if(browser.equalsIgnoreCase("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\HealthiansProj\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("edge")) {
		
		System.setProperty("webdriver.IE.driver", "C:\\Users\\Admin\\eclipse-workspace\\HealthiansProj\\Drivers\\msedgedriver.exe");
		driver=new EdgeDriver();
		
	}else if(browser.equalsIgnoreCase("firefox")) {
		
		
		
		driver =new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.get("https://healthians.com");
	driver.close();
		
		
		
	}

}
