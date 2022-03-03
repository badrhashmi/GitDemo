package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPassword {
	
	
	
	public WebDriver driver;
	
	By Email_Address= By.cssSelector("[id='user_email']");
	By Send_me_Instruction= By.cssSelector("[type='submit']");
	
	
	
	public ForgetPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
	}



	public WebElement EmailAd() {
		return driver.findElement(Email_Address);
	}
	
	public WebElement SendmeInstruc() {
		return driver.findElement(Send_me_Instruction);
	}

}
