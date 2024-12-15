package Practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookKilo {
	
	
	@Test
	public void scrollTillElement() {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.booksbykilo.in/new-books");
			
	//	WebElement book = driver.findElement(By.xpath("//h3[text()='Sleep, Baby, Sleep and Other Well-loved Lullabies']"));
		
		
		
//		Actions a =new Actions(driver);
//		a.scrollToElement(book).click().perform();
		
		
		JavascriptExecutor je=  (JavascriptExecutor)driver;
		//je.executeScript("arguments[0].scrollIntoView()", book);
		
		
		List<WebElement> listOfBooks = driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
		boolean found = false;
		
		while(!found) {
			
			for (WebElement ele : listOfBooks) {
				
				if(ele.getText().equals("Sleep, Baby, Sleep and Other Well-loved Lullabies")) 
				{
					System.out.println("book found");
					ele.click();
					found=true;
					break;
					
				}
				
				je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				
			}
			
			
			
			
		}
		
		Actions sa=new Actions(driver);
	
		
		
	}

}
