package myframework1.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeBrowser() throws IOException {
		prop = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(file);
		//String browser = System.getProperty("browser");
		String browser = prop.getProperty("browser");

		if (browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			ChromeOptions options =new ChromeOptions();
			if (browser.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		}

		return driver;
	}

    public String getScreenShot(String testName, WebDriver driver) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File ss = ts.getScreenshotAs(OutputType.FILE);
	String destFile = System.getProperty("user.dir")+"\\reports2\\"+testName+".png";
	FileUtils.copyFile(ss, new File(destFile));
	return destFile;
	
	
}
}

