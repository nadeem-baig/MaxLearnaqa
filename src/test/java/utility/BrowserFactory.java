package utility;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
		if (browserName.contentEquals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 1);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--remote-allow-origins=*");

			driver = new ChromeDriver(options);

		} else if (browserName.contentEquals("Firefox")) {
			
			 System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
			
			driver = new FirefoxDriver();

		} else if (browserName.contentEquals("IE")) {
			 System.setProperty("webdriver.ie.driver", "./drivers/IEDriverserver");
			driver = new InternetExplorerDriver();
		} else if (browserName.contentEquals("Edge")) {
			
			System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 1);
			EdgeOptions options = new EdgeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--remote-allow-origins=*");

			
			driver = new EdgeDriver(options);
		} 
		else {
			System.out.println("we do not support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(appURL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	
}
