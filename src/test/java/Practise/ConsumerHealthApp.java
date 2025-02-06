package Practise;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Date;

import org.openqa.selenium.net.UrlChecker.TimeoutException;

public class ConsumerHealthApp {
	
	 public void appiumTest() throws MalformedURLException, URISyntaxException, InterruptedException 
		{
	        ResultLogger resultLogger = new ResultLogger();
	        long startTime = System.currentTimeMillis();
	        try {
	            // Load configurations
	            String deviceName = ConfigLoader.get("deviceName");
	            String appPath = ConfigLoader.get("appPath");
	            String serverURL = ConfigLoader.get("serverURL");
	            String mobileNumber = ConfigLoader.get("mobileNumber");
	            String packageName = ConfigLoader.get("packageName");

	            resultLogger.log("startTime", new Date(startTime));
	            resultLogger.log("deviceName", deviceName);

	            UiAutomator2Options options = new UiAutomator2Options();
	            options.setDeviceName(deviceName);
	            options.setApp(appPath);
	            AndroidDriver driver = new AndroidDriver(new URI(serverURL).toURL(), options);

	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            clickElement(wait, By.id("com.google.android.gms:id/cancel"), "Cancel Suggestion");
//	            clickElement(wait, By.id("android:id/button1"), "Start button");
//	            clickElement(wait, By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"), "Permission button");

	            if (isElementPresent(wait, By.id("com.healthians.main.healthians.dev:id/secondary_button")))
	            {
	                clickElement(wait, By.id("com.healthians.main.healthians.dev:id/secondary_button"), "Kotlin button");
	            } 
	            else 
	            {
	                System.out.println("Kotlin button not present, skipping...");
	            }

//	             clickElement(wait, AppiumBy.xpath("//android.widget.Button[@resource-id='com.healthians.main.healthians.dev:id/startedButton']"), "Start button");

	            enterText(wait, By.id("com.healthians.main.healthians.dev:id/mobile_number"), mobileNumber, "Mobile number field");
	            
	            clickElement(wait, By.id("com.healthians.main.healthians.dev:id/bv_book_now"), "OTP button");
	            String otp = fetchOTP(mobileNumber);
	            enterOTP(driver, wait, otp);
	            
	            if (isElementPresent(wait, By.id("android:id/button1")))
	            	
	            {
	            	clickElement(wait, By.id("android:id/button1"), "new user");
	            	
	                System.out.println("Navigated to New User Screen");
	                handleNewUserFlow(wait);
	            } 
	            else 
	            {
	                System.out.println("Navigated to Existing User Screen");
	                handleExistingUserFlow(wait);
	            }
	    
	            clickElement(wait, By.id("com.android.permissioncontroller:id/permission_allow_button"), "Allow button");
	            clickElement(wait, By.id("com.healthians.main.healthians.dev:id/tv_pick_location"), "Location element");
	      
	            if (isElementPresent(wait, By.id("android:id/button1")))
	            {
	                clickElement(wait, By.id("android:id/button1"), "permission_button");
	            } 
	            else 
	            {
	                System.out.println("Permission button not present, skipping...");
	            }
	            
	            
	            
	            if (isElementPresent(wait, By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")))
	            {
	                clickElement(wait, By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"), "permission_allow_foreground");
	            } 
	            else 
	            {
	                System.out.println("permission_allow_foreground button not present, skipping...");
	            
	            
	            }
	       
	            clickElement(wait, By.id("com.healthians.main.healthians.dev:id/closeImage"), "Popup close button");

	            searchPackage(wait, driver, packageName);
	            clickElement(wait, By.id("com.healthians.main.healthians.dev:id/bv_book_now"), "Add to Cart button");

	            clickElement(wait, AppiumBy.xpath("(//android.widget.CheckBox[@resource-id='com.healthians.main.healthians.dev:id/select'])[1]"), "Member checkbox");
	            clickElement(wait, By.id("com.healthians.main.healthians.dev:id/bv_add_to_cart"), "Add Member button");

	            if (isElementPresent(wait, By.id("android:id/button1"))) 
	            {
	                clickElement(wait, By.id("android:id/button1"), "Coupon not applicable");
	            } 
	            else 
	            {
	                System.out.println("Coupon already applied.., skipping...");
	            }
	           
	            clickElement(wait, By.id("com.healthians.main.healthians.dev:id/bv_book_now"), "Submit button");
	            
	            Thread.sleep(2000);
	            
	            if (isElementPresent(wait, By.id("com.healthians.main.healthians.dev:id/enter_full_address"))) 
	            {
	             System.out.println("Address not found. Filling in the address details.");
	             WebElement clickableElement = driver.findElement(By.id("com.healthians.main.healthians.dev:id/enter_full_address"));
	             clickableElement.click(); // Click the element
	             // Enter full address
	             Thread.sleep(1000);
	            
	             System.out.println("Clicked on the address button.");
	             String houseNumber = ConfigLoader.get("houseNumber");
	             // Enter house/building number
	             WebElement houseField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.healthians.main.healthians.dev:id/edt_building_no")));
	             Assert.assertTrue(houseField.isDisplayed(), "House/Building Number field is not displayed!");
	             houseField.sendKeys(houseNumber);
	             System.out.println("Entered house/building number: " + houseNumber);
	             // Click on the save button
	             WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.healthians.main.healthians.dev:id/btn_save")));
	             Assert.assertTrue(saveButton.isDisplayed(), "Save button is not displayed!");
	             saveButton.click();
	             System.out.println("Clicked on the save button.");

	             // Wait briefly to ensure address save confirmation
	             Thread.sleep(1000);
	             System.out.println("Address details have been filled and saved successfully.");
	             } 
	             else 
	             {
	             System.out.println("Address is already available. Proceeding to the slot page.");
	             }

	            selectAvailableSlot(driver);

	            clickElement(wait, By.id("com.healthians.main.healthians.dev:id/bv_confirm"), "Continue button");
	            scrollToElement(driver, "com.healthians.main.healthians.dev:id/radio_btn");
	            clickElement(wait, By.xpath("//android.widget.RadioButton[@resource-id='com.healthians.main.healthians.dev:id/radio_btn' and @text='Cash/Card on Sample Collection']"), "Payment Method");
	            clickElement(wait, By.id("com.healthians.main.healthians.dev:id/checkBox"), "Terms and Conditions");
	            clickElement(wait, By.id("com.healthians.main.healthians.dev:id/bv_confirm"), "Pay Now button");
	            clickElement(wait, By.id("android:id/button1"), "Yes button");
	            clickElement(wait, By.id("com.healthians.main.healthians.dev:id/track_booking"), "Booking Details");
	            clickElement(wait, By.id("android:id/button1"), "Leave Page button");
	            clickElement(wait, By.id("com.healthians.main.healthians.dev:id/booking_list_card"), "My booking");
	            clickElement(wait, By.id("com.healthians.main.healthians.dev:id/btn_cancel"), "Cancel button");
	            clickElement(wait, By.id("com.healthians.main.healthians.dev:id/positive_btn"), "yes button");
	            clickElement(wait, By.id("com.healthians.main.healthians.dev:id/reasons_text"), "reason text");
	            clickElement(wait, By.id("android:id/button1"), "ok button");
	            clickElement(wait, By.id("com.healthians.main.healthians.dev:id/booking_id_view"), "booking_id");
	            String bookingId = driver.findElement(By.id("com.healthians.main.healthians.dev:id/booking_id_view")).getText();
	            System.out.println("Captured Booking ID: " + bookingId);
	            resultLogger.log("booking_id",bookingId );
	           
	         
	           
	         //   driver.quit();

	            // Log success
	            resultLogger.log("status", "Success");
	            } 
	            catch (AssertionError | Exception e) { // Catch both AssertionError and generic exceptions
	            // Log failure status and error details
	            resultLogger.log("status", "Failed");
	            resultLogger.log("errorMessage", e.getMessage() != null ? e.getMessage() : "Unknown error occurred");
	            throw e; // Re-throw to let the test framework handle the failure
	            } 
	            finally 
	            {
	            long endTime = System.currentTimeMillis();
	            resultLogger.log("endTime", new Date(endTime));
	            resultLogger.log("executionTime", (endTime - startTime) + " ms");
	          
	            // Save results to JSON file regardless of success or failure
	            resultLogger.saveResult("test-results.json");
	            }
	            }
		
		        private static void handleNewUserFlow(WebDriverWait wait) throws InterruptedException 
		        {
		        String userGender = ConfigLoader.get("Gender");
		        String userName = ConfigLoader.get("Name");
		        String userEmail = ConfigLoader.get("Email");
		        String userCity = ConfigLoader.get("City");
		        clickElement(wait, By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"), "new_user_permission");
		       
		        
		        // Gender Selection 
		        if ("Male".equalsIgnoreCase(userGender)) 
		        {
		        WebElement maleGenderButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.healthians.main.healthians.dev:id/txt_form_male")));
		        Assert.assertTrue(maleGenderButton.isDisplayed(), "Male Gender button is not displayed!");
		        maleGenderButton.click();
		        System.out.println("Selected Male gender.");
		        } 
		        else if ("Female".equalsIgnoreCase(userGender)) 
		        {
		        WebElement femaleGenderButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.healthians.main.healthians.dev:id/txt_form_female")));
		        Assert.assertTrue(femaleGenderButton.isDisplayed(), "Female Gender button is not displayed!");
		        femaleGenderButton.click();
		        System.out.println("Selected Female gender.");
		        }
		        else 
		        {
		        throw new IllegalArgumentException("Invalid gender specified in configuration: " + userGender);
		        }

		        // Full Name
		        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.healthians.main.healthians.dev:id/edt_name")));
		        Assert.assertTrue(nameField.isDisplayed(), "Name field is not displayed!");
		        nameField.sendKeys(userName);
		        System.out.println("Entered full name: " + userName);

		        // Email Address
		        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.healthians.main.healthians.dev:id/edt_email")));
		        Assert.assertTrue(emailField.isDisplayed(), "Email field is not displayed!");
		        emailField.sendKeys(userEmail);
		        System.out.println("Entered email: " + userEmail);

		        // Date of Birth
		        WebElement dobField = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.healthians.main.healthians.dev:id/dob_card")));
		        Assert.assertTrue(dobField.isDisplayed(), "DOB field is not displayed!");
		        dobField.click();
		        System.out.println("DOB field clicked.");
		    
		        WebElement dobOkButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
		        Assert.assertTrue(dobOkButton.isDisplayed(), "DOB OK button is not displayed!");
		        dobOkButton.click();
		        System.out.println("DOB OK button clicked.");

		        // City Name
		        WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.healthians.main.healthians.dev:id/autoCompleteTextView")));
		        Assert.assertTrue(cityField.isDisplayed(), "City field is not displayed!");
		        cityField.sendKeys(userCity);
		        System.out.println("Entered city: " + userCity);

		        // Submit Button
		        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.healthians.main.healthians.dev:id/submit_info")));
		        Assert.assertTrue(submitButton.isDisplayed(), "Submit button is not displayed!");
		        submitButton.click();
		        System.out.println("Clicked Submit button.");

//		        // Optional Screen: "Choose Option"
//		        WebElement ChooseOption = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.healthians.main.healthians.dev:id/text_layout")));
//		        Assert.assertTrue(ChooseOption.isDisplayed(), "ChooseOption is not displayed!");
//		        ChooseOption.click();
//	            System.out.println("Clicked ChooseOption on Choose Option screen.");
//		        WebElement startButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.healthians.main.healthians.dev:id/start_btn")));
//		        Assert.assertTrue(startButton.isDisplayed(), "Start button is not displayed!");
//	            startButton.click();
//	            System.out.println("Clicked Start button on Choose Option screen.");
	//	
		        }
		
		        private static void handleExistingUserFlow(WebDriverWait wait) 
		        {
		        System.out.println("Existing user flow, no additional actions required.");
		        
		        // Add logic for existing users here if needed.
		        }
		
		
		       private static boolean isElementPresent(WebDriverWait wait, By locator)
		       {
	           try 
	           {
	           wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	           return true;
	           } 
	           catch (Exception e) 
	           {
	           return false;
	           }
	           }
		
		
	           public static String fetchOTP(String mobileNumber) {
	           String dbURL = ConfigLoader.get("dbURL");
	           String dbUsername = ConfigLoader.get("dbUsername");
	           String dbPassword = ConfigLoader.get("dbPassword");
	           String otp = null;

	           try
	           (Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword)) 
	           {
	           String query = "SELECT otp_code FROM user_otp WHERE mobile_no = ?";
	           PreparedStatement preparedStatement = connection.prepareStatement(query);
	           preparedStatement.setString(1, mobileNumber);
	           ResultSet resultSet = preparedStatement.executeQuery();

	           if (resultSet.next()) 
	           {
	           otp = resultSet.getString("otp_code");
	           }
	           } 
	           catch (Exception e) 
	           {
	            e.printStackTrace();
	           }

	           Assert.assertNotNull(otp, "OTP is null after fetching from database!");
	           System.out.println("Fetched OTP: " + otp);
	           return otp;
	           }

	    private static void enterOTP(AndroidDriver driver, WebDriverWait wait, String otp) {
	        WebElement otpField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText")));
	        Assert.assertTrue(otpField.isDisplayed(), "OTP field is not displayed!");
	        otpField.sendKeys(otp);
	        System.out.println("Entered OTP: " + otp);
	    }

	    private static void searchPackage(WebDriverWait wait, AndroidDriver driver, String packageName) throws InterruptedException {
	    	clickElement(wait, By.id("com.healthians.main.healthians.dev:id/search_txt"), "Search icon");
	    	enterText(wait, By.id("com.healthians.main.healthians.dev:id/search_field"), packageName, "Search field");
	        Thread.sleep(1000);

	        try {
	            // Dynamically search for the dropdown item based on the package name
	            String dropdownItemXPath = "//android.widget.TextView[contains(@text, '" + packageName + "')]";
	            WebElement dropdownItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownItemXPath)));

	            // Validate and click the element
	            Assert.assertTrue(dropdownItem.isDisplayed(), "Dropdown item for package " + packageName + " is not displayed!");
	            dropdownItem.click();
	            Thread.sleep(500);

	        } catch (TimeoutException e) {
	            System.out.println("Dropdown item for package " + packageName + " not found, attempting to scroll...");

	            // Scroll to the element dynamically if it's not found in the dropdown list
	            scrollToElement(driver, packageName);
	            Thread.sleep(1000);

	            try {
	                String scrollDropdownItemXPath = "//android.widget.TextView[contains(@text, '" + packageName + "')]";
	                WebElement scrollDropdownItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(scrollDropdownItemXPath)));
	                scrollDropdownItem.click();
	            } catch (TimeoutException ex) {
	                System.out.println("Element still not found after scrolling.");
	            }
	        }
	    }

	   
	    public static void selectAvailableSlot(AndroidDriver driver) 
	    {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        boolean slotFound = false;
	        int maxSwipeAttempts = 7;

	        for (int attempt = 1; attempt <= maxSwipeAttempts; attempt++)
	        {
	            try 
	            {
	                List<WebElement> dateElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
	                		(By.id("com.healthians.main.healthians.dev:id/dateRecyclerView")));                       
	                for (WebElement dateElement : dateElements) 
	                {
	                   try 
	                      {
	                        dateElement.click();
	                        Thread.sleep(2000);
	                        List<WebElement> slotElements = driver.findElements(By.id("com.healthians.main.healthians.dev:id/slotItem"));
	                        for (WebElement slotElement : slotElements) {
	                            if (slotElement.isDisplayed() && slotElement.isEnabled()) {
	                                slotElement.click();
	                                slotFound = true;
	                                break;
	                            }
	                        }
	                        if (slotFound) break;
	                    } 
	                   catch (Exception e) 
	                   {
	        System.out.println("Error processing slot: " + e.getMessage());
	        }
	        }
	        if (slotFound) break;
	        swipeRight(driver, "//android.widget.HorizontalScrollView[@resource-id='com.healthians.main.healthians.dev:id/dateRecyclerView']");
	        } 
	        catch (Exception e)
	        {
	        System.out.println("Error during slot selection: " + e.getMessage());
	        }
	        }
	        Assert.assertTrue(slotFound, "No available slots found!");
	        }

	    public static void swipeRight(AndroidDriver driver, String scrollableElementXPath) {
	            try 
	            {
	            WebElement scrollableElement = driver.findElement(By.xpath(scrollableElementXPath));
	            int startX = scrollableElement.getLocation().getX() + scrollableElement.getSize().getWidth() - 10;
	            int startY = scrollableElement.getLocation().getY() + (scrollableElement.getSize().getHeight() / 2);
	            int endX = scrollableElement.getLocation().getX() + 10;
	            int endY = startY;

	            new TouchAction<>(driver)
	            .press(PointOption.point(startX, startY))
	            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
	            .moveTo(PointOption.point(endX, endY))
	            .release()
	            .perform();
	            System.out.println("Swipe successful.");
	            } 
	            catch (Exception e) 
	            {
	            System.out.println("Swipe failed: " + e.getMessage());
	            }
	            }

	    private static void clickElement(WebDriverWait wait, By locator, String elementName) throws InterruptedException {
	        int retryCount = 3;
	        for (int i = 0; i < retryCount; i++) 
	        {
	        try 
	        {
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	        Assert.assertTrue(element.isDisplayed(), elementName + " is not displayed!");
	        element.click();
	        Thread.sleep(500);
	        return;
	        } 
	        catch (TimeoutException e) 
	        {
	        System.out.println(elementName + " is not clickable, retrying...");
	        Thread.sleep(2000);  // Wait and retry
	        }
	        }
	        throw new TimeoutException(elementName + " could not be clicked after retries.");
	        }

	    public static void scrollToElement(AndroidDriver driver, String elementResourceId) {
	        driver.findElement(AppiumBy.androidUIAutomator
	        		("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"" + elementResourceId + "\"))"));

	        }

	    private static void enterText(WebDriverWait wait, By locator, String text, String fieldName) {
	        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        Assert.assertTrue(field.isDisplayed(), fieldName + " is not displayed!");
	        field.sendKeys(text);
	        }

}
