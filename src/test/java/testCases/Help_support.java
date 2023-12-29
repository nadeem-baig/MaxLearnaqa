package testCases;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.Help_SupportPages;
import PageObjects.ToasterObject;
import utility.Wrapper;

public class Help_support extends BaseClass{
	
	@Test(priority = 1, groups = { "Regression" })
	public void Help_Support_Name_Required() throws Exception {
		logger = extent.createTest("Help and Support Name*", "Help and Support Name required ");
		logger.log(Status.INFO, "Help and Support Name");
		Thread.sleep(2000);
		driver.get(config.helpandsupport());
		Thread.sleep(3000);
		driver.findElement(Help_SupportPages.Ask_question_button).click();
		Thread.sleep(2000);
		driver.findElement(Help_SupportPages.submit).click();
		Thread.sleep(2000);
		try {
			WebElement titleerror = driver.findElement(Help_SupportPages.error_message);
			titleerror.isDisplayed();
			logger.info("Message:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "name is required");
		} catch (Exception e) {
			logger.info(e);
		}
	}
	
	@Test(priority = 2, groups = { "Regression" })
	public void Help_Support_issuetype_Required() throws Exception {
		logger = extent.createTest("Help and Support issuetype*", "Help and Support issuetype required ");
		logger.log(Status.INFO, "Help and Support issuetype");
		Thread.sleep(2000);
		WebElement Name = driver.findElement(Help_SupportPages.Name);
		Name.click();
		Name.sendKeys("Maxlearn Automation");
		Thread.sleep(2000);
		driver.findElement(Help_SupportPages.submit).click();
		Thread.sleep(2000);
		try {
			WebElement titleerror = driver.findElement(Help_SupportPages.error_message);
			titleerror.isDisplayed();
			logger.info("Message:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "select the issue type");
		} catch (Exception e) {
			logger.info(e);
		}
	}
	
	@Test(priority = 3, groups = { "Regression" })
	public void Help_Support_issue_Required() throws Exception {
		logger = extent.createTest("Help and Support issue*", "Help and Support issue required ");
		logger.log(Status.INFO, "Help and Support issue");
		Thread.sleep(2000);
		WebElement Issue_Type = driver.findElement(Help_SupportPages.Typeofissue);
		Issue_Type.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(2000);		
		driver.findElement(Help_SupportPages.submit).click();
		Thread.sleep(2000);
		try {
			WebElement titleerror = driver.findElement(Help_SupportPages.error_message);
			titleerror.isDisplayed();
			logger.info("Message:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "description is required");
		} catch (Exception e) {
			logger.info(e);
		}
	}
	
	@Test(priority = 4, groups = { "Regression" })
	public void Help_support_Description_count() throws Exception {
		logger = extent.createTest("Help and Support  description Count",
				"verify Help and Support description counter changed after entering data");
		logger.log(Status.INFO, "Help and Support  description counter");
		
		WebElement chars = driver.findElement(Help_SupportPages.count);
		System.out.println(chars.getText());
		logger.log(Status.INFO, "Max limit - " + chars.getText());
		Thread.sleep(2000);
		
		WebElement Description = driver.findElement(Help_SupportPages.Issue);
		Description.click();
		Description.sendKeys(Wrapper.randomeString(5));
		Thread.sleep(2000);
		System.out.println(chars.getText());
		logger.log(Status.INFO, chars.getText());
		Thread.sleep(2000);
		assertEquals(chars.getText(), "max : 5/500 char");
		Thread.sleep(3000);
		driver.findElement(Help_SupportPages.cancel).click();

	}
	
	@Test(priority = 5, groups = { "Regression","SmokeTest" })
	public void Help_support_Valid() throws Exception {
		logger = extent.createTest("Help and Support Valid",
				"verify Help and Support Valid");
		logger.log(Status.INFO, "Help and Support Valid");
		driver.get(config.helpandsupport());
		Thread.sleep(3000);
		driver.findElement(Help_SupportPages.Ask_question_button).click();
		Thread.sleep(2000);
		WebElement Name = driver.findElement(Help_SupportPages.Name);
		Name.click();
		Name.sendKeys(excel.getDataSheetName("Help_Support", 1, 1));

		//Name.sendKeys("Maxlearn Automation");
		Thread.sleep(2000);
		
		WebElement Issue_Type = driver.findElement(Help_SupportPages.Typeofissue);
		Issue_Type.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(2000);
		
		WebElement Description = driver.findElement(Help_SupportPages.Issue);
		Description.click();
		Description.sendKeys(Wrapper.randomeString(10));
		Thread.sleep(2000);
		
		WebElement Submit = driver.findElement(Help_SupportPages.submit);
		Submit.click();
		Thread.sleep(2000);

		
		try {
			WebElement Toaster = driver.findElement(ToasterObject.toaster);
			Toaster.isDisplayed();
			logger.info("Toaster:" + Toaster.getText());
			String alert = Toaster.getText();
			System.out.println("Toaster Message - " + alert);
		} catch (Exception e) {
			logger.info(e);
		}
		
		
		

	}


}
