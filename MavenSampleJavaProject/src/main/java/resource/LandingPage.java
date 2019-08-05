package resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	By signIn = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector(".text-center>h2");
	By NavBar = By.xpath("//nav[@class='navbar-collapse collapse']");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	

	public WebElement getLogin() {
		return driver.findElement(signIn);
	}

	public WebElement getNavigationBar() {
		return driver.findElement(NavBar);

	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
}
