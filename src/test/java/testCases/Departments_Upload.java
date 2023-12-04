package testCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.Departments_UploadPage;
import PageObjects.ToasterObject;

public class Departments_Upload extends BaseClass {
	
	@Test(priority = 1, groups = { "Regression", "SmokeTest" })
	public void DepartmentExcel_Upload() throws Exception {
		logger = extent.createTest("Departments Excel Upload", "Department Upload");
		logger.log(Status.INFO, "Department Upload");
		driver.get(config.departments());
		Thread.sleep(5000);
		driver.findElement(Departments_UploadPage.Excel_Uplaod).click();
		Thread.sleep(2000);
		driver.findElement(Departments_UploadPage.file)
				.sendKeys(System.getProperty("user.dir") + "/TestData/job_title_department.xlsx");
		Thread.sleep(2000);
		System.out.println("Excel is uploaded");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
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
