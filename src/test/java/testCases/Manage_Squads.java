package testCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.Manage_Squads_Page;
import PageObjects.ToasterObject;
import utility.Wrapper;

public class Manage_Squads extends BaseClass {

	// navigate to create Squad form and click on submit without squad Name

	@Test(priority = 1, groups = { "Regression" })
	public void Add_Squad_Name_required() throws Exception {
		logger = extent.createTest("Squad Name*", "add new squad Name required ");
		logger.log(Status.INFO, "Add new squad Name Required");
		Click_Add_New_Squad();
		Thread.sleep(2000);
		driver.findElement(Manage_Squads_Page.Create_Squad).click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			WebElement titleerror = wait
					.until(ExpectedConditions.elementToBeClickable(Manage_Squads_Page.error_Message));
			titleerror.isDisplayed();
			String alert = titleerror.getText();
			logger.info("Error:" + alert);

			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Team Name Required");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add new squad and click submit without squad Members

	@Test(priority = 2, groups = { "Regression" })
	public void Add_Squad_Members_required() throws InterruptedException, Exception {
		logger = extent.createTest("Squad Members required ", "Squad Members without rule set");
		logger.log(Status.INFO, "Add new squad Members Required");

		driver.findElement(Manage_Squads_Page.squad_image).click();
		Thread.sleep(2000);
		driver.findElement(Manage_Squads_Page.Image_Upload).click();
		Thread.sleep(2000);

		driver.findElement(Manage_Squads_Page.file)
				.sendKeys(System.getProperty("user.dir") + "/TestData/profile icon.png");
		Thread.sleep(2000);
		System.out.println("Squad Icon is uploaded");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);

		WebElement SquadName = driver.findElement(Manage_Squads_Page.squad_Name);
		SquadName.sendKeys("Squad " + Wrapper.randomeString(5));
		System.out.println("Squad Name is entered");
		Thread.sleep(2000);

		driver.findElement(Manage_Squads_Page.Create_Squad).click();

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			WebElement toasterer = wait.until(ExpectedConditions.elementToBeClickable(ToasterObject.toaster));
			toasterer.isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Squad Image required")) {
				logger.log(Status.INFO, toaster);
				System.out.println("Message" + toaster);
				Thread.sleep(2000);
			} else if (toaster.contains("Select Team Members")) {
				logger.log(Status.INFO, toaster);
				System.out.println("Message" + toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
	} // navigate to add new squad and click submit without squad image

	@Test(priority = 3, groups = { "Regression","test" })
	public void Add_Squad_Image_required() throws InterruptedException, Exception {
		logger = extent.createTest("Squad Image*", "add new squad Image required ");
		logger.log(Status.INFO, "Add new squad Image Required");
		
		
		Click_Add_New_Squad();

		WebElement SquadName = driver.findElement(Manage_Squads_Page.squad_Name);
		SquadName.sendKeys("Squad " + Wrapper.randomeString(5));
		System.out.println("Squad Name is entered");
		Thread.sleep(2000);	
		
		WebElement Parameter = driver.findElement(Manage_Squads_Page.Parameter);
		Parameter.click();
		Parameter.sendKeys("D");
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER)).perform();
		
		System.out.println("Parameter is Selected");
		Thread.sleep(2000);

		WebElement Criteria = driver.findElement(Manage_Squads_Page.criteria);
		Criteria.click();
		Criteria.sendKeys("I");
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.ENTER)).perform();
		System.out.println("Critera is Selected");
		Thread.sleep(2000);

		WebElement Value = driver.findElement(Manage_Squads_Page.Value);
		Value.click();
		Value.sendKeys("IT");
		Thread.sleep(2000);
		System.out.println("Value is enterd");

		WebElement Add = driver.findElement(Manage_Squads_Page.Ruleset_add);
		Add.click();

		WebElement Member1 = driver.findElement(Manage_Squads_Page.checkbox1);
		Member1.click();
		Thread.sleep(2000);

		driver.findElement(Manage_Squads_Page.Create_Squad).click();
		Thread.sleep(1000);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			WebElement toasterer = wait.until(ExpectedConditions.elementToBeClickable(ToasterObject.toaster));

			toasterer.isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Squad Image required")) {
				logger.log(Status.INFO, toaster);
				System.out.println("Message -" + toaster);
				Thread.sleep(2000);
			} else if (toaster.contains("Select Team Members")) {
				logger.log(Status.INFO, toaster);
				System.out.println("Message" + toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
	}

	// navigate to add new squad and click add without parameter in rule set

	@Test(priority = 4, groups = { "Regression" })

	public void Add_Squad_Parameter_required() throws InterruptedException, Exception {
		logger = extent.createTest("create squad Parameter required*", "verify create squad Parameter Rule set");
		logger.log(Status.INFO, "Add new squad Parameter Required");
		Click_Add_New_Squad();
		Thread.sleep(2000);
		driver.findElement(Manage_Squads_Page.Ruleset_add).click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			WebElement titleerror = wait
					.until(ExpectedConditions.elementToBeClickable(Manage_Squads_Page.Parameter_error));
			titleerror.isDisplayed();
			logger.info("Error:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "parameter is not selected");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add new squad and click add without criteria in rule set

	@Test(priority = 5, groups = { "Regression" })

	public void Add_Squad_Criteria_required() throws InterruptedException, Exception {
		logger = extent.createTest("Create squad Criteria required ", "verify Criteria Rule set");
		logger.log(Status.INFO, "Add new squad Criteria Required");

		WebElement Parameter = driver.findElement(Manage_Squads_Page.Parameter);
		Parameter.click();
		Parameter.sendKeys("D");
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER)).perform();
		
		System.out.println("Parameter is Selected");
		Thread.sleep(2000);

		

		driver.findElement(Manage_Squads_Page.Ruleset_add).click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			WebElement titleerror = wait
					.until(ExpectedConditions.elementToBeClickable(Manage_Squads_Page.criteria_error));

			titleerror.isDisplayed();
			logger.info("Error:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "criteria is not selected");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add new squad and click add without entering Value field in rule
	// // set

	@Test(priority = 6, groups = { "Regression" })

	public void Add_Squad_Value_required() throws InterruptedException, Exception {
		logger = extent.createTest("Create Squad Value required*", "verify create squad Value Rule set");
		logger.log(Status.INFO, "Add new squad Value Required");
		
	
		WebElement Criteria = driver.findElement(Manage_Squads_Page.criteria);
		Criteria.click();
		Criteria.sendKeys("I");
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.ENTER)).perform();
		System.out.println("Critera is Selected");
		Thread.sleep(2000);


		driver.findElement(Manage_Squads_Page.Ruleset_add).click();

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			WebElement titleerror = wait.until(ExpectedConditions.elementToBeClickable(Manage_Squads_Page.Value_error));

			titleerror.isDisplayed();
			logger.info("Error:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Value is not available");
		} catch (Exception e) {
			logger.info(e);
		}
	}
	// navigate to add new squad and click add in rule set

	@Test(priority = 7, groups = { "Regression" })

	public void Add_Squad_Logic_required() throws InterruptedException, Exception {
		logger = extent.createTest("Create Squad Logic Rule set", "add new squad Logic required ");
		logger.log(Status.INFO, "Add new squad Logic Required");

		WebElement Value = driver.findElement(Manage_Squads_Page.Value);
		Value.click();
		Value.sendKeys("IT");
		Thread.sleep(2000);
		System.out.println("Value is enterd");

		WebElement Add = driver.findElement(Manage_Squads_Page.Ruleset_add);
		Add.click();
		Thread.sleep(3000);

		driver.findElement(Manage_Squads_Page.Ruleset_add).click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			WebElement titleerror = wait.until(ExpectedConditions.elementToBeClickable(Manage_Squads_Page.logic_error));

			titleerror.isDisplayed();
			logger.info("Error:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Logic is not available");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add new squad and enter rule set details without selecting
	// members

	@Test(priority = 8, groups = { "Regression" })

	public void Create_Squad_without_Members() throws InterruptedException, Exception {
		logger = extent.createTest("squad members required ", "verify create Squad without members");
		logger.log(Status.INFO, "Add new squad squad members Required");

//		WebElement clear = driver.findElement(Manage_Squads_Page.Ruleset_Clear);
		// clear.click();
		Thread.sleep(3000);

		driver.findElement(Manage_Squads_Page.squad_image).click();
		Thread.sleep(3000);
		driver.findElement(Manage_Squads_Page.Image_Upload).click();
		Thread.sleep(2000);

		driver.findElement(Manage_Squads_Page.file)
				.sendKeys(System.getProperty("user.dir") + "/TestData/profile icon.png");
		Thread.sleep(4000);
		System.out.println("Icon is uploaded");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);

		WebElement SquadName = driver.findElement(Manage_Squads_Page.squad_Name);
		SquadName.sendKeys("New " + Wrapper.randomeString(5));
		System.out.println("Squad Name is entered");
		Thread.sleep(2000);

		driver.findElement(Manage_Squads_Page.Create_Squad).click();
		Thread.sleep(1000);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			WebElement titleerror = wait.until(ExpectedConditions.elementToBeClickable(ToasterObject.toaster));

			titleerror.isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Select Team Members")) {
				logger.log(Status.INFO, toaster);
				System.out.println("Message" + toaster);
				Thread.sleep(2000);
			} else if (toaster.contains("Squad Image required")) {
				logger.log(Status.INFO, toaster);
				System.out.println("Message" + toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
		Thread.sleep(5000);
	}
	// cancel Create squad form

	@Test(priority = 9, groups = { "Regression" })
	public void Create_Squad_Cancel() throws Exception {
		logger = extent.createTest("Create Squad cancel ", "cancel Squad");
		logger.log(Status.INFO, "Create Squad cancel");
		Click_Add_New_Squad();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

		WebElement cancel = wait.until(ExpectedConditions.elementToBeClickable(Manage_Squads_Page.Cancel_Squad));

		System.out.println("Click on cancel button");
		cancel.click();
		Thread.sleep(3000);

	}

	// enter Required details with Valid Data

	@Test(priority = 10, groups = { "Regression", "SmokeTest","test" })

	public void Create_Squad_Valid() throws InterruptedException, Exception {
		logger = extent.createTest("Create New squad ", "Add New Squad with all the required data");
		logger.log(Status.INFO, "Created new squad");
		Click_Add_New_Squad();
		Thread.sleep(2000);
		driver.findElement(Manage_Squads_Page.squad_image).click();
		Thread.sleep(3000);
		driver.findElement(Manage_Squads_Page.Image_Upload).click();
		Thread.sleep(2000);

		driver.findElement(Manage_Squads_Page.file)
				.sendKeys(System.getProperty("user.dir") + "/TestData/profile icon.png");
		Thread.sleep(4000);
		System.out.println("Icon is uploaded");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);

		WebElement SquadName = driver.findElement(Manage_Squads_Page.squad_Name);
		SquadName.click();
		SquadName.sendKeys(excel.getDataSheetName("Learners_Squads", 1, 1));
		System.out.println("Squad Name is entered");
		Thread.sleep(2000);

		WebElement Parameter = driver.findElement(Manage_Squads_Page.Parameter);
		Parameter.click();
		Parameter.sendKeys("D");
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER)).perform();
		
		System.out.println("Parameter is Selected");
		Thread.sleep(2000);

		WebElement Criteria = driver.findElement(Manage_Squads_Page.criteria);
		Criteria.click();
		Criteria.sendKeys("I");
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.ENTER)).perform();
		System.out.println("Critera is Selected");
		Thread.sleep(2000);

		WebElement Value = driver.findElement(Manage_Squads_Page.Value);
		Value.click();
		Value.sendKeys(excel.getDataSheetName("Learners_Squads", 2, 1));
		Thread.sleep(2000);
		System.out.println("Value is enterd");

		WebElement Add = driver.findElement(Manage_Squads_Page.Ruleset_add);
		Add.click();
		Thread.sleep(3000);

		WebElement Member1 = driver.findElement(Manage_Squads_Page.checkbox1);
		Member1.click();
		Thread.sleep(2000);

		driver.findElement(Manage_Squads_Page.Create_Squad).click();

		Thread.sleep(2000);

		try {

			WebElement success = driver.findElement(ToasterObject.toaster);

			success.isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Squad already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(Manage_Squads_Page.Cancel_Squad);
				Thread.sleep(2000);

			} else if (toaster.contains("Squad Maxlearn New successfully created")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}

	}

	// wait for search to display and enter text then capture results
	@Test(priority = 11, groups = { "Regression" })
	public void Search_squad() throws Exception {
		logger = extent.createTest("search squad  ", "Search Squad");
		logger.log(Status.INFO, "search Squad");
		Thread.sleep(2000);
		driver.get(config.squads());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement search_Squad = wait.until(ExpectedConditions.elementToBeClickable(Manage_Squads_Page.Search_Squad));
		search_Squad.click();
		Thread.sleep(2000);
		search_Squad.sendKeys(excel.getDataSheetName("Learners_Squads", 1, 1));
		Thread.sleep(2000);

		if (driver.findElements(Manage_Squads_Page.No_data).size() > 0) {
			String nodata = driver.findElement(Manage_Squads_Page.No_data).getText();
			System.out.println(nodata);
			logger.log(Status.INFO, nodata);

		} else if (driver.findElements(Manage_Squads_Page.search_result).size() > 0) {

			driver.findElement(Manage_Squads_Page.View_Squad).click();
			Thread.sleep(3000);
			System.out.println("Search results matched and data displayed");
			logger.log(Status.INFO, "Search results matched and data displayed");

		}
		driver.findElement(Manage_Squads_Page.Search_Squad).clear();
		System.out.println("Search cleared");
		logger.log(Status.INFO, "Search cleared");

	}

	// view Squad
	@Test(priority = 12,groups = { "Regression" })
	public void View_Squad() throws Exception {
		logger = extent.createTest("view Squad  ", "view details");
		logger.log(Status.INFO, "view Squad");
		driver.get(config.squads());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

		Thread.sleep(5000);
		WebElement view_squad = wait.until(ExpectedConditions.elementToBeClickable(Manage_Squads_Page.View_Squad));
		view_squad.click();

		// capture details
		
		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(Manage_Squads_Page.Add_Member));
		Add.isDisplayed();
		String Message = Add.getText();
		System.out.println("Text - " + Message);
		logger.log(Status.INFO, Message);

		WebElement squadTab = driver.findElement(Manage_Squads_Page.squad_Tab);
		squadTab.isDisplayed();
		String Message1 = squadTab.getText();
		System.out.println("Text - " + Message1);
		logger.log(Status.INFO, Message1);

		WebElement ChallengesTab = driver.findElement(Manage_Squads_Page.Challenges_Tab);
		ChallengesTab.isDisplayed();
		ChallengesTab.click();
		String Message2 = ChallengesTab.getText();
		System.out.println("Text   - " + Message2);
		logger.log(Status.INFO, Message2);

	}

	// view Squad Tab
	@Test(priority = 13, groups = { "Regression" })
	public void View_Squad_Tab() throws Exception {
		logger = extent.createTest("view Squads Details", "view squad Tab details");
		logger.log(Status.INFO, "view Squad");
		driver.get(config.squads());
		Thread.sleep(5000);
		WebElement view_squad = driver.findElement(Manage_Squads_Page.View_Squad);
		view_squad.click();

		// capture details
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

		WebElement squadTab = driver.findElement(Manage_Squads_Page.squad_Tab);
		squadTab.isDisplayed();
		String Message1 = squadTab.getText();
		System.out.println("Text -" + Message1);
		logger.log(Status.INFO, Message1);

		if (driver.findElements(Manage_Squads_Page.No_data).size() > 0) {
			String nodata = driver.findElement(Manage_Squads_Page.No_data).getText();
			System.out.println(nodata);
			logger.log(Status.INFO, nodata);

		} else if (driver.findElements(Manage_Squads_Page.search_result).size() > 0) {

			Thread.sleep(3000);
			System.out.println("Search results matched and data displayed");
			logger.log(Status.INFO, "Squad Search results matched and data displayed");

		}

	}

	// view Squad Tab
	@Test(priority = 14, groups = { "Regression" })
	public void View_Challenges_Tab() throws Exception {
		logger = extent.createTest("view Challenges Tab", "view Challenges Tab details");
		logger.log(Status.INFO, "view Squad");

		driver.findElement(Manage_Squads_Page.Challenges_Tab).click();
		Thread.sleep(3000);

		// capture details
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

		WebElement ChallengesTab = wait
				.until(ExpectedConditions.elementToBeClickable(Manage_Squads_Page.Challenges_Tab));
		ChallengesTab.isDisplayed();
		String Message = ChallengesTab.getText();
		System.out.println("Text -" + Message);
		logger.log(Status.INFO, Message);

		if (driver.findElements(Manage_Squads_Page.No_data).size() > 0) {
			String nodata = driver.findElement(Manage_Squads_Page.No_data).getText();
			System.out.println(nodata);
			logger.log(Status.INFO, nodata);

		} else if (driver.findElements(Manage_Squads_Page.search_result).size() > 0) {

			Thread.sleep(3000);
			System.out.println("Search results matched and data displayed");
			logger.log(Status.INFO, "Challenges Search results matched and data displayed");

		}

	}

	// Edit Squad
	@Test(priority = 15, groups = { "Regression", "SmokeTest" })
	public void Edit_Squad() throws Exception {
		logger = extent.createTest("Edit Squad", "Edit Squad");
		logger.log(Status.INFO, "Edit Squad");
		driver.get(config.squads());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(Manage_Squads_Page.CTA_Button);
		CTA.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER, Keys.ENTER)).perform();
		Thread.sleep(2000);
		WebElement Name = driver.findElement(Manage_Squads_Page.editsquad_Name);
		Name.click();
		Name.clear();
		Name.sendKeys("MaxlearnCompany");
		System.out.println("squad name is entered");
		Thread.sleep(2000);
		driver.findElement(Manage_Squads_Page.Update).click();
		Thread.sleep(3000);

		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Squad with same name already exists")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(Manage_Squads_Page.Cancel_UpdatedSquad).click();
				Thread.sleep(2000);
			} else if (toaster.contains("Squad updated successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}

	}

	// Delete Squad clicking on cancel
	@Test(priority = 16, groups = { "Regression" })
	public void Delete_Squad_Cancel() throws Exception {
		logger = extent.createTest("Delete Squad No", "Delete Squad No");
		logger.log(Status.INFO, "Delete Squad Cancel");
		driver.get(config.squads());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(Manage_Squads_Page.CTA_Button);
		CTA.click();
		driver.findElement(Manage_Squads_Page.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Cancel = driver.findElement(Manage_Squads_Page.Delete_cancel);
		Cancel.click();
		Thread.sleep(2000);
		System.out.println("clicked on cancel button");

	}

	// Delete KLP clicking on Yes
	@Test(priority = 17, groups = { "Delete" })
	public void Delete_Squad_Yes() throws Exception {
		logger = extent.createTest("Delete Squad Yes", "Delete Squad Yes");
		logger.log(Status.INFO, "Delete Squad");
		driver.get(config.squads());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(Manage_Squads_Page.CTA_Button);
		CTA.click();
		driver.findElement(Manage_Squads_Page.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Delete = driver.findElement(Manage_Squads_Page.Delete_Yes);
		Delete.click();
		System.out.println("clicked on Yes button");
		Thread.sleep(3000);
		try {
			System.out.println("Executing Toaster");
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Squad Deleted successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
			} else if (toaster.contains("Sorry, You cannot delete this squads which is mapped to challenges")) {
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
	public void Click_Add_New_Squad() {
		driver.get(config.squads());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));

		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(Manage_Squads_Page.Add_New_Squad));
		Add.click();

	}
}
