package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	private By email = By.cssSelector("[id='email']");
	private By password = By.cssSelector("[type='password']");
	private By loginButton = By.cssSelector("[type='submit']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Objects at the top, methods a the bottom
	public WebElement getUsername() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getButton() {
		return driver.findElement(loginButton);
	}

	
}