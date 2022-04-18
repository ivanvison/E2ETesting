package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver;
	public Properties prop;
	
	@SuppressWarnings("deprecation")
	public WebDriver initializerDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Ivan\\Desktop\\QA Path\\Projects-Eclipse\\E2EIVTEST\\IVE2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println("Browser to be used: " + browserName);
		String url = prop.getProperty("url");
		System.out.println("URL to be used: " + url);
		
		//IMPORTANT: == can't be used when comparing with an element of a property 
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("pathToDrivers")+"chromeDriver.exe");
			driver = new ChromeDriver(); // Open Chrome Browser
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("pathToDrivers")+"geckoDriver.exe");
			driver = new FirefoxDriver(); // Open Firefox Browser
		}
		else if(browserName.equals("edge")) {
			System.setProperty("webdriver.msedge.driver", prop.getProperty("pathToDrivers")+"msedgeDriver.exe");
			driver = new EdgeDriver(); // Open Edge Browser
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
}
