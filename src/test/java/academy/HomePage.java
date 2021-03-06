package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	//log.info("Driver is initialized");	
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializerDriver();
		log.info("Driver is initialized");
	}
	
	@Test(dataProvider="getData")
	public void ValidateLoginSessions(String DataSet, String Username, String Password, String Text) throws IOException {	
		//Access method of a class: Inheritance or creating an object to the class and invoke method
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Website" + prop.getProperty("url"));
		
		LandingPage l = new LandingPage(driver);	
		
		//LoginPage
		LoginPage lp = l.getLogin();
		log.info("Going to Log In section");
		log.info(DataSet);
		lp.getUsername().sendKeys(Username);
		log.info("Inserted Username");
		lp.getPassword().sendKeys(Password);
		log.info("Inserted Password");
		lp.getButton().click();
		log.info("Clicked Submit Button");
		log.info(Text);
		
	}
	
	@AfterTest
	public void tearDown() {
		log.info("Quitting Browser");
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() {
		//Row stands for how many different data type test should run. This example is 2
		//Column stands for values per each test case
		//IMPORTANT: Object creation is the actual amount of rows, not the index. 
		Object[][] data = new Object[1][4];
		
		//0 row
		data[0][0] = "First Set";
		data[0][1] = "nonrestricteduser@amazingqa.com";
		data[0][2] = "amazing";
		data[0][3] = "Non Restricted User";
		
		//1 row
		//data[1][0] = "Second Set";
		//data[1][1] = "restricteduser@amazingqa.com";
		//data[1][2] = "amazingNOT";
		//data[1][3] = "Restricted User";
		
		return data;
	}
}
