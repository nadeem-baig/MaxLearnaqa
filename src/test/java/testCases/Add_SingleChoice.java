package testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.Add_QuestionsPage;
import PageObjects.ToasterObject;
import utility.Wrapper;

public class Add_SingleChoice extends BaseClass {

	// navigate to create question form and click on save without question

	@Test(priority = 1, groups = { "Regression" })
	public void Add_Question_question_required() throws Exception {
		logger = extent.createTest("Question Title", "add new question required ");
		logger.log(Status.INFO, "Add new question Title Required");
		Click_Add_New_Question();
		driver.findElement(Add_QuestionsPage.Save_button).click();

		try {
			WebElement titleerror = driver.findElement(Add_QuestionsPage.error);
			titleerror.isDisplayed();
			logger.info("Error:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please enter Question");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add new question and click submit without selecting options

	@Test(priority = 2, groups = { "Regression" })
	public void Add_Question_options_required() throws Exception {
		logger = extent.createTest("Options required", "add new question answer options required ");
		logger.log(Status.INFO, "Add new Questions options Required");

		WebElement Question = driver.findElement(Add_QuestionsPage.Question_Content);
		Question.sendKeys("Choose the correct answer " + Wrapper.AlphaNumericString(10));
		System.out.println("Question is entered");
		Thread.sleep(2000);
		Wrapper.ScrollToTop(driver);
		driver.findElement(Add_QuestionsPage.Save_button).click();

		try {
			WebElement titleerror = driver.findElement(Add_QuestionsPage.Answer_error);
			titleerror.isDisplayed();
			logger.info("Error:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please Select an Answer");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// Feedback count assert
	@Test(priority = 3, groups = { "Regression" })
	public void add_new_Questions_Feedback_count() throws Exception {
		logger = extent.createTest("Feedback required", "add new question Feedback required ");
		logger.log(Status.INFO, "Add new Questions Feedback Required");

		WebElement option1 = driver.findElement(Add_QuestionsPage.Option_1);
		option1.sendKeys(Wrapper.AlphaNumericString(5));
		System.out.println("first option is entered");
		Thread.sleep(2000);

		WebElement option2 = driver.findElement(Add_QuestionsPage.Option_2);
		option2.sendKeys(Wrapper.AlphaNumericString(5));
		System.out.println("second option is entered");
		Thread.sleep(2000);

		// select first option

		WebElement checkbox1 = driver.findElement(Add_QuestionsPage.checkbox);
		checkbox1.click();
		System.out.println("option is selected");
		Thread.sleep(2000);
		Wrapper.Scrollintoview(driver, "xpath", "//p[@id='charNum']");

		WebElement chars = driver.findElement(Add_QuestionsPage.chars);
		System.out.println(chars.getText());
		logger.log(Status.INFO, chars.getText());
		Thread.sleep(2000);
		Wrapper.Scrollintoview(driver, Add_QuestionsPage.locatortype, Add_QuestionsPage.feedbackview);

		WebElement Feedback = driver.findElement(Add_QuestionsPage.FeedBack);
		Feedback.click();
		Feedback.sendKeys(Wrapper.AlphaNumericString(7));
		Thread.sleep(2000);
		System.out.println(chars.getText());
		logger.log(Status.INFO, chars.getText());
		Thread.sleep(1000);
		assertEquals(chars.getText(), "max:493 char");
		Thread.sleep(1000);
	}

	// navigate to add new question and click submit without giving Topic Included

	@Test(priority = 4, groups = { "Regression" })
	public void Add_Question_Topic_included_required() throws Exception {
		logger = extent.createTest("Topic Included required", "add new question Topic Included required ");
		logger.log(Status.INFO, "Add new Questions Topic Included Required");
		Wrapper.scrollDown(driver);
		Thread.sleep(2000);
		WebElement Feedback = driver.findElement(Add_QuestionsPage.FeedBack);
		Feedback.sendKeys("Answer is option A ");
		System.out.println("Feedback is entered");
		Thread.sleep(2000);
		Wrapper.ScrollToTop(driver);
		Thread.sleep(3000);

		driver.findElement(Add_QuestionsPage.Save_button).click();
		Thread.sleep(2000);

		try {
			WebElement titleerror = driver.findElement(Add_QuestionsPage.Topic_included_error);
			titleerror.isDisplayed();
			logger.info("Error:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please add Topics Included");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add new question and click submit without giving learning level

	@Test(priority = 5, groups = { "Regression" })
	public void Add_Question_learning_level_required() throws Exception {
		logger = extent.createTest("Learning Level required", "add new question Learning Level required ");
		logger.log(Status.INFO, "Add new Questions Learning Level Required");
		// scroll down to enter topic included details
		Wrapper.scrollDown(driver);
		Thread.sleep(2000);

		WebElement Category = driver.findElement(Add_QuestionsPage.Category_dropdown);
		Category.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);
		System.out.println("Category selected");
		Thread.sleep(2000);

		WebElement subject = driver.findElement(Add_QuestionsPage.Subject_dropdown);
		subject.click();
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);
		System.out.println("subject selected");

		Thread.sleep(2000);

		WebElement Topic = driver.findElement(Add_QuestionsPage.Topic_dropdown);
		Topic.click();
		Actions keyDown2 = new Actions(driver);
		keyDown2.sendKeys(Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);
		System.out.println("Topic selected");
		Thread.sleep(2000);

		driver.findElement(Add_QuestionsPage.Add_Button).click();
		Thread.sleep(2000);

		Wrapper.ScrollToTop(driver);
		Thread.sleep(3000);
		driver.findElement(Add_QuestionsPage.Save_button).click();
		Thread.sleep(2000);

		try {
			WebElement titleerror = driver.findElement(Add_QuestionsPage.learning_level_error);
			titleerror.isDisplayed();
			logger.info("Error:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please select Learning level");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add new question and click submit without giving Time to Solve

	@Test(priority = 6, groups = { "Regression" })
	public void Add_Question_Timetosolve_required() throws Exception {
		logger = extent.createTest("Time to Solve  required", "add new question Time to Solve required ");
		logger.log(Status.INFO, "Add new Questions Time to Solve  Required");

		WebElement level = driver.findElement(Add_QuestionsPage.learninglevel);
		level.click();
		Thread.sleep(2000);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);

		System.out.println("Learning level is selected");
		Thread.sleep(2000);

		WebElement timetosolve = driver.findElement(Add_QuestionsPage.Timetosolve);
		timetosolve.click();
		Actions backspace = new Actions(driver);
		backspace.sendKeys(Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE)).perform();
		Thread.sleep(2000);
		driver.findElement(Add_QuestionsPage.Save_button).click();
		Thread.sleep(2000);

		try {
			WebElement titleerror = driver.findElement(Add_QuestionsPage.error);
			titleerror.isDisplayed();
			logger.info("Error:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please enter Time to solve in sec");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add new question and click submit without giving Time to Solve

	@Test(priority = 7, groups = { "Regression" })
	public void Add_Question_KLP_required() throws Exception {
		logger = extent.createTest("KLP required", "add new question KLP required ");
		logger.log(Status.INFO, "Add new Questions KLP Required");

		WebElement timetosolve = driver.findElement(Add_QuestionsPage.Timetosolve);
		timetosolve.click();
		timetosolve.clear();
		timetosolve.sendKeys("120");
		Thread.sleep(2000);

		driver.findElement(Add_QuestionsPage.Save_button).click();
		Thread.sleep(2000);

		try {
			WebElement titleerror = driver.findElement(Add_QuestionsPage.error);
			titleerror.isDisplayed();
			logger.info("Error:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please enter Key Learning Point");
		} catch (Exception e) {
			logger.info(e);
		}
	}
	// navigate to add new question and click submit without giving Topic Included
	// Category

	@Test(priority = 8, groups = { "Regression" })
	public void Topic_Included_Category_required() throws Exception {
		logger = extent.createTest("Category required", "Topic Included Category required ");
		logger.log(Status.INFO, "Topic Included Category Required");

		Click_Add_New_Question();

		Wrapper.scrollDown(driver);
		Thread.sleep(2000);

		driver.findElement(Add_QuestionsPage.Add_Button).click();
		Thread.sleep(2000);

		try {
			WebElement titleerror = driver.findElement(Add_QuestionsPage.Category_error);
			titleerror.isDisplayed();
			logger.info("Error:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please select Category");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add new question and click submit without giving Topic Included
	// Subject

	@Test(priority = 9, groups = { "Regression" })
	public void Topic_Included_Subject_required() throws Exception {
		logger = extent.createTest("Subject required", "Topic Included Subject required ");
		logger.log(Status.INFO, "Topic Included Subject Required");

		WebElement Category = driver.findElement(Add_QuestionsPage.Category_dropdown);
		Category.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);
		System.out.println("Category selected");
		Thread.sleep(2000);

		driver.findElement(Add_QuestionsPage.Add_Button).click();
		Thread.sleep(2000);

		try {
			WebElement titleerror = driver.findElement(Add_QuestionsPage.subject_error);
			titleerror.isDisplayed();
			logger.info("Error:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please select Subject");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add new question and click submit without giving Topic Included
	// Topic

	@Test(priority = 10, groups = { "Regression" })
	public void Topic_Included_Topic_required() throws Exception {
		logger = extent.createTest("Topic required", "Topic Included Topic required ");
		logger.log(Status.INFO, "Topic Included Topic Required");

		WebElement subject = driver.findElement(Add_QuestionsPage.Subject_dropdown);
		subject.click();
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);
		System.out.println("subject selected");
		Thread.sleep(2000);

		driver.findElement(Add_QuestionsPage.Add_Button).click();
		Thread.sleep(2000);

		try {
			WebElement titleerror = driver.findElement(Add_QuestionsPage.Topic_error);
			titleerror.isDisplayed();
			logger.info("Error:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please select Topic");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// cancel Create Questions form

	@Test(priority = 11, groups = { "Regression" })
	public void Add_Questions_Cancel() throws Exception {
		logger = extent.createTest("Add Questions cancel ", "cancel Add Questions");
		logger.log(Status.INFO, "Add Questions cancel");
		Click_Add_New_Question();
		Thread.sleep(5000);
		System.out.println("Click on cancel button");
		Wrapper.ScrollToTop(driver);
		Thread.sleep(2000);
		driver.findElement(Add_QuestionsPage.cancel_button);
		logger.log(Status.INFO, "Add Questions form cancelled");
		Thread.sleep(4000);
	}

	// enter all mandatory fields

	@Test(priority = 12, groups = { "Regression","SmokeTest" })
	public void Add_Questions_Valid() throws Exception {
		logger = extent.createTest("Add question valid", "Add Questions Mandatory field ");
		logger.log(Status.INFO, "Add Question");
		Click_Add_New_Question();
		Thread.sleep(2000);
		WebElement Question = driver.findElement(Add_QuestionsPage.Question_Content);
		Question.sendKeys(excel.getDataSheetName("Questions", 1, 5) + Wrapper.AlphaNumericString(10));
		System.out.println("Question is entered");
		Thread.sleep(1000);
		WebElement option1 = driver.findElement(Add_QuestionsPage.Option_1);
		option1.sendKeys(excel.getDataSheetName("Questions", 1, 6) + " -correct");
		System.out.println("first option is entered");
		Thread.sleep(1000);

		WebElement option2 = driver.findElement(Add_QuestionsPage.Option_2);
		option2.sendKeys(excel.getDataSheetName("Questions", 1, 7));
		System.out.println("second option is entered");
		Thread.sleep(2000);

		// select first option
		WebElement checkbox1 = driver.findElement(Add_QuestionsPage.checkbox);
		checkbox1.click();
		System.out.println("option is selected");
		Thread.sleep(2000);

		Wrapper.Scrollintoview(driver, Add_QuestionsPage.locatortype, Add_QuestionsPage.feedbackview);

		WebElement Feedback = driver.findElement(Add_QuestionsPage.FeedBack);
		Feedback.click();
		Feedback.sendKeys("Answer is option 1");
		Thread.sleep(2000);
		Wrapper.scrollDown(driver);
		WebElement Category = driver.findElement(Add_QuestionsPage.Category_dropdown);
		Category.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(excel.getDataSheetName("Questions", 1, 1), Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);
		System.out.println("Category selected");

		WebElement subject = driver.findElement(Add_QuestionsPage.Subject_dropdown);
		subject.click();
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(excel.getDataSheetName("Questions", 1, 2), Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);
		System.out.println("subject selected");

		WebElement Topic = driver.findElement(Add_QuestionsPage.Topic_dropdown);
		Topic.click();
		Actions keyDown2 = new Actions(driver);
		keyDown2.sendKeys(excel.getDataSheetName("Questions", 1, 3), Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(1000);
		System.out.println("Topic selected");
		Thread.sleep(1000);

		driver.findElement(Add_QuestionsPage.Add_Button).click();
		Thread.sleep(1000);

		Wrapper.ScrollToTop(driver);
		Thread.sleep(2000);

		WebElement Klp = driver.findElement(Add_QuestionsPage.Klp_dropdown);
		Klp.click();
		Actions keyDown4 = new Actions(driver);
		keyDown4.sendKeys(Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(1000);

		WebElement level = driver.findElement(Add_QuestionsPage.learninglevel);
		level.click();
		Thread.sleep(1000);
		Actions keyDown3 = new Actions(driver);
		keyDown3.sendKeys(excel.getDataSheetName("Questions", 1, 4), Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(1000);

		Wrapper.ScrollToTop(driver);
		Thread.sleep(2000);

		driver.findElement(Add_QuestionsPage.Save_button).click();
		Thread.sleep(1000);
		driver.findElement(Add_QuestionsPage.Save_as_publish).click();

		//driver.findElement(Add_QuestionsPage.Save_as_draft).click();
		Thread.sleep(3000);
		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Question already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(Add_QuestionsPage.cancel_button).click();
				Thread.sleep(2000);
			} else if (toaster.contains("Question created and published")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
		
		WebElement status = driver.findElement(Add_QuestionsPage.status);
		status.click();
		Actions keyDown11 = new Actions(driver);
		keyDown11.sendKeys(Keys.chord(Keys.UP,Keys.ENTER)).perform();
		Thread.sleep(3000);
		String toaster = driver.findElement(ToasterObject.toaster).getText();
		System.out.println("Text in Toaster---"+toaster);
		
		Thread.sleep(2000);


	}

	// wait for search to display and enter text then capture results
	@Test(priority = 13, groups = { "Regression" })
	public void Search_Question() throws Exception {
		logger = extent.createTest("search Question  ", "Search question");
		logger.log(Status.INFO, "search question");
		driver.get(config.Questions());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement search_Questions = wait.until(ExpectedConditions.elementToBeClickable(Add_QuestionsPage.Search));
		search_Questions.click();
		search_Questions.sendKeys("Gdpr");
		Thread.sleep(2000);

		if (driver.findElements(Add_QuestionsPage.No_data).size() > 0) {
			String nodata = driver.findElement(Add_QuestionsPage.No_data).getText();
			System.out.println(nodata);
			logger.log(Status.INFO, nodata);

		} else if (driver.findElements(Add_QuestionsPage.search_result).size() > 0) {

			System.out.println("Search results matched and data displayed");
			logger.log(Status.INFO, "Search results matched and data displayed");

		}
		driver.findElement(Add_QuestionsPage.Search).clear();
		System.out.println("Search cleared");
		logger.log(Status.INFO, "Search cleared");

	}

	// wait for search to display and enter text then capture results
	@Test(priority = 15, groups = { "Regression" })
	public void View_Question() throws Exception {
		logger = extent.createTest("View Question  ", "View question");
		logger.log(Status.INFO, "search question");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement view = wait.until(ExpectedConditions.elementToBeClickable(Add_QuestionsPage.eye_icon));
		view.click();
		Thread.sleep(2000);
		WebElement content = driver.findElement(Add_QuestionsPage.Preview_text);
		String text = content.getText();
		logger.log(Status.INFO, text);
		System.out.println(text);
		Thread.sleep(2000);
		driver.findElement(Add_QuestionsPage.View_close).click();

	}

	// Edit Question
	@Test(priority = 14, groups = { "Regression", "SmokeTest" })
	public void Edit_Question() throws Exception {
		logger = extent.createTest("Edit Question", "Edit Question");
		logger.log(Status.INFO, "Edit question");
		driver.get(config.Questions());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement CTA = driver.findElement(Add_QuestionsPage.CTA_Button);
		CTA.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER, Keys.ENTER)).perform();
		Thread.sleep(2000);
	
		WebElement Question = driver.findElement(Add_QuestionsPage.Question_Content);
		Question.click();
		Question.clear();
		Thread.sleep(2000);
		Question.sendKeys("Question Edited - choose correct " + Wrapper.AlphaNumericString(5));
		System.out.println("Question is entered");
		Thread.sleep(3000);
		driver.findElement(Add_QuestionsPage.Save_button).click();
		Thread.sleep(1000);
		driver.findElement(Add_QuestionsPage.Save_as_publish).click();

		try {
			WebElement Toaster = wait.until(ExpectedConditions.visibilityOfElementLocated(ToasterObject.toaster));

			Toaster.isDisplayed();
			String toaster = Toaster.getText();
			if (toaster.contains("Question already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);

				driver.findElement(Add_QuestionsPage.cancel_button).click();

			} else if (toaster.contains("Question created and published")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}

	}

	// Delete Question clicking on cancel
	@Test(priority = 16, groups = { "Regression" })
	public void Delete_Question_Cancel() throws Exception {
		logger = extent.createTest("Delete Question", "Delete Question Cancel");
		logger.log(Status.INFO, "Delete question");
		driver.get(config.Questions());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(Add_QuestionsPage.CTA_Button);
		CTA.click();
		driver.findElement(Add_QuestionsPage.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Cancel = driver.findElement(Add_QuestionsPage.Delete_cancel);
		Cancel.click();
		Thread.sleep(2000);
		System.out.println("clicked on cancel button");

	}

	// Delete Question clicking on Yes
	@Test(priority = 17, groups = { "Delete" })
	public void Delete_Question_Yes() throws Exception {
		logger = extent.createTest("Delete Question Yes", "Delete Question Yes");
		logger.log(Status.INFO, "Delete question");
		driver.get(config.Questions());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(Add_QuestionsPage.CTA_Button);
		CTA.click();
		driver.findElement(Add_QuestionsPage.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Delete = driver.findElement(Add_QuestionsPage.Delete_Yes);
		Delete.click();
		Thread.sleep(2000);
		System.out.println("clicked on Yes button");
		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains(
					"Sorry, You cannot delete this question which is mapped to active or completed challenge")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);

			} else if (toaster.contains("Question deleted")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
	}

	// add new button click method used as callback
	public void Click_Add_New_Question() throws Exception {
		driver.get(config.Questions());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));

		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(Add_QuestionsPage.Add_New_Question));
		Add.click();
		/*
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.TAB, Keys.ENTER)).perform();
		Thread.sleep(2000);
		//driver.findElement(Add_QuestionsPage.Single_Choice).isDisplayed();
		//driver.findElement(Add_QuestionsPage.Single_Choice).click();
		 * 
		 */
		driver.get(config.Singlechoice());
		Thread.sleep(2000);
	}

}
