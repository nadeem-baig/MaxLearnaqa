package testCases;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import PageObjects.FlashcardPage;
import PageObjects.ToasterObject;
import PageObjects.TopicsPage;
import utility.Wrapper;

public class AddNewFlashCard extends BaseClass {

	// navigate to Deck listing form and click on any deck

	@Test(priority = 0, groups = { "Regression", "SmokeTest" })
	public void Deck_Detailpage() throws InterruptedException {
		Thread.sleep(2000);
		driver.get(config.deck());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

		WebElement search_Deck = wait.until(ExpectedConditions.elementToBeClickable(DecksPage.Search_Deck));
		search_Deck.click();
		Thread.sleep(2000);
		search_Deck.sendKeys(excel.getDataSheetName("ManageContent", 7, 1));
		logger.log(Status.INFO, "Search ");
		Thread.sleep(2000);

		if (driver.findElements(FlashcardPage.deck_Detail).size() > 0) {

			driver.findElement(FlashcardPage.deck_Detail).click();
			System.out.println("Search results matched and data displayed");
			logger.log(Status.INFO, "Search results matched and data displayed");

		}
	}

	

	// navigate to add Flash card form and click on submit without title

	@Test(priority = 1, groups = { "Regression" })
	public void Add_Flascard_Title_required() throws Exception {
		logger = extent.createTest("Flashcard Title*", "add new Flashcard title required ");
		logger.log(Status.INFO, "add new Flashcard Title");
		Click_Add_New_Flashcard();
		Thread.sleep(2000);
		driver.findElement(FlashcardPage.publish).click();

		try {
			WebElement titleerror = driver.findElement(FlashcardPage.Error);
			titleerror.isDisplayed();
			logger.info("Message:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Title is Required");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add Flash card and click submit without icon

	@Test(priority = 2, groups = { "Regression" })
	public void Add_flashcard_Icon_Required() throws InterruptedException {
		logger = extent.createTest("Flashcard Icon*", "add new flashcard icon required ");
		logger.log(Status.INFO, "add new flashcard Icon Required");
		WebElement Title = driver.findElement(FlashcardPage.addTitle);
		Title.click();
		Title.clear();
		Title.sendKeys(Wrapper.AlphaNumericString(5));
		System.out.println("Flashcard title is entered");
		Thread.sleep(2000);
		driver.findElement(FlashcardPage.publish).click();

		try {
			WebElement titleerror = driver.findElement(FlashcardPage.Flascard_icon);
			titleerror.isDisplayed();
			logger.info("Message: " + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Icon is Required");
		} catch (Exception e) {
			logger.info(e);
		}
	}
	// navigate to add Flash card and submit without description

	@Test(priority = 3, groups = { "Regression" })
	public void Add_flashcard_description_Required() throws Exception {
		logger = extent.createTest("Flashcard description", "add new flashcard description required ");
		logger.log(Status.INFO, "add new flashcard Description Required");

		driver.findElement(FlashcardPage.upload).click();
		Thread.sleep(2000);
		driver.findElement(FlashcardPage.file).sendKeys(System.getProperty("user.dir") + "/TestData/AML.jpg");
		Thread.sleep(4000);
		System.out.println("Icon is uploaded");
		driver.findElement(FlashcardPage.addTitle).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		driver.findElement(FlashcardPage.publish).click();
		Thread.sleep(2000);

		try {
			WebElement titleerror = driver.findElement(FlashcardPage.Error);
			titleerror.isDisplayed();
			logger.info("Message: " + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);

			// Assert.assertEquals(alert, "Content is Required");
		} catch (Exception e) {
			logger.info(e);
		}
		Thread.sleep(3000);
	}

	// cancel category form
	@Test(priority = 4, groups = { "Regression" })
	public void cancel() throws Exception {
		logger = extent.createTest("Flashcard cancel", "add new Flashcard cancel ");
		logger.log(Status.INFO, "add new Flashcard click cancel");
			
		System.out.println("Click on cancel button");
		WebElement cancel = driver.findElement(FlashcardPage.cancel);
		cancel.click();
		Thread.sleep(3000);
		// Assert.assertEquals(false, cancel.isDisplayed());
		logger.log(Status.INFO, "Flashcard form cancelled");
	}

	// description count assert

	@Test(priority = 5, groups = { "Regression" })
	public void add_new_flashcard_Description_count() throws Exception {
		logger = extent.createTest("Flashcard counter", "add new Flashcard description counter");
		logger.log(Status.INFO, "add new Flashcard description counter");
		Click_Add_New_Flashcard();
		Thread.sleep(2000);
		driver.findElement(FlashcardPage.addTitle).click();
		Thread.sleep(2000);
		driver.findElement(FlashcardPage.addTitle).sendKeys(Wrapper.AlphaNumericString(7));
		System.out.println("category title is entered");
		Thread.sleep(2000);
		driver.findElement(FlashcardPage.file).sendKeys(System.getProperty("user.dir") + "/TestData/AML.jpg");
		Thread.sleep(4000);
		System.out.println("Icon is uploaded");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		WebElement chars = driver.findElement(FlashcardPage.chars);
		System.out.println(chars.getText());
		logger.log(Status.INFO, "Before " + chars.getText());
		Thread.sleep(2000);

		WebElement Description = driver.findElement(FlashcardPage.description);
		Description.click();
		Description.sendKeys("Testing");
		Thread.sleep(2000);
		System.out.println(chars.getText());
		logger.log(Status.INFO, "After " + chars.getText());
		Thread.sleep(2000);
		assertEquals(chars.getText(), "Characters : 7/1000");
		Thread.sleep(2000);
		driver.findElement(FlashcardPage.cancel).click();

	}

	@Test(priority = 6, groups = { "Regression", "SmokeTest" })
	public void Add_Flashcard_valid() throws InterruptedException, Exception {
		logger = extent.createTest("add flashcard success", "Add Flashcard successfully");
		logger.log(Status.INFO, "add new flashcard");
		Click_Add_New_Flashcard();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		Thread.sleep(2000);
		driver.findElement(FlashcardPage.addTitle).click();
		Thread.sleep(2000);
		driver.findElement(FlashcardPage.addTitle).sendKeys(excel.getDataSheetName("ManageContent", 8, 1));
		System.out.println("Flashcard title is entered");

		driver.findElement(FlashcardPage.upload).click();
		Thread.sleep(2000);
		driver.findElement(FlashcardPage.file).sendKeys(System.getProperty("user.dir") + "/TestData/AML.jpg");
		Thread.sleep(4000);
		System.out.println("Icon is uploaded");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		driver.findElement(FlashcardPage.description).click();
		Thread.sleep(1000);
		driver.findElement(FlashcardPage.description).sendKeys(excel.getDataSheetName("ManageContent", 9, 1));
		System.out.println("Description entered");
		WebElement publish = wait.until(ExpectedConditions.elementToBeClickable(FlashcardPage.publish));
		publish.click();
		Thread.sleep(2000);
		
		try {

			WebElement toasterdiaplay = driver.findElement(ToasterObject.toaster);
			toasterdiaplay.isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Flashcard already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);

				driver.findElement(FlashcardPage.cancel).click();
				
			} else if (toaster.contains("Flashcard created and saved as draft")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				
			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
		Thread.sleep(3000);
	}

	// wait for search to display and enter text then capture results
	@Test(priority = 7, groups = { "Regression", "SmokeTest" })
	public void Search_Flashcard() throws Exception {
		logger = extent.createTest("search Flashcard  ", "Search Flashcard");

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement search_Flashcard = wait.until(ExpectedConditions.elementToBeClickable(FlashcardPage.Search));
		search_Flashcard.click();
		Thread.sleep(2000);
		logger.log(Status.INFO, "Search Anti Money Laundering");
		search_Flashcard.sendKeys(excel.getDataSheetName("ManageContent", 8, 1));
		Thread.sleep(2000);

		if (driver.findElements(FlashcardPage.No_data).size() > 0) {
			String nodata = driver.findElement(FlashcardPage.No_data).getText();
			System.out.println(nodata);
			logger.log(Status.INFO, nodata);

		} else if (driver.findElements(FlashcardPage.View_icon).size() > 0) {
			WebElement drp = driver.findElement(ToasterObject.status2);
			drp.click();
			Select statusupdate = new Select(drp);
			statusupdate.selectByValue("PUBLISHED");
			Thread.sleep(2000);
			System.out.println("Search results matched and data displayed");
			logger.log(Status.INFO, "Search results matched and data displayed");

		}
		driver.findElement(FlashcardPage.Search).clear();
		System.out.println("Search cleared");
		Thread.sleep(2000);
	}

	// wait for search to display and enter text then capture results

	@Test(priority = 8, groups = { "Regression","SmokeTest" })
	public void view_Flashcard() throws Exception {
		logger = extent.createTest("View Flashcard  ", "View Flashcard");
		logger.log(Status.INFO, "View Flashcard");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement Flashcard = wait.until(ExpectedConditions.elementToBeClickable(FlashcardPage.View_icon));
		Flashcard.click();
		Thread.sleep(2000);
		WebElement content = driver.findElement(FlashcardPage.Flashcard_content);
		String text = content.getText();
		logger.log(Status.INFO, "FLashcard content -" + text);
		System.out.println(text);
		Thread.sleep(2000);
		driver.findElement(FlashcardPage.Flashcard_preview_close).click();

	}

	// Edit Flash card
	@Test(priority = 10, groups = { "Regression", "SmokeTest" })
	public void Edit_Flashcard() throws Exception {
		logger = extent.createTest("Edit Flashcard", "Edit Flashcard");
		logger.log(Status.INFO, "Edit Flashcard description");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(FlashcardPage.CTA_Button);
		CTA.click();
		Thread.sleep(2000);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER, Keys.ENTER)).perform();
		
		WebElement Description = wait.until(ExpectedConditions.elementToBeClickable(FlashcardPage.description));
		Description.click();
		Description.clear();
		Description.sendKeys(Wrapper.AlphaNumericString(15));
		System.out.println("Description is entered");
		WebElement publish = wait.until(ExpectedConditions.elementToBeClickable(FlashcardPage.publish));
		publish.click();
		

		try {
			WebElement Toaster = wait.until(ExpectedConditions.visibilityOfElementLocated(ToasterObject.toaster));
			Toaster.isDisplayed();
			String toaster = Toaster.getText();
			if (toaster.contains("Flashcards already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(TopicsPage.Cancel_Topic).click();
				Thread.sleep(2000);
			} else if (toaster.contains("Flashcards updated successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}

	}

	// Delete Flash card clicking on cancel
	@Test(priority = 9, groups = { "Regression","SmokeTest" })
	public void Delete_Flashcard_Cancel() throws Exception {
		logger = extent.createTest("Delete Flashcard No", "Delete Flashcard Cancel");
		logger.log(Status.INFO, "Flashcard Delete Cancel");		
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(FlashcardPage.CTA_Button);
		CTA.click();
		Thread.sleep(2000);
		
		driver.findElement(FlashcardPage.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Cancel = driver.findElement(FlashcardPage.Delete_cancel);
		Cancel.click();
		Thread.sleep(2000);
		System.out.println("clicked on cancel button");

	}
	@Test(priority = 11, groups = { "Regression" })
	public void add_new_Flashcard_Status() throws Exception {
		logger = extent.createTest("Add Flashcard Status Change",
				"Changing the status");
		logger.log(Status.INFO, "add new Flashcard Status");
		driver.get(config.flashcards());
		Thread.sleep(3000);
		WebElement status = driver.findElement(FlashcardPage.status);
		status.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN,Keys.ENTER)).perform();
		Thread.sleep(2000);
		String toaster = driver.findElement(ToasterObject.toaster).getText();
		System.out.println("Text in Toaster---"+toaster);
		
		Thread.sleep(3000);
		
		WebElement status1 = driver.findElement(FlashcardPage.status);
		status1.click();
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.UP,Keys.ENTER)).perform();
		Thread.sleep(2000);
		



	}

	// Delete Flash card clicking on Yes
	@Test(priority = 12, groups = { "Delete" })
	public void Delete_Flashcard_Yes() throws Exception {
		logger = extent.createTest("Delete Flashcard yes", "Delete Yes");
		logger.log(Status.INFO, "Delete Flashcard");
		//driver.get(config.flashcards());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(FlashcardPage.CTA_Button);
		CTA.click();
		driver.findElement(FlashcardPage.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Delete = driver.findElement(FlashcardPage.Delete_Yes);
		Delete.click();

		System.out.println("clicked on Yes button");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			WebElement toastervisible = wait.until(ExpectedConditions.elementToBeClickable(ToasterObject.toaster));

			toastervisible.isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Sorry, You cannot delete this Flashcards which is mapped to Klp")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
			} else if (toaster.contains("Flashcards Deleted successfully")) {
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
	public void Click_Add_New_Flashcard() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));

		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(FlashcardPage.Add_New_Flashcard));
		Add.click();

	}
}
