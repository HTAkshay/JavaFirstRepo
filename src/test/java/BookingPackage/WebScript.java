package BookingPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebScript {
	



	  WebDriver driver;
	  public String baseUrl = "https://w3.healthians.co.in";
	  String driverPath = "C:\\Users\\Healthians\\Downloads\\chromedriver-win32\\chromedriver.exe";
	 

	   public String getOTPFromDB(String query){
	   String dbHost = "gateway.echl.in";
	   String dbPort = "10301";
	   String dbName = "d10";
	   String dbUser = "chesta";
	   String dbPass = "RQuE5jW19Lt&Pg2e$&R$wZ^s";

	   System.out.print("dbHost "+dbHost);
	   System.out.print("dbPort "+dbPort);
	   System.out.print("dbName "+dbName);
	   System.out.print("dbUser "+dbUser);

	   String DB_URL = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
	   String DB_USER = dbUser;
	   String DB_PASSWORD = dbPass;
	   ResultSet rs=null;
	   String otp="";
	   
	   try {  
	           Class.forName("com.mysql.jdbc.Driver");  
	           Connection con=DriverManager.getConnection(  
	           DB_URL,DB_USER,DB_PASSWORD);  
	           //here sonoo is database name, root is username and password  
	           Statement stmt=con.createStatement();  
	           rs=stmt.executeQuery("Select * from user_otp where mobile_no='8650674288'");  
	           while(rs.next()) {
	           System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(4));
	           otp = rs.getString(4);
	   }
	   //System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	   con.close();  
	   }  catch(Exception e){

	       System.out.println(e);
	   }  
	   


	   return otp;

	}

	@SuppressWarnings({ "deprecation" })
	@BeforeMethod(description = "launching Chrome browser")
	public void launchBrowser() throws InterruptedException {

	System.setProperty("webdriver.chrome.driver", driverPath);
	driver = new ChromeDriver();
	driver.get(baseUrl);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	// Wait for a confirm dialog to appear, and then accept it
	/*WebDriverWait wait2=new WebDriverWait(driver,90);
	   WebElement element2=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-src='https://cdn4.healthians.com/img/static/gurgaon.svg']")));
	   Alert alt=driver.switchTo().alert();
	   alt.accept();*/
	}

	     @SuppressWarnings("deprecation")
	     @Test(description="NewCustomer")
	     public void Newuser() throws InterruptedException
	{

	   // verify title by assertion
	   driver.navigate().to("https://w3.healthians.co.in/");
	String actualTitle = driver.getTitle();
	String expectedTitle = "Blood test in delhi ncr, whole body checkup delhi, medical test in gurgaon, health checkup in Noida, best diagnostic lab in delhi NCR";
	Assert.assertEquals("Condition true", actualTitle, expectedTitle);
	System.out.println("Title=Blood test in delhi ncr, whole body checkup delhi, medical test in gurgaon, health checkup in Noida, best diagnostic lab in delhi NCR");

	   WebElement ele6= driver.findElement(By.xpath("(//*[@class='cityCurrnt'])[1]"));
	   ele6.click();
	   Thread.sleep(2000);

	 
	   WebDriverWait wait1=new WebDriverWait(driver,90);
	WebElement element1=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='mobile_number']")));
	element1.sendKeys("8650674288");
	Thread.sleep(3000);

	//Verify if Login button is clickable or not,by assertion.
	Assert.assertFalse(driver.findElement(By.xpath("//*[@id='submit_login']")).isSelected());
	System.out.println(driver.findElement(By.xpath("//*[@id='submit_login']")).isSelected());
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='submit_login']")).click();

	//WebElement ele1= driver.findElement(By.xpath("//*[@id='submit_login']"));
	//ele1.click();
	 
	String otp = getOTPFromDB("Select otp_code from user_otp where mobile_no='8650674288'");
	System.out.print("otp is "+otp);
	Thread.sleep(2000);
	 
	 
	Instant start = Instant.now();
	       Duration timeout = Duration.ofSeconds(30);

	       while (Duration.between(start, Instant.now()).compareTo(timeout) < 0) {
	       otp = getOTPFromDB("Select otp_code from user_otp where mobile_no='8650674288'");

	       if (otp != null)
	       {
	       break;
	       }

	       try
	       {
	       Thread.sleep(1000);
	       } catch (InterruptedException e)
	       {
	       e.printStackTrace();
	       }
	       }
	   //if (otp.length()==6)
	if (otp != null)
	   {
	     
	driver.findElement(By.id("otc-1")).sendKeys(String.valueOf(otp.charAt(0)));
	driver.findElement(By.id("otc-2")).sendKeys(String.valueOf(otp.charAt(1)));
	driver.findElement(By.id("otc-3")).sendKeys(String.valueOf(otp.charAt(2)));
	driver.findElement(By.id("otc-4")).sendKeys(String.valueOf(otp.charAt(3)));
	driver.findElement(By.id("otc-5")).sendKeys(String.valueOf(otp.charAt(4)));
	driver.findElement(By.id("otc-6")).sendKeys(String.valueOf(otp.charAt(5)));
	     
	        System.out.println("Success: OTP received and entered.");
	        }
	else
	{    
	         WebElement resendOtpButton = driver.findElement(By.xpath("//*[@id='resend_code']"));
	         resendOtpButton.click();
	         System.out.println("Failed: OTP not received from the database.");
	         }

	 JavascriptExecutor js= (JavascriptExecutor)driver;
	 js.executeScript("scroll(0,200);");
	 //Thread.sleep(2000);
	 
	 //WebElement ele4=driver.findElement(By.id("sign_out_menu"));
	 //ele4.click();
	 
	  Thread.sleep(4000);
	  WebElement elem =driver.findElement(By.xpath("//*[@class='brandlogo']"));
	  elem.click();
	 
	  //JavascriptExecutor js2 = (JavascriptExecutor)driver;
	  //js2.executeScript("scroll(0, 600);");  
	  //Thread.sleep(2000);
	 
	   WebElement elem1=driver.findElement(By.xpath("//*[@class='select2-search__field']"));
	elem1.click();
	Thread.sleep(2000);

	// Verify if Kidney test is selected or not,by assertion
	driver.findElement(By.xpath("//*[@data-value='Kidney Function Test']")).click();  
	       Assert.assertFalse(driver.findElement(By.xpath("//*[@data-value='Kidney Function Test']")).isSelected());  
	       System.out.println(driver.findElement(By.xpath("//*[@data-value='Kidney Function Test']")).isSelected());  
	         
	/*WebElement elem2=driver.findElement(By.xpath("//*[@data-value='Kidney Function Test']"));
	elem2.click();*/
	Thread.sleep(2000);

	//Search button is clickable or not, by assertion
	Assert.assertFalse(driver.findElement(By.xpath("//*[@class='button_icon_form']")).isSelected());
	System.out.println(driver.findElement(By.xpath("//*[@class='button_icon_form']")).isSelected());
	Thread.sleep(3000);
	   driver.findElement(By.xpath("//*[@class='button_icon_form']")).click();
	   
	/*WebElement elem3=driver.findElement(By.xpath("//*[@class='button_icon_form']"));
	elem3.click();*/
	Thread.sleep(2000);

	   JavascriptExecutor js3 = (JavascriptExecutor)driver;
	js3.executeScript("scroll(0, 200);");  
	Thread.sleep(3000);

	WebElement eleme2=driver.findElement(By.xpath("//*[@class='book_exact_para booknow-package']"));
	eleme2.click();
	Thread.sleep(2000);

	   driver.findElement(By.xpath("//*[@onclick='addMemberWithPackage(this)']")).click();
	Thread.sleep(2000);

	//Next button is clickable or not,by assertion.
	   Assert.assertFalse(driver.findElement(By.xpath("//*[@class='btn_3 mtl_30 ga_add_memeber_next_button']")).isSelected());
	   System.out.println(driver.findElement(By.xpath("//*[@class='btn_3 mtl_30 ga_add_memeber_next_button']")).isSelected());
	   Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@class='btn_3 mtl_30 ga_add_memeber_next_button']")).click();
	       
	   //JavascriptExecutor jss= (JavascriptExecutor) driver;
	   //jss.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//*[@class='logininput borderred ga_booking_sample_collection_date']")));
	   Thread.sleep(2000);      
	   driver.findElement(By.xpath("//*[@class='logininput borderred ga_booking_sample_collection_date']")).click();
	   
	   WebDriverWait wait5=new WebDriverWait(driver,90);
	  WebElement element5=wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dp2']")));
	   element5.click();
	   WebElement elemen = driver.findElement(By.xpath("//*[@id=\'dp2\']"));
	  elemen.sendKeys(Keys.ARROW_RIGHT);
	  elemen.sendKeys(Keys.ENTER);
	  Thread.sleep(6000);
	       
	  Select select1 = new Select(driver.findElement(By.xpath("//*[@id='collection_time']")));
	   select1.selectByIndex(3);
	   
	   JavascriptExecutor js4 = (JavascriptExecutor)driver;
	  js4.executeScript("scroll(0, 900);");
	   Thread.sleep(3000);
	   
	  WebDriverWait wait7=new WebDriverWait(driver,90);
	WebElement element7=wait7.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pay_wrp_cash > div > label > span")));
	JavascriptExecutor executor2 = (JavascriptExecutor) driver;
	executor2.executeScript("arguments[0].click();", element7);
	   Thread.sleep(2000);
	 
	   WebDriverWait wait9=new WebDriverWait(driver,90);
	   WebElement element9=wait9.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapse5 > div > div > div.payment_wrap2 > div > div > div > label")));
	JavascriptExecutor executor1 = (JavascriptExecutor) driver;
	   executor1.executeScript("arguments[0].click();", element9);
	   Thread.sleep(2000);
	 
	   driver.findElement(By.xpath("//a[@id='payment_out']")).click();
	   
	   Thread.sleep(2000);
	   WebElement eleme1=driver.findElement(By.xpath("//*[@id='cancel_booking_btn']"));
	   eleme1.click();
	   Thread.sleep(1000);
	   WebElement dropdown = driver.findElement(By.id("cancel_reason_id"));
	       Select select = new Select(dropdown);
	       select.selectByVisibleText("Not Require The Test ");
	       
	       WebElement eleme3=driver.findElement(By.xpath("//*[@onclick='cancelBooking();']"));
	       eleme3.click();
	}  
	}

