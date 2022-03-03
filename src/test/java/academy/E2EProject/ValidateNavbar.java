package academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class ValidateNavbar extends Base {
	private static Logger log=LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initilaize() throws IOException {
		driver =InitilizeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test
	public void ValidateNavigation() throws IOException {

		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.Navbaritem().isDisplayed());
		log.info("Navigation bar is Displayed");
		//Assert.assertEquals(lp.GetTitle().getText(), "FEATURED COURSES");
		
		
	}
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
}
