package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.Did_You_KnowPages;

import PageObjects.ToasterObject;
import utility.Wrapper;

public class Did_You_Know extends BaseClass{
	
	

	@Test(priority = 1, groups = { "Regression" })
	public void Did_You_Know_icon_Required() throws Exception {
		logger = extent.createTest("Did You Know icon*", "Did You Know icon required ");
		logger.log(Status.INFO, "Did You Know icon");
		Thread.sleep(2000);
		driver.get(config.DidyouKnow());
		Thread.sleep(3000);
		driver.findElement(Did_You_KnowPages.add_button).click();
		Thread.sleep(2000);
		driver.findElement(Did_You_KnowPages.submit).click();
		Thread.sleep(2000);
		try {
			WebElement titleerror = driver.findElement(Did_You_KnowPages.error_message);
			titleerror.isDisplayed();
			logger.info("Message:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please select a Image");
		} catch (Exception e) {
			logger.info(e);
		}
	}
	
	@Test(priority = 2, groups = { "Regression" })
	public void Did_You_Know_Headline_Required() throws Exception {
		logger = extent.createTest("Did You Know Headline*", "Did You Know required ");
		logger.log(Status.INFO, "Did You Know Headline");
		Thread.sleep(2000);
		WebElement icon = driver.findElement(Did_You_KnowPages.icon);
		icon.click();
		Thread.sleep(2000);
		driver.findElement(Did_You_KnowPages.submit).click();
		Thread.sleep(2000);
		try {
			WebElement titleerror = driver.findElement(Did_You_KnowPages.error_message);
			titleerror.isDisplayed();
			logger.info("Message:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please Enter headline");
		} catch (Exception e) {
			logger.info(e);
		}
	}
	
	@Test(priority = 3, groups = { "Regression" })
	public void Did_You_Know_Content_Required() throws Exception {
		logger = extent.createTest("Did You Know Content*", "Did You Know content required ");
		logger.log(Status.INFO, "Did You Know content");
		Thread.sleep(2000);
		WebElement Headline = driver.findElement(Did_You_KnowPages.Headline);
		Headline.click();
		Headline.sendKeys("Maxlearn");	
		driver.findElement(Did_You_KnowPages.submit).click();
		Thread.sleep(2000);
		try {
			WebElement titleerror = driver.findElement(Did_You_KnowPages.error_message);
			titleerror.isDisplayed();
			logger.info("Message:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please Enter content");
		} catch (Exception e) {
			logger.info(e);
		}
	}
	
	@Test(priority = 4, groups = { "Regression" })
	public void Did_You_Know_Description_count() throws Exception {
		logger = extent.createTest("Did You Know  description Count",
				"verify Did You Know  description counter changed after entering data");
		logger.log(Status.INFO, "Did You Know description counter");
		
		WebElement chars = driver.findElement(Did_You_KnowPages.Chars);
		System.out.println(chars.getText());
		logger.log(Status.INFO, "Max limit - " + chars.getText());
		Thread.sleep(2000);
		
		WebElement Description = driver.findElement(Did_You_KnowPages.description);
		Description.click();
		Description.sendKeys(Wrapper.randomeString(5));
		Thread.sleep(2000);
		System.out.println(chars.getText());
		logger.log(Status.INFO, chars.getText());
		Thread.sleep(2000);
		assertEquals(chars.getText(), "Characters : 5/300");
		Thread.sleep(3000);
		driver.findElement(Did_You_KnowPages.Cancel).click();

	}
	
	@Test(priority = 5, groups = { "Regression","SmokeTest" })
	public void Did_You_Know_Valid() throws Exception {
		logger = extent.createTest("Did You Know Valid",
				"verify Did You Know Valid");
		logger.log(Status.INFO, "Did You Know Valid");
		driver.get(config.DidyouKnow());
		Thread.sleep(3000);
		driver.findElement(Did_You_KnowPages.add_button).click();
		Thread.sleep(2000);
		WebElement icon = driver.findElement(Did_You_KnowPages.icon);
		icon.click();
		Thread.sleep(2000);
		WebElement Headline = driver.findElement(Did_You_KnowPages.Headline);
		Headline.click();
		Headline.sendKeys(excel.getDataSheetName("DidyouKnow", 1, 1));

		//Headline.sendKeys("Maxlearn");
		WebElement Description = driver.findElement(Did_You_KnowPages.description);
		Description.click();
		Description.sendKeys(Wrapper.randomeString(15));
		Thread.sleep(2000);		
		WebElement Submit = driver.findElement(Did_You_KnowPages.submit);
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
	@Test(priority = 6,groups = { "Regression","SmokeTest" })
	public void Toggle_status() throws Exception {
		logger = extent.createTest("Did you Know Status", "verify Did you Know Status");
		logger.log(Status.INFO, "Did you Know Status");
		driver.get(config.DidyouKnow());
		Thread.sleep(3000);
		WebElement Status = driver.findElement(Did_You_KnowPages.Toggle);
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
	
	@Test(priority = 7,groups = { "Regression","SmokeTest" })
	public void Did_You_Know_Edit() throws Exception {
		logger = extent.createTest("Did You Know Edit", "verify Did You Know Edit");
		logger.log(Status.INFO, "Did You Know  Edit");
		driver.get(config.DidyouKnow());
		Thread.sleep(3000);
		driver.findElement(Did_You_KnowPages.edit).click();
		Thread.sleep(2000);
		WebElement Description = driver.findElement(Did_You_KnowPages.description);
		Description.click();
		Description.clear();
		Description.sendKeys(Wrapper.randomeString(15));
		Thread.sleep(2000);
		driver.findElement(Did_You_KnowPages.submit).click();
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
	
	@Test(priority = 8,groups = {"Regression"})
	public void Did_You_Know_Delete() throws Exception {
		logger = extent.createTest("Did You Know Delete", "verify Did You Know Delete");
		logger.log(Status.INFO, "Did You Know Delete");
		Thread.sleep(3000);
		WebElement Delete = driver.findElement(Did_You_KnowPages.Delete);
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
