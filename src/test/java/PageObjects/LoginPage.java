package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public static By username = By.name("email");
	public static By password = By.name("password");
	public static By LoginButton = By.xpath("//button[@type='submit']");
	public static By EmailError = By.className("Log_err");
	
	public static By Workspace = By.id("workspace_id");
	public static By Workspace_proceed = By.xpath("//button[text()='Proceed']");
	
	

	public LoginPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "email")
	WebElement textUsername;

	public void setUserName(String uname) {
		textUsername.sendKeys(uname);

	}

	public void setPassword(String pass) {
		textUsername.sendKeys(pass);

	}

}