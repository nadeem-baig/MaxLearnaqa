package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.Goals_page;
import PageObjects.ToasterObject;
import utility.Wrapper;

public class Add_Goals extends BaseClass {

	@Test(priority = 1, groups = { "Regression" })

	public void Create_Goal_Learner_Required() throws Exception {
		logger = extent.createTest("learners Required", "please select learners ");
		logger.log(Status.ERROR, "learners Required");

		Click_Add_Goals();
		Thread.sleep(2000);
		driver.findElement(Goals_page.Create_Goals_Save).click();
		Thread.sleep(2000);

		try {

			WebElement goalserror = driver.findElement(ToasterObject.toaster);
			goalserror.isDisplayed();
			logger.error("Error:" + goalserror.getText());
			String alert = goalserror.getText();
			System.out.println("Message - " + alert);
			if (alert.contains("Please Select Learners")) {
				System.out.println("Please Select Learners");
				logger.log(Status.ERROR, alert);
			} else {
				System.out.println(alert);
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

//// Please Select Required learning level and status
	@Test(priority = 2, groups = { "Regression" })

	public void Create_Goal_Learning_level_req() throws InterruptedException, IOException {
		logger = extent.createTest("Create goal", "learning level required ");
		logger.log(Status.ERROR, "learning level required");
		Click_Add_Goals();

		// category
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

		WebElement category = wait.until(ExpectedConditions.elementToBeClickable(Goals_page.Category));
		category.click();
		Thread.sleep(3000);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(excel.getDataSheetName("Goals", 1, 1), Keys.chord(Keys.ENTER)).perform();
		System.out.println("Category selected");

		// subject

		WebElement subject = wait.until(ExpectedConditions.elementToBeClickable(Goals_page.Subject));
		subject.click();
		Thread.sleep(4000);
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(excel.getDataSheetName("Goals", 2, 1), Keys.chord(Keys.ENTER)).perform();
		System.out.println("subject selected");

		// topic

		WebElement topic = wait.until(ExpectedConditions.elementToBeClickable(Goals_page.Topic));
		topic.click();
		Actions keyDown2 = new Actions(driver);
		Thread.sleep(3000);
		keyDown2.sendKeys(excel.getDataSheetName("Goals", 3, 1), Keys.chord(Keys.ENTER)).perform();
		System.out.println("topic selected");

		Thread.sleep(2000);
		WebElement picklearners = wait.until(ExpectedConditions.elementToBeClickable(Goals_page.Pick_learners));
		picklearners.click();
		Thread.sleep(2000);
		WebElement parameter = driver.findElement(Goals_page.parameter);
		parameter.click();
		keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

		Thread.sleep(2000);
		WebElement criteria = driver.findElement(Goals_page.Criteria);
		criteria.click();
		keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(2000);

		WebElement value = driver.findElement(Goals_page.Value);
		value.sendKeys(excel.getDataSheetName("Goals", 4, 1));
		Thread.sleep(2000);

		WebElement add = driver.findElement(Goals_page.addbutton);
		add.click();
		Thread.sleep(2000);

		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(Goals_page.checkbox1));
		checkbox.click();
		Thread.sleep(2000);
		Wrapper.scrollDown(driver);

		WebElement confirm = driver.findElement(Goals_page.confirm);
		confirm.click();
		Thread.sleep(2000);
		driver.findElement(Goals_page.Create_Goals_Save).click();

		Thread.sleep(2000);
		try {
			driver.findElement(Goals_page.Error).isDisplayed();
			String error = driver.findElement(Goals_page.Error).getText();

			logger.log(Status.INFO, error);
			System.out.println(error);
			Thread.sleep(2000);
			Assert.assertEquals(error, "Please Select Required learning level and status");

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}

	}

	// goals already exist
	// Goal created successfully
	@Test(priority = 3, groups = { "Regression", "SmokeTest" })

	public void Create_Goal_valid() throws InterruptedException, IOException {
		logger = extent.createTest("Create goal", "create goal success ");
		logger.log(Status.INFO, "goal created successfully");

		Click_Add_Goals();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement category = wait.until(ExpectedConditions.elementToBeClickable(Goals_page.Category));
		category.click();
		Thread.sleep(3000);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys("compliance", Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);
		System.out.println("Category selected");

		// subject

		WebElement subject = wait.until(ExpectedConditions.elementToBeClickable(Goals_page.Subject));
		subject.click();
		Thread.sleep(3000);
		keyDown.sendKeys("Financial", Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);
		System.out.println("subject selected");

		// topic

		WebElement topic = wait.until(ExpectedConditions.elementToBeClickable(Goals_page.Topic));
		topic.click();
		Thread.sleep(2000);
		keyDown.sendKeys("Anti ", Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);
		System.out.println("topic selected");

		WebElement picklearners = wait.until(ExpectedConditions.elementToBeClickable(Goals_page.Pick_learners));
		picklearners.click();
		Thread.sleep(2000);
		WebElement parameter = driver.findElement(Goals_page.parameter);
		parameter.click();
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

		Thread.sleep(2000);
		WebElement criteria = driver.findElement(Goals_page.Criteria);
		criteria.click();
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(2000);

		WebElement value = driver.findElement(Goals_page.Value);
		value.sendKeys("HR");
		Thread.sleep(2000);

		WebElement add = driver.findElement(Goals_page.addbutton);
		add.click();
		Thread.sleep(2000);
		WebElement Search_learner = driver.findElement(Goals_page.Search_learner);
		Search_learner.click();
		Search_learner.sendKeys(excel.getDataSheetName("Goals", 5, 1));
		if (driver.findElements(Goals_page.nodata).size() > 0) {
			String nodata =driver.findElement(Goals_page.nodata).getText();
			logger.log(Status.INFO, "learners - "+nodata);
			System.out.println(nodata);
			Search_learner.clear();
		}
		
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(Goals_page.checkbox1));
		checkbox.click();
		Thread.sleep(2000);

		// scroll down
		Wrapper.scrollDown(driver);
		Thread.sleep(1000);

		WebElement confirm = driver.findElement(Goals_page.confirm);
		confirm.click();
		Thread.sleep(2000);
		WebElement learninglevel = driver.findElement(Goals_page.learning_level);

		learninglevel.click();

		Thread.sleep(2000);

		keyDown.sendKeys(Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);

		WebElement requiredstatus = driver.findElement(Goals_page.required_status);
		requiredstatus.click();

		Thread.sleep(2000);
		keyDown.sendKeys(Keys.chord(Keys.ENTER)).perform();

//scrollup
		Wrapper.ScrollToTop(driver);
		Thread.sleep(2000);
		driver.findElement(Goals_page.Create_Goals_Save).click();
		Thread.sleep(2000);

//toaster
		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("goals already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(4000);
				driver.findElement(Goals_page.Cancel).click();
				Thread.sleep(2000);
			} else if (toaster.contains("Goal created successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}

	}

	// search goal
	@Test(priority = 4, groups = { "Regression", "SmokeTest" })

	public void Search_goal() throws InterruptedException, IOException {
		logger = extent.createTest("search", "search goal ");
		logger.log(Status.INFO, "search goal");
		driver.get(config.Goals());
		Thread.sleep(2000);
		WebElement search = driver.findElement(Goals_page.Search);
		search.click();
		search.sendKeys("Anti Money");
		Thread.sleep(3000);

		if (driver.findElements(Goals_page.No_data).size() > 0) {
			String nodata = driver.findElement(Goals_page.No_data).getText();
			System.out.println(nodata);
			logger.log(Status.INFO, nodata);

		} else if (driver.findElements(Goals_page.search_result).size() > 0) {

			driver.findElement(Goals_page.view).click();
			System.out.println("Search results matched and data displayed");
			logger.log(Status.INFO, "Search results matched and data displayed");

		}

	}// view goal

	@Test(priority = 5, groups = { "Regression" })
	public void View_Goal() throws Exception {
		logger = extent.createTest("view goal ", "view goal");
		logger.log(Status.INFO, "view goal");
		driver.get(config.Goals());
		Thread.sleep(4000);
		// select manage learners in navigation menu
		driver.findElement(Goals_page.view).click();
		Thread.sleep(2000);

		WebElement EditGoal = driver.findElement(Goals_page.view_Edit_Goal);
		String Edit = EditGoal.getText();
		logger.log(Status.INFO, Edit);
		System.out.println(Edit);
		Thread.sleep(2000);
		WebElement Participants = driver.findElement(Goals_page.Participants);
		String Participant = Participants.getText();
		logger.log(Status.INFO, Participant);
		System.out.println(Participant);
		Thread.sleep(2000);
		WebElement Notifications = driver.findElement(Goals_page.Notifications);
		Notifications.click();
		String Notification = Notifications.getText();
		logger.log(Status.INFO, Notification);
		System.out.println(Notification);
		Thread.sleep(2000);
	}

	// Edit goal
	@Test(priority = 6, groups = { "Regression", "SmokeTest" })
	public void Edit_Goal() throws Exception {
		logger = extent.createTest("Edit goal", "Edit goal");
		logger.log(Status.INFO, "edit goal");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

		driver.get(config.Goals());
		Thread.sleep(4000);
		WebElement CTA = wait.until(ExpectedConditions.elementToBeClickable(Goals_page.CTA_Button));
		CTA.click();

		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER, Keys.ENTER)).perform();

		System.out.println("edit page open");

		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(Goals_page.Submit));
		submit.isDisplayed();
		submit.click();
		System.out.println("edit submit clicked");
		Thread.sleep(2000);

		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();

			if (toaster.contains("Goal updated successfully")) {
				logger.log(Status.INFO, "Goal updated successfully");
				System.out.println("Goal updated successfully");
			} else {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
			}
		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
		Thread.sleep(3000);

	} // Delete goal clicking on cancel

	@Test(priority = 7, groups = { "Regression" })
	public void Delete_goal_Cancel() throws Exception {
		logger = extent.createTest("Delete goal No", "Delete goal - No");

		driver.get(config.Goals());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement CTA = wait.until(ExpectedConditions.elementToBeClickable(Goals_page.CTA_Button));
		CTA.click();
		driver.findElement(Goals_page.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Cancel = driver.findElement(Goals_page.Delete_cancel);
		Cancel.click();
		Thread.sleep(2000);
		System.out.println("Delete cancelled");
		logger.log(Status.INFO, "Delete cancelled");
	}

	public void Click_Add_Goals() {

		driver.get(config.Goals());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(Goals_page.create_new_goals));
		Add.click();

	}

}
