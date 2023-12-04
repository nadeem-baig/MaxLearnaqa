package testCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.DepartmentsPage;
import PageObjects.ToasterObject;

public class Departments extends BaseClass{
	/*
	@Test(priority = 1,groups = { "Regression" })
	public void Department_Title_required() throws Exception {
		logger = extent.createTest("Departments Title", "verify Department Title required");
		logger.log(Status.INFO, "Department Title Required");
		driver.get("https://admin.staging.maxlearn.com/departments");
		Thread.sleep(3000);
		driver.findElement(DepartmentsPage.Edit).click();
		Thread.sleep(2000);
		WebElement Title = driver.findElement(DepartmentsPage.Title);
		Title.click();
		Title.clear();
		Thread.sleep(4000);
		driver.findElement(DepartmentsPage.Update).click();

		try {
			WebElement titleerror = driver.findElement(DepartmentsPage.error);
			titleerror.isDisplayed();
			logger.info("Error:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Title is Required");
		} catch (Exception e) {
			logger.info(e);
		}
	}
	*/
	
	@Test(priority = 2,groups = { "Regression","SmokeTest" })
	public void Department_Title_Edit() throws Exception {
		logger = extent.createTest("Department Title Edit", "verify Department Title Edit");
		logger.log(Status.INFO, "Department Title Edit");
		driver.get(config.admin_department());
		Thread.sleep(3000);
		driver.findElement(DepartmentsPage.Edit).click();
		Thread.sleep(2000);
		WebElement Title = driver.findElement(DepartmentsPage.Title);
		Title.click();
		Title.clear();
		Title.sendKeys("FinanceEdited");
		Thread.sleep(2000);
		driver.findElement(DepartmentsPage.Update).click();
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
	
	@Test(priority = 1,groups = { "Regression","SmokeTest" })
	public void Department_status() throws Exception {
		logger = extent.createTest("Department Status", "verify Department Title Status");
		logger.log(Status.INFO, "Department Title Status");
		driver.get(config.admin_department());
		Thread.sleep(3000);
		WebElement Status = driver.findElement(DepartmentsPage.Toggle);
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
	
	@Test(priority = 3,groups = {"Delete"})
	public void Department_Delete() throws Exception {
		logger = extent.createTest("Department Delete", "verify Department Title Delete");
		logger.log(Status.INFO, "Department Title Delete");
		Thread.sleep(3000);
		WebElement Status = driver.findElement(DepartmentsPage.Delete);
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
	
	
}
