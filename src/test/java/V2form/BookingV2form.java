package V2form;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BookingV2form {

	public static  WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	
		

	
	public static void main(String []args) throws IOException, InterruptedException {
		try {
		
		
			prop=new Properties();
		
			// TODO Auto-generated catch block
		
		
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\HealthiansProj\\src\\V2form\\ConfigFile.properties");
		prop.load(file);
		//prop.getProperty("value");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\HealthiansProj\\Drivers\\chromedriver.exe");

		 driver= new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(prop.getProperty("url"));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		
		
		
		WebElement username_txtbox = driver.findElement(By.xpath("//input[@name='username']"));
		username_txtbox.sendKeys(prop.getProperty("username"));
		WebElement password_txtbox = driver.findElement(By.xpath("//input[@name='password']"));
		password_txtbox.sendKeys(prop.getProperty("password"));
		
		WebElement login_btn = driver.findElement(By.xpath("//button[@id='login_submit']"));
	//	wait.withTimeout(Duration.ofSeconds(20));
		
		login_btn.click();
		//Thread.sleep(10000);
		//wait.until(ExpectedConditions.titleContains(":: Healthians | Dashboard::"));
		
		
 // WebElement firstAllModules = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sidebar-menu-action']/ul/li")));
	WebElement booking_text = driver.findElement(By.xpath("//span[text()='Booking ']"));
	booking_text.click();
	Thread.sleep(2000);
//WebElement listofBooking = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sidebar-menu-action']/descendant::ul[@class='treeview-menu']")));
	//WebElement v2form = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Lead Form V2']")));
	WebElement formv2 = driver.findElement(By.xpath("//a[@title='Lead Form V2']"));
	js.executeScript("arguments[0].scrollIntoView(true);", formv2);
	formv2.click();
		Thread.sleep(2000);
		
		
		WebElement callig_number = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='calling_number']")));
		callig_number.sendKeys("7030709917");
		WebElement search_customer_mobile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search_customer_mobile']")));

		search_customer_mobile.sendKeys("7030709917");
		WebElement Booking_Type_dropdown = driver.findElement(By.xpath("//select[@id='booking_type']"));
		Select s=new Select(Booking_Type_dropdown);
		s.selectByVisibleText("Pathology");
		Thread.sleep(5000);
			
//		List<WebElement> allfrontlist = driver.findElements(By.xpath("//div[@id='sidebar-menu-action']/ul/li"));
//		System.out.println(allfrontlist.size());
//	
//		Thread.sleep(5000);
		
	
		
//		for (WebElement webElement : allfrontlist) {
//			//String a="Booking ";
//			
//		System.out.println(webElement.getText());
		
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Manish")	;
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("More")	;
		driver.findElement(By.xpath("//input[@id='age']")).sendKeys("25")	;
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("manishm@gmail.com")	;
		WebElement gender_select = driver.findElement(By.xpath("//select[@id='gender']"));
		Select select=new Select(gender_select);
		select.selectByIndex(1);
	WebElement state_select = driver.findElement(By.xpath("//select[@id='lead_state']"));
	Select sel=new Select(state_select)	;
	sel.selectByVisibleText("Haryana");
	Thread.sleep(2000);
	WebElement city_select = driver.findElement(By.xpath("//select[@id='lead_city']"));
	Select sele=new Select(city_select)	;
	sele.selectByVisibleText("Gurgaon");
	driver.findElement(By.xpath("//input[@id='disposition2']")).click();
	driver.findElement(By.xpath("//input[@id='form_submit_btn']")).click();
	Thread.sleep(5000);
	
	WebElement address_state = driver.findElement(By.xpath("//select[@id='selectedaddress']"));
	Select s3= new Select(address_state);
	s3.selectByVisibleText("Haryana");
	WebElement address_city = driver.findElement(By.xpath("//span[@id='select2-cityName-container']"));
	address_city.click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='textbox']")).sendKeys("Gurgaon");
	
	
//	Select s4= new Select(address_state);
//	s4.selectByVisibleText("Gurgaon");
	List<WebElement> city_list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@id='select2-cityName-result-nk70-gurgaon']")));
for (int i=0;i<city_list.size();i++) {
	
	
	city_list.get(i).click();
	break;
	
	
	
	
}
	//li[@id='select2-cityName-result-nk70-gurgaon']
	
	driver.findElement(By.xpath("//span[contains(text(),'Search ZipCode')]")).click();
	driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='textbox']")).sendKeys("122001");
	List<WebElement> zipcode_list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-zipcode_search_google-results']/li")));
for (int i=0;i<zipcode_list.size();i++) {
	
	zipcode_list.get(i).click();
	break;
	
	
	
	
}

	
		
		
		driver.findElement(By.xpath("//span[text()='Akshay Mankar']")).click();
		 WebElement signOut_Button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-default']")));
        signOut_Button.click();
//			}
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		finally {
			
			

driver.close();
		}}}
	
	
