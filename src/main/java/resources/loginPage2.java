package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage2 {

	public WebDriver driver;

	private By login = By.id("user_email");
	private By password = By.id("user_password");
	private By sighInButton = By.xpath("//input[@name='commit']");

	public loginPage2(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
	}

	public WebElement Login() {
		return driver.findElement(login);
	}

	public WebElement Password() {
		return driver.findElement(password);
	}

	public WebElement SighInButton() {
		return driver.findElement(sighInButton);
	}
}
