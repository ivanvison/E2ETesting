package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class validateForgotPassword extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	//log.info("Driver is initialized");	
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializerDriver();
		log.info("Driver is initialized");
	}
	
	@Test
	public void ForgotPasswordValidation() throws IOException, InterruptedException {	
		//Access method of a class: Inheritance or creating an object to the class and invoke method
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Website" + prop.getProperty("url"));
		
		LandingPage l = new LandingPage(driver);	
		
		//LoginPage
		LoginPage lp = l.getLogin();
		log.info("Going to Log In section");
		Thread.sleep(5000);
		ForgotPassword fp = new ForgotPassword(driver);
		fp.resetLink().click();
		Thread.sleep(2000);
		log.info("Clicked Forgot Password");
		fp.getEmail().sendKeys("seleniumtest@rahulshettyacademy.com");
		log.info("Wrote Email");
		fp.sendMeInstructionsButton().click();
		log.info("Triggered Forgot Password.");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		log.info("Quitting Browser");
	}
	
}
