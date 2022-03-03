package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;



public class Base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver InitilizeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		//String browserName= System.getProperty("browser");
		String browserName=prop.getProperty("browser");

		if(browserName.contains("chrome")) {
			//execute chrome driver
			System.setProperty("webdriver.chrome.driver", "D:\\Chrome driver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);

		}
		else if(browserName.equals("firefox")) {
			//execute firefox driver
			System.setProperty("webdriver.chrome.driver", "D:\\Chrome driver\\geckodriver.exe");
			driver= new FirefoxDriver();

		}
		else if(browserName.equals("IE")) {
			//execute IE driver

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public String getScreenshotPath(String TestcasName, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile= System.getProperty("user.dir")+"\\reports\\"+TestcasName+".png";
		FileUtils.copyFile(source, new File(destinationFile));

		return destinationFile;

	}

}
