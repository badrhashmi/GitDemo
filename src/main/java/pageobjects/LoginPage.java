package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	
	
	public WebDriver driver;
	
	By Email=By.id("user_email");
	By Password=By.id("user_password");
	By Submit=By.cssSelector("[value='Log In']");
	By forgetpassword = By.cssSelector("[href*='password/new']");
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public WebElement GetEmail() {
		return driver.findElement(Email);
	}
	
	public WebElement GetPassword() {
		return driver.findElement(Password);
	}
	
	public WebElement ClickSbumit() {
		return driver.findElement(Submit);
	}

	
	public ForgetPassword forgetpass() {
		driver.findElement(forgetpassword).click();
		ForgetPassword fp= new ForgetPassword(driver);
		return fp;
		
	}
}
