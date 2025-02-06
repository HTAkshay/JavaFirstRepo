package BookingPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class listOfItems {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.switchTo().frame(0);
		List<WebElement> itemslist = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
	 WebElement itemslist2 = driver.findElement(By.xpath("//ol[@id='selectable']"));
	 

//		for(int i=0;i<itemslist.size();i++) {
//			
//			System.out.println(itemslist.get(i).getText());
//			
//			
//			
//		}
		
//		for (WebElement e : itemslist) {
//			
//			if(e.equals("Item 5")) {
//				
//				e.click();
//				Thread.sleep(2000);
//				break;
//			}
//			
//		}
		
	/*	System.out.println(itemslist2.isSelected());
		System.out.println(itemslist2.isDisplayed());
		System.out.println(itemslist2.isEnabled());          */
	 
	 Actions a=new Actions(driver);
	// a.keyDown(Keys.CONTROL).clickAndHold(itemslist.get(0)).clickAndHold(itemslist.get(2)).build().perform();
	
	 a.moveToElement(itemslist.get(0)).click(itemslist.get(0)).build();
	// a.moveToElement(itemslist.get(3)).click(itemslist.get(3)).build().perform();
	 Thread.sleep(2000);
	 
	 
	
		
		
		
driver.close();
	}

}
