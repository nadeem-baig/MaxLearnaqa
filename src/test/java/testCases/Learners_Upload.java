package testCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.Learners_UploadPage;
import PageObjects.ToasterObject;

public class Learners_Upload  extends BaseClass{
	
	@Test(priority = 1, groups = { "Regression", "SmokeTest" })
	public void LearnersExcel_Upload() throws Exception {
		logger = extent.createTest("Learners Excel Upload", "Learners Upload");
		logger.log(Status.INFO, "Learners Upload");
		driver.get(config.Lerners_upload());
		Thread.sleep(5000);
		driver.findElement(Learners_UploadPage.Excel_Uplaod).click();
		Thread.sleep(2000);
		driver.findElement(Learners_UploadPage.file)
				.sendKeys(System.getProperty("user.dir") + "/TestData/Learners.xlsx");
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
