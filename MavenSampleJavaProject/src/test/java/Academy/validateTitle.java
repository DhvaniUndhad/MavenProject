package Academy;

import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resource.LandingPage;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class validateTitle extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialization() throws IOException {
		driver = initializeDriver();
		log.info("Driver initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}

	@Test
	
	
	public void ValidateAppTitle() {

		LandingPage lanp = new LandingPage(driver);
		Assert.assertEquals(lanp.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validate title");
		System.out.println("title varified successfully");
	}

	@AfterTest
	public void teardown() {

		driver.close();
		driver = null;

	}

}
