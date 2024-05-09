package testCases;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.Manage_Squads_Page;
import PageObjects.ToasterObject;
import PageObjects.User_RolePages;

public class UserRoles extends BaseClass {

	@Test(priority = 1, groups = { "Regression" })

	public void AssignUser_Parameter_required() throws InterruptedException, Exception {
		logger = extent.createTest("AssignUser Parameter required*", "verify AssignUser Parameter Rule set");
		logger.log(Status.INFO, "AssignUser Parameter Required");
		driver.get(config.userroles());
		Thread.sleep(3000);
		WebElement Assign = driver.findElement(User_RolePages.Assign_User);
		Assign.click();
		Thread.sleep(2000);
		WebElement Role = driver.findElement(User_RolePages.Role);
		Role.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(3000);
		driver.findElement(User_RolePages.Add).click();
		try {
			WebElement titleerror = driver.findElement(User_RolePages.Error);
			titleerror.isDisplayed();
			logger.info("Error:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "parameter is not selected");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to Assign user and click add without criteria in rule set

	@Test(priority = 2, groups = { "Regression" })

	public void AssignUser_Criteria_required() throws InterruptedException, Exception {
		logger = extent.createTest("AssignUser Criteria required ", "verify Criteria Rule set");
		logger.log(Status.INFO, "AssignUser Criteria Required");

		WebElement Parameter = driver.findElement(User_RolePages.Parameter);
		Parameter.click();
		Parameter.sendKeys("D");

		Thread.sleep(2000);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER)).perform();
		System.out.println("Parameter is Selected");
		Thread.sleep(2000);

		driver.findElement(User_RolePages.Add).click();
		try {

			WebElement titleerror = driver.findElement(User_RolePages.Error);

			titleerror.isDisplayed();
			logger.info("Error:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "criteria is not selected");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to Assign User and click add without entering Value field in rule
	// // set

	@Test(priority = 3, groups = { "Regression" })

	public void AssignUser_Value_required() throws InterruptedException, Exception {
		logger = extent.createTest("AssignUser Value required*", "verify AssignUser Value Rule set");
		logger.log(Status.INFO, "Add AssignUser Value Required");

		WebElement Criteria = driver.findElement(User_RolePages.Criteria);
		Criteria.click();
		Criteria.sendKeys("I");
		Thread.sleep(2000);
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.ENTER)).perform();
		System.out.println("Critera is Selected");
		Thread.sleep(2000);

		driver.findElement(User_RolePages.Add).click();

		try {

			WebElement titleerror = driver.findElement(User_RolePages.Error);

			titleerror.isDisplayed();
			logger.info("Error:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Value is not available");
		} catch (Exception e) {
			logger.info(e);
		}
	}
	// navigate to Assign User and click add in rule set

	@Test(priority = 4, groups = { "Regression" })

	public void AssignUser_Logic_required() throws InterruptedException, Exception {
		logger = extent.createTest("Assign User Logic Rule set", "Assign User Logic required ");
		logger.log(Status.INFO, "Assign User Logic Required");

		WebElement Value = driver.findElement(User_RolePages.Value);
		Value.click();
		Value.sendKeys("testing");
		Thread.sleep(2000);
		System.out.println("Value is enterd");

		WebElement Add = driver.findElement(User_RolePages.Add);
		Add.click();
		Thread.sleep(3000);

		driver.findElement(User_RolePages.Add).click();
		try {
			WebElement titleerror = driver.findElement(User_RolePages.Error);
			titleerror.isDisplayed();
			logger.info("Error:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Logic is not available");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// cancel Create Assign user form

	@Test(priority = 5, groups = { "Regression" })
	public void AssignUser_Cancel() throws Exception {
		logger = extent.createTest("Assign User  cancel ", "cancel Assign User ");
		logger.log(Status.INFO, "Assign User  cancel");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

		WebElement cancel = wait.until(ExpectedConditions.elementToBeClickable(User_RolePages.Cancel));

		System.out.println("Click on cancel button");
		cancel.click();
		Thread.sleep(3000);

	}

	@Test(priority = 6, groups = { "Regression", "SmokeTest" })

	public void Assign_User_Valid() throws InterruptedException, Exception {
		logger = extent.createTest("AssignUser Valid*", "verify AssignUser valid details");
		logger.log(Status.INFO, "AssignUser Valid");
		driver.get(config.userroles());
		Thread.sleep(2000);
		WebElement Assign = driver.findElement(User_RolePages.Assign_User);
		Assign.click();
		Thread.sleep(2000);
		
		WebElement Role = driver.findElement(User_RolePages.Role);
		Role.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(3000);
		
		WebElement Parameter = driver.findElement(User_RolePages.Parameter);
		Parameter.click();
		Parameter.sendKeys("D");
		Thread.sleep(2000);
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.ENTER)).perform();
		System.out.println("Parameter is Selected");
		Thread.sleep(2000);
		
		WebElement Criteria = driver.findElement(User_RolePages.Criteria);
		Criteria.click();
		Criteria.sendKeys("I");
		Thread.sleep(2000);
		Actions keyDown11 = new Actions(driver);
		keyDown11.sendKeys(Keys.chord(Keys.ENTER)).perform();
		System.out.println("Critera is Selected");
		Thread.sleep(2000);
		
		WebElement Value = driver.findElement(User_RolePages.Value);
		Value.click();
		Value.sendKeys("testing");
		Thread.sleep(2000);
		System.out.println("Value is enterd");
		
		driver.findElement(User_RolePages.Add).click();
		Thread.sleep(3000);
		
		WebElement Learner = driver.findElement(User_RolePages.Checkbox);
		Learner.click();
		Thread.sleep(2000);
		
		driver.findElement(User_RolePages.Submit).click();
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
	
	@Test(priority = 7,groups = { "Regression","SmokeTest" })
	public void Assign_User_Edit() throws Exception {
		logger = extent.createTest("Assign User Edit", "verify Assign User Edit");
		logger.log(Status.INFO, "Assign User Edit");
		driver.get(config.userroles());
		Thread.sleep(3000);
		driver.findElement(User_RolePages.CTA).click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER, Keys.ENTER)).perform();
		Thread.sleep(2000);
		WebElement change_role = driver.findElement(User_RolePages.Change_Role);
		change_role.click();
		Thread.sleep(2000);
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(2000);
		driver.findElement(User_RolePages.Update).click();
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
	
	@Test(priority = 8,groups = { "Regression","SmokeTest" })
	public void AssignUser_status() throws Exception {
		logger = extent.createTest("Assign User Status", "Assign User Title Status");
		logger.log(Status.INFO, "Assign User Status");
		driver.get(config.userroles());
		Thread.sleep(5000);
		WebElement Status = driver.findElement(User_RolePages.Toggle);
		Status.click();
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
	
	@Test(priority = 9, groups = { "Regression" })
	public void Delete_User_Cancel() throws Exception {
		logger = extent.createTest("Delete User No", "Delete User - No");
		driver.get("https://admin.staging.maxlearn.com/data-list/userslist");
		Thread.sleep(3000);
		driver.findElement(User_RolePages.CTA).click();
		Thread.sleep(2000);
		WebElement Delete = driver.findElement(User_RolePages.Delete);
		Delete.click();	
		
		WebElement Cancel = driver.findElement(User_RolePages.Delete_cancel);
		Cancel.click();
		Thread.sleep(2000);
		System.out.println("Delete cancelled");
		logger.log(Status.INFO, "Delete cancelled");
	}
	
	@Test(priority = 10, groups = { "Delete" })
	public void Delete_User_Yes() throws Exception {
		logger = extent.createTest("Delete User Yes", "Delete User - Yes");
 
		driver.findElement(User_RolePages.CTA).click();
		Thread.sleep(2000);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN,Keys.ENTER)).perform();
		Thread.sleep(2000);	
		
		WebElement Cancel = driver.findElement(User_RolePages.Delete_Yes);
		Cancel.click();
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
