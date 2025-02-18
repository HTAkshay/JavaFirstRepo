package HTWebsite;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HTwebsiteFlow extends BaseTest {

	
	
	@BeforeMethod
    public void initialize() throws IOException {
        setUp();  // Calls setup method from BaseTest
    }

    @AfterMethod
    public void cleanup() {
        tearDown();  // Calls teardown method from BaseTest
    }

    public String getOTPFromDB() {
        DatabaseHelper dbHelper = new DatabaseHelper(
                config.getProperty("dbHost"),
                config.getProperty("dbPort"),
                config.getProperty("dbName"),
                config.getProperty("dbUser"),
                config.getProperty("dbPass")
        );
        return dbHelper.getOTP("8650674288");
    }

    @Test(description = "New Customer Login and Booking Flow")
    public void NewUser() {
        try {
            driver.navigate().to(config.getProperty("baseUrl"));
          //  Assert.assertEquals(driver.getTitle(), "Blood test in delhi ncr, whole body checkup delhi, medical test in gurgaon, health checkup in Noida, best diagnostic lab in delhi NCR");
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
            WebElement loginText= driver.findElement(By.xpath("(//*[@class='cityCurrnt'])[1]"));
            loginText.click();
            WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile_number")));
            phoneField.sendKeys("8650674288");

            WebElement loginButton = driver.findElement(By.id("submit_login"));
            Assert.assertFalse(loginButton.isSelected());
            loginButton.click();

            String otp = getOTPFromDB();
            if (otp != null && otp.length() == 6) {
                for (int i = 0; i < 6; i++) {
                    driver.findElement(By.id("otc-" + (i + 1))).sendKeys(String.valueOf(otp.charAt(i)));
                }
                System.out.println("Success: OTP received and entered.");
            } else {
                driver.findElement(By.id("resend_code")).click();
                System.out.println("Failed: OTP not received.");
            }

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("scroll(0,200);");
            Thread.sleep(4000);
          
      	  WebElement brandLogo =driver.findElement(By.xpath("//*[@class='brandlogo']"));
      	brandLogo.click();
            WebElement searchField = driver.findElement(By.xpath("//*[@class='select2-search__field']"));
            searchField.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@data-value='Kidney Function Test']")).click();

            WebElement searchButton = driver.findElement(By.xpath("//*[@class='button_icon_form']"));
            Assert.assertFalse(searchButton.isSelected());
            searchButton.click();
            Thread.sleep(2000);

            WebElement bookNow = driver.findElement(By.xpath("//*[@class='book_exact_para booknow-package']"));
            bookNow.click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@onclick='addMemberWithPackage(this)']")).click();
            Thread.sleep(2000);

            WebElement nextButton = driver.findElement(By.xpath("//*[@class='btn_3 mtl_30 ga_add_memeber_next_button']"));
            Assert.assertFalse(nextButton.isSelected());
            nextButton.click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@class='logininput borderred ga_booking_sample_collection_date']")).click();
            WebElement datePicker = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dp2")));
            datePicker.click();
            datePicker.sendKeys(Keys.ARROW_RIGHT);
            datePicker.sendKeys(Keys.ENTER);
            Thread.sleep(6000);

            Select timeSlot = new Select(driver.findElement(By.id("collection_time")));
            timeSlot.selectByIndex(3);

            js.executeScript("scroll(0, 900);");
            Thread.sleep(3000);

            WebElement cashPayment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pay_wrp_cash > div > label > span")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cashPayment);
            Thread.sleep(2000);

            WebElement confirmPayment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapse5 > div > div > div.payment_wrap2 > div > div > div > label")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmPayment);
            Thread.sleep(2000);

            driver.findElement(By.id("payment_out")).click();
            Thread.sleep(2000);

            WebElement cancelBooking = driver.findElement(By.id("cancel_booking_btn"));
            cancelBooking.click();
            Thread.sleep(1000);

            Select cancelReason = new Select(driver.findElement(By.id("cancel_reason_id")));
            cancelReason.selectByVisibleText("Wrong Test Booked");

            driver.findElement(By.xpath("//*[@onclick='cancelBooking();']")).click();

            JsonCreator.saveTestResult("NewUser", "Passed");

        } catch (Exception e) {
            JsonCreator.saveTestResult("NewUser", "Failed");
            e.printStackTrace();
        }
    }
}
