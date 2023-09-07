package PageObjects;

import org.openqa.selenium.By;

public class LearnersPage {
	public static By Learners_Nav_Menu = By.xpath("//span[contains(text(),'Manage Learners')]");
	public static By Add_New_Learner = By.xpath("//span[contains(text(),'Add New Learner')]");
	public static By Learner_name = By.name("name");
	public static By Employee_ID = By.name("emp_id");
	public static By Learner_Email = By.name("emailId");
	public static By Mobile = By.xpath("//input[@type='tel']");
	public static By Learner_HireDate = By.xpath("//input[@placeholder='Enter Hire Date']");
	public static By today= By.xpath("//a[normalize-space()='Today']");

	public static By Learner_Department = By.xpath("//div[contains(text(),'Select department')]");
	public static By Learner_Designation = By.xpath("//div[contains(text(),'Select role')]");
	public static By Learner_Country = By.xpath("//div[contains(text(),'Select country')]");
	public static By Learner_State = By.xpath("//div[contains(text(),'Select state')]");
	public static By Learner_Bio = By.name("bio");
	public static By Add_user_Button = By.xpath("//span[contains(text(),'Add User')]");
	public static By update_Button = By.xpath("//button[@type='submit']");
	public static By Cancel = By.xpath("//button[contains(text(),'Cancel')]");

	// errors
	public static By errormessage = By.xpath("//div[@class='form_error-message mt-25']");

//search
	public static By Search_learner = By.xpath("//input[@placeholder='Search']");

	public static By search_result = By.xpath("//div[@class='sc-dIfARi kNNa-dS rdt_TableBody']");

	// view
	public static By view = By.id("row-0");
	public static By No_data = By.xpath("//div[contains(text(),'There are no records to display')]");
	// different tabs
	public static By Learner_Deatils_Name = By.className("ml-learners-details__name");
	public static By Learner_Deatils_Email = By.className("ml-learners-details__email");

	public static By Learner_Deatils_Squad_tab = By.xpath("//p[contains(text(),'Squad')]");
	public static By Learner_Deatils_Challenges_tab = By.xpath("//p[contains(text(),'Challenges')]");
	public static By Learner_Deatils_LearnQuest_tab = By.xpath("//p[contains(text(),'Learn Quests')]");
	public static By Learner_Deatils_Details_tab = By.xpath("//p[contains(text(),'Details')]");

	public static By Edit_profile = By.xpath("//button[@type='button']//span[contains(text(),'Edit Profile')]");

	// scroll to view
	public static String locatorTypexpath = "xpath";
	public static String Manage_Learners = "//span[contains(text(),'Manage Learners')]";

	public static By CTA_Button = By.xpath("(//button[@type='button'])[3]");
	
	public static By Delete_Button = By.xpath("//div[@class='dropdown-menu show']//button[@role='menuitem'][normalize-space()='Delete']");
	public static By Delete_Yes = By
			.xpath("//button[@class='swal-button swal-button--confirm swal-button--danger'][text()='OK']");
	public static By Delete_cancel = By.xpath("//button[@class='swal-button swal-button--cancel'][text()='Cancel']");

	
	
	
}