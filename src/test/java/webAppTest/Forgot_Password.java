package webAppTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import webAppPageObjects.Forgot_PasswordPages;
import webAppPageObjects.LoginPageObjects;
import PageObjects.ToasterObject;


public class Forgot_Password extends BaseClassWebApp{
	
	
	@Test(priority = 0, groups = { "Regression", "SmokeTest" })
	public static void WorkspaceId_Valid() throws InterruptedException {
		logger = extent.createTest("verify valid WorkSpaceId", "Workspace Id");
		Thread.sleep(2000);
		driver.get(config.UserWebApp());
		Thread.sleep(3000);
		System.out.println("Enter the valid Workspace id");
		WebElement workspace = driver.findElement(LoginPageObjects.Workspace);
		workspace.sendKeys(excel.getDataSheetName("Login", 15,1));
		Thread.sleep(2000);
		WebElement proceed = driver.findElement(LoginPageObjects.Workspace_proceed);
		proceed.click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 1, groups = { "Regression"})
	public static void Forgotpassword_Empty() throws InterruptedException {
		logger = extent.createTest("verify Empty Email in Forgot Password", "Empty Email");
		Thread.sleep(2000);
		System.out.println("Click on Forgot password button");
		WebElement Forgotpassword_button = driver.findElement(Forgot_PasswordPages.Forgotpassword);
		Forgotpassword_button.click();
		Thread.sleep(2000);
		WebElement Verify = driver.findElement(Forgot_PasswordPages.Verification_button);
		Verify.click();
		Thread.sleep(2000);
		try {
			WebElement emailerror = driver.findElement(Forgot_PasswordPages.error1);
			emailerror.isDisplayed();
			logger.info("Error:" + emailerror.getText());
			String alert = emailerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please enter email");
		} catch (Exception e) {
			logger.info(e);
		}
	
	
}
	@Test(priority = 2, groups = { "Regression"})
	public static void Forgotpassword_invalid() throws InterruptedException {
		logger = extent.createTest("verify invalid Email in Forgot Password", "Invalid Email");
		Thread.sleep(2000);
		WebElement email = driver.findElement(Forgot_PasswordPages.Email);
		email.sendKeys("Test");
		Thread.sleep(2000);
		WebElement Verify = driver.findElement(Forgot_PasswordPages.Verification_button);
		Verify.click();
		Thread.sleep(2000);
		try {
			WebElement emailerror = driver.findElement(Forgot_PasswordPages.error2);
			emailerror.isDisplayed();
			logger.info("Error:" + emailerror.getText());
			String alert = emailerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please enter Valid Email");
		} catch (Exception e) {
			logger.info(e);
		}	
}
	@Test(priority = 3, groups = { "Regression"})
	public static void Forgotpassword_invalid_Learner() throws InterruptedException {
		logger = extent.createTest("verify invalid Learner in Forgot Password", "Invalid Learner");
		Thread.sleep(2000);
		WebElement email = driver.findElement(Forgot_PasswordPages.Email);
		email.clear();
		email.sendKeys("test@gmail.com");
		Thread.sleep(2000);
		WebElement Verify = driver.findElement(Forgot_PasswordPages.Verification_button);
		Verify.click();
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
	
	@Test(priority = 4, groups = { "Regression"})
	public static void Forgotpassword_Cancel() throws InterruptedException {
		logger = extent.createTest("verify Cancel button in Forgot Password", "Cancel");
		Thread.sleep(2000);
		WebElement Cancel = driver.findElement(Forgot_PasswordPages.Cancel);
		Cancel.click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 5, groups = { "Regression","SmokeTest"})
	public static void Forgotpassword_Valid() throws InterruptedException {
		logger = extent.createTest("verify Valid Forgot Password", "Valid Forgot password");
		Thread.sleep(2000);
		driver.get(config.Forgotpass());

		Thread.sleep(3000);

		WebElement email = driver.findElement(Forgot_PasswordPages.Email);
		email.sendKeys(excel.getDataSheetName("Login", 10, 1));
		Thread.sleep(2000);
		WebElement Verify = driver.findElement(Forgot_PasswordPages.Verification_button);
		Verify.click();
		Thread.sleep(2000);
		
}

}
