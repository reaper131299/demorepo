package resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

	public WebDriver driver;

	private By login = By.xpath("//span[text()='Login']");
	private By title = By.xpath("//div[@class='text-center']/h2");
	private By navBar = By.xpath("//div[@class='container']/nav");
	private By popup = By.xpath("//button[text()='NO THANKS']");
	private By videoslink = By.linkText("VIDEOS");

	public loginPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
	}

	public WebElement login() {
		return driver.findElement(login);
	}

	public WebElement title() {
		return driver.findElement(title);
	}

	public WebElement navBar() {
		return driver.findElement(navBar);
	}
	
	public int popupsize() {
		return driver.findElements(popup).size();
	}
	
	public WebElement popup() {
		return driver.findElement(popup);
	}

	public WebElement vidoeslink() {
		return driver.findElement(videoslink);
	}
}
