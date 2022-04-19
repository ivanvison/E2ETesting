package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ForgotPassword {

	public WebDriver driver;
	
	private By resetPassword = By.cssSelector("[href*='forgot_password']");
	private By email = By.xpath("//input[@id='email']");
	private By sendMeInstructionsButton = By.xpath("//input[@type='submit']");
	
	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement resetLink() {
		return driver.findElement(resetPassword);
	}
	
	//Objects at the top, methods a the bottom
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement sendMeInstructionsButton() {
		return driver.findElement(sendMeInstructionsButton);
	}


}