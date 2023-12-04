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

import PageObjects.Category;
import PageObjects.ToasterObject;
import utility.Wrapper;

public class AddNewCategory extends BaseClass {

	// navigate to add category form and click on submit without title
	@Test(priority = 1, groups = { "Regression" })
	public void Add_Category_Title_Required() throws Exception {
		logger = extent.createTest("Add Catrgory Title*", "add new category title required ");
		logger.log(Status.INFO, "add new category Title");
		Thread.sleep(2000);
		Click_Add_New_category();

		Thread.sleep(2000);
		driver.findElement(Category.cat_submitbutton).click();
		Thread.sleep(1000);
		try {
			WebElement titleerror = driver.findElement(Category.errormessage);
			titleerror.isDisplayed();
			logger.info("Message:" + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Title is Required");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	// navigate to add category and click submit without icon
	@Test(priority = 2, groups = { "Regression" })
	public void Add_Category_Icon_Required() throws InterruptedException {
		logger = extent.createTest("Add Catrgory Icon*", "add new category icon required ");
		logger.log(Status.INFO, "add new category Icon Required");
		Click_Add_New_category();

		WebElement title = driver.findElement(Category.addTitle);

		title.sendKeys(Wrapper.randomeString(5));

		// driver.findElement(Category.cardColor).click();
		driver.findElement(Category.cat_submitbutton).click();
		Thread.sleep(1000);
		try {
			WebElement titleerror = driver.findElement(Category.icon);
			titleerror.isDisplayed();
			logger.info("Message: " + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);
			Assert.assertEquals(alert, "Icon is Required");
		} catch (Exception e) {
			logger.info(e);
		}
	}
	// navigate to add category and submit without description

	@Test(priority = 3, groups = { "Regression" })
	public void Add_Category_description_Required() throws Exception {
		logger = extent.createTest("Add Catrgory description*", "add new category description required ");
		logger.log(Status.INFO, "add new category Description Required");
		Click_Add_New_category();
		WebElement title = driver.findElement(Category.addTitle);

		title.sendKeys(Wrapper.randomeString(5));
		Thread.sleep(3000);
		driver.findElement(Category.cat_Fileupload).click();

		driver.findElement(Category.File).sendKeys(System.getProperty("user.dir") + "/TestData/profile icon.png");

		Thread.sleep(4000);
		System.out.println("Icon is uploaded");

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Actions dragger = new Actions(driver);
		WebElement element = driver.findElement(ToasterObject.innerscroll);
		dragger.moveToElement(element).clickAndHold().moveByOffset(0, 150).release(element).build().perform();
		Thread.sleep(2000);
		
		
		driver.findElement(Category.cardColor).click();
		Thread.sleep(1000);

		driver.findElement(Category.cat_submitbutton).click();

		try {
			WebElement titleerror = driver.findElement(Category.errormessage);
			titleerror.isDisplayed();
			logger.info("Message: " + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println("Message - " + alert);

			Assert.assertEquals(alert, "Description is Required");
		} catch (Exception e) {
			logger.info(e);
		}
		Thread.sleep(3000);
	}

	// navigate to cat form and submit without card color
	@Test(priority = 4, groups = { "Regression" })
	public void Add_Category_CardColor_Required() throws Exception {
		logger = extent.createTest("Add Catrgory Pick a card*", "add new category card color ");
		logger.log(Status.INFO, "add new category pick a card color  Required");
		
		
		WebElement description = driver.findElement(Category.category_Description);
		description.click();
		description.clear();
		description.sendKeys("test");
		System.out.println("Description entered");
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		driver.findElement(Category.cat_submitbutton).click();
		System.out.println("scroll ");
		Actions dragger = new Actions(driver);
		WebElement element = driver.findElement(ToasterObject.innerscroll);
		dragger.moveToElement(element).clickAndHold().moveByOffset(0, 150).release(element).build().perform();
		Thread.sleep(2000);
		try {
			WebElement titleerror = driver.findElement(Category.errorcard);
			titleerror.isDisplayed();
			String alert = titleerror.getText();
			logger.info("Message: " + alert);

			System.out.println("Message - " + alert);

			Assert.assertEquals(alert, "Card color is Required");
		} catch (Exception e) {
			logger.info(e);
		}
		Thread.sleep(3000);

	}

//cancel category form
	@Test(priority = 5, groups = { "Regression" })
	public void cancel() throws InterruptedException, IOException {
		logger = extent.createTest("Categoty Cancel", "add new category flow cancel");
		logger.log(Status.INFO, "add new category cancel");
		Click_Add_New_category();
		Thread.sleep(4000);
		Wrapper.scrollDown(driver);
		System.out.println("Click on cancel button");
		WebElement cancel = driver.findElement(Category.categorycancel);
		cancel.click();
		Thread.sleep(3000);
		// Assert.assertEquals(false,
		// driver.findElement(Category.add_Form_title).isDisplayed());
		logger.log(Status.INFO, "category form cancelled");
	}

	// add category with all the dta filled
	@Test(priority = 6, groups = { "Regression", "SmokeTest" })
	public void add_new_Category_Valid() throws Exception {
		logger = extent.createTest("Add Category valid", "verify add new category with required all data ");
		logger.log(Status.INFO, "add new category created");
		Click_Add_New_category();
		Thread.sleep(2000);
		driver.findElement(Category.addTitle).click();
		driver.findElement(Category.addTitle).sendKeys(excel.getDataSheetName("ManageContent", 1, 1));
		System.out.println("category title is entered");

		driver.findElement(Category.cat_Fileupload).click();
		driver.findElement(Category.File).sendKeys(System.getProperty("user.dir") + "/TestData/profile icon.png");
		Thread.sleep(4000);
		System.out.println("Icon is uploaded");

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		//driver.findElement(Category.category_Description).click();
		Actions dragger = new Actions(driver);
		WebElement element = driver.findElement(ToasterObject.innerscroll);
		dragger.moveToElement(element).clickAndHold().moveByOffset(0, 150).release(element).build().perform();
		Thread.sleep(2000);

		driver.findElement(Category.category_Description).sendKeys(excel.getDataSheetName("ManageContent", 2, 1));
		System.out.println("Description filled");
	
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);	
		Thread.sleep(2000);
		driver.findElement(Category.cardColor).click();

		driver.findElement(Category.cat_submitbutton).click();
		Thread.sleep(3000);
		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();

			String toaster = driver.findElement(ToasterObject.toaster).getText();

			if (toaster.contains("Category already exist")) {
				logger.log(Status.INFO, "Message -" + toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(Category.categorycancel).click();
				Thread.sleep(2000);
			} else if (toaster.contains("Category created and saved as draft")) {
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
	@Test(priority = 7, groups = { "Regression" })
	public void add_new_Category_Description_count() throws Exception {
		logger = extent.createTest("Add Category description Count",
				"verify add new category description counter changed after entering data");
		logger.log(Status.INFO, "add new category description counter");
		Click_Add_New_category();
		Thread.sleep(2000);
		driver.findElement(Category.addTitle).click();
		driver.findElement(Category.addTitle).sendKeys(Wrapper.AlphaNumericString(10));
		System.out.println("category title is entered");
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		WebElement chars = driver.findElement(Category.chars);
		System.out.println(chars.getText());
		logger.log(Status.INFO, "Max limit - " + chars.getText());
		Thread.sleep(2000);
		WebElement Description = driver.findElement(Category.category_Description);
		Description.click();
		Description.sendKeys(Wrapper.randomeString(5));
		Thread.sleep(2000);
		System.out.println(chars.getText());
		logger.log(Status.INFO, chars.getText());
		Thread.sleep(2000);
		assertEquals(chars.getText(), "max:495 char");
		driver.findElement(Category.cat_submitbutton).click();

	}

	// wait for search to display and enter text then capture results
	@Test(priority = 8, groups = { "Regression", "SmokeTest" })
	public void Search_Category() throws Exception {
		logger = extent.createTest("Search category ", "Search category");
		logger.log(Status.INFO, "Search category");
		driver.get(config.category());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement search_category = wait.until(ExpectedConditions.elementToBeClickable(Category.Search_category));
		search_category.click();
		search_category.sendKeys(excel.getDataSheetName("ManageContent", 1, 1));
		logger.log(Status.INFO, excel.getDataSheetName("ManageContent", 1, 1));
		Thread.sleep(2000);

		if (driver.findElements(Category.No_data).size() > 0) {
			String nodata = driver.findElement(Category.No_data).getText();
			System.out.println(nodata);
			logger.log(Status.INFO, nodata);

		} else if (driver.findElements(Category.View_Row).size() > 0) {
			Thread.sleep(2000);
			WebElement drp = driver.findElement(ToasterObject.status);
			drp.click();
			Select statusupdate = new Select(drp);
			statusupdate.selectByValue("PUBLISHED");
			Thread.sleep(2000);
			// driver.findElement(Category.View_Row).click();
			System.out.println("Search results matched and data displayed");
			logger.log(Status.INFO, "Search results matched and data displayed");

		}
		driver.findElement(Category.Search_category).clear();
		System.out.println("Search cleared");

	}

	// view category
	@Test(priority = 9, groups = { "Regression" })
	public void View_category() throws Exception {
		logger = extent.createTest("View category ", "view category details");
		logger.log(Status.INFO, "View category");
		driver.get(config.category());
		Thread.sleep(2000);
		WebElement view_category = driver.findElement(Category.View_Row);
		view_category.click();

		// capture details
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(Category.Add_Subjects));
		Add.isDisplayed();

		logger.log(Status.INFO, "Subject Listing - " + Add.getText());

	}

	// Edit category
	@Test(priority = 10, groups = { "Regression", "SmokeTest" })
	public void Edit_Category() throws Exception {
		logger = extent.createTest("Edit category", "Edit category description");
		logger.log(Status.INFO, "Edit category description");
		driver.get(config.category());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(Category.CTA_Button);
		CTA.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER, Keys.ENTER)).perform();
		Thread.sleep(2000);
		driver.findElement(Category.addTitle).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		 WebElement description = driver.findElement(Category.category_Description);
		 description.clear();
		 description.sendKeys(Wrapper.AlphaNumericString(15));
		 System.out.println("description is entered");
		Thread.sleep(2000);
		driver.findElement(Category.cat_submitbutton).click();
		Thread.sleep(3000);

		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Category already exist")) {
				logger.log(Status.INFO, "Message -" + toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(Category.categorycancel).click();
				Thread.sleep(2000);
			} else if (toaster.contains("categories updated successfully")) {
				logger.log(Status.INFO, "Message -" + toaster);
				System.out.println(toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}

		}

	// Delete category clicking on cancel
	@Test(priority = 11, groups = { "Regression" })
	public void Delete_category_Cancel() throws Exception {
		logger = extent.createTest("Delete Category - No", "verify category delete and cancel ");
		logger.log(Status.INFO, "Delete category - No");
		driver.get(config.category());
		Thread.sleep(3000);
		WebElement CTA = driver.findElement(Category.CTA_Button);
		CTA.click();
		Thread.sleep(2000);
		driver.findElement(Category.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Cancel = driver.findElement(Category.Delete_cancel);
		Cancel.click();
		Thread.sleep(2000);
		System.out.println("clicked on cancel button");

	}

	// Delete category clicking on Yes
	@Test(priority = 12, groups = { "Delete" })
	public void Delete_Category_Yes() throws Exception {
		logger = extent.createTest("Delete category - Yes ", "verify category Delete Yes");
		logger.log(Status.INFO, "Delete category yes");
		driver.get(config.category());

		Thread.sleep(3000);

		WebElement CTA = driver.findElement(Category.CTA_Button);
		CTA.click();
		driver.findElement(Category.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Delete = driver.findElement(Category.Delete_Yes);
		Delete.click();

		System.out.println("clicked on Yes button");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			WebElement Add = wait.until(ExpectedConditions.visibilityOfElementLocated(ToasterObject.toaster));
			Add.isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Sorry, You cannot delete this category which is mapped to subjects")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
			} else if (toaster.contains("categories updated successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
	}
	@Test(priority = 13, groups = { "Regression" })
	public void add_new_Category_Status() throws Exception {
		logger = extent.createTest("Add Category Status Change",
				"Changing the status");
		logger.log(Status.INFO, "add new category Status");
		
		WebElement status = driver.findElement(Category.status);
		status.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN,Keys.ENTER)).perform();
		Thread.sleep(2000);
		String toaster = driver.findElement(ToasterObject.toaster).getText();
		System.out.println("Text in Toaster"+toaster);
		WebElement status1 = driver.findElement(Category.status);
		status1.click();
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.UP,Keys.ENTER)).perform();
		Thread.sleep(2000);



	}

	// add new button click method used as callback
	public void Click_Add_New_category() {
		driver.get(config.category());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));

		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(Category.addNewCategory));
		Add.click();

	}

}
