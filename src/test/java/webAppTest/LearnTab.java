package webAppTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import utility.Wrapper;
import webAppPageObjects.LearnTab_Pages;

public class LearnTab extends BaseClassWebApp {

	@Test(priority = 1, groups = { "Regression" })
	public static void Hot_Topics() throws InterruptedException {
		logger = extent.createTest("Hot Topics Corsole", "Hot Topics Corsole in Learn Tab");
		logger.log(Status.INFO, "Hot Topics Corsole in Learn Tab");
		Thread.sleep(3000);
		System.out.println("Navigate to Learn Tab");
		driver.get(config.Learntab());
		Thread.sleep(2000);

		WebElement Heading = driver.findElement(LearnTab_Pages.Hot_Topics_title);
		Heading.isDisplayed();
		logger.info("Heading:" + Heading.getText());
		String Title = Heading.getText();
		System.out.println("Heading - " + Title);

		List<WebElement> Corsole = driver.findElements(LearnTab_Pages.count_topics);
		int HotTopicscount = Corsole.size();
		System.out.println("Total Number of HotTopics count: " + HotTopicscount);
		logger.log(Status.INFO, "Total HotTopics are--" + HotTopicscount);

	}

	@Test(priority = 2, groups = { "Regression" })
	public static void Hot_Topics_viewall() throws InterruptedException {
		logger = extent.createTest("Hot Topics Corsole view all", " Verify Hot Topics Corsole view all in Learn Tab");
		logger.log(Status.INFO, "Hot Topics Corsole view all in Learn Tab");
		Thread.sleep(3000);
		WebElement View = driver.findElement(LearnTab_Pages.View_all);
		View.click();
		Thread.sleep(2000);
		WebElement Heading = driver.findElement(LearnTab_Pages.View_detail);
		Heading.isDisplayed();
		logger.info("Heading:" + Heading.getText());
		String Title = Heading.getText();
		System.out.println("Message - " + Title);
		WebElement close = driver.findElement(LearnTab_Pages.details_close);
		close.click();

	}

	@Test(priority = 3, groups = { "Regression" })
	public static void Continue_learning() throws InterruptedException {
		logger = extent.createTest("Continue Learning Corsole", "Continue Learning  Corsole in Learn Tab");
		logger.log(Status.INFO, "Continue Learning  Corsole in Learn Tab");
		Thread.sleep(3000);

		if (driver.findElements(LearnTab_Pages.continue_learning_count).size() > 0) {

			WebElement Heading = driver.findElement(LearnTab_Pages.continue_learning_heading);
			Heading.isDisplayed();
			logger.info("Heading:" + Heading.getText());
			String Title = Heading.getText();
			System.out.println("Heading - " + Title);

			List<WebElement> Corsole = driver.findElements(LearnTab_Pages.continue_learning_count);
			int Continuelearning_count = Corsole.size();
			System.out.println("Total Number of Learnings count: " + Continuelearning_count);
			logger.log(Status.INFO, "Total Learnings are--" + Continuelearning_count);

			WebElement View = driver.findElement(LearnTab_Pages.continue_learning_viewall);
			View.click();
			Thread.sleep(2000);
			WebElement Heading1 = driver.findElement(LearnTab_Pages.continue_learning_detail);
			Heading1.isDisplayed();
			logger.info("Heading:" + Heading1.getText());
			String Title1 = Heading1.getText();
			System.out.println("Message - " + Title1);
			WebElement close = driver.findElement(LearnTab_Pages.details_close);
			close.click();

		} else if (driver.findElements(LearnTab_Pages.Empty_learning_header).size() > 0) {
			WebElement Empty_Learnings = driver.findElement(LearnTab_Pages.Empty_learning_header);
			String Message = Empty_Learnings.getText();
			System.out.println("Empty Challenge Header--" + Message);
			logger.log(Status.INFO, "Empty Challenge Header--" + Message);
			Thread.sleep(2000);

			WebElement empty_subheader = driver.findElement(LearnTab_Pages.Empty_learning_subheader);
			String Header = empty_subheader.getText();
			System.out.println("Empty Challenge Sub Header--" + Header);
			logger.log(Status.INFO, "Empty Challenge Sub Header--" + Header);

		}
	}

	@Test(priority = 4, groups = { "Regression" })
	public static void Categories_listing() throws InterruptedException, Exception {
		logger = extent.createTest("Learn by category Corsole", "Learn by category Corsole in Learn Tab");
		logger.log(Status.INFO, "Learn by category Corsole in Learn Tab");
		Thread.sleep(3000);

		WebElement l = driver.findElement(LearnTab_Pages.Learn_Title);
		// Actions class with moveToElement()
		Actions a = new Actions(driver);
		a.moveToElement(l);
		a.perform();
		Thread.sleep(3000);

		WebElement Heading = driver.findElement(LearnTab_Pages.Learn_Title);
		Heading.isDisplayed();
		logger.info("Heading:" + Heading.getText());
		String Title = Heading.getText();
		System.out.println("Heading - " + Title);

		List<WebElement> Corsole = driver.findElements(LearnTab_Pages.Learn_category_count);
		int Categories_count = Corsole.size();
		System.out.println("Total Number of Categories count: " + Categories_count);
		logger.log(Status.INFO, "Total Categories are--" + Categories_count);

	}

	@Test(priority = 5, groups = { "Regression" })
	public static void Categories_viewall() throws InterruptedException {
		logger = extent.createTest("category Corsole view all", " Verify category Corsole view all in Learn Tab");
		logger.log(Status.INFO, "category Corsole view all in Learn Tab");
		Thread.sleep(3000);
		WebElement View = driver.findElement(LearnTab_Pages.Learn_viewall);
		View.click();
		Thread.sleep(2000);

		WebElement Heading = driver.findElement(LearnTab_Pages.Learn_detail);
		Heading.isDisplayed();
		logger.info("Heading:" + Heading.getText());
		String Title = Heading.getText();
		System.out.println("Message - " + Title);

	}

	@Test(priority = 6, groups = { "Regression" })
	public static void Goals_listing() throws InterruptedException, Exception {
		logger = extent.createTest("Goals Corsole", "Goals Corsole in Learn Tab");
		logger.log(Status.INFO, "Goals Corsole in Learn Tab");
		Thread.sleep(3000);
		WebElement learn = driver.findElement(LearnTab_Pages.LearnTab_Button);
		learn.click();
		Thread.sleep(3000);
		Wrapper.scrollDown(driver);
		Thread.sleep(3000);
		
		try {
			WebElement Heading = driver.findElement(LearnTab_Pages.Goals);
			Heading.isDisplayed();
			logger.info("Heading:" + Heading.getText());
			String Title = Heading.getText();
			System.out.println("Heading - " + Title);

			List<WebElement> Corsole = driver.findElements(LearnTab_Pages.Goals_count);
			int Goals_count = Corsole.size();
			System.out.println("Total Number of Goals count: " + Goals_count);
			logger.log(Status.INFO, "Total Goals are--" + Goals_count);
		} catch (Exception e) {
			logger.info(e);
			driver.navigate().refresh();
			Thread.sleep(2000);

		}	
		
	

}

	@Test(priority = 7, groups = { "Regression","SmokeTest" })
	public static void Learn_Category_valid_category() throws InterruptedException, Exception {
	logger = extent.createTest("Learn Category", "Learn Category in Learn Tab");
	logger.log(Status.INFO, "Learn Category Flow in Learn Tab");
	Thread.sleep(3000);
	driver.get(config.Learntab());
	Thread.sleep(2000);

	WebElement learn = driver.findElement(LearnTab_Pages.LearnTab_Button);
	learn.click();
	Thread.sleep(3000);
	
	WebElement l = driver.findElement(LearnTab_Pages.Learn_Title);
	// Actions class with moveToElement()
	Actions a = new Actions(driver);
	a.moveToElement(l);
	a.perform();
	Thread.sleep(3000);
	
	WebElement View = driver.findElement(LearnTab_Pages.Learn_viewall);
	View.click();
	Thread.sleep(2000);
	//clicking on category
	WebElement category = driver.findElement(LearnTab_Pages.Category);
	category.click();
	Thread.sleep(2000);
	

	//capturing subject details 
	WebElement Text = driver.findElement(LearnTab_Pages.Category_view);
	Text.isDisplayed();
	logger.info("Subject details:" + Text.getText());
	String Title = Text.getText();
	System.out.println("Subject details - " + Title);
	
	//capturing topic details
	WebElement Subject = driver.findElement(LearnTab_Pages.Subject);
	Subject.click();
	Thread.sleep(2000);
	List<WebElement> Subjects = driver.findElements(LearnTab_Pages.Topics_count);
	int Subjects_count = Subjects.size();
	System.out.println("Total Number of Topics count: " + Subjects_count);
	logger.log(Status.INFO, "Total Topics are--" + Subjects_count);
	
	WebElement Text1 = driver.findElement(LearnTab_Pages.Subject_view);
	Text1.isDisplayed();
	logger.info("Topics details:" + Text1.getText());
	String Title1 = Text1.getText();
	System.out.println("Topics details - " + Title1);
	
	//capturing deck details
	WebElement Topics = driver.findElement(LearnTab_Pages.Subject_view);
	Topics.click();
	Thread.sleep(2000);

	List<WebElement> Topics_list = driver.findElements(LearnTab_Pages.Topic);
	int Topics_count = Topics_list.size();
	System.out.println("Total Number of Decks count: " + Topics_count);
	logger.log(Status.INFO, "Total Decks are--" + Topics_count);
	WebElement Text11 = driver.findElement(LearnTab_Pages.Topic);
	Text11.isDisplayed();
	
	logger.info("Decks details:" + Text11.getText());
	String Title11 = Text11.getText();
	System.out.println("Decks details - " + Title11);
	
	//capturing flashcard details
	
	WebElement decks = driver.findElement(LearnTab_Pages.deck);
	decks.click();
	Thread.sleep(4000);

	WebElement flashcard_close = driver.findElement(LearnTab_Pages.flash_close);
	flashcard_close.click();
	Thread.sleep(3000);
	
	if(driver.findElement(LearnTab_Pages.Quizme).isDisplayed()) {
		
	WebElement quizme = driver.findElement(LearnTab_Pages.Quizme);
	quizme.isDisplayed();
	quizme.click();
	Thread.sleep(3000);
	
	
	}else{
		WebElement learn1 = driver.findElement(LearnTab_Pages.LearnTab_Button);
		learn1.click();
		Thread.sleep(3000);
	}
	
}
}
