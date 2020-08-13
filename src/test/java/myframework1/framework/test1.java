package myframework1.framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import myframework1.framework.base;
import resources.loginPage;
import resources.loginPage2;


public class test1 extends base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@Test(dataProvider = "getData")
	public void logingInTest(String username, String password) throws IOException, InterruptedException {
		loginPage lp = new loginPage(driver);
		lp.login().click();
		loginPage2 logp = new loginPage2(driver);
		logp.Login().sendKeys(username);
		logp.Password().sendKeys(password);
		logp.SighInButton().click();
		log.info("tried logging-in");
	}

	@BeforeMethod
	public void browseropen() throws IOException {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
		log.info("driver started");
	}

	@AfterMethod
	public void browserClose() {
		driver.quit();
		log.info("driver quit");

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];

		data[0][0] = "hahaha@haha";
		data[0][1] = "abcdef";
		data[1][0] = "hehehe@hehe";
		data[1][1] = "qwerty";

		return data;
	}

}