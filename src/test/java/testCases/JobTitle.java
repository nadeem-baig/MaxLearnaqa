package testCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.JobTitlePages;
import PageObjects.ToasterObject;

public class JobTitle extends BaseClass{

	@Test(priority = 1,groups = { "Regression","SmokeTest" })
	public void Job_status() throws Exception {
		logger = extent.createTest("jobtitle Status", "verify Job Title Status");
		logger.log(Status.INFO, "Job Title Status");
		driver.get(config.Job_title());
		Thread.sleep(3000);
		WebElement Status = driver.findElement(JobTitlePages.Toggle);
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
	
	@Test(priority = 2,groups = { "Regression","SmokeTest" })
	public void Job_Title_Edit() throws Exception {
		logger = extent.createTest("job Title Edit", "verify Job Title Edit");
		logger.log(Status.INFO, "Job Title Edit");
		driver.get(config.Job_title());
		Thread.sleep(3000);
		driver.findElement(JobTitlePages.Edit).click();
		Thread.sleep(2000);
		WebElement Title = driver.findElement(JobTitlePages.Department_Title);
		Title.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(2000);
		WebElement Job_Title = driver.findElement(JobTitlePages.Job_Title);
		Job_Title.click();
		Job_Title.clear();
		Job_Title.sendKeys("Admin");
		Thread.sleep(2000);
		driver.findElement(JobTitlePages.Update).click();
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
	
	@Test(priority = 3,groups = {"Regression"})
	public void Job_Delete() throws Exception {
		logger = extent.createTest("Job Delete", "verify Job Title Delete");
		logger.log(Status.INFO, "Job Title Delete");
		Thread.sleep(3000);
		WebElement Delete = driver.findElement(JobTitlePages.Delete);
		Delete.click();
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
