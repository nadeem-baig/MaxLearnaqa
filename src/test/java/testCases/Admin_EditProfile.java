package testCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.Admin_EditprofilePage;
import PageObjects.ToasterObject;
import utility.Wrapper;

public class Admin_EditProfile extends BaseClass {
	
	@Test(priority = 1,groups = { "Regression","SmokeTest" })
	public void Admin_Edit() throws Exception {
		logger = extent.createTest("Admin EditProfile", "verify Edit Profile");
		logger.log(Status.INFO, "Admin Edit Profile");
		Thread.sleep(3000);
		WebElement Profile = driver.findElement(Admin_EditprofilePage.Profile_button);
		Profile.click();
		Thread.sleep(2000);
		WebElement Edit_Profile = driver.findElement(Admin_EditprofilePage.Edit_Profile);
		Edit_Profile.click();
		Thread.sleep(2000);
		WebElement Edit = driver.findElement(Admin_EditprofilePage.Edit_Button);
		Edit.click();
		Thread.sleep(2000);
		WebElement Description = driver.findElement(Admin_EditprofilePage.Description);
		Description.click();
		Description.clear();
		Description.sendKeys("BIO---- " + Wrapper.AlphaNumericString(15));
		Thread.sleep(2000);
		WebElement Submit = driver.findElement(Admin_EditprofilePage.Submit);
		Submit.click();
		Thread.sleep(2000);
				
		try {
			WebElement Toaster = driver.findElement(ToasterObject.toaster);
			Toaster.isDisplayed();
			logger.info("Error:" + Toaster.getText());
			String alert = Toaster.getText();
			System.out.println("Toaster Message - " + alert);
		} catch (Exception e) {
			logger.info(e);
		}	

	}
	
	@Test(priority = 2,groups = { "Regression" })
	public void Profile_View() throws Exception {
		logger = extent.createTest("Admin Profile", "View Admin Profile");
		logger.log(Status.INFO, "Admin View Profile");
		Thread.sleep(3000);
		WebElement Profile_Status = driver.findElement(Admin_EditprofilePage.Status_view);
		Profile_Status.isDisplayed();
		String Message1 = Profile_Status.getText();
		System.out.println("Text - " + Message1);
		logger.log(Status.INFO, Message1);
		
		WebElement Admin_Details = driver.findElement(Admin_EditprofilePage.Admin_details);
		Admin_Details.isDisplayed();
		String Message11 = Admin_Details.getText();
		System.out.println("Text - " + Message11);
		logger.log(Status.INFO, Message11);
		
	}
	


	@Test(priority = 3,groups = { "Regression","SmokeTest" })
	public void Change_Password() throws Exception {
		logger = extent.createTest("Admin Change Password", "verify Change Password");
		logger.log(Status.INFO, "Admin Change Password");
		Thread.sleep(5000);
		driver.get("https://admin.maxlearn.com/profileview");
		Thread.sleep(3000);
		WebElement Change_Pass = driver.findElement(Admin_EditprofilePage.Change_Password);
		Change_Pass.click();
		Thread.sleep(2000);
		WebElement Old_Pass = driver.findElement(Admin_EditprofilePage.Current_Pass);
		Old_Pass.click();
		Old_Pass.sendKeys("Maxlearn@1");
		Thread.sleep(2000);
		WebElement New_Pass = driver.findElement(Admin_EditprofilePage.New_Pass);
		New_Pass.click();
		New_Pass.sendKeys("Maxlearn@1");
		Thread.sleep(2000);
		WebElement RetypeNew_Pass = driver.findElement(Admin_EditprofilePage.ReEnter_New_Pass);
		RetypeNew_Pass.click();
		RetypeNew_Pass.sendKeys("Maxlearn@1");
		Thread.sleep(2000);		
		WebElement Submit = driver.findElement(Admin_EditprofilePage.Save);
		Submit.click();
		Thread.sleep(2000);
				
		try {
			WebElement Toaster = driver.findElement(ToasterObject.toaster);
			Toaster.isDisplayed();
			logger.info("Error:" + Toaster.getText());
			String alert = Toaster.getText();
			System.out.println("Toaster Message - " + alert);
		} catch (Exception e) {
			logger.info(e);
		}	

	}




	

	


}
