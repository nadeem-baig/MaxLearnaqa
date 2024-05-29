package webAppTest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.ToasterObject;
import utility.Wrapper;
import webAppPageObjects.MyProfileObjects;

public class MyProfileTest extends BaseClassWebApp {
	@Test(priority = 0, groups = { "Regression", "SmokeTest" })
	public static void profile_Navigation() throws InterruptedException {
		logger = extent.createTest("Navigate to profilepage", "Learner Navigated to profile page");
		logger.log(Status.INFO, "Learner Navigated to profile page");
		Thread.sleep(2000);
		System.out.println("Navigate to profile page");
		WebElement profile_dropdown = driver.findElement(MyProfileObjects.profile_dropdown);
		profile_dropdown.click();
		System.out.println("profile dropdown clicked");
		Thread.sleep(2000);
		WebElement Myprofile = driver.findElement(MyProfileObjects.MyProfile);
		Myprofile.click();
		System.out.println("My profile clicked");
		Thread.sleep(2000);

		try {
			WebElement profilename = driver.findElement(MyProfileObjects.profilename);
			profilename.isDisplayed();
			String name = profilename.getText();
			logger.info("Error:" + name);
			System.out.println("profile name - " + name);

		} catch (Exception e) {
			logger.info(e);
		}

	}

	@Test(priority = 1, groups = { "Regression", "SmokeTest" })
	public static void Edit_profile_icon() throws InterruptedException {
		logger = extent.createTest("Edit profile icon", "Update profile icon in Profile");
		logger.log(Status.INFO, "Edit Profile Icon");
		System.out.println("Edit profile icon");

		WebElement profile_edit = driver.findElement(MyProfileObjects.Edit_profile_iocn);
		profile_edit.click();
		System.out.println("click on edit profile");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement avatar = wait.until(ExpectedConditions.elementToBeClickable(MyProfileObjects.avatar_img));
		avatar.click();
		System.out.println("avatar selected");
		WebElement submit_avatar = driver.findElement(MyProfileObjects.submit_avatar);
		submit_avatar.click();
		System.out.println("update avatar");

		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();

			if (toaster.contains("profile image updated successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println("Toaster is---" + toaster);

			} else if (toaster.contains("error")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}

	}

	@Test(priority = 2, groups = { "Regression" })
	public static void Edit_User_BioRequired() throws InterruptedException {
		logger = extent.createTest("Edit User Bio", "Edit User My Bio required");
		logger.log(Status.INFO, "In Edit User My Bio required");
		Thread.sleep(3000);
		Wrapper.ScrollToTop(driver);
		Thread.sleep(2000);
		WebElement basic_info = driver.findElement(MyProfileObjects.Basic_info_tab);
		basic_info.click();
		Thread.sleep(2000);
		System.out.println("Basic info tab clicked");
		WebElement basic_editicon = driver.findElement(MyProfileObjects.Basic_info_edit);
		basic_editicon.click();
		Thread.sleep(2000);
		System.out.println("Basic info Edit Icon clicked");
		WebElement my_bio = driver.findElement(MyProfileObjects.Bio);
		my_bio.click();
		my_bio.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

		WebElement mobileNumber = driver.findElement(MyProfileObjects.mobileNo);
		mobileNumber.click();

		try {
			WebElement bio = driver.findElement(MyProfileObjects.Required_Error);
			bio.isDisplayed();
			logger.info("Error:" + bio.getText());
			String alert = bio.getText();
			System.out.println(alert);
			Assert.assertEquals(alert, "Bio Is Required");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	@Test(priority = 3, groups = { "Regression" })
	public static void Edit_User_vaildNumber() throws InterruptedException {
		logger = extent.createTest("Edit User Mobile number", "Edit User valid phone number");
		logger.log(Status.INFO, "In Edit User page validations");
		Thread.sleep(1000);
		WebElement my_bio = driver.findElement(MyProfileObjects.Bio);
		my_bio.click();
		my_bio.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		my_bio.sendKeys(Wrapper.AlphaNumericString(20));
		System.out.println("Bio Entered");
		Thread.sleep(2000);

		WebElement mobileNumber = driver.findElement(MyProfileObjects.mobileNo);
		mobileNumber.click();
		mobileNumber.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

		mobileNumber.sendKeys("91909090898999");
		System.out.println("mobile number Entered");
		Thread.sleep(2000);

		try {
			WebElement MobileNo = driver.findElement(MyProfileObjects.Required_Error);
			MobileNo.isDisplayed();
			logger.info("Error Message:" + MobileNo.getText());
			String alert = MobileNo.getText();
			System.out.println(alert);
			Assert.assertEquals(alert, "Please Enter a valid Phone Number");
		} catch (Exception e) {
			logger.info(e);
		}
	}

	@Test(priority = 4, groups = { "Regression" })
	public void cancel() throws InterruptedException, IOException {
		logger = extent.createTest("Edit User cancel  ", "cancel");
		logger.log(Status.INFO, "Edit User click cancel");
		System.out.println("Click on cancel button");
		WebElement cancel = driver.findElement(MyProfileObjects.close);
		cancel.click();
		Thread.sleep(3000);
		logger.log(Status.INFO, "edit User form cancelled");
	}

	@Test(priority = 5, groups = { "Regression", "SmokeTest" })
	public static void Edit_User_Details() throws InterruptedException {
		logger = extent.createTest("Edit User Details", "Edit user with mandatory fields");
		logger.log(Status.INFO, "In Edit User enter Required Fields");

		Thread.sleep(1000);
		System.out.println("Edit User Details");
		 WebElement basic_info = driver.findElement(MyProfileObjects.Basic_info_tab);
		 basic_info.click();

		WebElement basic_editicon = driver.findElement(MyProfileObjects.Basic_info_edit);
		basic_editicon.click();
		Thread.sleep(2000);
		System.out.println("Basic info Edit Icon clicked");
		WebElement my_bio = driver.findElement(MyProfileObjects.Bio);
		my_bio.click();
		my_bio.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		my_bio.sendKeys("Bio - " + Wrapper.AlphaNumericString(20));
		System.out.println("Bio Entered");
		Thread.sleep(2000);
		WebElement mobileNumber = driver.findElement(MyProfileObjects.mobileNo);
		mobileNumber.click();
		mobileNumber.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

		mobileNumber.sendKeys("+919090908989");
		System.out.println("mobile number Entered");
		Thread.sleep(2000);
		WebElement submit = driver.findElement(MyProfileObjects.profile_submit);
		submit.click();

		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();

			if (toaster.contains("profile Data updated successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println("Toast Mesage is--" + toaster);
				Thread.sleep(2000);

			} else if (toaster.contains("error")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
	}

	@Test(priority = 7, groups = { "Regression", "SmokeTest" })
	public static void Squad_Details() throws Exception {
		logger = extent.createTest("Squad detail page", "Squad details of learner");
		logger.log(Status.INFO, "Squad Details in Your Squad Tab");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		//WebElement squad =driver.findElement(MyProfileObjects.your_Squad_tab);

		//WebElement squad = wait.until(ExpectedConditions.elementToBeClickable(MyProfileObjects.your_Squad_tab));

		//squad.click();
		driver.get(config.Squadpage());
		System.out.println("Total no.of squads are displayed");
		Thread.sleep(5000);

		if (driver.findElements(MyProfileObjects.Empty_Header).size() > 0) {
			Wrapper.scrollDown(driver);

			WebElement empty = wait
					.until(ExpectedConditions.visibilityOfElementLocated(MyProfileObjects.Empty_challenges_header));
			String header = empty.getText();
			System.out.println("Empty Header text--" + header);
			logger.log(Status.INFO, "Empty Header text is --" + header);
			Thread.sleep(2000);

		} else if (driver.findElements(MyProfileObjects.Squad_Number_row).size() > 0) {
			WebElement squad_header = driver.findElement(MyProfileObjects.your_Squad_header);
			squad_header.isDisplayed();
			String Message = squad_header.getText();
			System.out.println("Squad Count --" + Message);
			logger.log(Status.INFO, "Squad Count --" + Message);

			// clicking on squad

			WebElement squad_list = driver.findElement(MyProfileObjects.Squad_Number_row);
			squad_list.click();
			System.out.println("Members in squad are displayed");
			Thread.sleep(2000);

			// After navigating to squad details page capturing score of learner

			WebElement score = driver.findElement(MyProfileObjects.score);
			score.isDisplayed();
			String yourScore = score.getText();
			System.out.println("yourScore --" + yourScore);
			logger.log(Status.INFO, "yourScore in Squad Details --" + yourScore);

			// Capturing total members in squad

			List<WebElement> Members = driver.findElements(MyProfileObjects.TotalMembers);
			int MembersCount = Members.size();
			System.out.println(" Members in squad are: " + MembersCount + " Members");
			logger.log(Status.INFO, "Members in squad are:--" + MembersCount + " Members");
			Thread.sleep(2000);

			WebElement squad_challenges = driver.findElement(MyProfileObjects.Squad_Challenges_tab);
			squad_challenges.click();
			System.out.println("Navigated to challenges tab");
			Thread.sleep(3000);

			if (driver.findElements(MyProfileObjects.Empty_challenges_header).size() > 0) {
				WebElement empty = driver.findElement(MyProfileObjects.Empty_challenges_header);
				String Message1 = empty.getText();
				System.out.println("Empty Challenge Header--" + Message1);
				logger.log(Status.INFO, "Empty Challenge Header--" + Message1);
				Thread.sleep(2000);

				WebElement empty_subheader = driver.findElement(MyProfileObjects.Empty_challenges_subheader);
				String Header = empty_subheader.getText();
				System.out.println("Empty Challenge Sub Header--" + Header);
				logger.log(Status.INFO, "Empty Challenge Sub Header--" + Header);

			} else if (driver.findElements(MyProfileObjects.Challenges_count).size() > 0) {

				// capturing number of challenges

				WebElement squad_challenges_detail = driver.findElement(MyProfileObjects.Squad_Challenge_header);
				squad_challenges_detail.isDisplayed();
				String Challenge_count = squad_challenges_detail.getText();
				System.out.println("Total Challenges for learner is--" + Challenge_count);
				logger.log(Status.INFO, "Total Challenges for learner is--" + Challenge_count);

			}
		}
	}
	@Test(priority = 6, groups = { "Regression" })
	public void Analytics_Tab() throws InterruptedException, IOException {
		logger = extent.createTest("Analytics Tab  ", "Analytics");
		logger.log(Status.INFO, "Click on Analytics Tab");
		System.out.println("Click on Analytics button");
		Thread.sleep(5000);
		WebElement Analytics = driver.findElement(MyProfileObjects.Analytics);
		Analytics.click();
		Thread.sleep(3000);
		
		WebElement Topics_subheader = driver.findElement(MyProfileObjects.text1);
		String Header = Topics_subheader.getText();
		System.out.println("Analytic Sub Header--" + Header);
		logger.log(Status.INFO, "Analytic Sub Header--" + Header);
		
		WebElement Challenges_subheader = driver.findElement(MyProfileObjects.text2);
		String Header1 = Challenges_subheader.getText();
		System.out.println("Analytic Sub Header--" + Header1);
		logger.log(Status.INFO, "Analytic Sub Header--" + Header1);
		
	}
	
	
	@Test(priority = 8, groups = { "Regression", "SmokeTest" })
	public static void Transcripts() throws InterruptedException, Exception {
		logger = extent.createTest("Navigate to Transicipts page", "Learner Navigated to Transicipts page");
		logger.log(Status.INFO, "Learner Navigated to Transicipts page");
		Thread.sleep(2000);
		WebElement profile_dropdown = driver.findElement(MyProfileObjects.profile_dropdown);
		profile_dropdown.click();
		System.out.println("profile dropdown clicked");
		Thread.sleep(2000);
		
		WebElement Transcripts = driver.findElement(MyProfileObjects.Transcripts);
		Transcripts.click();
		System.out.println("My Transcripts clicked");
		Thread.sleep(2000);
		
		WebElement Search = driver.findElement(MyProfileObjects.Transcripts_search);
		Search.click();
		Search.sendKeys("Challenge");
		Thread.sleep(2000);
		Wrapper.scrollDown(driver);
		System.out.println("Searching Transcripts");


	}


}
