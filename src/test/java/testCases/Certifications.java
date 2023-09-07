package testCases;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.CertficationsPage;

import PageObjects.ToasterObject;
import utility.Wrapper;

public class Certifications extends BaseClass {

	@Test(priority = 1, groups = { "Regression" })
	public void Add_Cert_Name_Required() throws Exception {
		logger = extent.createTest("Cert name*", "add Cert Name required ");
		logger.log(Status.INFO, "add new Cert Name Required");
		Click_Add_New_Cert();
		System.out.println("Create cert page opened");
		Thread.sleep(1000);

		driver.findElement(CertficationsPage.Createcert).click();
		Thread.sleep(1000);
		try {
			WebElement Nameerror = driver.findElement(CertficationsPage.Cert_Error);
			Nameerror.isDisplayed();
			logger.info("Error:" + Nameerror.getText());
			String alert = Nameerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please enter Cert Name");

		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add Cert form and click on Create cert without Description
	@Test(priority = 2, groups = { "Regression" })
	public void Cert_Description_Required() throws Exception {
		logger = extent.createTest("Cert Description*", "Cert Description required ");
		logger.log(Status.INFO, "add new Cert Description Required");

		WebElement Name = driver.findElement(CertficationsPage.CertName);
		Name.click();
		Name.sendKeys(Wrapper.randomeString(7));
		System.out.println("Cert Name is entered");
		Thread.sleep(1000);
		driver.findElement(CertficationsPage.Createcert).click();
		Thread.sleep(1000);

		try {
			WebElement descerror = driver.findElement(CertficationsPage.Description_error);
			descerror.isDisplayed();
			logger.info("Error:" + descerror.getText());
			String alert = descerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please Enter Certfication Description");

		} catch (Exception e) {
			logger.info(e);
		}
	}
	// navigate to add Cert form and click on Create Certfications without cert
	// Content

	@Test(priority = 3, groups = { "Regression" })
	public void CertContent_Required() throws Exception {
		logger = extent.createTest("Cert content*", "Cert Content required ");
		logger.log(Status.INFO, "add new cert Content Required");

		WebElement Name = driver.findElement(CertficationsPage.CertName);
		Name.click();
		Name.clear();
		Name.sendKeys(Wrapper.randomeString(7));
		System.out.println("Cert Name is entered");
		Thread.sleep(1000);

		WebElement Description = driver.findElement(CertficationsPage.CertDescription);
		Description.click();
		Description.clear();
		Description.sendKeys(Wrapper.AlphaNumericString(10));
		System.out.println("Description filled");
		Thread.sleep(1000);

		driver.findElement(CertficationsPage.Createcert).click();
		Thread.sleep(1000);

		try {
			WebElement contenterror = driver.findElement(CertficationsPage.Cert_Content_error);
			contenterror.isDisplayed();
			logger.info("Error:" + contenterror.getText());
			String alert = contenterror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please Select Questions");

		} catch (Exception e) {
			logger.info(e);
		}
	}

	@Test(priority = 4, groups = { "Regression" })
	public void PassingPercentage_Required() throws Exception {
		logger = extent.createTest("Cert PassingPercentage*", "Passing Percentage required ");
		logger.log(Status.INFO, "add new cert Passing Percentage Required");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement Name = driver.findElement(CertficationsPage.CertName);
		Name.click();
		Name.clear();
		Name.sendKeys(Wrapper.randomeString(7));
		System.out.println("Cert Name is entered");
		Thread.sleep(1000);

		WebElement Description = driver.findElement(CertficationsPage.CertDescription);
		Description.click();
		Description.clear();
		Description.sendKeys(Wrapper.AlphaNumericString(10));
		System.out.println("Description filled");
		Thread.sleep(1000);

		Wrapper.scrollDown(driver);
		Thread.sleep(1000);

		// select category from options

		WebElement category = driver.findElement(CertficationsPage.Category_dropdown);
		category.click();
		Actions keyDown = new Actions(driver);

		keyDown.sendKeys(excel.getDataSheetName("Certifications", 4, 1), Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);
		System.out.println("Category selected");

		// select subject from options
		WebElement Subject = wait.until(ExpectedConditions.elementToBeClickable(CertficationsPage.Subject_dropdown));
		Subject.click();
		keyDown.sendKeys(excel.getDataSheetName("Certifications", 5, 1), Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);

		WebElement checkbox1 = driver.findElement(CertficationsPage.checkbox1);
		checkbox1.click();
		Thread.sleep(2000);

		WebElement learninglevel = wait.until(ExpectedConditions.elementToBeClickable(CertficationsPage.learninglevel));
		learninglevel.click();
		Thread.sleep(2000);
		System.out.println("click learning level");

		Actions keyDown2 = new Actions(driver);
		keyDown2.sendKeys(Keys.chord(Keys.TAB)).perform();
		Thread.sleep(1000);
		System.out.println("selected learning level");

		WebElement pickquestions = driver.findElement(CertficationsPage.PickQuestions);
		pickquestions.click();
		Thread.sleep(1000);
		System.out.println("click pick questions");

		WebElement question1 = driver.findElement(CertficationsPage.selectQuestion1);
		question1.click();
		Thread.sleep(1000);
		System.out.println("select one questions");

		WebElement question2 = driver.findElement(CertficationsPage.selectQuestion2);
		question2.click();
		Thread.sleep(1000);
		System.out.println("select second questions");

		WebElement confirmquestion = driver.findElement(CertficationsPage.confirmselection_question);
		confirmquestion.click();
		Thread.sleep(1000);
		System.out.println("confirm questions");

		Wrapper.ScrollToTop(driver);
		Thread.sleep(1000);
		System.out.println("Scroll top");

		driver.findElement(CertficationsPage.Createcert).click();
		Thread.sleep(2000);

		try {
			WebElement Percentageerror = driver.findElement(CertficationsPage.PassingPer_error);
			Percentageerror.isDisplayed();
			logger.info("Error:" + Percentageerror.getText());
			String alert = Percentageerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please Select Passing Percentag");

		} catch (Exception e) {
			logger.info(e);
		}
	}

	@Test(priority = 5, groups = { "Regression" })
	public void Fromdate_Required() throws Exception {
		logger = extent.createTest("Cert Fromdate*", "Fromdate required ");
		logger.log(Status.INFO, "add new cert From date Required");

		WebElement Name = driver.findElement(CertficationsPage.CertName);
		Name.click();
		Name.clear();
		Name.sendKeys(Wrapper.randomeString(7));
		System.out.println("Cert Name is entered");
		Thread.sleep(2000);

		WebElement Description = driver.findElement(CertficationsPage.CertDescription);
		Description.click();
		Description.clear();
		Description.sendKeys(Wrapper.AlphaNumericString(10));
		System.out.println("Description filled");
		Thread.sleep(2000);

		Wrapper.scrollDown(driver);
		Thread.sleep(2000);

		WebElement Passpercentage = driver.findElement(CertficationsPage.Passing_Percentage);
		Passpercentage.click();
		Passpercentage.clear();
		Passpercentage.sendKeys("50");
		System.out.println("Percentage selected");

		Wrapper.ScrollToTop(driver);
		Thread.sleep(2000);

		driver.findElement(CertficationsPage.Createcert).click();
		Thread.sleep(2000);

		try {
			WebElement Fromdateerror = driver.findElement(CertficationsPage.From_Date_error);
			Fromdateerror.isDisplayed();
			logger.info("Error:" + Fromdateerror.getText());
			String alert = Fromdateerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please Select From Date");

		} catch (Exception e) {
			logger.info(e);
		}
	}

	@Test(priority = 6, groups = { "Regression" })
	public void Todate_Required() throws Exception {
		logger = extent.createTest("Cert Todate*", "Todate required ");
		logger.log(Status.INFO, "add new cert To date Required");

		WebElement Name = driver.findElement(CertficationsPage.CertName);
		Name.click();
		Name.clear();
		Name.sendKeys(Wrapper.randomeString(7));
		System.out.println("Cert Name is entered");
		Thread.sleep(2000);

		WebElement Description = driver.findElement(CertficationsPage.CertDescription);
		Description.click();
		Description.clear();
		Description.sendKeys(Wrapper.AlphaNumericString(10));
		System.out.println("Description filled");
		Thread.sleep(2000);

		Wrapper.scrollDown(driver);
		Thread.sleep(2000);

		WebElement Passpercentage = driver.findElement(CertficationsPage.Passing_Percentage);
		Passpercentage.click();
		Passpercentage.clear();
		Passpercentage.sendKeys("50");
		System.out.println("Percentage selected");

		WebElement fromdate = driver.findElement(CertficationsPage.FromDate);
		fromdate.click();
		Thread.sleep(2000);

		System.out.println("From Date  is clicked");
		WebElement Select_Date = driver.findElement(CertficationsPage.select_date1);
		Select_Date.click();
		System.out.println("From Date is entered");
		Thread.sleep(2000);

		Wrapper.ScrollToTop(driver);
		Thread.sleep(2000);

		driver.findElement(CertficationsPage.Createcert).click();
		Thread.sleep(2000);

		try {
			WebElement Todateerror = driver.findElement(CertficationsPage.To_Date_error);
			Todateerror.isDisplayed();
			logger.info("Error:" + Todateerror.getText());
			String alert = Todateerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please Select To Date");

		} catch (Exception e) {
			logger.info(e);
		}
	}

	@Test(priority = 7, groups = { "Regression", "SmokeTest" })

	public void Create_Cert_Valid() throws InterruptedException, Exception {
		logger = extent.createTest("Create Cert", "Create New Cert ");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		Click_Add_New_Cert();
		System.out.println("Create cert page opened");
		Thread.sleep(2000);

		WebElement Name = driver.findElement(CertficationsPage.CertName);
		Name.click();

		Name.sendKeys(excel.getDataSheetName("Certifications", 1, 1));
		logger.log(Status.INFO, excel.getDataSheetName("Certifications", 1, 1));
		System.out.println("Cert Name is entered");

		WebElement Description = driver.findElement(CertficationsPage.CertDescription);
		Description.click();

		System.out.println("Cert Description is entered");
		Description.sendKeys(excel.getDataSheetName("Certifications", 2, 1));
		Thread.sleep(2000);

		WebElement PickLearners = driver.findElement(CertficationsPage.PickLearners);
		PickLearners.click();
		Thread.sleep(2000);

		WebElement IndiviualLearners = driver.findElement(CertficationsPage.IndividualLearners);
		IndiviualLearners.click();
		Thread.sleep(2000);

		WebElement SelectParameter = driver.findElement(CertficationsPage.Parameter);
		SelectParameter.click();
		Thread.sleep(2000);
		Actions keyDown3 = new Actions(driver);
		keyDown3.sendKeys(Keys.chord(Keys.DOWN, Keys.TAB)).perform();
		Thread.sleep(1000);

		WebElement Selectcriteria = driver.findElement(CertficationsPage.Criteria);
		Selectcriteria.click();
		Thread.sleep(2000);
		Actions keyDown4 = new Actions(driver);
		keyDown4.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.TAB)).perform();
		Thread.sleep(1000);

		WebElement Selectvalue = driver.findElement(CertficationsPage.Value);
		Selectvalue.click();
		Selectvalue.sendKeys(excel.getDataSheetName("Certifications", 3, 1));
		Thread.sleep(1000);

		WebElement Add_button = driver.findElement(CertficationsPage.Add);
		Add_button.click();
		Thread.sleep(1000);

		WebElement learner1 = driver.findElement(CertficationsPage.Individual_learner1);
		learner1.click();
		Thread.sleep(1000);

		WebElement learner2 = driver.findElement(CertficationsPage.Individual_learner2);
		learner2.click();
		Thread.sleep(1000);

		WebElement confirm_learner = driver.findElement(CertficationsPage.ConfirmSelection);
		confirm_learner.click();
		Thread.sleep(1000);

		// select category from options

		WebElement category = driver.findElement(CertficationsPage.Category_dropdown);
		category.click();
		Actions keyDown = new Actions(driver);

		keyDown.sendKeys(excel.getDataSheetName("Certifications", 4, 1), Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);
		System.out.println("Category selected");

		// select subject from options
		WebElement Subject = driver.findElement(CertficationsPage.Subject_dropdown);
		Subject.click();
		keyDown.sendKeys(excel.getDataSheetName("Certifications", 5, 1), Keys.chord(Keys.ENTER)).perform();

		Thread.sleep(2000);
		WebElement checkbox1 = driver.findElement(CertficationsPage.checkbox1);
		checkbox1.click();
		Thread.sleep(3000);

		WebElement learninglevel = wait.until(ExpectedConditions.elementToBeClickable(CertficationsPage.learninglevel));
		learninglevel.click();
		Thread.sleep(2000);
		System.out.println("click learning level");

		Actions keyDown2 = new Actions(driver);
		keyDown2.sendKeys(Keys.chord(Keys.TAB)).perform();
		Thread.sleep(2000);
		System.out.println("selected learning level");

		WebElement pickquestions = driver.findElement(CertficationsPage.PickQuestions);
		pickquestions.click();
		Thread.sleep(2000);
		System.out.println("click pick questions");

		WebElement question1 = driver.findElement(CertficationsPage.selectQuestion1);
		question1.click();
		Thread.sleep(1000);
		System.out.println("select one questions");

		WebElement question2 = driver.findElement(CertficationsPage.selectQuestion2);
		question2.click();
		Thread.sleep(1000);
		System.out.println("select second questions");

		WebElement confirmquestion = driver.findElement(CertficationsPage.confirmselection_question);
		confirmquestion.click();
		Thread.sleep(2000);
		System.out.println("confirm questions");

		Wrapper.scrollDown(driver);
		Thread.sleep(2000);

		WebElement fromdate = driver.findElement(CertficationsPage.FromDate);
		fromdate.click();
		Thread.sleep(2000);

		System.out.println("From Date  is clicked");
		WebElement Select_Date = driver.findElement(CertficationsPage.select_date1);
		Select_Date.click();
		System.out.println("From Date is entered");
		Thread.sleep(2000);

		WebElement Todate = driver.findElement(CertficationsPage.ToDate);
		Todate.click();
		Thread.sleep(2000);
		System.out.println("To Date  is clicked");

		WebElement Select_Date1 = driver.findElement(CertficationsPage.select_date2);
		Select_Date1.click();
		System.out.println("To Date is entered");

		WebElement frequency = driver.findElement(CertficationsPage.Certfrequency);
		frequency.click();
		System.out.println("Frequency dropdown opened");

		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.TAB)).perform();
		Thread.sleep(1000);
		System.out.println("Frequency selected");
		Wrapper.scrollDown(driver);
		Thread.sleep(2000);

		WebElement Passpercentage = driver.findElement(CertficationsPage.Passing_Percentage);
		Passpercentage.click();
		Passpercentage.sendKeys("75");
		System.out.println("Percentage selected");
		Thread.sleep(2000);
		System.out.println("scrolling");

		Wrapper.ScrollToTop(driver);
		Thread.sleep(2000);
		System.out.println("scroll to top");

		driver.findElement(CertficationsPage.Createcert).click();
		Thread.sleep(1000);
		try {

			WebElement Message = driver.findElement(ToasterObject.toaster);
			Message.isDisplayed();
			String toaster = Message.getText();
			if (toaster.contains("Cert already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(CertficationsPage.Cancel_submit).click();
				Thread.sleep(2000);
			} else if (toaster.contains("Certs created successfully")) {
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
	@Test(priority = 8, groups = { "Regression" })
	public void Search_Certifications() throws Exception {
		logger = extent.createTest("Search Cert", "Search cert");
		logger.log(Status.INFO, "search cert");

		driver.get(config.Certifications());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement search_Cert = wait.until(ExpectedConditions.elementToBeClickable(CertficationsPage.Search_Cert));
		search_Cert.click();
		Thread.sleep(2000);
		search_Cert.sendKeys("Maxlearn");
		Thread.sleep(2000);

		if (driver.findElements(CertficationsPage.No_data).size() > 0) {
			String nodata = driver.findElement(CertficationsPage.No_data).getText();
			System.out.println(nodata);
			logger.log(Status.INFO, nodata);

		} else if (driver.findElements(CertficationsPage.search_result).size() > 0) {

			driver.findElement(CertficationsPage.View_cert).click();
			Thread.sleep(3000);
			System.out.println("Search results matched and data displayed");
			logger.log(Status.INFO, "Search results matched and data displayed");

		}
		Thread.sleep(2000);
	}

	// view cert
	@Test(priority = 9, groups = { "Regression" })
	public void View_Certifications() throws Exception {
		logger = extent.createTest("view Cert", "view cert details");
		logger.log(Status.INFO, "view cert details");
		driver.get(config.Certifications());
		Thread.sleep(2000);
		WebElement view_cert = driver.findElement(CertficationsPage.View_cert);
		view_cert.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement Details = wait.until(ExpectedConditions.elementToBeClickable(CertficationsPage.Details_Tab));
		String Detailstext = Details.getText();
		logger.log(Status.INFO, Detailstext);

		WebElement Participants = wait
				.until(ExpectedConditions.elementToBeClickable(CertficationsPage.participants_Tab));
		String ParticipantsText = Participants.getText();
		logger.log(Status.INFO, ParticipantsText);

		WebElement Notification_Tab = wait
				.until(ExpectedConditions.elementToBeClickable(CertficationsPage.Notification_Tab));
		String Notifications = Notification_Tab.getText();
		logger.log(Status.INFO, Notifications);

	}

	// Edit Certifications
	@Test(priority = 10, groups = { "Regression", "SmokeTest" })
	public void Edit_Cert() throws Exception {
		logger = extent.createTest("Edit Cert", "Cert Edit");
		logger.log(Status.INFO, "Edit Cert");
		driver.get(config.Certifications());
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement CTA = wait.until(ExpectedConditions.elementToBeClickable(CertficationsPage.CTA_Button));
		CTA.click();
		if (driver.findElement(CertficationsPage.Edit).isDisplayed()) {

			System.out.println("Edit Element is Present");

			Actions keyDown = new Actions(driver);
			keyDown.sendKeys(Keys.chord(Keys.ENTER, Keys.ENTER)).perform();

			WebElement Name = wait.until(ExpectedConditions.elementToBeClickable(CertficationsPage.CertName));
			Name.click();
			Name.clear();
			Name.sendKeys("Maxlearn");
			System.out.println("Certfications name is entered");
			Thread.sleep(2000);
			driver.findElement(CertficationsPage.update).click();
			Thread.sleep(3000);

			try {
				driver.findElement(ToasterObject.toaster).isDisplayed();
				String toaster = driver.findElement(ToasterObject.toaster).getText();
				if (toaster.contains("Certfications already exist")) {
					logger.log(Status.INFO, toaster);
					System.out.println(toaster);
					Thread.sleep(2000);
					driver.findElement(CertficationsPage.Cancel_submit).click();
					Thread.sleep(2000);
				} else if (toaster.contains("Certfications updated successfully")) {
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
			logger.log(Status.INFO, "Edit Element is Absent for Certfications");

		}

	}

	// Delete Certifications clicking on cancel
	@Test(priority = 11, groups = { "Regression" })
	public void Delete_Cert_Cancel() throws Exception {
		logger = extent.createTest("Delete cert No", "verify cert delete no");
		logger.log(Status.INFO, "Delete cert Cancel");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement status = wait.until(ExpectedConditions.elementToBeClickable(CertficationsPage.status_dropdown));
		status.click();
		System.out.println("click status dropdown");
		Thread.sleep(1000);

		WebElement draftstatus = driver.findElement(CertficationsPage.Draft_status);
		draftstatus.click();
		System.out.println("click draft status");
		Thread.sleep(1000);

		if (driver.findElements(CertficationsPage.CTA_Button).size() > 0) {
			System.out.println("Delete Element is Present");

			WebElement CTA = wait.until(ExpectedConditions.elementToBeClickable(CertficationsPage.CTA_Button));
			CTA.click();
			Actions keyDown = new Actions(driver);
			keyDown.sendKeys(Keys.chord(Keys.TAB, Keys.DOWN)).perform();

			WebElement Delete = wait.until(ExpectedConditions.elementToBeClickable(CertficationsPage.Delete_Button));

			Thread.sleep(1000);

			Delete.click();
			WebElement Cancel = wait.until(ExpectedConditions.elementToBeClickable(CertficationsPage.Delete_cancel));

			Cancel.click();

			System.out.println("clicked on cancel button");
		} else {
			System.out.println("Delete Element is Absent");
			logger.log(Status.INFO, "Delete Element is Absent for Certifications");
		}
	}

	// Delete Certifications clicking on Yes
	@Test(priority = 12, groups = { "Regression" })
	public void Delete_Cert_Yes() throws Exception {
		logger = extent.createTest("Delete cert yes", "Delete cert Yes");
		logger.log(Status.INFO, "Delete Cert");

		Thread.sleep(3000);
		if (driver.findElements(CertficationsPage.CTA_Button).size() > 0) {
			System.out.println("Delete Element is Present");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

			WebElement CTA = wait.until(ExpectedConditions.elementToBeClickable(CertficationsPage.CTA_Button));
			CTA.click();

			Thread.sleep(2000);
			WebElement Delete = driver.findElement(CertficationsPage.Delete_Button);
			Delete.click();
			WebElement yes = wait.until(ExpectedConditions.elementToBeClickable(CertficationsPage.Delete_Yes));

			yes.click();
			Thread.sleep(2000);
			System.out.println("clicked on Yes button");
			try {
				// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

				// WebElement toastermessage = wait
				// .until(ExpectedConditions.elementToBeClickable(driver.findElement(ToasterObject.toaster)));

				WebElement toastermessage = driver.findElement(ToasterObject.toaster);
				String toaster = toastermessage.getText();
				if (toaster.contains("Cert Maxlearn Deleted")) {
					logger.log(Status.INFO, toaster);
					System.out.println(toaster);
					Thread.sleep(2000);
				} else if (toaster.contains("Sorry, You cannot delete this Cert which is mapped to questions")) {
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
			logger.log(Status.INFO, "Delete Element is Absent for cert");
		}
	}

	// add new button click method used as callback
	public void Click_Add_New_Cert() {
		driver.get(config.Certifications());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(CertficationsPage.CreateCert_Main));
		Add.click();

	}

}