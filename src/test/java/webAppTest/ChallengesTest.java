package webAppTest;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.ToasterObject;
import utility.Wrapper;
import webAppPageObjects.ChallengesObjects;

public class ChallengesTest extends BaseClassWebApp {

	@Test(priority = 0, groups = { "Regression" })
	public static void ToDo_Challenges_count() throws InterruptedException {
		logger = extent.createTest("Challenges Count in To-do", "Challenges Count in ToDo Tab");
		logger.log(Status.INFO, "Challenges count in To Do Tab");
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("Navigate to To Do Tab");
		WebElement ToDo = driver.findElement(ChallengesObjects.ToDo_Tab);
		ToDo.click();
		System.out.println("To Do Tab is clicked");
		Thread.sleep(2000);

		List<WebElement> Challenges = driver.findElements(ChallengesObjects.Challenges_count);
		int ChallengesCount = Challenges.size();
		System.out.println("Total Number of Challenges count: " + ChallengesCount);
		logger.log(Status.INFO, "Total challenges are--" + ChallengesCount);

	}

	/*
	 * @Test(priority = 1, groups = { "Regression" }) public void
	 * ToDo_Challenges_Status() throws Exception { logger =
	 * extent.createTest("Challenge Q&A flow", "Challenge flow");
	 * logger.log(Status.INFO, "Challenges QA flow "); Thread.sleep(2000);
	 * 
	 * if (driver.findElements(ChallengesObjects.Empty_challenges_header).size() >
	 * 0) { WebElement empty =
	 * driver.findElement(ChallengesObjects.Empty_challenges_header); String Message
	 * = empty.getText(); System.out.println("Empty Challenge Header--" + Message);
	 * logger.log(Status.INFO, "Empty Challenge Header--" + Message);
	 * Thread.sleep(2000);
	 * 
	 * WebElement empty_subheader =
	 * driver.findElement(ChallengesObjects.Empty_challenges_subheader); String
	 * Header = empty_subheader.getText();
	 * System.out.println("Empty Challenge Sub Header--" + Header);
	 * logger.log(Status.INFO, "Empty Challenge Sub Header--" + Header);
	 * 
	 * } else if (driver.findElements(ChallengesObjects.Challenges_count).size() >
	 * 0) { WebElement Challenge = driver.findElement(ChallengesObjects.Challenge);
	 * String Message = Challenge.getText(); System.out.println("Challenge Name--" +
	 * Message); logger.log(Status.INFO, "Challenge Name--" + Message);
	 * Thread.sleep(2000);
	 * 
	 * WebElement status = driver.findElement(ChallengesObjects.status1);
	 * status.isDisplayed(); String Message1 = status.getText();
	 * System.out.println("Status is --" + Message1); logger.log(Status.INFO,
	 * "Status of challenge --" + Message1);
	 * 
	 * String str = status.getText(); switch (str) {
	 * 
	 * // Case 1
	 * 
	 * // Method when status is Completed
	 * 
	 * case "Completed":
	 * 
	 * Challenge(); Thread.sleep(2000);
	 * driver.findElement(ToasterObject.toaster).isDisplayed(); String toaster =
	 * driver.findElement(ToasterObject.toaster).getText();
	 * assertTrue(toaster.contains("Maximum session limit reached for a day"));
	 * System.out.println("Toaster Message is---" + toaster);
	 * logger.log(Status.INFO, "Toaster Message is---" + toaster);
	 * Wrapper.ScrollToTop(driver); Thread.sleep(2000);
	 * driver.findElement(ChallengesObjects.Detail_Close).click();
	 * Thread.sleep(2000); System.out.println("Completed"); break;
	 * 
	 * // Case 2 // Method when status is In progress
	 * 
	 * case "In progress": Challenge(); Thread.sleep(2000);
	 * 
	 * WebElement Questions = driver.findElement(ChallengesObjects.Question_count);
	 * String count = Questions.getText();
	 * System.out.println("Total No of Questions are--" + count);
	 * logger.log(Status.INFO, "Total No of Questions are---" + count);
	 * Thread.sleep(2000); // login for QA flow WebElement close =
	 * driver.findElement(ChallengesObjects.close); close.click();
	 * Thread.sleep(1000); WebElement yes =
	 * driver.findElement(ChallengesObjects.yes_close); yes.click();
	 * Thread.sleep(1000); System.out.println("Q & A Form is closed");
	 * 
	 * System.out.println("In Progress"); break;
	 * 
	 * // Case 3 // Method when status is let's start
	 * 
	 * case "let's start":
	 * 
	 * Challenge(); Thread.sleep(2000);
	 * 
	 * WebElement Questions1 = driver.findElement(ChallengesObjects.Question_count);
	 * String count1 = Questions1.getText();
	 * System.out.println("Total No of Questions are--" + count1);
	 * logger.log(Status.INFO, "Total No of Questions are---" + count1);
	 * Thread.sleep(2000);
	 * 
	 * WebElement Names = driver.findElement(ChallengesObjects.Team_Names); String
	 * text = Names.getText(); System.out.println("Particpants Names" + text);
	 * logger.log(Status.INFO, "Particpant Name---" + text); Thread.sleep(2000); //
	 * login for QA flow WebElement close1 =
	 * driver.findElement(ChallengesObjects.close); close1.click();
	 * Thread.sleep(1000); WebElement yes1 =
	 * driver.findElement(ChallengesObjects.yes_close); yes1.click();
	 * Thread.sleep(1000); System.out.println("Q & A Form is closed");
	 * 
	 * System.out.println("Let's Start"); break;
	 * 
	 * // Case 4 // Default case default: case "invalid":
	 * 
	 * System.out.println("Status is not matched"); }
	 * 
	 * } Thread.sleep(2000); }
	 */
	@Test(priority = 2, groups = { "Regression" })
	public void Upcoming_Challenges() throws Exception {
		logger = extent.createTest("Upcomming Challenges", "View upcomming challenge details");
		logger.log(Status.INFO, "View upcomming challenge details");
		Thread.sleep(1000);
		To_Do_Tab();
		Thread.sleep(2000);
		if (driver.findElements(ChallengesObjects.upcomming).size() > 0) {
			WebElement Upcomming_Challenge = driver.findElement(ChallengesObjects.upcomming);

			Upcomming_Challenge.click();
			Thread.sleep(1000);
			System.out.println("Upcomming challenge button clicked");

			WebElement view = driver.findElement(ChallengesObjects.upcomming_view);
			view.isDisplayed();
			Thread.sleep(3000);
			String Message = view.getText();
			System.out.println("View Challenge--" + Message);
			logger.log(Status.INFO, "View Challenge--" + Message);
			Thread.sleep(1000);

			WebElement close = driver.findElement(ChallengesObjects.upcomming_close);
			close.click();

		} else if (driver.findElements(ChallengesObjects.Empty_challenges_header).size() > 0) {
			WebElement Empty_Challenge = driver.findElement(ChallengesObjects.Empty_challenges_header);
			String Message = Empty_Challenge.getText();
			System.out.println("Empty Challenge Header--" + Message);
			logger.log(Status.INFO, "Empty Challenge Header--" + Message);
			Thread.sleep(2000);

			WebElement empty_subheader = driver.findElement(ChallengesObjects.Empty_challenges_subheader);
			String Header = empty_subheader.getText();
			System.out.println("Empty Challenge Sub Header--" + Header);
			logger.log(Status.INFO, "Empty Challenge Sub Header--" + Header);

		}

	}

	// add new button click method used as callback
	public void To_Do_Tab() throws Exception {

		driver.get(config.TodoChallenges());
		Thread.sleep(2000);

	}

	// challenge button method used as call back
	public void Challenge() throws Exception {
		WebElement challenge = driver.findElement(ChallengesObjects.Challenge);

		challenge.click();
		Thread.sleep(2000);
		Wrapper.scrollDown(driver);
		Thread.sleep(2000);
		WebElement startchallenge = driver.findElement(ChallengesObjects.startChallenge);
		startchallenge.click();
		Thread.sleep(2000);

	}

	@Test(priority = 1, groups = {"Regression","SmokeTest" })
	public void challengeQA() throws Exception {
		logger = extent.createTest("Challenge Q&A flow", "Challenge flow");
		logger.log(Status.INFO, "Challenges QA flow ");
		Thread.sleep(2000);

		if (driver.findElements(ChallengesObjects.Empty_challenges_header).size() > 0) {
			WebElement empty = driver.findElement(ChallengesObjects.Empty_challenges_header);
			String Message = empty.getText();
			System.out.println("Empty Challenge Header--" + Message);
			logger.log(Status.INFO, "Empty Challenge Header--" + Message);
			Thread.sleep(2000);

			WebElement empty_subheader = driver.findElement(ChallengesObjects.Empty_challenges_subheader);
			String Header = empty_subheader.getText();
			System.out.println("Empty Challenge Sub Header--" + Header);
			logger.log(Status.INFO, "Empty Challenge Sub Header--" + Header);

		} else if (driver.findElements(ChallengesObjects.Challenges_count).size() > 0) {
			WebElement Challenge = driver.findElement(ChallengesObjects.Challenge);
			String Message = Challenge.getText();
			System.out.println("Challenge Name--" + Message);
			logger.log(Status.INFO, "Challenge Name--" + Message);
			Thread.sleep(2000);

			WebElement status = driver.findElement(ChallengesObjects.status1);
			status.isDisplayed();
			String Message1 = status.getText();
			System.out.println("Status is --" + Message1);
			logger.log(Status.INFO, "Status of challenge --" + Message1);

			String str = status.getText();
			switch (str) {

			// Case 1

			// Method when status is Completed

			case "Completed":

				Challenge();
				Thread.sleep(2000);
				driver.findElement(ToasterObject.toaster).isDisplayed();
				String toaster = driver.findElement(ToasterObject.toaster).getText();
				assertTrue(toaster.contains("Maximum session limit reached for a day"));
				System.out.println("Toaster Message is---" + toaster);
				logger.log(Status.INFO, "Toaster Message is---" + toaster);
				Wrapper.ScrollToTop(driver);
				Thread.sleep(2000);
				driver.findElement(ChallengesObjects.Detail_Close).click();
				Thread.sleep(2000);
				System.out.println("Completed");
				break;

			// Case 2
			// Method when status is In progress

			case "In progress":
				Challenge();
				Thread.sleep(2000);

				WebElement Questions = driver.findElement(ChallengesObjects.Question_count);
				String count = Questions.getText();
				System.out.println("Total No of Questions are--" + count);
				logger.log(Status.INFO, "Total No of Questions are---" + count);
				Thread.sleep(2000);
				// login for QA flow

				int x = Integer.parseInt(count.split(" ")[2]);
				int y = Integer.parseInt(count.split(" ")[4]);

				// login for QA flow
				for (int i = x; i <= y; i++) {
					if (driver.findElements(ChallengesObjects.single_choice).size() > 0) {
						WebElement option1 = driver.findElement(ChallengesObjects.option1);
						option1.click();
						WebElement nextbutton = driver.findElement(ChallengesObjects.submit);
						assertTrue(nextbutton.isEnabled());
						nextbutton.click();
						Thread.sleep(1000);
						WebElement continue_QA = driver.findElement(ChallengesObjects.continue_QA);
						continue_QA.click();

					} else if (driver.findElements(ChallengesObjects.multi_select).size() > 0) {
						WebElement option1 = driver.findElement(ChallengesObjects.option1);
						option1.click();
						WebElement option2 = driver.findElement(ChallengesObjects.option2);
						option2.click();
						WebElement nextbutton = driver.findElement(ChallengesObjects.submit);
						assertTrue(nextbutton.isEnabled());
						nextbutton.click();
						Thread.sleep(1000);
						WebElement continue_QA = driver.findElement(ChallengesObjects.continue_QA);
						continue_QA.click();
					} else if (driver.findElements(ChallengesObjects.put_in_order).size() > 0) {
						WebElement nextbutton = driver.findElement(ChallengesObjects.submit);
						assertTrue(nextbutton.isEnabled());
						nextbutton.click();
						Thread.sleep(1000);
						WebElement continue_QA = driver.findElement(ChallengesObjects.continue_QA);
						continue_QA.click();
					} else if (driver.findElements(ChallengesObjects.Truefalse).size() > 0) {
						WebElement option1 = driver.findElement(ChallengesObjects.option1);
						option1.click();
						WebElement nextbutton = driver.findElement(ChallengesObjects.submit);
						assertTrue(nextbutton.isEnabled());
						nextbutton.click();
						Thread.sleep(1000);
						WebElement continue_QA = driver.findElement(ChallengesObjects.continue_QA);
						continue_QA.click();

					}

				}

				WebElement close = driver.findElement(ChallengesObjects.close);
				close.click();
				Thread.sleep(1000);
				WebElement yes = driver.findElement(ChallengesObjects.yes_close);
				yes.click();
				Thread.sleep(1000);
				System.out.println("Q & A Form is closed");

				System.out.println("In Progress");
				break;

			// Case 3
			// Method when status is let's start

			case "let's start":

				Challenge();
				Thread.sleep(2000);

				WebElement Questions1 = driver.findElement(ChallengesObjects.Question_count);
				String count1 = Questions1.getText();
				System.out.println("Total No of Questions are--" + count1);
				logger.log(Status.INFO, "Total No of Questions are---" + count1);
				Thread.sleep(2000);

				WebElement Names = driver.findElement(ChallengesObjects.Team_Names);
				String text = Names.getText();
				System.out.println("Particpants Names" + text);
				logger.log(Status.INFO, "Particpant Name---" + text);
				Thread.sleep(2000);
				// login for QA flow
				Challenge();
				Thread.sleep(2000);

				int a = Integer.parseInt(count1.split(" ")[2]);
				int b = Integer.parseInt(count1.split(" ")[4]);

				// login for QA flow
				for (int i = a; i <= b; i++) {
					if (driver.findElements(ChallengesObjects.single_choice).size() > 0) {
						WebElement option1 = driver.findElement(ChallengesObjects.option1);
						option1.click();
						WebElement nextbutton = driver.findElement(ChallengesObjects.submit);
						assertTrue(nextbutton.isEnabled());
						nextbutton.click();
						Thread.sleep(1000);
						WebElement continue_QA = driver.findElement(ChallengesObjects.continue_QA);
						continue_QA.click();

					} else if (driver.findElements(ChallengesObjects.multi_select).size() > 0) {
						WebElement option1 = driver.findElement(ChallengesObjects.option1);
						option1.click();
						WebElement option2 = driver.findElement(ChallengesObjects.option2);
						option2.click();
						WebElement nextbutton = driver.findElement(ChallengesObjects.submit);
						assertTrue(nextbutton.isEnabled());
						nextbutton.click();
						Thread.sleep(1000);
						WebElement continue_QA = driver.findElement(ChallengesObjects.continue_QA);
						continue_QA.click();
					} else if (driver.findElements(ChallengesObjects.put_in_order).size() > 0) {
						WebElement nextbutton = driver.findElement(ChallengesObjects.submit);
						assertTrue(nextbutton.isEnabled());
						nextbutton.click();
						Thread.sleep(1000);
						WebElement continue_QA = driver.findElement(ChallengesObjects.continue_QA);
						continue_QA.click();
					} else if (driver.findElements(ChallengesObjects.Truefalse).size() > 0) {
						WebElement option1 = driver.findElement(ChallengesObjects.option1);
						option1.click();
						WebElement nextbutton = driver.findElement(ChallengesObjects.submit);
						assertTrue(nextbutton.isEnabled());
						nextbutton.click();
						Thread.sleep(1000);
						WebElement continue_QA = driver.findElement(ChallengesObjects.continue_QA);
						continue_QA.click();

					}
				}

				WebElement close1 = driver.findElement(ChallengesObjects.close);
				close1.click();
				Thread.sleep(1000);
				WebElement yes1 = driver.findElement(ChallengesObjects.yes_close);
				yes1.click();
				Thread.sleep(1000);
				System.out.println("Q & A Form is closed");

				System.out.println("Let's Start");
				break;

			// Case 4
			// Default case
			default:
			case "invalid":

				System.out.println("Status is not matched");
			}

		}
		Thread.sleep(2000);
	}

}
