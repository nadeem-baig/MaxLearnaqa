package PageObjects;

import org.openqa.selenium.By;

public class Admin_EditprofilePage {
	public static By Profile_button = By.xpath("(//img[@alt='avatar'])[1]");
	public static By Edit_Profile = By.xpath("//span[normalize-space()='Edit Profile']");
	public static By Edit_Button = By.xpath("(//BUTTON[@type='button'])[1]");
	public static By Description = By.xpath("//TEXTAREA[@id='data-name']");
	public static By Submit = By.xpath("//BUTTON[@type='submit']");
	public static By Status_view = By.xpath("(//span[@class='bdg_dng badge badge-success badge-pill'])[1]");
	public static By Admin_details = By.xpath("//div[@class='col-sm-6 p-0']");
	public static By Change_Password = By.xpath("(//BUTTON[@type='button'])[2]");
	public static By Current_Pass = By.xpath("//INPUT[@placeholder='Enter your password']");
	public static By New_Pass = By.xpath("//INPUT[@placeholder='Type new password here']");
	public static By ReEnter_New_Pass = By.xpath("//INPUT[@placeholder='Retype new password']");
	public static By Save = By.xpath("//BUTTON[@type='submit']");

}
