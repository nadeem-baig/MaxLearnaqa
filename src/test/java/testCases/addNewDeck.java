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

import PageObjects.DecksPage;
import PageObjects.ToasterObject;
import utility.Wrapper;

public class addNewDeck extends BaseClass {

	// navigate to add Deck form and click on submit without title
	@Test(priority = 1, groups = { "Regression" })
	public void AddDeck_Title_required() throws Exception {
		logger = extent.createTest("Add Deck Title*", "add new Deck title required ");
		logger.log(Status.INFO, "add new Deck Title");
		Click_Add_New_Deck();
		Thread.sleep(2000);
		driver.findElement(DecksPage.Save).click();

		try {
			WebElement titleerror = driver.findElement(DecksPage.errorMessage);
			titleerror.isDisplayed();
			logger.info("Message:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please enter Title");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add Deck form and click on submit without category

	@Test(priority = 2, groups = { "Regression" })
	public void AddDeck_category_required() throws Exception {
		logger = extent.createTest("Add Deck category*", "add new Deck category required ");
		logger.log(Status.INFO, "add new Deck category");
		Thread.sleep(2000);
		WebElement Title = driver.findElement(DecksPage.deckTitle);
		Title.click();
		Title.sendKeys(Wrapper.AlphaNumericString(5));
		Thread.sleep(2000);
		System.out.println("Title is entered");
		Thread.sleep(2000);
		driver.findElement(DecksPage.Save).click();

		try {
			WebElement titleerror = driver.findElement(DecksPage.errorMessage1);
			titleerror.isDisplayed();
			logger.info("Message:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please select Category");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add Deck form and click on submit without Subject

	@Test(priority = 3, groups = { "Regression" })
	public void Add_Deck_subject_required() throws Exception {
		logger = extent.createTest("Add Deck Subejct*", "add new Deck subject required ");
		logger.log(Status.INFO, "add new Deck subject");
		Click_Add_New_Deck();
		Thread.sleep(2000);
		WebElement Title = driver.findElement(DecksPage.deckTitle);

		Title.sendKeys(Wrapper.randomeString(5));
		Thread.sleep(2000);
		System.out.println("Title is entered");
		WebElement category = driver.findElement(DecksPage.Category_dropdown);
		category.click();
		Thread.sleep(4000);
		System.out.println("Category dropdown is clicked");
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(2000);
		driver.findElement(DecksPage.Save).click();

		try {
			WebElement titleerror = driver.findElement(DecksPage.errorMessage1);
			titleerror.isDisplayed();
			logger.info("Message:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please select Subject");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add Deck form and click on submit without Topic

	@Test(priority = 4, groups = { "Regression" })
	public void Add_Deck_Topic_required() throws Exception {
		logger = extent.createTest("Add Deck Topic*", "add new Deck topic required ");
		logger.log(Status.INFO, "add new Deck Topic");
		Click_Add_New_Deck();
		Thread.sleep(2000);
		WebElement Title = driver.findElement(DecksPage.deckTitle);

		Title.sendKeys(Wrapper.AlphaNumericString(6));
		Thread.sleep(2000);
		System.out.println("Title is entered");

		WebElement category = driver.findElement(DecksPage.Category_dropdown);
		category.click();
		Thread.sleep(2000);
		System.out.println("Category dropdown is clicked");
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(excel.getDataSheetName("ManageContent", 1, 1) ,Keys.chord( Keys.ENTER)).perform();
		Thread.sleep(2000);

		WebElement Subject = driver.findElement(DecksPage.Subject_dropdown);
		Subject.click();
		Thread.sleep(2000);
		System.out.println("Subject dropdown is clicked");
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(excel.getDataSheetName("ManageContent", 3, 1),Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);
		driver.findElement(DecksPage.Save).click();

		try {
			WebElement titleerror = driver.findElement(DecksPage.errorMessage1);
			titleerror.isDisplayed();
			logger.info("Message:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Please select Topic");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// cancel add New Deck form

	@Test(priority = 5, groups = { "Regression" })
	public void Add_Deck_Cancel() throws Exception {
		logger = extent.createTest("add new Deck cancel ", "cancel deck");
		logger.log(Status.INFO, "add new Deck cancel");
		Click_Add_New_Deck();
		Thread.sleep(2000);
		Wrapper.scrollDown(driver);
		System.out.println("Click on cancel button");
		driver.findElement(DecksPage.Cancle);
		logger.log(Status.INFO, "category form cancelled");
		Thread.sleep(3000);
	}

	// add New deck with all the data filled

	@Test(priority = 6, groups = { "Regression", "SmokeTest" })
	public void Add_New_Deck_Valid() throws Exception {
		logger = extent.createTest("add new Deck ", "add deck valid ");
		logger.log(Status.INFO, "add new Deck");
		Click_Add_New_Deck();
		Thread.sleep(2000);
		driver.findElement(DecksPage.deckTitle).click();
		driver.findElement(DecksPage.deckTitle).sendKeys(excel.getDataSheetName("ManageContent", 7, 1) );
		Thread.sleep(2000);
		System.out.println("deck Title is entered");
		WebElement category = driver.findElement(DecksPage.Category_dropdown);
		category.click();
		Thread.sleep(2000);
		System.out.println("Category dropdown is clicked");
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(excel.getDataSheetName("ManageContent", 1, 1) ,Keys.chord( Keys.ENTER)).perform();
		Thread.sleep(2000);

		WebElement Subject = driver.findElement(DecksPage.Subject_dropdown);
		Subject.click();
		Thread.sleep(2000);
		System.out.println("Subject dropdown is clicked");
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(excel.getDataSheetName("ManageContent", 3, 1),Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);

		WebElement Topic = driver.findElement(DecksPage.Topic_dropdown);
		Topic.click();
		Thread.sleep(4000);
		System.out.println("Topic dropdown is clicked");
		Actions keyDown2 = new Actions(driver);
		keyDown2.sendKeys(excel.getDataSheetName("ManageContent", 5, 1),Keys.chord( Keys.ENTER)).perform();
		Thread.sleep(2000);
		driver.findElement(DecksPage.Save).click();

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			WebElement message = wait.until(ExpectedConditions.elementToBeClickable(ToasterObject.toaster));

			message.isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Deck already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(DecksPage.Cancle).click();
				Thread.sleep(2000);
			} else if (toaster.contains("Deck created successfully")) {
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
	@Test(priority = 7, groups = { "Regression","SmokeTest" })
	public void Search_Deck() throws Exception {
		logger = extent.createTest("search Decks  ", "Search");
		logger.log(Status.INFO, "search deck");
		driver.get(config.deck());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));

		WebElement search_Deck = wait.until(ExpectedConditions.elementToBeClickable(DecksPage.Search_Deck));
		search_Deck.click();
		Thread.sleep(2000);
		search_Deck.sendKeys(excel.getDataSheetName("ManageContent", 7, 1));
		logger.log(Status.INFO, "Search ");
		Thread.sleep(2000);

		if (driver.findElements(DecksPage.No_data).size() > 0) {
			String nodata = driver.findElement(DecksPage.No_data).getText();
			System.out.println(nodata);
			logger.log(Status.INFO, nodata);

		} else if (driver.findElements(DecksPage.View_Row).size() > 0) {
			WebElement drp =driver.findElement(ToasterObject.status);
			drp.click();
			Thread.sleep(2000);
			Select statusupdate = new Select(drp);
			statusupdate.selectByValue("PUBLISHED");
			Thread.sleep(2000);
			//driver.findElement(DecksPage.View_Row).click();
			System.out.println("Search results matched and data displayed");
			logger.log(Status.INFO, "Search results matched and data displayed");

		}
		driver.findElement(DecksPage.Search_Deck).clear();
		System.out.println("Search cleared");

	}

	// view Deck
	@Test(priority = 8, groups = { "Regression" })
	public void View_Deck() throws Exception {
		logger = extent.createTest("view Deck ", "view deck details");
		logger.log(Status.INFO, "view Deck");
		driver.get(config.deck());
		WebElement view_category = driver.findElement(DecksPage.View_Row);
		view_category.click();

		// capture details
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(DecksPage.Add_flascard));
		Add.isDisplayed();
		String Message = Add.getText();
		System.out.println("deck details " + Message);
		logger.log(Status.INFO, " Deck Details - " + Message);

	}

	// Edit Deck
	@Test(priority = 9, groups = { "Regression", "SmokeTest" })
	public void Edit_Deck() throws Exception {
		logger = extent.createTest("Edit Deck", "Edit Deck title");
		logger.log(Status.INFO, "Edit Deck Title");
		driver.get(config.deck());
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

		WebElement CTA = wait.until(ExpectedConditions.elementToBeClickable(DecksPage.CTA_Button));
		
		CTA.click();
		Thread.sleep(3000);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(2000);
		WebElement Title = driver.findElement(DecksPage.deckTitle);
		Title.click();
		Title.sendKeys(" " + Wrapper.AlphaNumericString(3));
		System.out.println("Title is entered");
		Thread.sleep(2000);
		driver.findElement(DecksPage.Save).click();
		Thread.sleep(3000);

		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("deck already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(DecksPage.Cancle).click();
				Thread.sleep(2000);
			} else if (toaster.contains("decks updated successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}

	}

	// Delete Deck clicking on cancel
	@Test(priority = 10, groups = { "Regression" })
	public void Delete_Deck_Cancel() throws Exception {
		logger = extent.createTest("Delete Deck - no", "Deck delete Cancel");
		logger.log(Status.INFO, "Deck Delete No");
		driver.get(config.deck());
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement CTA = wait.until(ExpectedConditions.elementToBeClickable(DecksPage.CTA_Button));
		
		CTA.click();
		driver.findElement(DecksPage.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Cancel = driver.findElement(DecksPage.Delete_cancel);
		Cancel.click();
		Thread.sleep(2000);
		System.out.println("clicked on cancel button");

	}
	@Test(priority = 11, groups = { "Regression" })
	public void add_new_Deck_Status() throws Exception {
		logger = extent.createTest("Add Deck Status Change",
				"Changing the status");
		logger.log(Status.INFO, "add new Deck Status");
		
		WebElement status = driver.findElement(DecksPage.status);
		status.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN,Keys.ENTER)).perform();
		Thread.sleep(2000);
		String toaster = driver.findElement(ToasterObject.toaster).getText();
		System.out.println("Text in Toaster---"+toaster);
		
		Thread.sleep(3000);
		
		WebElement status1 = driver.findElement(DecksPage.status);
		status1.click();
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.UP,Keys.ENTER)).perform();
		Thread.sleep(2000);
		String Message1 = driver.findElement(DecksPage.status).getText();

		System.out.println("Status is ---"+Message1);



	}

	// Delete Deck clicking on Yes
	@Test(priority = 12, groups = { "Delete" })
	public void Delete_Deck_Yes() throws Exception {
		logger = extent.createTest("Delete Deck - yes", "Deck Delete Yes");
		logger.log(Status.INFO, "Delete Deck yes");
		driver.get(config.deck());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(DecksPage.CTA_Button);
		CTA.click();
		driver.findElement(DecksPage.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Delete = driver.findElement(DecksPage.Delete_Yes);
		Delete.click();

		System.out.println("clicked on Yes button");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(ToasterObject.toaster));

			Add.isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Sorry, You cannot delete this Deck which is mapped to flashcard")) {
				logger.log(Status.INFO, toaster);
				System.out.println("Message - " + toaster);
				Thread.sleep(2000);
			} else if (toaster.contains("decks Deleted successfully")) {
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
	public void Click_Add_New_Deck() throws InterruptedException {
		Thread.sleep(2000);
		driver.get(config.deck());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));

		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(DecksPage.Add_New_Deck));
		Add.click();
		Thread.sleep(3000);
	}
}
