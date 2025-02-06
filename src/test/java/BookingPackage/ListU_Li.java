package BookingPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ListU_Li {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		
		List<WebElement> multiselct = driver.findElements(By.xpath("//ol[@id='selectable']//li"));
		Actions a =new Actions(driver);
		a.keyDown(Keys.CONTROL).clickAndHold(multiselct.get(1)).clickAndHold(multiselct.get(2)).build().perform();
		
		//multi list,check  file downloaded or not,auto suggestions,window handles
		
		
		List<WebElement> listofElements = driver.findElements(By.xpath("//ol[@id='selectable']//li"));
		Actions b=new Actions(driver);
		b.keyDown(Keys.CONTROL);
		
		
		
		

	}

}
