package Academy;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import junit.framework.Assert;
import resource.LandingPage;
import resource.LoginPage;

import org.testng.AssertJUnit;

import java.io.IOException;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class HomePage extends base {
	
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialization() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialize");
		log.info("Its Initializzeeeeeee");

	}

	@Test(dataProvider = "getData")
	public void BasePagenavigation(String Username, String Password) throws IOException, InterruptedException {

		driver.get(prop.getProperty("url"));
		log.info("Navigate to login page");

		 LandingPage lp = new LandingPage(driver);
		 lp.getLogin().click();
		 log.info("clicked on login button");
		 
		LoginPage lop = new LoginPage(driver);
		lop.getemail().sendKeys(Username);
		lop.getpassword().sendKeys(Password);
		lop.getlogin().click();
		Assert.assertEquals(lop.getalert().getText(), "Invalid email or password.");
		log.info("Successfully validated alert message");
		System.out.println("Test completed");
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][2];
		data[0][0] = "Dhvani@gmail.com";
		data[0][1] = "hello";

		data[1][0] = "Vivek@gmail.com";
		data[1][1] = "Vivek";
		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}

}
