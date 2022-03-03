package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
	
	public WebDriver driver;
	
	private By Login=By.xpath("//a//span[text()='Login']");
	private By title = By.xpath("//*[text()='Featured Courses']");
	private By navbar = By.xpath("//a[contains(text(),'Contact')]");
	private By forgetpassword = By.cssSelector("a[href*='password/new']");
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public LoginPage GetLogin() {
		 driver.findElement(Login).click();
		 LoginPage sip = new LoginPage(driver);
		 return sip;
		
		 
	}
	
	public WebElement GetTitle() {
		return driver.findElement(title);
	}
	
	public WebElement Navbaritem() {
		return driver.findElement(navbar);
	}
	
	public WebElement Forgetpass() {
		return   driver.findElement(forgetpassword);
		 
	}


}
