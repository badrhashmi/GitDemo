package academy.E2EProject;

import java.io.IOException;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class Validatetext extends Base {
	private static Logger log=LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initilaize() throws IOException {
		driver =InitilizeDriver();
		log.info("Driver is initialized");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Homepage");
		
		
	}
	
	@Test
	public void ValidateText() throws IOException {
		LandingPage lp = new LandingPage(driver);
		Assert.assertEquals(lp.GetTitle().getText(), "FEATURED COURSES123");
		log.info("Successfully Navigated Text messages");
		
	}
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
}
