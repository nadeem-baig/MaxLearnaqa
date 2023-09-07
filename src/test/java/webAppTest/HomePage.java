package webAppTest;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import webAppPageObjects.HomePageObjects;

public class HomePage extends BaseClassWebApp {

	@Test(priority = 0, groups = { "Regression", "SmokeTest" })
	public static void Learner_Name() throws InterruptedException {
		logger = extent.createTest("Navigate to Home", "Learner Navigated to Home page");
		logger.log(Status.INFO, "Learner Navigated to Home page");
		Thread.sleep(2000);
		WebElement home_Button = driver.findElement(HomePageObjects.home_button);
		home_Button.click();
		System.out.println("Home Button clicked");
		Thread.sleep(2000);

		WebElement LearnerName = driver.findElement(HomePageObjects.Username);
		LearnerName.isDisplayed();
		String Name = LearnerName.getText();
		System.out.println("Learner Name: --" + Name);
		logger.log(Status.INFO, "Learner Name: --" + Name);

	}

	@Test(priority = 1, groups = { "Regression", "SmokeTest" })
	public static void challenges() throws InterruptedException {
		logger = extent.createTest("view challenges", "view challenges in Home Screen");
		logger.log(Status.INFO, "view challenges in Home Screen");
		Thread.sleep(2000);

		if (driver.findElements(HomePageObjects.Empty_Header).size() > 0) {
			WebElement empty = driver.findElement(HomePageObjects.Empty_Header);
			String Message = empty.getText();
			System.out.println("Empty Challenge Header--" + Message);
			logger.log(Status.INFO, "Empty Challenge Header--" + Message);
			Thread.sleep(2000);

			WebElement empty_subheader = driver.findElement(HomePageObjects.Empty_challenges_subheader);
			String Header = empty_subheader.getText();
			System.out.println("Empty Challenge Sub Header--" + Header);
			logger.log(Status.INFO, "Empty Challenge Sub Header--" + Header);

		} else if (driver.findElements(HomePageObjects.challenges).size() > 0) {

			WebElement viewall = driver.findElement(HomePageObjects.viewAll_Button);
			viewall.click();
			System.out.println("view all Button clicked");
			Thread.sleep(2000);

			WebElement view = driver.findElement(HomePageObjects.todo_view);
			view.isDisplayed();
			String text = view.getText();
			System.out.println("Text in To-Do: --" + text);
			logger.log(Status.INFO, "Text in To-Do: --" + text);

		}

	}

}
