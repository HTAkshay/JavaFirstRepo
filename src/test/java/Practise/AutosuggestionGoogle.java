package Practise;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestionGoogle {
	
	
	
public void autosuggestGoogle() throws InterruptedException {
	
	
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\HealthiansProj\\Drivers\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.com/");
	String googleTitle=driver.getTitle();
	System.out.println(googleTitle);
	System.out.println("************************************************");
	if(googleTitle.equalsIgnoreCase("Google")) {
		
		
		WebElement textArea = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		textArea.sendKeys("selenium");
		Thread.sleep(5000);
		List<WebElement> listFirst = driver.findElements(By.xpath("//div[@class='OBMEnb']/ul/li"));
	for (WebElement li : listFirst) {
		
		String printList=li.getText();
		System.out.println(printList);
	}
	
	for (WebElement li2 : listFirst) {
		
		if(li2.getText().equals("selenium webdriver")) {
		
			
			li2.click();
			Thread.sleep(5000);
			String newTitle = driver.getTitle();
			System.out.println(newTitle);
			
				
				if(newTitle.equalsIgnoreCase("selenium webdriver - Google Search")) {
					
			break;
			
			}
		}
	}
	
//	driver.navigate().back();
//	driver.navigate().forward();
	try {
	WebElement newTextArea = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
	
	String newText = newTextArea.getText();

	
	System.out.println(newText); 
	
	System.out.println(newText.isEmpty());
	
	
	if(!newText.isEmpty()) {
		
		
		System.out.println("this is new text in text area "+newText);
	}
	else {
		System.out.println("text area is empty");
	}
	}catch(Exception e) {
		
		System.out.println(e);
	}
	
//	else {
//		
//		System.out.println("text area is empty");
//	}
	
	
	

	

	driver.close();	
		
		
	}else {
		
		throw new RuntimeException("Google url is not open");
		
	}
	
	
	
	
	
}
	

}
