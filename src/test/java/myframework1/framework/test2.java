package myframework1.framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import myframework1.framework.base;
import resources.loginPage;


public class test2 extends base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@Test
	public void getTitle() throws IOException {
		loginPage lp = new loginPage(driver);
		Assert.assertEquals(lp.title().getText(), "FEATURED COURSE");
		log.info("text received");

	}

	@Test
	public void navigationBar() throws IOException {
		loginPage lp = new loginPage(driver);
		Assert.assertEquals(lp.navBar().isDisplayed(), true);
		log.info("navigation bar present");
	}
	
	@Test
	public void videoslink() throws IOException {
		loginPage lp = new loginPage(driver);
		lp.vidoeslink().click();
		log.info("link is present");
	}

	@AfterMethod
	public void browserClose(){
		driver.close();
		log.info("driver quit");
	}

	@BeforeMethod
	public void browseropen() throws IOException {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
		log.info("driver started");
	}
	
}
