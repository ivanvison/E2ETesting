package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(),'NO THANKS')]")
	WebElement closePopup;
	
	@FindBy(xpath = "//span[contains(text(),'Login')]")
	WebElement signIn;
	
	@FindBy(css = "div[class='text-center'] h2")
	WebElement h2Title;
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']")
	WebElement navBar;
	
	//Objects at the top, methods a the bottom
	public WebElement closePopup() {
		return closePopup;
	}
	
	public WebElement getLogin() {
		return signIn;
	}
	
	public WebElement getTitle() {
		return h2Title;
	}

	public WebElement getNavBar() {
		return navBar;
	}
}
