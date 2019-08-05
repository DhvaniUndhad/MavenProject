package Academy;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Academy.HomePage;

public class base {
	public  WebDriver driver;
	public Properties prop = new Properties();
	public static Logger log = LogManager.getLogger(HomePage.class.getName());

	public WebDriver initializeDriver() throws IOException {

		FileInputStream fis = new FileInputStream(
				"/Users/Shared/Jenkins/.jenkins/MavenSampleJavaProject/src/main/java/resource/data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"/Users/vivekbhalala/Downloads/selenium-java-3.141.59/chromedriver");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/vivekbhalala/Downloads/selenium-java-3.141.59/geckodriver");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {

			// systemProperty for IE
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
	
	public void getScreenShot() throws IOException{
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/vivekbhalala/Desktop/test/screenshot.png"));
	}										
	
	
	

}
