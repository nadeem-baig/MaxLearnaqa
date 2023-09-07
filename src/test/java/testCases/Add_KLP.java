package testCases;

import static org.testng.Assert.assertEquals;

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

import PageObjects.KLP_Page;
import PageObjects.ToasterObject;
import utility.Wrapper;

public class Add_KLP extends BaseClass {

	// navigate to create KlP form and click on submit without title
	@Test(priority = 1, groups = { "Regression" })
	public void Add_KLP_Title_required() throws Exception {
		logger = extent.createTest("KLP tilte*","Create Klp title required ");
		logger.log(Status.INFO, "Create Klp Title");
		Click_Add_New_KLP();
		Thread.sleep(2000);
		driver.findElement(KLP_Page.Save_Klp).click();

		try {
			WebElement titleerror = driver.findElement(KLP_Page.errorMessage);
			titleerror.isDisplayed();
			logger.info("Message:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Title Required");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to create KlP and click on submit without category

	@Test(priority = 2, groups = { "Regression" })
	public void Create_KLP_category_required() throws Exception {
		logger = extent.createTest("KLP category*","create KlP category required ");
		logger.log(Status.INFO, "create KlP category");
		Thread.sleep(2000);
		WebElement Title = driver.findElement(KLP_Page.Klp_Title);
		Title.click();
		Title.sendKeys(Wrapper.AlphaNumericString(5));
		Thread.sleep(2000);
		System.out.println("Title is entered");
		Thread.sleep(2000);
		driver.findElement(KLP_Page.Save_Klp).click();

		try {
			WebElement titleerror = driver.findElement(KLP_Page.errorMessage2);
			titleerror.isDisplayed();
			logger.info("Message:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Category Required");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to create KlP form and click on submit without Subject

	@Test(priority = 3, groups = { "Regression" })
	public void Create_KLP_subject_required() throws Exception {
		logger = extent.createTest( "KLP subject*","create KLP subject required ");
		logger.log(Status.INFO, "create KLP subject");
		Thread.sleep(2000);
		WebElement category = driver.findElement(KLP_Page.Category_dropdown);
		category.click();
		Thread.sleep(4000);
		System.out.println("Category dropdown is clicked");
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(excel.getDataSheetName("ManageContent", 1, 1),Keys.chord(Keys.ENTER)).perform();
		

		Thread.sleep(2000);
		driver.findElement(KLP_Page.Save_Klp).click();

		try {
			WebElement titleerror = driver.findElement(KLP_Page.errorMessage2);
			titleerror.isDisplayed();
			logger.info("Message:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Subject Required");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to create KlP form and click on submit without Topic

	@Test(priority = 4,groups = { "Regression" })
	public void Create_KLP_Topic_required() throws Exception {
		logger = extent.createTest("KLP Topic*","create KlP topic required ");
		logger.log(Status.INFO, "create KlP Topic");
		Thread.sleep(2000);
		WebElement Subject = driver.findElement(KLP_Page.Subject_dropdown);
		Subject.click();
		Thread.sleep(4000);
		System.out.println("Subject dropdown is clicked");
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(excel.getDataSheetName("ManageContent", 3, 1),Keys.chord(Keys.ENTER)).perform();
		
		Thread.sleep(2000);
		driver.findElement(KLP_Page.Save_Klp).click();

		try {
			WebElement titleerror = driver.findElement(KLP_Page.errorMessage2);
			titleerror.isDisplayed();
			logger.info("Message:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Topic Required");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to create KLP and submit without description

	@Test(priority = 5,groups = { "Regression" })
	public void Create_KLP_description_Required() throws Exception {
		logger = extent.createTest("KLP description","create KLP description required ");
		logger.log(Status.INFO, "create KLP Description Required");
		WebElement Topic = driver.findElement(KLP_Page.Topic_dropdown);
		Topic.click();
		Thread.sleep(4000);
		System.out.println("Subject dropdown is clicked");
		Actions keyDown2 = new Actions(driver);
		keyDown2.sendKeys(Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(1000);
		driver.findElement(KLP_Page.Save_Klp).click();
		Actions dragger = new Actions(driver);
		WebElement element = driver.findElement(ToasterObject.innerscroll);
		dragger.moveToElement(element).clickAndHold().moveByOffset(0, 200).release(element).build().perform();
		Thread.sleep(2000);
		try {
			WebElement titleerror = driver.findElement(KLP_Page.errorMessage);
			titleerror.isDisplayed();
			logger.info("Message:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Content Required");
		} catch (Exception e) {
			logger.info(e);
		}

	}

	// cancel Create KLP form

	@Test(priority = 6,groups = { "Regression" })
	public void Create_KLP_Cancel() throws Exception {
		logger = extent.createTest("KLP cancel ", "verify cancel KLP");
		logger.log(Status.INFO, "Create Klp cancel");
		Thread.sleep(2000);
		System.out.println("Click on cancel button");
		driver.findElement(KLP_Page.Cancle_Klp);
		logger.log(Status.INFO, "KLP form cancelled");
		Thread.sleep(3000);
	}

	// add Create KLP with all the data filled

	@Test(priority = 7, groups = { "Regression" ,"SmokeTest"})
	public void Create_KLP_Valid() throws Exception {
		logger = extent.createTest("Create KLP valid", "verify KLP valid case with all the data filled");
		logger.log(Status.INFO, "Create KLP");
		Click_Add_New_KLP();
		Thread.sleep(2000);

		// Enter Title

		WebElement Title = driver.findElement(KLP_Page.Klp_Title);
		Title.click();
		Title.sendKeys(excel.getDataSheetName("ManageContent", 10, 1) );
		Thread.sleep(2000);

		// Select Category

		WebElement category = driver.findElement(KLP_Page.Category_dropdown);
		category.click();
		Thread.sleep(4000);
		System.out.println("Category dropdown is clicked");
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(excel.getDataSheetName("ManageContent", 1, 1),Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);

		// Select Subject

		WebElement Subject = driver.findElement(KLP_Page.Subject_dropdown);
		Subject.click();
		Thread.sleep(4000);
		System.out.println("Subject dropdown is clicked");
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(excel.getDataSheetName("ManageContent", 3, 1),Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);

		// Select Topic

		WebElement Topic = driver.findElement(KLP_Page.Topic_dropdown);
		Topic.click();
		Thread.sleep(4000);
		System.out.println("topic dropdown is clicked");
		Actions keyDown2 = new Actions(driver);
		keyDown2.sendKeys(excel.getDataSheetName("ManageContent", 5, 1),Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);

		// Enter Content

		WebElement Description = driver.findElement(KLP_Page.Klp_Content);
		Description.click();
		Description.sendKeys(excel.getDataSheetName("ManageContent", 11, 1) +Wrapper.AlphaNumericString(10));
		Thread.sleep(2000);

		driver.findElement(KLP_Page.Save_Klp).click();
		Thread.sleep(2000);
		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("KLP already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(KLP_Page.Cancle_Klp).click();
				Thread.sleep(2000);
			} else if (toaster.contains("KLP created successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
	}

	// description count assert
	@Test(priority = 8,groups = { "Regression" })
	public void Add_New_KLP_Description_count() throws Exception {
		logger = extent.createTest("KLP counter","add new KLP description counter");
		logger.log(Status.INFO, "add new KLP description counter");
		Click_Add_New_KLP();
		Thread.sleep(2000);

		WebElement Title = driver.findElement(KLP_Page.Klp_Title);
		Title.click();
		Title.sendKeys("Title");
		Thread.sleep(2000);
		System.out.println("KLP title is entered");
		Thread.sleep(2000);
		WebElement chars = driver.findElement(KLP_Page.chars);
		System.out.println(chars.getText());
		logger.log(Status.INFO, "Before - "+chars.getText());
		Thread.sleep(2000);

		WebElement Description = driver.findElement(KLP_Page.Klp_Content);
		Description.click();
		Description.sendKeys(Wrapper.AlphaNumericString(7));
		Thread.sleep(2000);
		WebElement chars2 = driver.findElement(KLP_Page.chars);
		System.out.println(chars2.getText());
		logger.log(Status.INFO,  "After - "+chars2.getText());
		Thread.sleep(2000);
		assertEquals(chars2.getText(), "max: 493 char.");
		Thread.sleep(2000);
		driver.findElement(KLP_Page.Save_Klp).click();

	}

	// wait for search to display and enter text then capture results
	@Test(priority = 9,groups = { "Regression","SmokeTest" })
	public void Search_KLP() throws Exception {
		logger = extent.createTest("Search KLP  ", "Search KLP");
		logger.log(Status.INFO, "search KLP");

		driver.get(config.klp());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement search_KLP = wait.until(ExpectedConditions.elementToBeClickable(KLP_Page.Search));
		search_KLP.click();
		Thread.sleep(2000);
		search_KLP.sendKeys(excel.getDataSheetName("ManageContent", 10, 1));
		logger.log(Status.INFO, "Search ");
		Thread.sleep(2000);

		if (driver.findElements(KLP_Page.No_data).size() > 0) {
			String nodata = driver.findElement(KLP_Page.No_data).getText();
			System.out.println(nodata);
			logger.log(Status.INFO, nodata);

		} else if (driver.findElements(KLP_Page.View_Row).size() > 0) {
			
			driver.findElement(KLP_Page.View_Row).click();
			Thread.sleep(3000);
			System.out.println("Search results matched and data displayed");
			logger.log(Status.INFO, "Search results matched and data displayed");

		}
		driver.findElement(KLP_Page.Search).clear();
		System.out.println("Search cleared");
		

	}

	// view category
	@Test(priority = 10,groups = { "Regression" })
	public void View_KLP() throws Exception {
		logger = extent.createTest("View KLP  ", "view KLP details");
		logger.log(Status.INFO, "view KLP");
		driver.get(config.klp());
		Thread.sleep(3000);
		WebElement view_KLP = driver.findElement(KLP_Page.View_Row);
		view_KLP.click();

		// capture details
		Thread.sleep(2000);
		WebElement content = driver.findElement(KLP_Page.KLP_Detail_Title);
		String text = content.getText();
		logger.log(Status.INFO, "KLP content - "+text);
		System.out.println(text);
		Thread.sleep(2000);
		driver.findElement(KLP_Page.KLP_preview_close).click();

	}

	// Edit KLP
	@Test(priority = 11,groups = { "Regression","SmokeTest" })
	public void Edit_KLP() throws Exception {
		logger = extent.createTest("Edit KLP", "Edit KLP");
		logger.log(Status.INFO, "Edit KLP");
		driver.get(config.klp());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(KLP_Page.CTA_Button);
		CTA.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER, Keys.ENTER)).perform();
		Thread.sleep(2000);
		WebElement Description = driver.findElement(KLP_Page.Klp_Content);
		Description.clear();
		Description.sendKeys(Wrapper.AlphaNumericString(10));
		System.out.println("Description is entered");
		Thread.sleep(2000);
		driver.findElement(KLP_Page.Save_Klp).click();
		Thread.sleep(2000);

		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("KLP already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(KLP_Page.Cancle_Klp).click();
				Thread.sleep(2000);
			} else if (toaster.contains("KLP updated successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}

	}

	// Delete KLP clicking on cancel
	@Test(priority = 12,groups = { "Regression" })
	public void Delete_KLP_Cancel() throws Exception {
		logger = extent.createTest("Delete KLP - No", "KLP delete Cancel");
		logger.log(Status.INFO, "KLP Delete Cancel");
		driver.get(config.klp());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(KLP_Page.CTA_Button);
		CTA.click();
		driver.findElement(KLP_Page.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Cancel = driver.findElement(KLP_Page.Delete_cancel);
		Cancel.click();
		Thread.sleep(2000);
		System.out.println("clicked on cancel button");

	}

	// Delete KLP clicking on Yes
	@Test(priority = 13,groups = { "Delete" })
	public void Delete_KLP_Yes() throws Exception {
		logger = extent.createTest("Delete KLP Yes", "Delete KLP Yes");
		logger.log(Status.INFO, "Delete KLP");
		driver.get(config.klp());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(KLP_Page.CTA_Button);
		CTA.click();
		driver.findElement(KLP_Page.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Delete = driver.findElement(KLP_Page.Delete_Yes);
		Delete.click();
		System.out.println("clicked on Yes button");
		Thread.sleep(3000);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			WebElement KLP = wait.until(ExpectedConditions.elementToBeClickable(ToasterObject.toaster));

			KLP.isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Sorry, You cannot delete this KLP which is mapped to questions")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
			} else if (toaster.contains("KLP Deleted successfully")) {
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
	public void Click_Add_New_KLP() {
		driver.get(config.klp());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));

		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(KLP_Page.Add_New_Klp));
		Add.click();

	}
}
