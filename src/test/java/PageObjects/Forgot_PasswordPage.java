package PageObjects;

import org.openqa.selenium.By;

public class Forgot_PasswordPage {
	
	public static By Forgotpassword = By.xpath("//A[@class='frgt_pwdtxt'][text()='Forgot Password?']");
	public static By Email = By.xpath("//INPUT[@placeholder='Email ID']");
	public static By Verification_button = By.xpath("//SPAN[@class='mr-50'][text()='Send Verification Link']");
	public static By Cancel = By.xpath("//P[@class='canc_txt'][text()='Cancel']");
	public static By error1 = By.xpath("//P[@class='Log_err'][text()='Please enter Email']");
	public static By error2 = By.xpath("//P[@class='Log_err'][text()='Please enter Valid Email']");
	





	

}
