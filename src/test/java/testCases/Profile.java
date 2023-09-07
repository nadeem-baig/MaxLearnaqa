package testCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import PageObjects.Profilepage;
import PageObjects.ToasterObject;

public class Profile extends BaseClass {

	@Test(priority = 1, groups = { "smokeTest" })
	public void profile() throws InterruptedException {
		logger = extent.createTest("Profile page ", "Profile page");
		logger.log(Status.INFO, "Profile Edit");
		Thread.sleep(4000);
		// driver.findElement(Profilepage.Profiel_Nav).click();
		Thread.sleep(1000);
		// driver.findElement(Profilepage.Edit_Profilebutton).click();
		logger.info("profile page opened");
		Thread.sleep(4000);
		SoftAssert softAssert = new SoftAssert();
		String msg = driver.getCurrentUrl();
		softAssert.assertTrue(msg.contains("profile"), "assertion passed");

	}
	

	// case 2
	@Test(priority = 2, groups = { "smokeTest" })
	public void profile_Details() throws InterruptedException {
		logger = extent.createTest("Profile detail page ", "Profile details page");
		logger.log(Status.INFO, "Profile Edit");
		WebElement name = driver.findElement(Profilepage.name);
		String Message = name.getText();
		System.out.println("Text--" + Message);
		logger.log(Status.INFO, Message);
		System.out.println("Name displayed");
		Thread.sleep(1000);

		WebElement email = driver.findElement(Profilepage.email_id);
		email.isDisplayed();
		String Message1 = email.getText();
		System.out.println("Text--" + Message1);
		logger.log(Status.INFO, Message1);
		System.out.println("Email id displayed");
		Thread.sleep(1000);

		WebElement status = driver.findElement(Profilepage.Availability_status);
		status.isDisplayed();
		String Message2 = status.getText();
		System.out.println("Text--" + Message2);
		logger.log(Status.INFO, Message2);
		Thread.sleep(1000);
		System.out.println("Status displayed");
	}

	@Test(priority = 3, groups = { "smokeTest" })
	public void profile_Edit() throws InterruptedException {
		logger = extent.createTest("Profile edit page ", "Profile Edit page");
		logger.log(Status.INFO, "Profile Edit");
		driver.findElement(Profilepage.Edit_User_button).click();
		System.out.println("Edit page opened");
		Thread.sleep(1000);

		WebElement role = driver.findElement(Profilepage.Edit_role);
		role.click();
		Thread.sleep(3000);
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(1000);
		System.out.println("role dropdown is clicked");

		WebElement fullname = driver.findElement(Profilepage.Edit_name);
		fullname.click();
		fullname.clear();
		fullname.sendKeys(excel.getDataSheetName("Login", 6, 1));
		Thread.sleep(3000);
		System.out.println("Name entered");

		WebElement gender = driver.findElement(Profilepage.Edit_Gender);
		gender.click();
		Actions keyDown2 = new Actions(driver);
		keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
		gender.isDisplayed();
		Thread.sleep(1000);
		System.out.println("gender dropdown is clicked");

		WebElement bio = driver.findElement(Profilepage.Edit_Bio);
		bio.click();
		bio.clear();
		bio.sendKeys("abcdef");
		bio.isDisplayed();
		Thread.sleep(1000);
		System.out.println("Bio edited");

		System.out.println("scroll starts");
		Actions dragger = new Actions(driver);
		WebElement element = driver.findElement(ToasterObject.innerscroll);
		dragger.moveToElement(element).clickAndHold().moveByOffset(0, 150).release(element).build().perform();
		System.out.println("scroll end");

		WebElement number = driver.findElement(Profilepage.Edit_Number);
		try {

			System.out.println(number.isEnabled());
			number.click();
			number.clear();
			number.sendKeys("1234567890");
			Thread.sleep(3000);
			System.out.println("contact number edited");
		}

		catch (Exception e) {
			System.out.println(e);
		}

		WebElement email = driver.findElement(Profilepage.Edit_Email);
		try {

			System.out.println(email.isEnabled());
			email.click();
			email.sendKeys("danny@codewave.com");
			Thread.sleep(1000);
			System.out.println("email edited");
		} catch (Exception e) {
			System.out.println(e);
		} // assertion

		WebElement empid = driver.findElement(Profilepage.Edit_EmployeeId);
		empid.click();
		empid.clear();
		empid.isEnabled();
		empid.sendKeys("125465665");
		Thread.sleep(1000);
		System.out.println("employeeid edited");

		WebElement hiredate = driver.findElement(Profilepage.Edit_Hiredate);
		hiredate.click();
		hiredate.clear();
		hiredate.sendKeys("2023/01/12");
		hiredate.isDisplayed();
		Thread.sleep(1000);
		System.out.println("hire date edited");

		/*
		 * WebElement department = driver.findElement(Profilepage.Edit_Department);
		 * department.click(); Actions keyDown3 = new Actions(driver);
		 * keyDown3.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
		 * Thread.sleep(1000); System.out.println("department edited");
		 * 
		 * WebElement designation = driver.findElement(Profilepage.Edit_Designation);
		 * designation.click(); Actions keyDown4 = new Actions(driver);
		 * keyDown4.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
		 * Thread.sleep(1000); System.out.println("designation edited");
		 * 
		 * WebElement country = driver.findElement(Profilepage.Edit_country);
		 * country.click(); Actions keyDown5 = new Actions(driver);
		 * keyDown5.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
		 * country.isDisplayed(); Thread.sleep(1000);
		 * System.out.println("country edited");
		 * 
		 * 
		 * WebElement state = driver.findElement(Profilepage.Edit_state); state.click();
		 * Actions keyDown6 = new Actions(driver);
		 * keyDown6.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
		 * Thread.sleep(1000); System.out.println("State edited");
		 */

		/*
		 * WebElement submit= driver.findElement(Profilepage.Edit_submit);
		 * submit.click(); submit.isEnabled(); Thread.sleep(1000);
		 * System.out.println("Edit user submitted ");
		 */

		WebElement cancel = driver.findElement(Profilepage.Edit_cancel);
		cancel.click();
		Thread.sleep(1000);

	}

}
