package HTWebsite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	protected WebDriver driver;
    protected Properties config;

    public void setUp() throws IOException {
    	
        config = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Mvn\\src\\main\\java\\WEBconfig.properties");
        config.load(fis);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(
                Integer.parseInt(config.getProperty("timeoutSeconds")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(config.getProperty("baseUrl"));
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
