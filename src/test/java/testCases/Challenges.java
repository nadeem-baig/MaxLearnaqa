package testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.ChallengePage;
import PageObjects.ToasterObject;
import utility.Wrapper;

public class Challenges extends BaseClass {

	// navigate to add Challenge form and click on Create challenge without Name
	@Test(priority = 1, groups = { "Regression" })
	public void Add_Challenge_Name_Required() throws Exception {
		logger = extent.createTest("Challenge name*", "add Challenge Name required ");
		logger.log(Status.INFO, "add new Challenge Name Required");
		Thread.sleep(2000);
		driver.get(config.Challenge());

		Click_Add_New_Challenge();

		Thread.sleep(3000);
		driver.findElement(ChallengePage.CreateChallenge_submit).click();
		Thread.sleep(1000);
		try {
			WebElement Nameerror = driver.findElement(ChallengePage.Challenge_Error);
			Nameerror.isDisplayed();
			logger.info("Error:" + Nameerror.getText());
			String alert = Nameerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please Enter Challenge Name");

		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add Challenge form and click on Create challenge without
	// Description
	@Test(priority = 2, groups = { "Regression" })
	public void Challenge_Description_Required() throws Exception {
		logger = extent.createTest("Challenge Description*", "Challenge Description required ");
		logger.log(Status.INFO, "add new Challenge Description Required");

		WebElement Name = driver.findElement(ChallengePage.ChallengeName);
		Name.click();
		Name.sendKeys(Wrapper.randomeString(7));
		System.out.println(" Challenge Name is entered");
		Thread.sleep(2000);
		driver.findElement(ChallengePage.CreateChallenge_submit).click();
		Thread.sleep(2000);

		try {
			WebElement descerror = driver.findElement(ChallengePage.Description_error);
			descerror.isDisplayed();
			logger.info("Error:" + descerror.getText());
			String alert = descerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please Enter Challenge Description");

		} catch (Exception e) {
			logger.info(e);
		}
	}
	// navigate to add Challenge form and click on Create challenge without
	// Challenge Content

	@Test(priority = 3, groups = { "Regression" })
	public void ChallengeContent_Required() throws Exception {
		logger = extent.createTest("Challenge content*", "Challenge Content required ");
		logger.log(Status.INFO, "add new Challenge Content Required");

		WebElement Name = driver.findElement(ChallengePage.ChallengeName);
		Name.click();
		Name.clear();
		Name.sendKeys(Wrapper.randomeString(7));
		System.out.println(" Challenge Name is entered");
		Thread.sleep(2000);

		WebElement Description = driver.findElement(ChallengePage.ChallengeDescription);
		Description.click();
		Description.sendKeys(Wrapper.AlphaNumericString(10));
		System.out.println("Description filled");
		Thread.sleep(2000);

		driver.findElement(ChallengePage.CreateChallenge_submit).click();
		Thread.sleep(2000);

		try {
			WebElement contenterror = driver.findElement(ChallengePage.Challenge_Content_error);
			contenterror.isDisplayed();
			logger.info("Error:" + contenterror.getText());
			String alert = contenterror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please Select Challenge Content");

		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add Challenge form and click on Create challenge without Question
	// Per Session
	@Test(priority = 4, groups = { "Regression" })
	public void QuestionPerSession_Required() throws Exception {
		logger = extent.createTest("Challenge Question Per Session required", "verify Question Per Sessions");
		logger.log(Status.INFO, "add new Challenge Question per session Required");

		WebElement Name = driver.findElement(ChallengePage.ChallengeName);
		Name.click();
		Name.clear();
		Name.sendKeys(Wrapper.randomeString(7));
		System.out.println("Challenge Name is entered");
		Thread.sleep(2000);

		WebElement Description = driver.findElement(ChallengePage.ChallengeDescription);
		Description.click();
		Description.sendKeys(Wrapper.AlphaNumericString(10));
		System.out.println("Description filled");
		Thread.sleep(2000);

		WebElement checkbox1 = driver.findElement(ChallengePage.checkbox1);
		checkbox1.click();
		Thread.sleep(3000);
		WebElement checkbox2 = driver.findElement(ChallengePage.checkbox2);
		checkbox2.click();
		Thread.sleep(3000);

		driver.findElement(ChallengePage.CreateChallenge_submit).click();
		Thread.sleep(2000);

		try {
			WebElement qsessionerror = driver.findElement(ChallengePage.Session_error);
			qsessionerror.isDisplayed();
			logger.info("Error:" + qsessionerror.getText());
			String alert = qsessionerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please Select Question Per Session");

		} catch (Exception e) {
			logger.info(e);
		}

	}

	// navigate to add Challenge form and click on Create challenge without Sessions
	// Per Day

	@Test(priority = 5, groups = { "Regression" })
	public void SessionsPerDay_Required() throws Exception {
		logger = extent.createTest("Session per day*", "Challenge  Sessions Per Day required ");
		logger.log(Status.INFO, "add new Challenge session Per Day Required");

		WebElement Name = driver.findElement(ChallengePage.ChallengeName);
		Name.click();
		Name.clear();
		Name.sendKeys(Wrapper.randomeString(7));
		System.out.println(" Challenge Name is entered");
		Thread.sleep(2000);
		System.out.println(" Challenge Name is entered");
		Thread.sleep(2000);

		WebElement Description = driver.findElement(ChallengePage.ChallengeDescription);
		Description.click();
		Description.sendKeys(Wrapper.AlphaNumericString(10));
		System.out.println("Description filled");
		Thread.sleep(2000);

		// WebElement checkbox1 = driver.findElement(ChallengePage.checkbox1);
		// checkbox1.click();
		// Thread.sleep(5000);

		Wrapper.scrollDown(driver);
		Thread.sleep(2000);

		WebElement Questions = driver.findElement(ChallengePage.Question_PerSession);
		Questions.click();
		Thread.sleep(2000);
		System.out.println("Questions per Session dropdown is clicked");
		Actions keyDown2 = new Actions(driver);
		keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(2000);
		Wrapper.ScrollToTop(driver);
		Thread.sleep(2000);
		driver.findElement(ChallengePage.CreateChallenge_submit).click();
		Thread.sleep(2000);

		try {
			WebElement daysessionerror = driver.findElement(ChallengePage.Session_Day_error);
			daysessionerror.isDisplayed();
			logger.info("Error:" + daysessionerror.getText());
			String alert = daysessionerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please Select Sessions Per Day");

		} catch (Exception e) {
			logger.info(e);
		}

	}

	// navigate to add Challenge form and click on Create challenge without From
	// Date

	@Test(priority = 6, groups = { "Regression" })
	public void FromDate_Required() throws Exception {
		logger = extent.createTest("Challenge From date", "Challenge  From Date required ");
		logger.log(Status.INFO, "add new Challenge From Date Required");

		WebElement Name = driver.findElement(ChallengePage.ChallengeName);
		Name.click();
		Name.clear();
		Name.sendKeys(Wrapper.randomeString(7));
		System.out.println(" Challenge Name is entered");
		Thread.sleep(2000);
		System.out.println(" Challenge Name is entered");
		Thread.sleep(2000);

		WebElement Description = driver.findElement(ChallengePage.ChallengeDescription);
		Description.click();
		Description.sendKeys(Wrapper.AlphaNumericString(10));
		System.out.println("Description filled");
		Thread.sleep(2000);

		// WebElement checkbox1 = driver.findElement(ChallengePage.checkbox1);
		// checkbox1.click();
		// Thread.sleep(4000);

		Wrapper.scrollDown(driver);
		Thread.sleep(2000);

		WebElement Questions = driver.findElement(ChallengePage.Question_PerSession);
		Questions.click();
		Thread.sleep(2000);
		System.out.println("Questions per Session dropdown is clicked");
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(2000);

		Wrapper.scrollDown(driver);
		Thread.sleep(2000);

		WebElement PerDay = driver.findElement(ChallengePage.Session_PerDay);
		PerDay.click();
		Thread.sleep(2000);
		System.out.println("SessionPerDay dropdown is clicked");
		Actions keyDown2 = new Actions(driver);
		keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(2000);

		Wrapper.ScrollToTop(driver);
		Thread.sleep(2000);

		driver.findElement(ChallengePage.CreateChallenge_submit).click();
		Thread.sleep(2000);

		try {
			WebElement fromdateerror = driver.findElement(ChallengePage.From_Date_error);
			fromdateerror.isDisplayed();
			logger.info("Error:" + fromdateerror.getText());
			String alert = fromdateerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please Select From Date");

		} catch (Exception e) {
			logger.info(e);
		}

	}

	// navigate to add Challenge form and click on Create challenge without To Date

	@Test(priority = 7, groups = { "Regression" })
	public void To_Date_Required() throws Exception {
		logger = extent.createTest("Challenge To date*", "Challenge To Date required ");
		logger.log(Status.INFO, "add new Challenge To Date Required");

		WebElement Name = driver.findElement(ChallengePage.ChallengeName);
		Name.click();
		Name.clear();
		Name.sendKeys(Wrapper.randomeString(7));
		System.out.println(" Challenge Name is entered");
		Thread.sleep(2000);

		WebElement Description = driver.findElement(ChallengePage.ChallengeDescription);
		Description.click();
		Description.sendKeys(Wrapper.AlphaNumericString(10));
		System.out.println("Description filled");
		Thread.sleep(2000);

		// WebElement checkbox1 = driver.findElement(ChallengePage.checkbox1);
		// checkbox1.click();
		// Thread.sleep(4000);

		Wrapper.scrollDown(driver);
		Thread.sleep(2000);

		WebElement Questions = driver.findElement(ChallengePage.Question_PerSession);
		Questions.click();
		Thread.sleep(2000);
		System.out.println("Questions per Session dropdown is clicked");
		Actions keyDown2 = new Actions(driver);
		keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(2000);

		WebElement PerDay = driver.findElement(ChallengePage.Session_PerDay);
		PerDay.click();
		Thread.sleep(2000);
		System.out.println("SessionPerDay dropdown is clicked");
		Actions keyDown3 = new Actions(driver);
		keyDown3.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(2000);

		Wrapper.scrollDown(driver);
		Thread.sleep(2000);

		WebElement fromdate = driver.findElement(ChallengePage.FromDate);
		fromdate.click();
		Thread.sleep(2000);
		System.out.println(" From Date  is clicked");
		// fromdate.sendKeys("2023-02-28", Keys.TAB, Keys.TAB);
		WebElement Select_Date = driver.findElement(ChallengePage.select_date1);
		Select_Date.click();
		Thread.sleep(2000);

		System.out.println("From Date is entered");

		Wrapper.ScrollToTop(driver);
		Thread.sleep(2000);
		driver.findElement(ChallengePage.CreateChallenge_submit).click();
		Thread.sleep(2000);

		try {
			WebElement todateerror = driver.findElement(ChallengePage.To_Date_error);
			todateerror.isDisplayed();
			logger.info("Error:" + todateerror.getText());
			String alert = todateerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please Select To Date");

		} catch (Exception e) {
			logger.info(e);
		}

	}

	// description counter verify in create challenge form
	@Test(priority = 8, groups = { "Regression" })
	public void Description_counter() throws InterruptedException, Exception {

		logger = extent.createTest("challenge description", "verify Description counter");
		logger.log(Status.INFO, "description");
		Click_Add_New_Challenge();
		Thread.sleep(2000);

		WebElement chars = driver.findElement(ChallengePage.chars);
		System.out.println(chars.getText());
		logger.log(Status.INFO, "Description text limit - " + chars.getText());
		Thread.sleep(2000);

		WebElement Description = driver.findElement(ChallengePage.ChallengeDescription);
		Description.click();
		Description.sendKeys(Wrapper.AlphaNumericString(5));
		Thread.sleep(2000);
		System.out.println(chars.getText());
		logger.log(Status.INFO, chars.getText());
		Thread.sleep(2000);
		assertEquals(chars.getText(), "max:495 char");
		Thread.sleep(3000);
	}

	@Test(priority = 9, groups = { "Regression" })
	public void cancel() throws Exception {

		logger = extent.createTest("Challenge Cancel  ", "verify challenge cancel");
		logger.log(Status.INFO, "add new challenge click cancel");
		System.out.println("Click on cancel button");
		driver.findElement(ChallengePage.Cancel_submit).click();
		logger.info("Add new challenge form cancelled");
		Thread.sleep(3000);
	}

	// squad valid
	@Test(priority = 10, groups = { "Regression" })

	public void Select_Squad() throws Exception {

		logger = extent.createTest("Select Squad", "verify selecting squads");
		logger.log(Status.INFO, "Selecting Squads");
		Click_Add_New_Challenge();
		Thread.sleep(2000);

		driver.findElement(ChallengePage.Type_Squads).click();
		Thread.sleep(2000);

		driver.findElement(ChallengePage.PickSquads).click();
		Thread.sleep(2000);

		driver.findElement(ChallengePage.Squad_option1).click();
		Thread.sleep(2000);

		driver.findElement(ChallengePage.Squad_option2).click();
		Thread.sleep(2000);

		driver.findElement(ChallengePage.ConfirmSelection).click();
		Thread.sleep(2000);

		driver.findElement(ChallengePage.CreateChallenge_submit).click();
		Thread.sleep(2000);

		WebElement Assignedcount = driver.findElement(ChallengePage.squad_count);
		System.out.println(Assignedcount.getText());
		logger.info("Count:" + Assignedcount.getText());

		try {
			WebElement Nameerror = driver.findElement(ChallengePage.Challenge_Error);
			Nameerror.isDisplayed();
			logger.info("Error:" + Nameerror.getText());
			String alert = Nameerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please Enter Challenge Name");

		} catch (Exception e) {
			logger.info(e);
		}

	}

	// selecting already the member present in both squads
	@Test(priority = 11, groups = { "Regression" })

	public void invalid_Squad() throws Exception {

		logger = extent.createTest("Squad members present", "verify squad members present in other selected squad ");
		logger.log(Status.INFO, "select squads");
		Click_Add_New_Challenge();
		Thread.sleep(2000);

		driver.findElement(ChallengePage.Type_Squads).click();
		Thread.sleep(2000);

		driver.findElement(ChallengePage.PickSquads).click();
		Thread.sleep(2000);
		driver.findElement(ChallengePage.Squad_option3).click();
		Thread.sleep(2000);
		driver.findElement(ChallengePage.Squad_option1).click();

		System.out.println("memebrs present in other squad case");
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement Message = wait.until(ExpectedConditions.elementToBeClickable(ToasterObject.toaster));

			String toaster = Message.getText();
			if (toaster.contains("Member already present in selected squad")) {
				logger.log(Status.INFO, toaster);
				System.out.println("Error" + toaster);
				Thread.sleep(3000);
				driver.findElement(ChallengePage.Cancel_Squad).click();

			} else if (toaster.contains("Squad selected")) {
				logger.log(Status.INFO, toaster);
				System.out.println("Message" + toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.INFO, e);
		}
		Thread.sleep(3000);
	}

	@Test(priority = 12, groups = { "Regression", "SmokeTest" })

	public void Create_Challenge_Valid() throws InterruptedException, Exception {
		logger = extent.createTest("Create individual challenge", "Create New Challenge ");

		Click_Add_New_Challenge();
		Thread.sleep(2000);

		WebElement Name = driver.findElement(ChallengePage.ChallengeName);
		Name.click();
		String chalngname = Wrapper.randomeString(4);
		Name.sendKeys(excel.getDataSheetName("Challenge", 1, 1) + chalngname);
		logger.log(Status.INFO, excel.getDataSheetName("Challenge", 1, 1) + "-" + chalngname);
		System.out.println("Challenge Name is entered");

		WebElement Description = driver.findElement(ChallengePage.ChallengeDescription);
		Description.click();
		Description.sendKeys(excel.getDataSheetName("Challenge", 2, 1));
		Thread.sleep(2000);

		// select category from options

		WebElement category = driver.findElement(ChallengePage.Category_dropdown);
		category.click();
		Actions keyDown = new Actions(driver);

		keyDown.sendKeys(excel.getDataSheetName("Challenge", 3, 1), Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(1000);
		// select category from options
		WebElement Subject = driver.findElement(ChallengePage.Subject_dropdown);
		Subject.click();
		keyDown.sendKeys(excel.getDataSheetName("Challenge", 4, 1), Keys.chord(Keys.ENTER)).perform();
		;
		Thread.sleep(1000);
		WebElement checkbox1 = driver.findElement(ChallengePage.checkbox1);
		checkbox1.click();
		Thread.sleep(1000);

		Wrapper.scrollDown(driver);
		Thread.sleep(2000);

		WebElement Questions = driver.findElement(ChallengePage.Question_PerSession);
		Questions.click();
		Thread.sleep(1000);
		System.out.println("Questions per Session dropdown is clicked");
		Actions keyDown2 = new Actions(driver);
		keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(2000);

		WebElement PerDay = driver.findElement(ChallengePage.Session_PerDay);
		PerDay.click();
		Thread.sleep(1000);
		System.out.println("SessionPerDay dropdown is clicked");
		Actions keyDown3 = new Actions(driver);
		keyDown3.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(2000);

		Wrapper.scrollDown(driver);
		Thread.sleep(2000);
		WebElement fromdate = driver.findElement(ChallengePage.FromDate);
		fromdate.click();
		Thread.sleep(2000);

		System.out.println("From Date  is clicked");
		WebElement Select_Date = driver.findElement(ChallengePage.select_date1);
		Select_Date.click();
		// fromdate.sendKeys("2023-02-20", Keys.TAB, Keys.TAB);
		System.out.println("From Date is entered");
		Thread.sleep(2000);

		WebElement Todate = driver.findElement(ChallengePage.ToDate);
		Todate.click();
		Thread.sleep(2000);

		System.out.println(" To Date  is clicked");
		WebElement Select_Date1 = driver.findElement(ChallengePage.select_date2);
		Select_Date1.click();
		// Todate.sendKeys("2023-02-28", Keys.TAB, Keys.TAB);
		System.out.println("To Date is entered");
		WebElement Explanation = driver.findElement(ChallengePage.Answer_Explanation);
		Explanation.click();

		Wrapper.ScrollToTop(driver);
		Thread.sleep(1000);

		// driver.findElement(ChallengePage.IndividualLearners).click();
		// Thread.sleep(2000);

		// individual learners radio button
		driver.findElement(ChallengePage.PickLearners).click();
		Thread.sleep(2000);

		
		WebElement Parameter = driver.findElement(ChallengePage.Parameter);
		Parameter.click();
		Thread.sleep(2000);
		Actions keyDown21 = new Actions(driver);
		keyDown21.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
		System.out.println("Parameter is Selected");
		Thread.sleep(2000);

		WebElement Criteria = driver.findElement(ChallengePage.criteria);
		Criteria.click();
		Thread.sleep(2000);
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
		System.out.println("Critera is Selected");
		Thread.sleep(2000);

		WebElement Value = driver.findElement(ChallengePage.Value);
		Value.click();
		Value.sendKeys("testing");
		Thread.sleep(2000);
		System.out.println("Value is enterd");
		
		WebElement Add = driver.findElement(ChallengePage.Ruleset_add);
		Add.click();

		// learners selection
		driver.findElement(ChallengePage.Individual_option1).click();
		Thread.sleep(2000);

		driver.findElement(ChallengePage.Individual_option2).click();
		Thread.sleep(2000);

		// confirm
		driver.findElement(ChallengePage.ConfirmSelection).click();
		Thread.sleep(2000);

		WebElement Assignedcount = driver.findElement(ChallengePage.Learners_count);
		System.out.println(Assignedcount.getText());
		logger.info("Count:" + Assignedcount.getText());
		Thread.sleep(3000);

		driver.findElement(ChallengePage.CreateChallenge_submit).click();
		System.out.println("valid case create challenge");
		Thread.sleep(3000);
		try {

			WebElement Message = driver.findElement(ToasterObject.toaster);
			Message.isDisplayed();
			String toaster = Message.getText();
			if (toaster.contains("Challenges already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(ChallengePage.Cancel_submit).click();
				Thread.sleep(2000);
			} else if (toaster.contains("Challenge 'Maxlearn Challenge '" + chalngname + "created successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
		Thread.sleep(2000);
	}

	// wait for search to display and enter text then capture results
	@Test(priority = 13, groups = { "Regression" })
	public void Search_Challenge() throws Exception {
		logger = extent.createTest("Search Challenge", "Search challenges");
		logger.log(Status.INFO, "search Challenge");

		driver.get(config.Challenge());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement search_Challenge = wait
				.until(ExpectedConditions.elementToBeClickable(ChallengePage.Search_Challenge));
		search_Challenge.click();
		Thread.sleep(2000);
		search_Challenge.sendKeys("Maxlearn");
		Thread.sleep(2000);

		if (driver.findElements(ChallengePage.No_data).size() > 0) {
			String nodata = driver.findElement(ChallengePage.No_data).getText();
			System.out.println(nodata);
			logger.log(Status.INFO, nodata);

		} else if (driver.findElements(ChallengePage.search_result).size() > 0) {

			driver.findElement(ChallengePage.View_Challenge).click();
			Thread.sleep(3000);
			System.out.println("Search results matched and data displayed");
			logger.log(Status.INFO, "Search results matched and data displayed");

		}
		Thread.sleep(2000);
	}

	// view Challenge
	@Test(priority = 14, groups = { "Regression" })
	public void View_Challenge() throws Exception {
		logger = extent.createTest("view Challenge", "view challenge details");
		logger.log(Status.INFO, "view Challenge details");
		driver.get(config.Challenge());
		Thread.sleep(2000);
		WebElement view_Challenge = driver.findElement(ChallengePage.View_Challenge);
		view_Challenge.click();

		// capture details
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement DetailsTab = wait.until(ExpectedConditions.elementToBeClickable(ChallengePage.Details_Tab));
		DetailsTab.isDisplayed();
		String Message = DetailsTab.getText();
		System.out.println("Tab Text--" + Message);
		logger.log(Status.INFO, Message);

		WebElement ParticipantsTab = wait
				.until(ExpectedConditions.elementToBeClickable(ChallengePage.participants_Tab));
		ParticipantsTab.isDisplayed();
		String Message1 = ParticipantsTab.getText();
		System.out.println("Tab Text--" + Message1);
		logger.log(Status.INFO, Message1);

		WebElement Notification_Tab = wait
				.until(ExpectedConditions.elementToBeClickable(ChallengePage.Notification_Tab));
		Notification_Tab.isDisplayed();
		String Message2 = Notification_Tab.getText();
		System.out.println("Tab Text--" + Message2);
		logger.log(Status.INFO, Message2);

	}

	// view Challenge Detail Tab
	@Test(priority = 15, groups = { "Regression" })
	public void View_Detail_Tab() throws Exception {
		logger = extent.createTest("challenge Detail Tab", "view challenge Detail Tab");
		logger.log(Status.INFO, "view Detail");
		driver.get(config.Challenge());
		Thread.sleep(2000);
		WebElement view_Challenge = driver.findElement(ChallengePage.View_Challenge);
		view_Challenge.click();

		// capture details
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement DetailsTab = wait.until(ExpectedConditions.elementToBeClickable(ChallengePage.Details_Tab));
		DetailsTab.isDisplayed();
		String Message1 = DetailsTab.getText();
		System.out.println("Text--" + Message1);
		logger.log(Status.INFO, "tab - " + Message1);

		if (driver.findElement(ChallengePage.Publish_status).isDisplayed()) {
			WebElement publish_Status = driver.findElement(ChallengePage.Publish_status);
			String Message2 = publish_Status.getText();
			System.out.println("Text--" + Message2);
			logger.log(Status.INFO, " Status - " + Message2);
		} else if (driver.findElement(ChallengePage.Draft_status).isDisplayed()) {
			WebElement Draft_Status = driver.findElement(ChallengePage.Draft_status);
			String Message2 = Draft_Status.getText();
			System.out.println("Text--" + Message2);
			logger.log(Status.INFO, " Status - " + Message2);
		}
		WebElement Challenge_Name = driver.findElement(ChallengePage.Challenge_Text);
		Challenge_Name.isDisplayed();
		String Message3 = Challenge_Name.getText();
		System.out.println("Text--" + Message3);
		logger.log(Status.INFO, "Challenge Name - " + Message3);

	}

	// view Participants Tab
	@Test(priority = 16, groups = { "Regression" })
	public void View_Participants_Tab() throws Exception {
		logger = extent.createTest("View Participants Tab", "view Participants Tab details");
		logger.log(Status.INFO, "view Participants");
		driver.get(config.Challenge());
		Thread.sleep(2000);
		WebElement view_Challenge = driver.findElement(ChallengePage.View_Challenge);
		view_Challenge.click();

		driver.findElement(ChallengePage.participants_Tab).click();

		// capture details
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement Participants = wait.until(ExpectedConditions.elementToBeClickable(ChallengePage.participants_Tab));
		Participants.isDisplayed();
		String Message1 = Participants.getText();
		System.out.println("Tab Text--" + Message1);
		logger.log(Status.INFO, "Tab - " + Message1);

		List<WebElement> Challenges = driver.findElements(ChallengePage.member_count);
		int Count = Challenges.size();
		System.out.println("Total number of Members are: " + Count);
		logger.log(Status.INFO, "Total number of Members are--" + Count);

	}
	// view Notification Tab
		@Test(priority = 17, groups = { "Regression" })
		public void View_Notification_Tab() throws Exception {
			logger = extent.createTest("View Notification Tab", "view Notification Tab details");
			logger.log(Status.INFO, "view Notification");
			driver.get(config.Challenge());
			Thread.sleep(2000);
			WebElement view_Challenge = driver.findElement(ChallengePage.View_Challenge);
			view_Challenge.click();

			driver.findElement(ChallengePage.Notification_Tab).click();

			// capture details
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

			WebElement Notification = wait.until(ExpectedConditions.elementToBeClickable(ChallengePage.Notification_Tab));
			Notification.isDisplayed();
			String Message1 = Notification.getText();
			System.out.println("Tab Text--" + Message1);
			logger.log(Status.INFO, "Tab - " + Message1);
			
			WebElement toggle = wait.until(ExpectedConditions.elementToBeClickable(ChallengePage.toggle));
			toggle.isDisplayed();
			String text = toggle.getText();
			System.out.println("Toggle button Text--" + text);
			logger.log(Status.INFO, "Tab - " + text);
			
			

			

		}

	// Edit Challenge
	@Test(priority = 18, groups = { "Regression" })
	public void Edit_Challenge() throws Exception {
		logger = extent.createTest("Edit Challenge", "Challenge Edit");
		logger.log(Status.INFO, "Edit Challenge");
		driver.get(config.Challenge());
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		if (driver.findElements(ChallengePage.CTA_Button1).size() > 0) {

			System.out.println("Edit Element is Present");

			WebElement CTA = wait.until(ExpectedConditions.elementToBeClickable(ChallengePage.CTA_Button1));
			CTA.click();
			Actions keyDown = new Actions(driver);
			keyDown.sendKeys(Keys.chord(Keys.ENTER, Keys.ENTER)).perform();

			WebElement Name = wait.until(ExpectedConditions.elementToBeClickable(ChallengePage.ChallengeName));
			Name.click();
			Name.clear();
			Name.sendKeys("Maxlearn");
			System.out.println("Challenge name is entered");
			Thread.sleep(2000);
			driver.findElement(ChallengePage.Update).click();
			Thread.sleep(3000);

			try {
				driver.findElement(ToasterObject.toaster).isDisplayed();
				String toaster = driver.findElement(ToasterObject.toaster).getText();
				if (toaster.contains("Challenge already exist")) {
					logger.log(Status.INFO, toaster);
					System.out.println(toaster);
					Thread.sleep(2000);
					driver.findElement(ChallengePage.Cancel_submit).click();
					Thread.sleep(2000);
				} else if (toaster.contains("Challenge updated successfully")) {
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
			logger.log(Status.INFO, "Edit Element is Absent for challenge");

		}
	}

	// Delete Challenge clicking on cancel
	@Test(priority = 19, groups = { "Regression" })
	public void Delete_Challenge_Cancel() throws Exception {
		logger = extent.createTest("Delete Challenge No", "verify Challenge delete no");
		logger.log(Status.INFO, "Delete Challenge Cancel");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		Thread.sleep(3000);
		if (driver.findElements(ChallengePage.CTA_Button).size() > 0) {
			System.out.println("Delete Element is Present");
			WebElement CTA = wait.until(ExpectedConditions.elementToBeClickable(ChallengePage.CTA_Button));

			CTA.click();
			WebElement Delete = wait.until(ExpectedConditions.elementToBeClickable(ChallengePage.Delete_Button));

			Delete.click();
			WebElement Cancel = wait.until(ExpectedConditions.elementToBeClickable(ChallengePage.Delete_cancel));

			Cancel.click();

			System.out.println("clicked on cancel button");
		} else {
			System.out.println("Delete Element is Absent");
			logger.log(Status.INFO, "Delete Element is Absent for challenge");
		}
	}
	@Test(priority = 20, groups = { "Regression","test" })
	public void Challenge_Status() throws Exception {
		logger = extent.createTest("Add Challenge Status Change",
				"Changing the status");
		logger.log(Status.INFO, "add new Challenge Status");
		driver.get(config.Challenge());

		Thread.sleep(3000);
		WebElement status = driver.findElement(ChallengePage.status1);
		status.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN,Keys.ENTER)).perform();
		Thread.sleep(2000);
		String toaster = driver.findElement(ToasterObject.toaster).getText();
		System.out.println("Text in Toaster---"+toaster);
		
		WebElement status1 = driver.findElement(ChallengePage.status1);
		status1.click();
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.UP,Keys.ENTER)).perform();
		Thread.sleep(2000);
		
		
		WebElement Toggle = driver.findElement(ChallengePage.status);
		Toggle.click();
		Thread.sleep(3000);
		WebElement Toggle1 = driver.findElement(ChallengePage.status);
		Toggle1.click();
		

	}
	// Delete Challenge clicking on Yes
	@Test(priority = 21, groups = { "Delete" })
	public void Delete_Challenge_Yes() throws Exception {
		logger = extent.createTest("Delete Challenge yes", "Delete challenge Yes");
		logger.log(Status.INFO, "Delete Challenge");
		driver.get(config.Challenge());

		Thread.sleep(3000);
		if (driver.findElements(ChallengePage.CTA_Button).size() > 0) {
			System.out.println("Delete Element is Present");

			WebElement CTA = driver.findElement(ChallengePage.CTA_Button);
			CTA.click();
			driver.findElement(ChallengePage.Delete_Button).click();
			Thread.sleep(2000);
			WebElement Delete = driver.findElement(ChallengePage.Delete_Yes);
			Delete.click();
			System.out.println("clicked on Yes button");
			try {
				// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

				// WebElement toastermessage = wait
				// .until(ExpectedConditions.elementToBeClickable(driver.findElement(ToasterObject.toaster)));

				WebElement toastermessage = driver.findElement(ToasterObject.toaster);
				String toaster = toastermessage.getText();
				if (toaster.contains("Challenge Maxlearn Deleted")) {
					logger.log(Status.INFO, toaster);
					System.out.println(toaster);
					Thread.sleep(2000);
				} else if (toaster.contains("Sorry, You cannot delete this Challenge which is mapped to questions")) {
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
			logger.log(Status.INFO, "Delete Element is Absent for challenge");
		}
	}

	// add new button click method used as callback
	public void Click_Add_New_Challenge() {
		driver.get(config.Challenge());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(ChallengePage.CreateChallenge_Main));
		Add.click();

	}
}
