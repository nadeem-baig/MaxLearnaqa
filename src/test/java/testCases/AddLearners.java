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

import PageObjects.LearnersPage;
import PageObjects.ToasterObject;
import utility.Wrapper;

public class AddLearners extends BaseClass {
	@Test(priority = 1, groups = { "Regression", "SmokeTest" })
	public void Verify_Add_New_Learner_isDisplayed() throws Exception {
		logger = extent.createTest("Add learner Button", "Verify add learner is displayed");
 
		driver.get(config.learnersurl());
 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		 
		WebElement AddNewLearner = wait
				.until(ExpectedConditions.visibilityOfElementLocated(LearnersPage.Heading));
		String pageheading = AddNewLearner.getText();
		System.out.println("Message - " + pageheading);
	
		//Assert.assertEquals(true, AddNewLearner.isDisplayed());
		logger.log(Status.INFO, "Add new Learner button displayed");
		System.out.println("Add new Learner button displayed");
		Thread.sleep(4000);
	}
 
	@Test(priority = 2, groups = { "Regression" })
	public void Add_New_Learner_Name_Required() throws Exception {
		logger = extent.createTest("Learner name*", "verify add new learner name required");
 
		Click_Add_New_Learner();
		System.out.println("In add learner page");
 
		Thread.sleep(2000);
		// name validation
		WebElement Learner_Name = driver.findElement(LearnersPage.Learner_name);
		Learner_Name.click();
 
		Thread.sleep(2000);
		WebElement Emp_ID = driver.findElement(LearnersPage.Employee_ID);
		Emp_ID.click();
 
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 
			WebElement Learner_Name_Error_ob = wait
					.until(ExpectedConditions.elementToBeClickable(LearnersPage.errormessage));
			String Learner_Name_Error = Learner_Name_Error_ob.getText();
			if (Learner_Name_Error.contains("Name is Required")) {
				logger.log(Status.INFO, "Message - Name is Required");
				System.out.println("Message - Name is Required");
			} else if (Learner_Name_Error.contains("Can contain only alphabets")) {
				logger.log(Status.INFO, "Message - Can contain only alphabets");
				System.out.println("Message - Can contain only alphabets");
			} else if (Learner_Name_Error.contains("Cannot be greater than 60")) {
				logger.log(Status.INFO, "Message - Cannot be greater than 60");
				System.out.println("Message - Cannot be greater than 60");
			}
 
		} catch (Exception e) {
			logger.log(Status.FAIL, e);
		}
		Thread.sleep(2000);
	}
	// verify Emp ID required
 
	@Test(priority = 3, groups = { "Regression" })
	public void Learner_EmpID_Required() throws InterruptedException {
		logger = extent.createTest("Learner Emp ID*", "verify add new learner emp id required");
 
		Thread.sleep(2000);
		WebElement Learner_Name = driver.findElement(LearnersPage.Learner_name);
		Learner_Name.click();
		Learner_Name.sendKeys(Wrapper.randomeString(6));
		Thread.sleep(2000);
		// emp id required
		WebElement Emp_email = driver.findElement(LearnersPage.Learner_Email);
		Emp_email.click();
		// driver.findElement(LearnersPage.Add_user_Button).click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 
			WebElement Learner_EmpID_Error_ob = wait
					.until(ExpectedConditions.elementToBeClickable(LearnersPage.errormessage));
			String Learner_EmpID_Error = Learner_EmpID_Error_ob.getText();
			if (Learner_EmpID_Error.contains("Employee ID is Required")) {
				logger.log(Status.INFO, "Message - Employee ID is Required");
				System.out.println("Message - Employee ID is Required");
 
			}
		} catch (Exception e) {
			logger.log(Status.FAIL, e);
		}
		Thread.sleep(2000);
	}
 
	// verify email required
	@Test(priority = 4, groups = { "Regression" })
	public void Learner_Email_Required() throws InterruptedException {
		logger = extent.createTest("Learner Email*", "verify add new learner email id required");
		logger.log(Status.INFO, "add new learner email id");
 
		WebElement Learner_EmpID = driver.findElement(LearnersPage.Employee_ID);
		Learner_EmpID.click();
		Learner_EmpID.sendKeys(Wrapper.randomeString(4));
		Thread.sleep(2000);
		// emp id required
		WebElement Emp_email = driver.findElement(LearnersPage.Learner_Email);
		Emp_email.click();
		// driver.findElement(LearnersPage.Add_user_Button).click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 
			WebElement Learner_Error_ob = wait
					.until(ExpectedConditions.elementToBeClickable(LearnersPage.errormessage));
			String Learner_Email_Error = Learner_Error_ob.getText();
			if (Learner_Email_Error.contains("Email is Required")) {
				logger.log(Status.INFO, "Message - Email is Required");
				System.out.println("Message - Email is Required");
 
			} else if (Learner_Email_Error.contains("Invalid email")) {
				logger.log(Status.INFO, "Message - Invalid email");
				System.out.println("Message - Invalid email");
			}
 
		} catch (Exception e) {
			logger.log(Status.FAIL, e);
		}
		Thread.sleep(2000);
	}
 
	// verify hire date required
	@Test(priority = 5, groups = { "Regression" })
	public void Learner_HireDate_Required() throws InterruptedException {
		logger = extent.createTest("Learner hire date*", "verify hire date required");
 
		WebElement Learner_email = driver.findElement(LearnersPage.Learner_Email);
		Learner_email.click();
		Learner_email.sendKeys("test" + Wrapper.randomeString(4) + "@gmail.com");
		Thread.sleep(2000);
		// mobile - optional
		driver.findElement(LearnersPage.Mobile).sendKeys("+915444567898", Keys.chord(Keys.TAB));
 
		WebElement hiredate = driver.findElement(LearnersPage.Learner_HireDate);
		hiredate.click();
		// driver.findElement(LearnersPage.Add_user_Button).click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 
			WebElement Learner_Hiredate_Error_ob = wait
					.until(ExpectedConditions.elementToBeClickable(LearnersPage.errormessage));
			String Learner_Error = Learner_Hiredate_Error_ob.getText();
			if (Learner_Error.contains("Hire date is Required")) {
				logger.log(Status.INFO, "Message - Hire date is Required");
				System.out.println("Message - Hire date is Required");
 
			}
 
		} catch (Exception e) {
			logger.log(Status.FAIL, e);
		}
		Thread.sleep(2000);
	}
 
	// verify department required
	@Test(priority = 6, groups = { "Regression" })
	public void Learner_Department_Required() throws InterruptedException {
		logger = extent.createTest("Learner department*", "verify department required");
 
		WebElement hiredate = driver.findElement(LearnersPage.Learner_HireDate);
		hiredate.click();
		//hiredate.sendKeys(Keys.chord(Keys.TAB, Keys.TAB));
		driver.findElement(LearnersPage.today).click();
		Thread.sleep(2000);
		// emp id required
		WebElement department = driver.findElement(LearnersPage.Learner_Department);
		department.click();
		driver.findElement(LearnersPage.Add_user_Button).click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 
			WebElement Learner_Error_ob = wait
					.until(ExpectedConditions.elementToBeClickable(LearnersPage.errormessage));
			String Learner_Error = Learner_Error_ob.getText();
			if (Learner_Error.contains("Department is Required")) {
				logger.log(Status.INFO, "Message - Department is Required");
				System.out.println("Message - Department is Required");
 
			}
 
		} catch (Exception e) {
			logger.log(Status.FAIL, e);
		}
		Thread.sleep(2000);
	}
 
	// verify designation required
	@Test(priority = 7, groups = { "Regression" })
	public void Learner_Designation_Required() throws InterruptedException {
		logger = extent.createTest("Learner designation*", "verify designation required");
 
		WebElement Department = driver.findElement(LearnersPage.Learner_Department);
		Department.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER, Keys.TAB, Keys.TAB)).perform();
		System.out.println("Department selected");
		Thread.sleep(2000);
		WebElement designation = driver.findElement(LearnersPage.Learner_Designation);
		designation.click();
		driver.findElement(LearnersPage.Add_user_Button).click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 
			WebElement Learner_Error_ob = wait
					.until(ExpectedConditions.elementToBeClickable(LearnersPage.errormessage));
			String Learner_Error = Learner_Error_ob.getText();
			if (Learner_Error.contains("Designation is Required")) {
				logger.log(Status.INFO, "Message - Designation is Required");
				System.out.println("Message - Designation is Required");
 
			}
 
		} catch (Exception e) {
			logger.log(Status.FAIL, e);
		}
		Thread.sleep(2000);
	}
 
	// verify country required
	@Test(priority = 8, groups = { "Regression" })
	public void Learner_Country_Required() throws InterruptedException {
		logger = extent.createTest("Learner country*", "verify country required");
 
		Thread.sleep(2000);
		WebElement Learner_Designation = driver.findElement(LearnersPage.Learner_Designation);
 
		Learner_Designation.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER, Keys.TAB)).perform();
		System.out.println("designation selected");
		Thread.sleep(2000);
 
		WebElement country = driver.findElement(LearnersPage.Learner_Country);
		country.click();
		driver.findElement(LearnersPage.Add_user_Button).click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement Learner_Error_ob = wait
					.until(ExpectedConditions.elementToBeClickable(LearnersPage.errormessage));
			String Learner_Error = Learner_Error_ob.getText();
			if (Learner_Error.contains("Country is Required")) {
				logger.log(Status.INFO, "Message - Country is Required");
				System.out.println("Message - Country is Required");
 
			}
 
		} catch (Exception e) {
			logger.log(Status.FAIL, e);
		}
		Thread.sleep(2000);
	}
 
	// verify state required
	@Test(priority = 9, groups = { "Regression" })
	public void Learner_State_Required() throws InterruptedException {
		logger = extent.createTest("Learner state*", "verify state required");
 
		Thread.sleep(2000);
		WebElement Learner_Country = driver.findElement(LearnersPage.Learner_Country);
 
		Learner_Country.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER, Keys.TAB)).perform();
		System.out.println("designation selected");
		Thread.sleep(2000);
 
		WebElement state = driver.findElement(LearnersPage.Learner_State);
		state.click();
		driver.findElement(LearnersPage.Add_user_Button).click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement Learner_Error_ob = wait
					.until(ExpectedConditions.elementToBeClickable(LearnersPage.errormessage));
			String Learner_Error = Learner_Error_ob.getText();
			if (Learner_Error.contains("State is Required")) {
				logger.log(Status.INFO, "Message - " + Learner_Error);
				System.out.println("Message- " + Learner_Error);
 
			}
 
		} catch (Exception e) {
			logger.log(Status.FAIL, e);
		}
		Thread.sleep(2000);
	}
 
	// learner valid case
	@Test(priority = 10, groups = { "Regression", "SmokeTest" })
	public void Add_New_Learner() throws Exception {
		logger = extent.createTest("add new learner ", "add learner success");
 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		Click_Add_New_Learner();
		System.out.println("In add learner page");
 
		// learner name
 
		WebElement Learners_name = wait.until(ExpectedConditions.visibilityOfElementLocated(LearnersPage.Learner_name));
		Learners_name.sendKeys(excel.getDataSheetName("Learners_Squads", 4, 1));
		logger.log(Status.INFO, "learner name entered");
		System.out.println("fill learner emp ID");
 
		// enter learner emp id
		driver.findElement(LearnersPage.Employee_ID).sendKeys(excel.getDataSheetName("Learners_Squads", 5, 1));
 
		// email
		driver.findElement(LearnersPage.Learner_Email).sendKeys(excel.getDataSheetName("Learners_Squads", 6, 1));
 
		// mobile - optional
		driver.findElement(LearnersPage.Mobile).sendKeys(excel.getDataSheetName("Learners_Squads", 7, 1));
		// hire date
		WebElement hiredate = driver.findElement(LearnersPage.Learner_HireDate);
		hiredate.click();
		//hiredate.sendKeys(excel.getDataSheetName("Learners_Squads", 8, 1), Keys.TAB, Keys.TAB);
		 driver.findElement(LearnersPage.today).click();
 
		// department
		WebElement Department = driver.findElement(LearnersPage.Learner_Department);
		Department.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(excel.getDataSheetName("Learners_Squads", 9, 1), Keys.chord(Keys.ENTER, Keys.TAB)).perform();
		System.out.println("Department selected");
		Actions dragger = new Actions(driver);
		WebElement element = driver.findElement(ToasterObject.innerscroll);
		dragger.moveToElement(element).clickAndHold().moveByOffset(0, 100).release(element).build().perform();
		Thread.sleep(2000);
 
		// designation
		WebElement Learner_Designation = wait
				.until(ExpectedConditions.visibilityOfElementLocated(LearnersPage.Learner_Designation));
 
		Learner_Designation.click();
		keyDown.sendKeys(excel.getDataSheetName("Learners_Squads", 10, 1), Keys.chord(Keys.ENTER, Keys.TAB)).perform();
		System.out.println("designation selected");
		Thread.sleep(2000);
 
		// country
		WebElement country = wait.until(ExpectedConditions.visibilityOfElementLocated(LearnersPage.Learner_Country));
 
		country.click();
		keyDown.sendKeys(excel.getDataSheetName("Learners_Squads", 11, 1), Keys.chord(Keys.ENTER, Keys.TAB)).perform();
		System.out.println("country selected");
		Thread.sleep(2000);
 
		// state
		driver.findElement(LearnersPage.Learner_State).click();
		System.out.println("state dropdown is clicked");
		keyDown.sendKeys(excel.getDataSheetName("Learners_Squads", 12, 1), Keys.chord(Keys.ENTER, Keys.TAB)).perform();
		System.out.println("state selected");
		Thread.sleep(2000);
 
		// enter the description
		WebElement Bio = driver.findElement(LearnersPage.Learner_Bio);
		Bio.click();
		Bio.sendKeys(excel.getDataSheetName("Learners_Squads", 13, 1));
		Thread.sleep(2000);
		System.out.println("Bio is added");
		WebElement save = wait.until(ExpectedConditions.elementToBeClickable(LearnersPage.Add_user_Button));
 
		// save learner
		save.click();
 
		try {
			WebElement Toaster = wait.until(ExpectedConditions.visibilityOfElementLocated(ToasterObject.toaster));
 
			Toaster.isDisplayed();
			String toaster = Toaster.getText();
			if (toaster.contains("Learner already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Assert.assertEquals(toaster, "Learner already exist");
				driver.findElement(LearnersPage.Cancel).click();
				Thread.sleep(2000);
			} else if (toaster.contains("Learner created successfully")) {
				logger.log(Status.INFO, toaster);
				Assert.assertEquals(toaster, "Learner created successfully");
				System.out.println(toaster);
			}
 
		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
		Thread.sleep(2000);
	}
 
	@Test(priority = 11, groups = { "Regression" })
	public void Search_Learner() throws Exception {
		logger = extent.createTest("Search learner  ", "Search learner");
 
		driver.get(config.learnersurl());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
 
		WebElement search_learner = wait.until(ExpectedConditions.elementToBeClickable(LearnersPage.Search_learner));
		search_learner.click();
		search_learner.sendKeys(excel.getDataSheetName("Learners_Squads", 4, 1));
		Thread.sleep(2000);
 
		if (driver.findElements(LearnersPage.No_data).size() > 0) {
			String nodata = driver.findElement(LearnersPage.No_data).getText();
			System.out.println(nodata);
			logger.log(Status.INFO, nodata);
 
		} else if (driver.findElements(LearnersPage.search_result).size() > 0) {
 
			driver.findElement(LearnersPage.view).click();
			System.out.println("Search results matched and data displayed");
			logger.log(Status.INFO, "Search results matched and data displayed");
 
		}
 
	}
 
	// view learner
	@Test(priority = 12, groups = { "Regression" })
	public void View_Learner() throws Exception {
		logger = extent.createTest("view learner ", "view learner");
 
		driver.get(config.learnersurl());
 
		// select manage learners in navigation menu
		driver.findElement(LearnersPage.view).click();
		Thread.sleep(2000);
		WebElement Learner_Details_Name = driver.findElement(LearnersPage.Learner_Deatils_Name);
		String name = Learner_Details_Name.getText();
		logger.log(Status.INFO, "Name - " + name);
		System.out.println("Name - " + name);
		WebElement Learner_email = driver.findElement(LearnersPage.Learner_Deatils_Email);
		String Email = Learner_email.getText();
		logger.log(Status.INFO, "Email - " + Email);
		System.out.println("Email - " + Email);
 
		// Squads
		WebElement Squads = driver.findElement(LearnersPage.Learner_Deatils_Squad_tab);
		Squads.click();
 
		// challenges
		WebElement Challenges = driver.findElement(LearnersPage.Learner_Deatils_Challenges_tab);
		Challenges.click();
 
		if (driver.findElements(LearnersPage.view).size() > 0) {
			System.out.println("challenges exist");
			logger.log(Status.INFO, "challenges exist");
		} else if (driver.findElements(LearnersPage.No_data).size() > 0) {
 
			String nodata = driver.findElement(LearnersPage.No_data).getText();
			System.out.println(nodata);
			logger.log(Status.INFO, nodata);
		}
	}
 
	// Edit learner
	@Test(priority = 13, groups = { "Regression", "SmokeTest" })
	public void Edit_Learner() throws Exception {
		logger = extent.createTest("Edit Learner", "Edit learner");
 
		driver.get(config.learnersurl());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(LearnersPage.CTA_Button);
		CTA.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER, Keys.ENTER)).perform();
		Thread.sleep(2000);
 
		// view bio and edit
 
		// WebElement Bio = driver.findElement(LearnersPage.Learner_Bio);
		// Bio.click();
		// Bio.clear();
 
		driver.findElement(LearnersPage.update_Button).click();
		Thread.sleep(3000);
 
		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Learner already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(LearnersPage.Cancel).click();
				Thread.sleep(2000);
			} else if (toaster.contains("Learner updated successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
 
			}
 
		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
 
	}
 
	// Delete learner clicking on cancel
	@Test(priority = 14, groups = { "Regression" })
	public void Delete_Learner_Cancel() throws Exception {
		logger = extent.createTest("Delete learner No", "Delete Learner - No");
 
		driver.get(config.learnersurl());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(LearnersPage.CTA_Button);
		CTA.click();
		driver.findElement(LearnersPage.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Cancel = driver.findElement(LearnersPage.Delete_cancel);
		Cancel.click();
		Thread.sleep(2000);
		System.out.println("Delete cancelled");
		logger.log(Status.INFO, "Delete cancelled");
	}
	
	@Test(priority = 15, groups = { "Regression" })
	public void Learner_Status() throws Exception {
		logger = extent.createTest("Add Learner Status Change",
				"Changing the status");
		logger.log(Status.INFO, "add new Learner Status");
		WebElement status = driver.findElement(LearnersPage.status);
		status.click();
		
		String toaster = driver.findElement(ToasterObject.toaster).getText();
		System.out.println("Text in Toaster---"+toaster);
		
		Thread.sleep(3000);
		
		WebElement status1 = driver.findElement(LearnersPage.status);
		status1.click();
		
		



	}

	// Delete learner clicking on Yes
	@Test(priority = 16, groups = { "Delete" })
	public void Delete_Learner_Yes() throws Exception {
		logger = extent.createTest("Delete Learner yes", "Delete Learner - Yes");
		driver.get(config.learnersurl());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(LearnersPage.CTA_Button);
		CTA.click();
		driver.findElement(LearnersPage.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Delete = driver.findElement(LearnersPage.Delete_Yes);
		Delete.click();
		Thread.sleep(2000);
		System.out.println("clicked on Yes button");
		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Sorry, You cannot delete ")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
			} else if (toaster.contains("deleted successfully")) {
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
	public void Click_Add_New_Learner() {
		driver.get(config.learnersurl());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
 
		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(LearnersPage.Add_New_Learner));
		Add.click();
 
	}
 

}