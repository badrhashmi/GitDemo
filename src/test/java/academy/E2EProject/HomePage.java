package academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import junit.framework.Assert;
import pageobjects.ForgetPassword;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	private static Logger log=LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	
	
	@BeforeTest
	public void initilaize() throws IOException {
		driver =InitilizeDriver();
		driver.manage().window().maximize();
		
		
	}
	
	@Test(dataProvider="getData")
	public void HomePageNavigation(String username, String password) throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		Assert.assertEquals(lp.GetTitle().getText(), "FEATURED COURSES");
		LoginPage sip=lp.GetLogin();
		
		
		//LoginPage sip = new LoginPage(driver);
		sip.GetEmail().sendKeys(username);
		sip.GetPassword().sendKeys(password);
		//System.out.println(text);
		sip.ClickSbumit().click();
		ForgetPassword fp=sip.forgetpass();
		fp.EmailAd().sendKeys("abc");
		fp.SendmeInstruc().click();
		
		System.out.println(System.getProperty("user.dir"));
		
	}
	
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2]; 
		data[0][0]="Restricteduser@gmail.com";
		data[0][1]="12345";
		//data[0][2]="Restricteduser@gmail.com";
		
//		data[1][0]="nonrestricteduser@gmail.com";
//		data[1][1]="12345";
//		data[1][2]="nonrestricteduser@gmail.com";
		
		 return data;
	}
	
	

}
