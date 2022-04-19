//File created to troubleshoot L4J issue.
package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class UnicornValidationTest extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(UnicornValidationTest.class.getName());
	//log.info("Driver is initialized");
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializerDriver();
		log.info("Driver is initialized");
		
		//driver.get(prop.getProperty("url"));
		log.info("Navigated to Website " + prop.getProperty("url"));
	}
		
	@Test
	public void validateUnicornTest()  {

		Assert.assertTrue(true);
		log.debug("False Statement");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		//log.info("Quitting Browser");
	}
}
