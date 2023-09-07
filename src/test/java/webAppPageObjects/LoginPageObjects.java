package webAppPageObjects;

import org.openqa.selenium.By;

public class LoginPageObjects {

	public static By email=By.id("user_name");
	public static By password=By.name("password");
	public static By LoginButton=By.xpath("//button[@class='login_button']");
	public static By error=By.className("Log_err");
	public static By popup_error = By.id("swal2-html-container");
	public static By Workspace = By.id("workspace_id");
	public static By Workspace_proceed = By.xpath("//button[@class='login_button'][text()='Proceed']");
	public static By invalid_model= By.id("swal2-html-container");
	
	public static By OK_popupclose = By.xpath("//button[normalize-space()='OK']");
	//span[normalize-space()='session expired']
}
