package resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By emailId = By.id("user_email");
	By password = By.cssSelector("input[type='password']");
	By login = By.cssSelector("input[type='submit']");
	By alert = By.cssSelector("div[class='alert alert-danger']");

	public WebElement getemail() {
		return driver.findElement(emailId);
	}

	public WebElement getpassword() {
		return driver.findElement(password);
	}

	public WebElement getlogin() {
		return driver.findElement(login);
	}

	public WebElement getalert() {
		return driver.findElement(alert);
	}

}
