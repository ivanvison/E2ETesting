package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateNavBar extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	//log.info("Driver is initialized");
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializerDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Website" + prop.getProperty("url"));
	}
	
	@Test
	public void validateApplicationNavBar() {
		//Access method of a class: Inheritance or creating an object to the class and invoke method
		LandingPage l = new LandingPage(driver);

		//compare elements from the browser with expected result
		Assert.assertTrue(l.getNavBar().isDisplayed());
		log.info("Validation of the NavBar presence");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		log.info("Quitting Browser");
	}

}
