package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='user_email']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='user_password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@name='commit']")
	WebElement loginButton;

	@FindBy(xpath = "//a[contains(text(),'Forgot')]")
	WebElement forgotPassword;
	
	//Objects at the top, methods a the bottom
	public WebElement getUsername() {
		return username;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getButton() {
		return loginButton;
	}

	public WebElement forgotPassword() {
		return forgotPassword;
	}
	
}