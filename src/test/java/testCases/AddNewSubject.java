package testCases;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
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

import PageObjects.SubjectsPage;
import PageObjects.ToasterObject;
import utility.Wrapper;

public class AddNewSubject extends BaseClass {

	// navigate to add new subjects and verify subject title
	@Test(priority = 0, groups = { "Regression" })
	public void Add_Subject_Title_Required() throws InterruptedException, Exception {
		logger = extent.createTest("Add Subject Title*","add new subject title required");
		logger.log(Status.INFO, "add new subject Title");
		Click_Add_New_Subject();
		Thread.sleep(2000);

		driver.findElement(SubjectsPage.Subject_save).click();
		Thread.sleep(2000);
		try {
			WebElement titleerror = driver.findElement(SubjectsPage.errormessage);
			titleerror.isDisplayed();
			logger.info("Message:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Title is Required");
		} catch (Exception e) {
			logger.info(e);
		}

	}

//subject icon mandatory validation
	@Test(priority = 2, groups = { "Regression" })
	public void Add_Subject_Icon_Required() throws InterruptedException {
		logger = extent.createTest("Add Subject Icon*","add new subject icon required ");
		logger.log(Status.INFO, "add new subject Icon Required");

		Click_Add_New_Subject();
		Thread.sleep(3000);
		WebElement title = driver.findElement(SubjectsPage.Subject_Title);

		title.sendKeys(Wrapper.AlphaNumericString(7));

		driver.findElement(SubjectsPage.Subject_save).click();
		Thread.sleep(2000);
		try {
			WebElement titleerror = driver.findElement(SubjectsPage.icon);
			titleerror.isDisplayed();
			logger.info("Message: " + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Icon is Required");
		} catch (Exception e) {
			logger.info(e);
		}
		Thread.sleep(2000);
	}

	@Test(priority = 3, groups = { "Regression" })
	public void Add_subject_category_dropdown_Required() throws Exception {
		logger = extent.createTest("Add Subject Category*","add new subject category dropdown required ");
		logger.log(Status.INFO, "add new subject category Required");
		Thread.sleep(2000);
		WebElement title = driver.findElement(SubjectsPage.Subject_Title);
		title.click();
		title.clear();
		title.sendKeys(Wrapper.randomeString(5));
		Thread.sleep(3000);
		driver.findElement(SubjectsPage.sub_upload).click();
		driver.findElement(SubjectsPage.File).sendKeys(System.getProperty("user.dir") + "/TestData/profile icon.png");
		Thread.sleep(4000);
		System.out.println("Icon is uploaded");

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);
		
		driver.findElement(SubjectsPage.Subject_Title).click();
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		WebElement category = driver.findElement(SubjectsPage.Category_Dropdown);
		category.click();
//		Actions dragger = new Actions(driver);
//		WebElement element = driver.findElement(ToasterObject.innerscroll);
//		dragger.moveToElement(element).clickAndHold().moveByOffset(0, 200).release(element).build().perform();
		Thread.sleep(2000);
		
		driver.findElement(SubjectsPage.Subject_save).click();

		try {
			WebElement titleerror = driver.findElement(SubjectsPage.errormessage);
			titleerror.isDisplayed();
			logger.info("Message: " + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);

			Assert.assertEquals(alert, "Category is Required");
		} catch (Exception e) {
			logger.info(e);
		}
		Thread.sleep(3000);
	}

	// verify subject description mandatory
	@Test(priority = 4, groups = { "Regression" })
	public void Add_subject_description_Required() throws Exception {
		logger = extent.createTest("Add Subject description*","add new subject description required");
		logger.log(Status.INFO, "add new subject Description Required");
		Thread.sleep(2000);
		/*WebElement title = driver.findElement(SubjectsPage.Subject_Title);
		title.click();
		title.sendKeys(Wrapper.AlphaNumericString(7));
		Thread.sleep(3000);

		driver.findElement(SubjectsPage.sub_upload).click();
		driver.findElement(SubjectsPage.File).sendKeys(System.getProperty("user.dir") + "/TestData/profile icon.png");
		Thread.sleep(4000);
		System.out.println("Icon is uploaded");

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		*/
//		WebElement category = driver.findElement(SubjectsPage.Category_Dropdown);
//		category.click();
		Thread.sleep(2000);
		System.out.println("Category dropdown is clicked");
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER, Keys.TAB)).perform();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		WebElement Decription = driver.findElement(SubjectsPage.description);
		Decription.click();
		Decription.clear();

		Wrapper.scrollDown(driver);
		driver.findElement(SubjectsPage.Subject_save).click();
		Thread.sleep(2000);
		

		try {
			WebElement titleerror = driver.findElement(SubjectsPage.errormessage);
			titleerror.isDisplayed();
			String alert = titleerror.getText();
			logger.info("Message: " + alert);

			System.out.println("Message - " + alert);

			// Assert.assertEquals(alert, "Description is Required");
		} catch (Exception e) {
			logger.info(e);
		}
		Thread.sleep(2000);
	}

	// cancel subject form
	@Test(priority = 5, groups = { "Regression" })
	public void cancel() throws InterruptedException, IOException {
		logger = extent.createTest("add new subject cancel", "verify subject delete cancel");
		logger.log(Status.INFO, "add new subject click cancel");
		Click_Add_New_Subject();
		Thread.sleep(4000);
		Wrapper.scrollDown(driver);
		System.out.println("Click on cancel button");
		WebElement cancel = driver.findElement(SubjectsPage.Cancel);
		cancel.click();
		logger.log(Status.INFO, "subject form cancelled");
		//Assert.assertEquals(false, driver.findElement(SubjectsPage.add_Form_title).isDisplayed());
		Thread.sleep(3000);
	}

//add subject valid case with all the data filled
	@Test(priority = 6, groups = { "Regression", "SmokeTest" })
	public void add_new_Subject_Valid() throws InterruptedException, Exception {
		logger = extent.createTest("add new subject valid ", "verify add new subject with all the data");
		logger.log(Status.INFO, "add new subject");
		Click_Add_New_Subject();
		Thread.sleep(2000);

		driver.findElement(SubjectsPage.Subject_Title).click();

		//driver.findElement(SubjectsPage.Subject_Title).sendKeys(Wrapper.randomeString(7));
		
		driver.findElement(SubjectsPage.Subject_Title).sendKeys(excel.getDataSheetName("ManageContent", 3, 1));
		Thread.sleep(2000);
		System.out.println("Title is entered");

		driver.findElement(SubjectsPage.sub_upload).click();
		driver.findElement(SubjectsPage.File).sendKeys(System.getProperty("user.dir") + "/TestData/profile icon.png");
		Thread.sleep(4000);
		System.out.println("image uploaded");

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);
		driver.findElement(SubjectsPage.Subject_Title).click();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		WebElement category = driver.findElement(SubjectsPage.Category_Dropdown);
		category.click();
		Thread.sleep(2000);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(excel.getDataSheetName("ManageContent", 1, 1),Keys.chord(Keys.ENTER)).perform();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
//		Actions dragger = new Actions(driver);
//		WebElement element = driver.findElement(ToasterObject.innerscroll);
//		dragger.moveToElement(element).clickAndHold().moveByOffset(0, 200).release(element).build().perform();

		
		WebElement Deccription = driver.findElement(SubjectsPage.description);
		Deccription.click();	
		Deccription.sendKeys(excel.getDataSheetName("ManageContent", 4, 1));
		Thread.sleep(2000);
		System.out.println("Description is added");

		driver.findElement(SubjectsPage.Subject_save).click();
		Thread.sleep(3000);
		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("subjects already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(SubjectsPage.Cancel).click();
				Thread.sleep(2000);
			} else if (toaster.contains("subjects created successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}

	}

	// description count and invalid file upload
	@Test(priority = 7, groups = { "Regression" })
	public void add_new_Subject_Description_count() throws InterruptedException, Exception {
		logger = extent.createTest("Add Subject invalid image*","add new subject and check invalid file");
		logger.log(Status.INFO, "add new subject check invalid file ");
		Click_Add_New_Subject();
		Thread.sleep(2000);

		WebElement title = driver.findElement(SubjectsPage.Subject_Title);
		title.click();
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		WebElement chars = driver.findElement(SubjectsPage.chars);
		System.out.println(chars.getText());
		Thread.sleep(2000);

		WebElement Deccription = driver.findElement(SubjectsPage.description);
		Deccription.click();
		Deccription.sendKeys(Wrapper.randomeString(5));
		Thread.sleep(2000);
		System.out.println("Description is added");
		System.out.println(chars.getText());

		assertEquals(chars.getText(), "max:495 char");

		

	}

	//
	@Test(priority = 8, groups = { "SmokeTest","Regression" })
	public void Search_Subjects() throws Exception {
		logger = extent.createTest("Search Subject","Detail page in subject listing ");
		logger.log(Status.INFO, "search subject");
		driver.get(config.subject());
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement Search_subject = wait.until(ExpectedConditions.elementToBeClickable(SubjectsPage.search));
		Search_subject.click();
		Thread.sleep(1000);

		Search_subject.sendKeys(excel.getDataSheetName("ManageContent", 3, 1));
		Thread.sleep(2000);

		if (driver.findElements(SubjectsPage.No_data).size() > 0) {
			String nodata = driver.findElement(SubjectsPage.No_data).getText();
			System.out.println(nodata);
			logger.log(Status.INFO, nodata);

		} else if (driver.findElements(SubjectsPage.View_Row).size() > 0) {
			Thread.sleep(2000);
			WebElement drp =driver.findElement(ToasterObject.status);
			drp.click();
			Select statusupdate = new Select(drp);
			statusupdate.selectByValue("PUBLISHED");
			Thread.sleep(2000);
			System.out.println("subject published ");
			//driver.findElement(SubjectsPage.View_Row).click();
			System.out.println("Search results matched and data displayed");
			logger.log(Status.INFO, "Search results matched and data displayed");

		}
		driver.findElement(SubjectsPage.Search_category).clear();
		System.out.println("Search cleared");
	
	}

	// view subject
	@Test(priority = 9, groups = { "Regression" })
	public void View_Subject() throws Exception {
		logger = extent.createTest("view Subject  ", "view subject details");
		logger.log(Status.INFO, "view Subject");
		driver.get(config.subject());

		WebElement view_Subject = driver.findElement(SubjectsPage.View_Row);
		view_Subject.click();

		// capture details
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement Add = wait.until(ExpectedConditions.visibilityOfElementLocated(SubjectsPage.Add_Topics));
		Add.isDisplayed();
		logger.log(Status.INFO, "Topic Listing - "+Add.getText());

	}

	// Edit Subject
	@Test(priority = 10, groups = { "Regression", "SmokeTest" })
	public void Edit_Subject() throws Exception {
		logger = extent.createTest("Edit Subject", "Edit subject description");
		logger.log(Status.INFO, "Edit Subject description");
		driver.get(config.subject());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(SubjectsPage.CTA_Button);
		CTA.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER, Keys.ENTER)).perform();
		Thread.sleep(2000);
		driver.findElement(SubjectsPage.Subject_Title).click();

		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		WebElement description = driver.findElement(SubjectsPage.description);
		description.clear();
		description.sendKeys(Wrapper.AlphaNumericString(1));
		System.out.println("Description is entered");
		Thread.sleep(2000);
		driver.findElement(SubjectsPage.Subject_save).click();
		Thread.sleep(3000);

		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Subjects already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(SubjectsPage.Cancel).click();
				Thread.sleep(2000);
			} else if (toaster.contains("Subject updated successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}

	}
	
	

	// Delete Subject clicking on cancel
	@Test(priority = 11, groups = { "Regression" })
	public void Delete_Subject_Cancel() throws Exception {
		logger = extent.createTest("Delete Subject -No", "Subject delete Cancel");
		logger.log(Status.INFO, "Delete Subject no");
		driver.get(config.subject());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(SubjectsPage.CTA_Button);
		CTA.click();
		driver.findElement(SubjectsPage.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Cancel = driver.findElement(SubjectsPage.Delete_cancel);
		Cancel.click();
		Thread.sleep(2000);
		System.out.println("clicked on cancel button");

	}
	@Test(priority = 12, groups = { "Regression" })
	public void add_new_Subject_Status() throws Exception {
		logger = extent.createTest("Add Subject Status Change",
				"Changing the status");
		logger.log(Status.INFO, "add new Subject Status");
		
		WebElement status = driver.findElement(SubjectsPage.status);
		status.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN,Keys.ENTER)).perform();
		Thread.sleep(2000);
		String toaster = driver.findElement(ToasterObject.toaster).getText();
		System.out.println("Text in Toaster"+toaster);
		WebElement status1 = driver.findElement(SubjectsPage.status);
		status1.click();
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.UP,Keys.ENTER)).perform();
		Thread.sleep(2000);



	}


	// Delete Subject clicking on Yes
	@Test(priority = 13, groups = { "Delete" })
	public void Delete_Subject_Yes() throws Exception {
		logger = extent.createTest("Delete Subject - Yes", "Delete subject Yes");
		logger.log(Status.INFO, "Delete Subject");
		driver.get(config.subject());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(SubjectsPage.CTA_Button);
		CTA.click();
		driver.findElement(SubjectsPage.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Delete = driver.findElement(SubjectsPage.Delete_Yes);
		Delete.click();
		Thread.sleep(3000);
		System.out.println("clicked on Yes button");
		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Sorry, You cannot delete this Subject which is mapped to Topics")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
			} else if (toaster.contains("Subjects Deleted successfully")) {
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
	public void Click_Add_New_Subject() throws InterruptedException {

		driver.get(config.subject());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));

		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(SubjectsPage.Add_New_Subject));
		Add.click();
	}

}
