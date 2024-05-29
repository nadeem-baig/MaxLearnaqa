
package testCases;


import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import PageObjects.ToasterObject;
import PageObjects.TopicsPage;
import utility.Wrapper;

public class addNewTopic extends BaseClass {

	// verify add topic title required

	@Test(priority = 0, groups = { "Regression" })
	public void Add_Topic_Title_Required() throws InterruptedException, Exception {
		logger = extent.createTest("Add Topic Title* ", "verify Title required");

		Click_Add_New_Topic();

		driver.findElement(TopicsPage.Topic_publish).click();
		Thread.sleep(2000);
		try {
			WebElement titleerror = driver.findElement(TopicsPage.error1);
			titleerror.isDisplayed();
			String alert = titleerror.getText();
			logger.info("Message:" + alert);
			System.out.println(alert);
			Assert.assertEquals(alert, "Required");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add Topic and click submit without icon

	@Test(priority = 1, groups = { "Regression" })
	public void Add_topic_category_dropdown_Required() throws Exception {
		logger = extent.createTest("add topic category * ", "Add Topic category required");

		
		Thread.sleep(2000);
		driver.findElement(TopicsPage.Topic_Title).sendKeys("Topic");
		logger.log(Status.INFO, "Topic title entered");
		Thread.sleep(1000);

		driver.findElement(TopicsPage.Topic_publish).click();
		Thread.sleep(2000);
		try {
			WebElement titleerror = driver.findElement(TopicsPage.error2);
			titleerror.isDisplayed();
			logger.info("Message: " + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println(alert);

			Assert.assertEquals(alert, "Required");
		} catch (Exception e) {
			logger.info(e);
		}
		Thread.sleep(2000);
	}

	@Test(priority = 2, groups = { "Regression" })
	public void Add_Topic_subject_dropdown_Required() throws Exception {
		logger = extent.createTest(" Add Topic Subject*", " add new topic subject dropdown required");
		Thread.sleep(3000);
		WebElement cat = driver.findElement(TopicsPage.Category_dropdown);
		cat.click();

		System.out.println("Category dropdown is clicked");

		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER)).perform();

		driver.findElement(TopicsPage.Topic_publish).click();
		Thread.sleep(3000);
		try {
			WebElement titleerror = driver.findElement(TopicsPage.error2);
			titleerror.isDisplayed();
			logger.info("Error: " + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println(alert);

			Assert.assertEquals(alert, "Required");
		} catch (Exception e) {
			logger.info(e);
		}
		Thread.sleep(2000);
	}

	@Test(priority = 3, groups = { "Regression" })
	public void Add_topic_description_Required() throws Exception {
		logger = extent.createTest(" Add Topic Description*", "add new topic description required");

		Thread.sleep(2000);

		driver.findElement(TopicsPage.Subject_dropdown).click();
		System.out.println("subject dropdown is clicked");

		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER)).perform();
		System.out.println("subject selected");
		
		Thread.sleep(3000);
		Actions dragger = new Actions(driver);
		WebElement element = driver.findElement(ToasterObject.innerscroll);
		dragger.moveToElement(element).clickAndHold().moveByOffset(0, 200).release(element).build().perform();

		driver.findElement(TopicsPage.Topic_publish).click();
		Thread.sleep(2000);

		try {
			WebElement titleerror = driver.findElement(TopicsPage.error1);
			titleerror.isDisplayed();
			logger.info("Error: " + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println(alert);

			Assert.assertEquals(alert, "Required");
		} catch (Exception e) {
			logger.info(e);
		}
		Thread.sleep(3000);
	}

	

	@Test(priority = 4, groups = { "Regression", "SmokeTest" })
	public void Add_New_Topic_Valid() throws Exception {
		logger = extent.createTest("Add New Topic ", "verify Add new Topic ");

		Click_Add_New_Topic();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement title = wait.until(ExpectedConditions.elementToBeClickable(TopicsPage.Topic_Title));
		// topic title
		title.sendKeys(excel.getDataSheetName("ManageContent", 5, 1));
		logger.log(Status.INFO, "Topic title entered");
		Thread.sleep(1000);
		System.out.println("Topic title entered");
		logger.log(Status.INFO, "title entered"); // select category from keyboard keydown and enter keys
		WebElement cat = driver.findElement(TopicsPage.Category_dropdown);
		cat.click();
		Thread.sleep(2000);

		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(excel.getDataSheetName("ManageContent", 1, 1), Keys.chord(Keys.ENTER)).perform();
		System.out.println("Category dropdown is clicked");
		logger.log(Status.INFO, "Category selected");
		Thread.sleep(3000);

		driver.findElement(TopicsPage.Subject_dropdown).click();
		System.out.println("subject dropdown is clicked");

		// subject
		keyDown.sendKeys(excel.getDataSheetName("ManageContent", 3, 1), Keys.chord(Keys.ENTER)).perform();
		logger.log(Status.INFO, "subject selected");
		Thread.sleep(2000);
		// enter the description
		WebElement Description = driver.findElement(TopicsPage.Topic_description);
		Description.click();
		Description.sendKeys(excel.getDataSheetName("ManageContent", 6, 1));
		
		System.out.println("Deccription is added");
		logger.log(Status.INFO, "description added");
		WebElement publish = wait.until(ExpectedConditions.elementToBeClickable(TopicsPage.Topic_publish));
		// save topic
		publish.click();
		Thread.sleep(3000);
		
		try {
			//WebElement Toaster = wait.until(ExpectedConditions.visibilityOfElementLocated(ToasterObject.toaster));
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("topics already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(TopicsPage.Cancel_Topic).click();
				Thread.sleep(2000);
			} else if (toaster.contains("topics created successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);

			}else if (driver.findElement(TopicsPage.error2).isDisplayed()) {

				WebElement titleerror = driver.findElement(TopicsPage.error2);

				logger.info("Error: " + titleerror.getText());
				String alert = titleerror.getText();
				System.out.println(alert);
			}
		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
		Thread.sleep(2000);
	}
	

	@Test(priority = 5, groups = { "Regression", "SmokeTest" })
	public void Search_Topic() throws Exception {
		logger = extent.createTest("Search topic ", "search topic");

		driver.get(config.topics());
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement Search = wait.until(ExpectedConditions.elementToBeClickable(TopicsPage.search));
		Search.click();
		

		Search.sendKeys(excel.getDataSheetName("ManageContent", 5, 1));
		logger.log(Status.INFO, "Search ");
		System.out.println("searching");
		Thread.sleep(3000);

		if (driver.findElements(TopicsPage.No_data).size() > 0) {
			String nodata = driver.findElement(TopicsPage.No_data).getText();
			System.out.println(nodata);
			logger.log(Status.INFO, nodata);

		} else if (driver.findElements(TopicsPage.View_Row).size() > 0) {
			Thread.sleep(2000);
			WebElement drp =driver.findElement(ToasterObject.status);
			drp.click();
			Select statusupdate = new Select(drp);
			statusupdate.selectByValue("PUBLISHED");
			Thread.sleep(2000);

			// driver.findElement(TopicsPage.View_Row).click();
			System.out.println("Search results matched and data displayed");
			logger.log(Status.INFO, "Search results matched and data displayed");

		}
		driver.findElement(TopicsPage.search).clear();
		System.out.println("Search cleared");

	}

	@Test(priority = 6, groups = { "Regression" })
	public void View_Topic() throws Exception {
		logger = extent.createTest("view topic  ", "view topic details");

		driver.get(config.topics());

		WebElement view_topic = driver.findElement(TopicsPage.View_Row);
		view_topic.click();
		logger.log(Status.INFO, "view topic details");
		// capture details
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(TopicsPage.Add_Deck));
		Add.isDisplayed();

		logger.log(Status.INFO, "Topics details - " + Add.getText());
	}

	// Edit Topic
	@Test(priority = 7, groups = { "Regression", "SmokeTest" })
	public void Edit_Topic() throws Exception {
		logger = extent.createTest("Edit Topic", "Edit topics");

		driver.get(config.topics());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(TopicsPage.CTA_Button);
		CTA.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER, Keys.ENTER)).perform();
		Thread.sleep(2000);
		WebElement Description = driver.findElement(TopicsPage.Topic_description);
		Description.clear();
		Description.sendKeys(Wrapper.AlphaNumericString(15));
		System.out.println("Description is entered");
		Thread.sleep(2000);
		driver.findElement(TopicsPage.Topic_publish).click();
		Thread.sleep(3000);
		logger.log(Status.INFO, "Topic  description update");
		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Topics already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(TopicsPage.Cancel_Topic).click();
				Thread.sleep(2000);
			} else if (toaster.contains("Topic updated successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}

	}

	// Delete Topic clicking on cancel
	@Test(priority = 8, groups = { "Regression" })
	public void Delete_Topic_Cancel() throws Exception {
		logger = extent.createTest("Delete Topic - No", "Topic delete Cancel");

		driver.get(config.topics());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(TopicsPage.CTA_Button);
		CTA.click();
		driver.findElement(TopicsPage.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Cancel = driver.findElement(TopicsPage.Delete_cancel);
		Cancel.click();
		Thread.sleep(2000);
		System.out.println("clicked on cancel button");
		logger.log(Status.INFO, "cancelled delete");
	}
	@Test(priority = 9, groups = { "Regression" })
	public void add_new_Topic_Status() throws Exception {
		logger = extent.createTest("Add Topic Status Change",
				"Changing the status");
		logger.log(Status.INFO, "add new Topic Status");
		
		WebElement status = driver.findElement(TopicsPage.status);
		status.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN,Keys.ENTER)).perform();
		Thread.sleep(2000);
		String toaster = driver.findElement(ToasterObject.toaster).getText();
		System.out.println("Text in Toaster---"+toaster);
		
		Thread.sleep(3000);
		
		WebElement status1 = driver.findElement(TopicsPage.status);
		status1.click();
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.UP,Keys.ENTER)).perform();
		Thread.sleep(2000);
		String Message1 = driver.findElement(TopicsPage.status).getText();

		System.out.println("Status is ---"+Message1);



	}
	// Delete Topic clicking on Yes
	@Test(priority = 10, groups = { "Delete" })
	public void Delete_Topic_Yes() throws Exception {
		logger = extent.createTest("Delete Topic - yes", "Delete topic Yes");

		driver.get(config.topics());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(TopicsPage.CTA_Button);
		CTA.click();
		driver.findElement(TopicsPage.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Delete = driver.findElement(TopicsPage.Delete_Yes);
		Delete.click();
		Thread.sleep(3000);
		System.out.println("clicked on Yes button");
		try {

			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Sorry, You cannot delete this Topic which is mapped to subjects")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);

			} else if (toaster.contains("Topics Deleted successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
		Thread.sleep(2000);
	}

	// add new button click method used as callback
	public void Click_Add_New_Topic() throws InterruptedException {
		Thread.sleep(2000);
		driver.get(config.topics());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(TopicsPage.Add_New_topic));
		Thread.sleep(2000);
		Add.click();
		Thread.sleep(3000);
	}
}
