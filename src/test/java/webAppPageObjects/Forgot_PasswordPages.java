package webAppPageObjects;

import org.openqa.selenium.By;

public class Forgot_PasswordPages {
	
	
	public static By Forgotpassword = By.xpath("//A[@class='forgot_password-link'][text()='Forgot password?']");
	public static By Email = By.xpath("//INPUT[@id='user_name']");
	public static By Verification_button = By.xpath("//BUTTON[@class='login_button'][text()='Send verification link']");
	public static By Cancel = By.xpath("//A[@class='forgot_password'][text()='Cancel']");
	public static By error1 = By.xpath("//P[@class='Log_err'][text()='Please enter email']");
	public static By error2 = By.xpath("//P[@class='Log_err'][text()='Please enter Valid Email']");
	

}
