package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected WebDriver driver;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
     //  options.addArguments("--headless=new","--window-size=1920,1080","--no-sandbox","--disable-dev-shm-usage");
       
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public void tearDown() throws InterruptedException {
        if (driver != null) driver.quit();
        Thread.sleep(2000);
    }

}
