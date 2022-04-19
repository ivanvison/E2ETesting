package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	private By signIn = By.xpath("//a[contains(text(),'Login')]");
	private By h2MainTitle = By.xpath("//span[contains(text(),'Academy')]");
	private By h2Title = By.xpath("//h2[contains(text(),'Featured')]");
	private By navBar = By.xpath("//div[@class='navbar-collapse collapse clearfix']");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	//Objects at the top, methods a the bottom
	public LoginPage getLogin() {
		//return signIn;
		driver.findElement(signIn).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	
	public WebElement getTitle() {
		return driver.findElement(h2Title);
	}
	
	public WebElement getMainTitle() {
		return driver.findElement(h2MainTitle);
	}

	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
}
