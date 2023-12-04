package testCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.Permission_Setting_Pages;
import PageObjects.ToasterObject;

public class Permission_Settings extends BaseClass {
	

	@Test(priority = 1,groups = { "Regression","SmokeTest" })
	public void Admin_Permission_Setting_status() throws Exception {
		logger = extent.createTest("Admin permission setting Status", "verify Admin permission setting Status");
		logger.log(Status.INFO, "Admin permission setting Status");
		driver.get(config.Permissions());
		Thread.sleep(3000);
		WebElement Status = driver.findElement(Permission_Setting_Pages.Admin_Toggle);
		Status.click();
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
	@Test(priority = 2,groups = { "Regression","SmokeTest" })
	public void Admin_Permission_Settings() throws Exception {
		logger = extent.createTest("Admin permission setting ", "verify Admin permission settings");
		logger.log(Status.INFO, "Admin permission setting ");
		Thread.sleep(3000);
		WebElement Settings = driver.findElement(Permission_Setting_Pages.Admin_check);
		Settings.click();
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
	
	@Test(priority = 3,groups = { "Regression","SmokeTest" })
	public void Creator_Permission_Setting_status() throws Exception {
		logger = extent.createTest("Creator permission setting Status", "verify Creator permission setting Status");
		logger.log(Status.INFO, "Creator permission setting Status");
		driver.get(config.Permissions());
		Thread.sleep(3000);
		WebElement Status = driver.findElement(Permission_Setting_Pages.Creator_Toggle);
		Status.click();
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
	@Test(priority = 4,groups = { "Regression","SmokeTest" })
	public void Creator_Permission_Settings() throws Exception {
		logger = extent.createTest("Creator permission setting ", "verify Creator permission setting");
		logger.log(Status.INFO, "Creator permission setting");
		Thread.sleep(3000);
		WebElement Settings = driver.findElement(Permission_Setting_Pages.creator_check);
		Settings.click();
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
	
	@Test(priority = 5,groups = { "Regression","SmokeTest" })
	public void Manager_Permission_Setting_status() throws Exception {
		logger = extent.createTest("Manager permission setting Status", "verify Manager permission setting Status");
		logger.log(Status.INFO, "Manager permission setting Status");
		driver.get(config.Permissions());
		Thread.sleep(3000);
		WebElement Status = driver.findElement(Permission_Setting_Pages.Manager_Toggle);
		Status.click();
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
	@Test(priority = 6,groups = { "Regression","SmokeTest" })
	public void Manager_Permission_Settings() throws Exception {
		logger = extent.createTest("Manager permission settings", "verify Manager permission settings");
		logger.log(Status.INFO, "Manager permission settings");
		Thread.sleep(3000);
		WebElement Settings = driver.findElement(Permission_Setting_Pages.Manager_check);
		Settings.click();
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
