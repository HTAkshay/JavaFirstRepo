package BookingPackage;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckFileDownload {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/file.xhtml");
		driver.findElement(By.xpath("//span[text()='Download']")).click();
		Thread.sleep(10000);
		File file=new File("C:\\Users\\Admin\\Downloads");
		File[]	allfiles=file.listFiles();
		for (File file2 : allfiles) {
			if(file2.getName().equals("TestLeaf Logo.png"))
					
					
					{
				System.out.println("file is downloaded");
				
				break;
			}else {
				
				System.out.println("file is not downloaded");
				
			}
		}
		
		
		

	}

}
