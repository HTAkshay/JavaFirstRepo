package v2_Form;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class leadForm {
	
	public static WebDriver driver;
	
	@Test
	public void leadGeneration() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://devcrm002.echl.co.in/");
		driver.findElement(By.name("username")).sendKeys("akshay.mankar@healthians.com");
		driver.findElement(By.name("password")).sendKeys("1@password");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
	
	
		//driver.findElement(By.id("login_submit")).click();
		List<WebElement> first_list_of_Elements = driver.findElements(By.xpath("//div[@id='sidebar-menu-action']/ul/li"));
		
		// List<WebElement> first_list_of_Elements2 = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='sidebar-menu-action']/ul/li")));
		//List<WebElement> first_list_of_Elements1 = driver.findElements(By.xpath("//div[@id='sidebar-menu-action']/ul/li"));
		for (WebElement li: first_list_of_Elements) {
			// js.executeScript("arguments[0].scrollIntoView(true);", listElements); 
			if(li.getText().equals("Booking")) {
				
				li.click();
				System.out.println("click on booking action");
				Thread.sleep(5000);
				break;
				
			}
			
		}	
		
		List<WebElement> bookingList = driver.findElements(By.xpath("//li[@class='treeview menu-open']//ul[@class='treeview-menu']/li"));
		for (WebElement li2: bookingList) {
			 js.executeScript("arguments[0].scrollIntoView(true);", li2); 
			if(li2.getText().equals("Lead Form V2")) {
				
				li2.click();
				System.out.println("Click on Lead Form V2 action");
				Thread.sleep(5000);
				break;
				
			}
			
		}
	
		
		
		driver.findElement(By.id("calling_number")).sendKeys("7054564487");
		driver.findElement(By.id("search_customer_mobile")).sendKeys("7054564487");
		WebElement checkBox = driver.findElement(By.id("b2c"));
		boolean b=checkBox.isSelected();
		System.out.println(b);
		
		WebElement testSelect = driver.findElement(By.id("booking_type"));
		Select s=new Select(testSelect);
		s.selectByVisibleText("Pathology");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Sunil");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Mohan");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='age']")).sendKeys("26");
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("sunil@gmail.com");
		Thread.sleep(1000);
		WebElement genderSelect = driver.findElement(By.id("gender"));
		Thread.sleep(1000);
		Select s4=new Select(genderSelect);
		s4.selectByVisibleText("Male");
		Thread.sleep(1000);
		WebElement stateSelect = driver.findElement(By.id("lead_state"));
		Select s2=new Select(stateSelect);
		s2.selectByVisibleText("Haryana");
		Thread.sleep(1000);
		WebElement citySelect = driver.findElement(By.id("lead_city"));
		Select s3=new Select(citySelect);
		s3.selectByVisibleText("Gurgaon");
		Thread.sleep(1000);
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,1000)");
		driver.findElement(By.id("disposition2")).click();
	
		Thread.sleep(2000);
		WebElement clickbutton = driver.findElement(By.id("form_submit_btn"));
		
		//js.executeScript("arguments[0].scrollIntoView(true);", clickbutton);
		clickbutton.click();
		System.out.println("click on submit button");
		Thread.sleep(5000);
		
		
		System.out.println("lead generated succesfully-new page");
		
		JavascriptExecutor js3=(JavascriptExecutor)driver;
		 js3.executeScript("window.scroll(0, 1000)");
		 Thread.sleep(2000);
		 js3.executeScript("document.querySelector(\"div[class='col-sm-12'] div[class='panel-body dataTable_wrapper']\").scrollTop=300");
		
		// js3.executeScript("document.querySelector(\"div[class='col-sm-12'] div[class='panel-body dataTable_wrapper']\").scrollLeft=300");
		WebElement addressState = driver.findElement(By.id("selectedaddress"));
//		Actions a =new Actions(driver);
//		a.scrollToElement(addressState);
//		JavascriptExecutor js3=(JavascriptExecutor)driver;
//		 js3.executeScript("window.scroll(0, 500);");
		Select s5=new Select(addressState);
		s5.selectByVisibleText("Haryana");
		Thread.sleep(2000);
		
		WebElement addressCity= driver.findElement(By.xpath("//span[@id='select2-cityName-container']//span[@class='select2-selection__placeholder']"));
		addressCity.click();
		WebElement enterCity = driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"));
		enterCity.sendKeys("Gurgaon");
		Thread.sleep(2000);
		enterCity.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
//		JavascriptExecutor js4=(JavascriptExecutor)driver;
//		js3.executeScript("arguments[0].scrollIntoView(true);", addressCity);
//		Select s6=new Select(addressCity);
//		s6.selectByVisibleText("Gurgaon");
//		Thread.sleep(2000);
		
		//div[class='col-sm-12'] div[class='panel-body dataTable_wrapper']
		//document.querySelector("div[class='col-sm-12'] div[class='panel-body dataTable_wrapper']").scrollTop=300
		driver.findElement(By.xpath("//span[text()='Search ZipCode ']")).click();
	WebElement zipcode = driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field'] "));
	zipcode.sendKeys("122016");
	Thread.sleep(2000);
	zipcode.sendKeys(Keys.SPACE);
	Thread.sleep(1000);
	zipcode.sendKeys(Keys.ENTER);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@id='select2-sub_locality_google-container']")).click();
	WebElement sublocality = driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"));
	sublocality.sendKeys("sector 21");
	Thread.sleep(1000);
	sublocality.sendKeys(Keys.SPACE);
	Thread.sleep(1000);
	sublocality.sendKeys(Keys.ENTER);
	Thread.sleep(3000);
	driver.findElement(By.id("frm_address")).sendKeys("1245");
	driver.findElement(By.id("landmark")).sendKeys("near temple");
	
	System.out.println("Address added successfully");
	Thread.sleep(1000);
	
	driver.findElement(By.id("altbillingMobile")).sendKeys("7111123456");
	
	System.out.println("Alternate number added");
	
	JavascriptExecutor jss=(JavascriptExecutor)driver;
	 jss.executeScript("document.querySelector(\"div[class='col-sm-12'] div[class='panel-body dataTable_wrapper']\").scrollTop=700");
	
	 WebElement addPatientButton= driver.findElement(By.xpath("//input[@id='btn_addcustomer']"));
	addPatientButton.click();
			Thread.sleep(5000);
			System.out.println("clicked on add patient button");
			
			
			WebElement selectCustomer= driver.findElement(By.xpath("//select[@class='form-control select-patient patient_types']"));
//			JavascriptExecutor js4=(JavascriptExecutor)driver;
//			 js4.executeScript("arguments[0].scrollIntoView(true);", selectCustomer); 

	Select s7=new Select(selectCustomer);
	s7.selectByVisibleText("self");
	Thread.sleep(2000);
	
	System.out.println("customer selected successfully");
	/*
	driver.findElement(By.xpath("//input[@id='customer_173316420070520_age_duplicate']")).sendKeys("30");
	driver.findElement(By.xpath("//span[@id='select2-customer_173316420070520_gender_duplicate-container']")).click();
	WebElement gender = driver.findElement(By.xpath("(//input[@class='select2-search__field'])[3]"));
	gender.sendKeys("male");
	gender.sendKeys(Keys.ENTER);
	
	*/
	driver.findElement(By.xpath("//button[@class='btn btn-success _packge-add']")).click();
	Thread.sleep(3000);
	 WebElement searchbox = driver.findElement(By.xpath("(//input[@class='select2-search__field'])[5]"));
	 searchbox.sendKeys("Healthians Executive Full Body Checkup");
	 Thread.sleep(2000);
	 searchbox.sendKeys(Keys.ENTER);
	 driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//button[@class='btn btn-primary hideSearchProduct']")).click();
	 Thread.sleep(3000);
	 
	 
	
	
	
	driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']//button[@type='button'][1]")).click();
	Thread.sleep(5000);
	 WebElement packSearch = driver.findElement(By.xpath("//div[@class='col-md-7']/descendant::ul/li/input"));
	 packSearch.sendKeys("Basic Preventive Package");
	 packSearch.sendKeys(Keys.ENTER);
	 driver.findElement(By.xpath("//div[@class='col-md-3']//input[@type='submit' or @value='Search']")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.id("package_119")).click();
		System.out.println("test selected successfully");
	 
	/*
	
	// Locate the scrollable container
	WebElement container = driver.findElement(By.cssSelector("div[class='col-sm-12'] div[class='panel-body dataTable_wrapper']"));

	// Scroll the container down by 400 pixels
	JavascriptExecutor js4 = (JavascriptExecutor) driver;
	js4.executeScript("arguments[0].scrollTop += 400;", container);

	// Locate the element you want to scroll to
	WebElement element1 = driver.findElement(By.cssSelector("#btn_addcustomer")); // Change to your actual selector

	// Bring 'element1' into view
	js4.executeScript("arguments[0].scrollIntoView(true);", element1);
	
	element1.click();
	
	/*

	/*
	JavascriptExecutor js4 = (JavascriptExecutor) driver;

	// Get the current scroll position


	// Scroll by an additional 300 pixels
	js4.executeScript("document.querySelector(\"div[class='col-sm-12'] div[class='panel-body dataTable_wrapper']\").scrollTop = 800");


*/
	// Thread.sleep(3000);
	// WebElement addPatientButton = driver.findElement(By.cssSelector("#btn_addcustomer"));
	// WebElement addPatientButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='btn_addcustomer']")));
	// WebElement addPatientButton= driver.findElement(By.xpath("//input[@id='btn_addcustomer']"));
//	 Actions a2=new Actions(driver);
//	 a2.scrollToElement(addPatientButton);
//	JavascriptExecutor js5=(JavascriptExecutor)driver;
//	 js5.executeScript("arguments[0].click();", addPatientButton); 
	 //addPatientButton.click();
		//Thread.sleep(5000);
	//	System.out.println("clicked on add patient button");

		/*

			WebElement selectCustomer= driver.findElement(By.id("customer[172780740069406][customer_id]"));
//			JavascriptExecutor js4=(JavascriptExecutor)driver;
//			 js4.executeScript("arguments[0].scrollIntoView(true);", selectCustomer); 

	Select s7=new Select(selectCustomer);
	s7.selectByVisibleText("self");
	Thread.sleep(2000);
	
	System.out.println("customer selected successfully");
	
	driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']//button[@type='button'][1]")).click();
	Thread.sleep(5000);
	 WebElement packSearch = driver.findElement(By.xpath("//div[@class='col-md-7']/descendant::ul/li/input"));
	 packSearch.sendKeys("Basic Preventive Package");
	 packSearch.sendKeys(Keys.ENTER);
	 driver.findElement(By.xpath("//div[@class='col-md-3']//input[@type='submit' or @value='Search']")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.id("package_119")).click();
		System.out.println("test selected successfully");

	
	*/
	
	
	
	
	
	//div[@class='col-md-7']//li[@class='select2-search select2-search--inline']//input[@class='select2-search__field']
	//             or
	//div[@class='col-md-7']/descendant::ul/li/input
		
	
	
	
	 /*       try {
	           

	            // Select the date using the Select class
	        	WebElement dateSelect = driver.findElement(By.id("sample-collect-date"));
	        	Select s8=new Select(dateSelect);
	        	s8.selectByIndex(0); // Select the first date

	            // Check for available slots
	            if (checkAvailableSlots(driver)) {
	                // Click on the first available slot
	                selectFirstAvailableSlot(driver);
	            } else {
	                // If no slots available, select a new date
	                System.out.println("No slots available. Selecting a new date.");
	                dateSelect.selectByIndex(1); // Change index to select the next date

	                // Check again for available slots
	                if (checkAvailableSlots(driver)) {
	                    selectFirstAvailableSlot(driver);
	                } else {
	                    System.out.println("No slots available for the new date.");
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	    }

	    private static boolean checkAvailableSlots(WebDriver driver) {
	        List<WebElement> slots = driver.findElements(By.xpath("//div[contains(@class, 'slot')]")); // Replace with actual slot locator
	        for (WebElement slot : slots) {
	            String id = slot.getAttribute("id");
	            if (!"0".equals(id)) { // Slot available if id is not equal to 0
	                return true;
	            }
	        }
	        return false;
	    }

	    private static void selectFirstAvailableSlot(WebDriver driver) {
	        List<WebElement> slots = driver.findElements(By.xpath("//div[contains(@class, 'slot')]")); // Replace with actual slot locator
	        for (WebElement slot : slots) {
	            String id = slot.getAttribute("id");
	            if (!"0".equals(id)) { // Select the first available slot
	                slot.click();
	                System.out.println("Selected slot with ID: " + id);
	                return;
	            }
	        }
	    */
	}

}
