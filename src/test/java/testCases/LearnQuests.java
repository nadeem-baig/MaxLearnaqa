
package testCases;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.LearnQuests_Page;
import PageObjects.ToasterObject;
import utility.Wrapper;

public class LearnQuests extends BaseClass {
	@Test(priority = 1, groups = { "Regression" })
	public void createQuest() throws Exception {
		logger = extent.createTest("quests", "topic required ");
		logger.log(Status.ERROR, "Topic Required");
		Click_Add_learnQuests();
		Thread.sleep(2000);
		driver.findElement(LearnQuests_Page.createQuest).click();
		Thread.sleep(1000);
		try {
			WebElement questerror = driver.findElement(LearnQuests_Page.topic_Error);
			questerror.isDisplayed();
			logger.error("Error:" + questerror.getText());
			String alert = questerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Topic Required");
		} catch (Exception e) {
			logger.error(e);
		}
	}

//navigate to add Quest form and click on Create quest without Description
	@Test(priority = 2, groups = { "Regression" })
	public void Description_Required() throws Exception {
		logger = extent.createTest("Description required", " Description required ");
		logger.log(Status.ERROR, " Description Required");
		// select category from options
		WebElement category = driver.findElement(LearnQuests_Page.Category);
		category.click();
		Thread.sleep(1000);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(excel.getDataSheetName("Learn_Quest", 3, 1), Keys.chord(Keys.ENTER, Keys.TAB)).perform();
		System.out.println("category selected");
		Thread.sleep(1000);
		// select subject from options
		WebElement Subject = driver.findElement(LearnQuests_Page.Subject);
		Subject.click();
		Thread.sleep(1000);
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(excel.getDataSheetName("Learn_Quest", 4, 1), Keys.chord(Keys.ENTER, Keys.TAB)).perform();
		System.out.println("subject selected");
		Thread.sleep(1000);
		// select topic from option
		WebElement topic = driver.findElement(LearnQuests_Page.Topic);
		topic.click();
		System.out.println("topic click");
		Thread.sleep(2500);
		Actions keyDown3 = new Actions(driver);
		keyDown3.sendKeys(excel.getDataSheetName("Learn_Quest", 5, 1), Keys.chord(Keys.ENTER)).perform();
		System.out.println("topic selected");
		Thread.sleep(200);
		Wrapper.ScrollToTop(driver);
		Thread.sleep(2000);
		driver.findElement(LearnQuests_Page.createQuest).click();
		Thread.sleep(2000);
		try {
			WebElement descerror = driver.findElement(LearnQuests_Page.Description_error);
			descerror.isDisplayed();
			String alert = descerror.getText();
			logger.info("Error:" + alert);
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Description Required");
		} catch (Exception e) {

			logger.error(e);

		}
	}

	// navigate to add Quest form and click on Create quest without Name
	@Test(priority = 3, groups = { "Regression" })
	public void Name_Required() throws Exception {
		logger = extent.createTest("Name required", " Name required ");
		logger.log(Status.ERROR, "Name Required");

		WebElement Description = driver.findElement(LearnQuests_Page.QuestDescription);
		Description.click();
		Thread.sleep(2000);
		Description.sendKeys("test is working");
		System.out.println("description entered");
		Thread.sleep(2000);
		driver.findElement(LearnQuests_Page.createQuest).click();
		Thread.sleep(2000);

		try {
			WebElement nameerror = driver.findElement(LearnQuests_Page.name_error);
			nameerror.isDisplayed();
			String alert = nameerror.getText();
			logger.info("Error:" + alert);
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Name is Required");
		} catch (Exception e) {

			logger.error(e);

		}

	}

	@Test(priority = 4, groups = { "Regression" })
	public void Content_Required() throws Exception {
		logger = extent.createTest("content", "content required ");
		logger.log(Status.ERROR, "content Required");
		Thread.sleep(1000);
		WebElement Questname = driver.findElement(LearnQuests_Page.LearnQuestName);
		Questname.click();
		Thread.sleep(2000);
		Questname.sendKeys(Wrapper.randomeString(7));
		System.out.println("name entered");
		Thread.sleep(2000);

		driver.findElement(LearnQuests_Page.createQuest).click();
		Thread.sleep(2000);

		try {
			WebElement contenterror = driver.findElement(LearnQuests_Page.content_error);
			contenterror.isDisplayed();
			logger.error("Error:" + contenterror.getText());
			String alert = contenterror.getText();
			System.out.println("Message - " + alert);

			Assert.assertEquals(alert, "Content Required");
		} catch (Exception e) {

			logger.error(e);

		}

	}

//valid test cases

	@Test(priority = 5, groups = { "Regression", "SmokeTest" })

	public void Quest_Valid() throws Exception {
		// logger = extent.createTest("Create Quest", "Create New Quest ");
		// Click_Add_learnQuests();
		driver.get("http://maxlearn-adminqa.s3-website-us-east-1.amazonaws.com/data-list/learn-quests");
		Thread.sleep(2000);
		System.out.println("Quest page opened");
		Thread.sleep(2000);
		WebElement createquest_main = driver.findElement(LearnQuests_Page.createnewQuest);
		createquest_main.click();
		Thread.sleep(2000);
		System.out.println("Create Quest page opened");

		WebElement Questname = driver.findElement(LearnQuests_Page.LearnQuestName);
		Questname.click();
		Thread.sleep(2000);
		Questname.sendKeys(Wrapper.randomeString(7));
		System.out.println("name entered");
		Thread.sleep(2000);

		WebElement Description = driver.findElement(LearnQuests_Page.QuestDescription);
		Description.click();
		Thread.sleep(2000);
		Description.sendKeys("test is working");
		System.out.println("description entered");
		Thread.sleep(2000);

		// select category from options
		WebElement category = driver.findElement(LearnQuests_Page.Category);
		category.click();
		Thread.sleep(1000);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(excel.getDataSheetName("Learn_Quest", 3, 1), Keys.chord(Keys.ENTER, Keys.TAB)).perform();
		System.out.println("category selected");
		Thread.sleep(1000);
		// select subject from options
		WebElement Subject = driver.findElement(LearnQuests_Page.Subject);
		Subject.click();
		Thread.sleep(1000);
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(excel.getDataSheetName("Learn_Quest", 4, 1), Keys.chord(Keys.ENTER, Keys.TAB)).perform();
		System.out.println("subject selected");
		Thread.sleep(1000);
		// select topic from option
		WebElement topic = driver.findElement(LearnQuests_Page.Topic);
		topic.click();
		System.out.println("topic click");
		Thread.sleep(2500);
		Actions keyDown3 = new Actions(driver);
		keyDown3.sendKeys(excel.getDataSheetName("Learn_Quest", 5, 1), Keys.chord(Keys.ENTER)).perform();
		System.out.println("topic selected");
		Thread.sleep(200);
		// Wrapper.scrollDown(driver);
		// Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollTo(0, 450)");
		Thread.sleep(2000);
		System.out.println("scroll down");
		WebElement checkbox1 = driver.findElement(LearnQuests_Page.checkbox_1);
		checkbox1.click();
		Thread.sleep(1000);
		WebElement checkbox2 = driver.findElement(LearnQuests_Page.checkbox_2);
		checkbox2.click();
		Thread.sleep(1000);
		WebElement addobjects = driver.findElement(LearnQuests_Page.Addobjects);
		addobjects.click();
		Thread.sleep(2000);

		Wrapper.ScrollToTop(driver);
		Thread.sleep(2000);

		WebElement Create = driver.findElement(LearnQuests_Page.createQuest);
		Create.click();
		Thread.sleep(2000);
		// WebElement removeobjects = driver.findElement(LearnQuests_Page.removeobject);
		// removeobjects.click();
		Thread.sleep(3000);
//toaster
		try {
			WebElement toaster_Message = driver.findElement(ToasterObject.toaster);
			toaster_Message.isDisplayed();
			String toaster = toaster_Message.getText();
			if (toaster.contains("Quest already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(LearnQuests_Page.submit_cancel).click();
				Thread.sleep(2000);
			} else if (toaster.contains("Quest" + Questname + "created")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
			}
		} catch (Exception e) {
			System.out.println("Toaster Exception" + e);
		}
	}

	// wait for search to display and enter text then capture results
	@Test(priority = 6, groups = { "Regression" })
	public void Search_quest() throws Exception {
		logger = extent.createTest("Search quest", "Search quest");
		logger.log(Status.INFO, "search quest");

		driver.get(config.LearnQuest());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement search_quest = wait.until(ExpectedConditions.elementToBeClickable(LearnQuests_Page.search_quest));
		search_quest.click();
		System.out.println("click search button");
		Thread.sleep(2000);
		search_quest.sendKeys("Maxlearn");
		Thread.sleep(2000);

		if (driver.findElements(LearnQuests_Page.No_data).size() > 0) {
			String nodata = driver.findElement(LearnQuests_Page.No_data).getText();
			System.out.println(nodata);
			logger.log(Status.INFO, nodata);

		} else if (driver.findElements(LearnQuests_Page.search_result).size() > 0) {

			driver.findElement(LearnQuests_Page.View_quest).click();
			Thread.sleep(3000);
			System.out.println("Search results matched and data displayed");
			logger.log(Status.INFO, "Search results matched and data displayed");

		}
		Thread.sleep(2000);
	}

	// view quest
	@Test(priority = 7, groups = { "Regression" })
	public void View_quest() throws Exception {
		logger = extent.createTest("view quest", "view quest details");
		logger.log(Status.INFO, "view quest details");
		driver.get(config.LearnQuest());
		Thread.sleep(2000);
		WebElement view_quest = driver.findElement(LearnQuests_Page.View_quest);
		view_quest.click();

		// capture details
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement DetailsTab = wait
				.until(ExpectedConditions.elementToBeClickable(LearnQuests_Page.Details_content_Tab));

		DetailsTab.isDisplayed();
		String Message = DetailsTab.getText();
		Thread.sleep(2000);
		System.out.println("Tab Text--" + Message);
		logger.log(Status.INFO, Message);

		WebElement learnersTab = wait
				.until(ExpectedConditions.elementToBeClickable(LearnQuests_Page.IndividualLearners_Tab));
		learnersTab.click();
		learnersTab.isDisplayed();
		String Message1 = learnersTab.getText();
		Thread.sleep(2000);
		System.out.println("Tab Text--" + Message1);
		logger.log(Status.INFO, Message1);

		WebElement Notification_Tab = wait
				.until(ExpectedConditions.elementToBeClickable(LearnQuests_Page.Notification_Tab));
		Notification_Tab.click();
		Notification_Tab.isDisplayed();
		String Message2 = Notification_Tab.getText();
		Thread.sleep(2000);
		System.out.println("Tab Text--" + Message2);
		logger.log(Status.INFO, Message2);

	}

	// Edit quest
	@Test(priority = 8, groups = { "Regression", "SmokeTest" })
	public void Edit_quest() throws Exception {
		logger = extent.createTest("Edit quest", "quest Edit");
		logger.log(Status.INFO, "Edit quest");
		driver.get(config.LearnQuest());
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		if (driver.findElements(LearnQuests_Page.CTA_Button).size() > 0) {

			System.out.println("Edit Element is Present");

			WebElement CTA = wait.until(ExpectedConditions.elementToBeClickable(LearnQuests_Page.CTA_Button));
			CTA.click();
			Actions keyDown = new Actions(driver);
			keyDown.sendKeys(Keys.chord(Keys.ENTER, Keys.ENTER)).perform();

			WebElement Name = wait.until(ExpectedConditions.elementToBeClickable(LearnQuests_Page.LearnQuestName));
			Name.click();
			Name.clear();
			Name.sendKeys("Maxlearn");
			System.out.println("quest name is entered");
			Thread.sleep(2000);
			driver.findElement(LearnQuests_Page.Update).click();
			Thread.sleep(3000);

			try {
				driver.findElement(ToasterObject.toaster).isDisplayed();
				String toaster = driver.findElement(ToasterObject.toaster).getText();
				if (toaster.contains("quest already exist")) {
					logger.log(Status.INFO, toaster);
					System.out.println(toaster);
					Thread.sleep(2000);
					driver.findElement(LearnQuests_Page.submit_cancel).click();
					Thread.sleep(2000);
				} else if (toaster.contains("quest updated successfully")) {
					logger.log(Status.INFO, toaster);
					System.out.println(toaster);
					Thread.sleep(2000);

				}

			} catch (Exception e) {
				System.out.println(e);
				logger.log(Status.ERROR, e);
			}

		} else {

			System.out.println("Edit Element is Absent");
			logger.log(Status.INFO, "Edit Element is Absent for quest");

		}
	}

	// Delete quest clicking on cancel
	@Test(priority = 9, groups = { "Regression" })
	public void Delete_quest_Cancel() throws Exception {
		logger = extent.createTest("Delete quest No", "verify quest delete no");
		logger.log(Status.INFO, "Delete quest Cancel");
		driver.get(config.LearnQuest());
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		Thread.sleep(3000);
		if (driver.findElements(LearnQuests_Page.CTA_Button).size() > 0) {
			System.out.println("Delete Element is Present");
			WebElement CTA = wait.until(ExpectedConditions.elementToBeClickable(LearnQuests_Page.CTA_Button));

			CTA.click();
			WebElement Delete = wait.until(ExpectedConditions.elementToBeClickable(LearnQuests_Page.Delete_Button));
			Thread.sleep(2000);
			Delete.click();
			WebElement Cancel = wait.until(ExpectedConditions.elementToBeClickable(LearnQuests_Page.Delete_cancel));
			Thread.sleep(2000);
			Cancel.click();
			Thread.sleep(2000);
			System.out.println("clicked on cancel button");
			Thread.sleep(2000);
		} else {
			System.out.println("Delete Element is Absent");
			Thread.sleep(2000);
			logger.log(Status.INFO, "Delete Element is Absent for quest");
			Thread.sleep(2000);
		}
	}

	// Delete quest clicking on Yes
	@Test(priority = 10, groups = { "Regression" })
	public void Delete_quest_Yes() throws Exception {
		logger = extent.createTest("Delete quest yes", "Delete quest Yes");
		logger.log(Status.INFO, "Delete quest");
		driver.get(config.LearnQuest());

		Thread.sleep(3000);
		if (driver.findElements(LearnQuests_Page.CTA_Button).size() > 0) {
			System.out.println("Delete Element is Present");

			WebElement CTA = driver.findElement(LearnQuests_Page.CTA_Button);
			CTA.click();
			Thread.sleep(2000);
			driver.findElement(LearnQuests_Page.Delete_Button).click();
			Thread.sleep(2000);
			WebElement Delete = driver.findElement(LearnQuests_Page.Delete_Yes);
			Delete.click();
			Thread.sleep(2000);
			System.out.println("clicked on Yes button");
			try {
				// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

				// WebElement toastermessage = wait
				// .until(ExpectedConditions.elementToBeClickable(driver.findElement(ToasterObject.toaster)));

				WebElement toastermessage = driver.findElement(ToasterObject.toaster);
				String toaster = toastermessage.getText();
				if (toaster.contains("quest Maxlearn Deleted")) {
					logger.log(Status.INFO, toaster);
					System.out.println(toaster);
					Thread.sleep(2000);
				} else if (toaster.contains("Sorry, You cannot delete this quest which is mapped to questions")) {
					logger.log(Status.INFO, toaster);
					System.out.println(toaster);
					Thread.sleep(2000);

				}

			} catch (Exception e) {
				System.out.println(e);
				logger.log(Status.ERROR, e);
			}
		} else {
			System.out.println("Delete Element is Absent");
			logger.log(Status.INFO, "Delete Element is Absent for quest");
		}
	}

	// add new button click method used as callback
	public void Click_Add_learnQuests() {
		driver.get(config.LearnQuest());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(LearnQuests_Page.createnewQuest));
		Add.click();
	}
}
