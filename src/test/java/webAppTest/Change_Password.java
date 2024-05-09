package webAppTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.ToasterObject;
import webAppPageObjects.MyProfileObjects;

public class Change_Password extends BaseClassWebApp{
	
	
	@Test(priority = 1, groups = {"Regression"})
	public static void Old_UserPassword_required() throws InterruptedException {
		logger = extent.createTest("Old User Password", "old User Password required");
		logger.log(Status.INFO, "In old User Password Required");
		Thread.sleep(1000);
		driver.get(config.Reset());
		Thread.sleep(3000);
		WebElement Old_pass = driver.findElement(MyProfileObjects.Old_pass);
		Old_pass.click();
		Thread.sleep(2000);
		System.out.println("Old password button clicked");
		WebElement Submit = driver.findElement(MyProfileObjects.Submit);
		Submit.click();
		Thread.sleep(3000);
		
		try {
			WebElement emailerror = driver.findElement(MyProfileObjects.error);
			emailerror.isDisplayed();
			logger.info("Error:" + emailerror.getText());
			String alert = emailerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "old password cant be empty");
		} catch (Exception e) {
			logger.info(e);
		}
	}
	
	@Test(priority = 2, groups = {"Regression"})
	public static void New_UserPassword_required() throws InterruptedException {
		logger = extent.createTest("New User Password", "New User Password required");
		logger.log(Status.INFO, "In New User Password Required");
		Thread.sleep(1000);
		WebElement Old_pass = driver.findElement(MyProfileObjects.Old_pass);
		Old_pass.click();
		Old_pass.sendKeys("test");
		Thread.sleep(2000);
		System.out.println("Old password button clicked and passed value");
		WebElement New_pass = driver.findElement(MyProfileObjects.New_pass);
		New_pass.click();
		WebElement Submit = driver.findElement(MyProfileObjects.Submit);
		Submit.click();
		Thread.sleep(3000);
		
		try {
			WebElement emailerror = driver.findElement(MyProfileObjects.error);
			emailerror.isDisplayed();
			logger.info("Error:" + emailerror.getText());
			String alert = emailerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "New Password is required");
		} catch (Exception e) {
			logger.info(e);
		}
	}
	
	@Test(priority = 3, groups = {"Regression"})
	public static void New_UserPassword_short() throws InterruptedException {
		logger = extent.createTest("New User Password", "New User Password Short");
		logger.log(Status.INFO, "In New User Password Short");
		Thread.sleep(1000);
		WebElement New_pass = driver.findElement(MyProfileObjects.New_pass);
		New_pass.click();
		New_pass.sendKeys("test");
		Thread.sleep(3000);
		
		try {
			WebElement emailerror = driver.findElement(MyProfileObjects.error);
			emailerror.isDisplayed();
			logger.info("Error:" + emailerror.getText());
			String alert = emailerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Password is Short!");
		} catch (Exception e) {
			logger.info(e);
		}
	}
	
	@Test(priority = 4, groups = {"Regression"})
	public static void New_UserPassword_invalid_format() throws InterruptedException {
		logger = extent.createTest("New User Password", "New User Password invalid format");
		logger.log(Status.INFO, "In New User Password invalid");
		Thread.sleep(1000);
		WebElement New_pass = driver.findElement(MyProfileObjects.New_pass);
		New_pass.click();
		New_pass.sendKeys("maxlearn");
		Thread.sleep(3000);
		
		try {
			WebElement emailerror = driver.findElement(MyProfileObjects.error);
			emailerror.isDisplayed();
			logger.info("Error:" + emailerror.getText());
			String alert = emailerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Password must contain atleast 1 UpperCase letter, 1 LowerCase letter, 1 Special Character, 1 Number and should be between 8-20 characters long");
		} catch (Exception e) {
			logger.info(e);
		}
	}
	
	@Test(priority = 5, groups = { "Regression"})
	public static void confirm_UserPassword_empty() throws InterruptedException {
		logger = extent.createTest("Confirm User Password", "Confirm User Password Short");
		logger.log(Status.INFO, "In Confirm User Password Short");
		Thread.sleep(1000);
		WebElement New_pass = driver.findElement(MyProfileObjects.New_pass);
		New_pass.click();
		New_pass.sendKeys(Keys.chord(Keys.COMMAND,"a", Keys.DELETE));
		Thread.sleep(1000);
		New_pass.sendKeys(excel.getDataSheetName("Login", 10, 2));
		Thread.sleep(2000);
		WebElement Confirm_pass = driver.findElement(MyProfileObjects.Confirm_pass);
		Confirm_pass.click();
		Thread.sleep(2000);
		
	
		try {
			WebElement emailerror = driver.findElement(MyProfileObjects.error);
			emailerror.isDisplayed();
			logger.info("Error:" + emailerror.getText());
			String alert = emailerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Confirm Password cant be empty");
		} catch (Exception e) {
			logger.info(e);
		}
	}
	
	
	
	@Test(priority = 6, groups = { "Regression"})
	public static void confirm_UserPassword_invalid() throws InterruptedException {
		logger = extent.createTest("Confirm User Password", "Confirm User Password Short");
		logger.log(Status.INFO, "In Confirm User Password Short");
		Thread.sleep(1000);
		WebElement New_pass = driver.findElement(MyProfileObjects.New_pass);
		New_pass.click();
		New_pass.sendKeys(Keys.chord(Keys.COMMAND,"a", Keys.DELETE));
		Thread.sleep(1000);
		New_pass.sendKeys(excel.getDataSheetName("Login", 10, 2));
		Thread.sleep(2000);
		WebElement Confirm_pass = driver.findElement(MyProfileObjects.Confirm_pass);
		Confirm_pass.click();
		Thread.sleep(2000);
		Confirm_pass.sendKeys("maxlearn");
		Thread.sleep(1000);
	
		try {
			WebElement emailerror = driver.findElement(MyProfileObjects.error);
			emailerror.isDisplayed();
			logger.info("Error:" + emailerror.getText());
			String alert = emailerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Confirm password should be same as new password");
		} catch (Exception e) {
			logger.info(e);
		}
		
	}
		
		@Test(priority = 7, groups = { "Regression"})
		public static void Old_NewPassword_invalid() throws InterruptedException {
			logger = extent.createTest("Old & New User Password", "Old & New User Password same");
			logger.log(Status.INFO, "In Old & New User Password same");
			Thread.sleep(1000);
			
			WebElement Old_pass = driver.findElement(MyProfileObjects.Old_pass);
			Old_pass.click();
			Old_pass.sendKeys(Keys.chord(Keys.COMMAND,"a", Keys.DELETE));
			Thread.sleep(1000);
			Old_pass.sendKeys(excel.getDataSheetName("Login", 10, 2));
			Thread.sleep(2000);
			
			WebElement New_pass = driver.findElement(MyProfileObjects.New_pass);
			New_pass.click();
			New_pass.sendKeys(Keys.chord(Keys.COMMAND,"a", Keys.DELETE));
			Thread.sleep(1000);
			New_pass.sendKeys(excel.getDataSheetName("Login", 10, 2));
			Thread.sleep(2000);
			WebElement Confirm_pass = driver.findElement(MyProfileObjects.Confirm_pass);
			Confirm_pass.click();
			Thread.sleep(2000);
			Confirm_pass.sendKeys("maxlearn");
			Thread.sleep(1000);
		
			try {
				WebElement emailerror = driver.findElement(MyProfileObjects.error);
				emailerror.isDisplayed();
				logger.info("Error:" + emailerror.getText());
				String alert = emailerror.getText();
				System.out.println("Message - " + alert);
				Assert.assertEquals(alert, "Old Password and new password cannot be same");
			} catch (Exception e) {
				logger.info(e);
			}
		
	}
		
		@Test(priority = 8, groups = { "Regression"})
		public static void ChangePassword_valid() throws InterruptedException {
			logger = extent.createTest("Change User Password", "Change User Password same");
			logger.log(Status.INFO, "In Change User Password same");
			Thread.sleep(1000);
			
			WebElement Old_pass = driver.findElement(MyProfileObjects.Old_pass);
			Old_pass.click();
			Old_pass.sendKeys(Keys.chord(Keys.COMMAND,"a", Keys.DELETE));
			Thread.sleep(1000);
			Old_pass.sendKeys("Maxlearn@1");
			Thread.sleep(2000);
			
			WebElement New_pass = driver.findElement(MyProfileObjects.New_pass);
			New_pass.click();
			New_pass.sendKeys(Keys.chord(Keys.COMMAND,"a", Keys.DELETE));
			Thread.sleep(1000);
			New_pass.sendKeys("Maxlearn@1");
			Thread.sleep(2000);
			
			WebElement Confirm_pass = driver.findElement(MyProfileObjects.Confirm_pass);
			Confirm_pass.click();
			Thread.sleep(2000);
			Confirm_pass.sendKeys(Keys.chord(Keys.COMMAND,"a", Keys.DELETE));
			Thread.sleep(1000);
			Confirm_pass.sendKeys("Maxlearn@1");
			Thread.sleep(1000);
			
			WebElement Submit = driver.findElement(MyProfileObjects.Submit);
			Submit.click();
			Thread.sleep(3000);

		
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
