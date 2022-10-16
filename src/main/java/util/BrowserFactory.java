package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	static WebDriver driver;

	static String browser;
	static String url;

	public static void readConfig() {
		
		try {
			InputStream input = new FileInputStream("C:\\Users\\salma\\OneDrive\\Desktop\\Selenium\\1st_Selenium\\projectWithJunit\\src\\main\\java\\util\\config.properties");
			Properties prop = new Properties();
			prop.load(input);
			browser = prop.getProperty("browser");
			url = prop.getProperty("url");
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	public static WebDriver init() {
		readConfig();
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			}else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
