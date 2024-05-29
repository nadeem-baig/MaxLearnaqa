package testCases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.LoginPage;
import PageObjects.ToasterObject;

public class LoginTest extends BaseClass {

	@Test(priority = 0, groups = { "Regression", "SmokeTest","test" })
	public static void login_Workspace_Id() throws InterruptedException {
		logger = extent.createTest("verify valid WorkSpaceId", "Workspace Id");
		Thread.sleep(2000);
		driver.get("https://admin.staging.maxlearn.com/");
		Thread.sleep(2000);
		System.out.println("Enter the valid Workspace id");
		WebElement workspace = driver.findElement(LoginPage.Workspace);
		workspace.sendKeys(excel.getDataSheetName("Login", 15,1));
		Thread.sleep(2000);
		WebElement proceed = driver.findElement(LoginPage.Workspace_proceed);
		proceed.click();
		Thread.sleep(2000);
	}

	@Test(priority = 1, groups = { "Regression" })
	public static void login_empty() throws InterruptedException {
		logger = extent.createTest("login Empty", "verify login empty case");
		//driver.get(config.loginurl());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement uname = wait.until(ExpectedConditions.elementToBeClickable(LoginPage.username));
		System.out.println("Login empty case");
		uname.clear();
		uname.sendKeys(excel.getDataSheetName("Login", 3, 1));

		WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(LoginPage.password));
		pass.clear();
		pass.sendKeys(excel.getDataSheetName("Login", 3, 2));

		WebElement Login = wait.until(ExpectedConditions.elementToBeClickable(LoginPage.LoginButton));
		Login.click();
		Thread.sleep(2000);
		if (driver.findElements(LoginPage.EmailError).size() > 0) {
			String error = driver.findElement(LoginPage.EmailError).getText();
			logger.log(Status.INFO, "Message :" + error);
			System.out.println("Message :" + error);
			assertTrue(error.contains("Please enter Email"));
		} else {
			logger.log(Status.INFO, "Login success");
			System.out.println("login is success");
		}

	}

	@Test(priority = 2, groups = { "Regression" })

	public static void login_invalid_email() throws InterruptedException {
		logger = extent.createTest("login invalid email", "verify login invalid email case");
		//driver.get(config.loginurl());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		System.out.println("Login invalid case");
		WebElement uname = wait.until(ExpectedConditions.elementToBeClickable(LoginPage.username));
		uname.clear();
		uname.sendKeys(excel.getDataSheetName("Login", 1, 1));

		WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(LoginPage.password));
		pass.clear();
		pass.sendKeys(excel.getDataSheetName("Login", 1, 2));

		WebElement Login = wait.until(ExpectedConditions.elementToBeClickable(LoginPage.LoginButton));
		Login.click();

		Thread.sleep(5000);
		if (driver.findElements(LoginPage.EmailError).size() > 0) {
			String error = driver.findElement(LoginPage.EmailError).getText();
			logger.log(Status.INFO, "Message :" + error);
			System.out.println("Message :" + error);
			assertTrue(error.contains("Please enter Valid Email"));
		} else {
			logger.log(Status.INFO, "Login success");
			System.out.println("login is success");
		}
		Thread.sleep(1000);
	}

	@Test(priority = 3, groups = { "Regression" })

	public static void login_invalid_credentials() throws InterruptedException {
		logger = extent.createTest("login invalid credentials", "verify login invalid credentials");
		//driver.get(config.loginurl());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		System.out.println("Login invalid case");
		WebElement uname = wait.until(ExpectedConditions.elementToBeClickable(LoginPage.username));

		uname.clear();
		uname.sendKeys(excel.getDataSheetName("Login", 4, 1));

		WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(LoginPage.password));
		pass.clear();
		pass.sendKeys(excel.getDataSheetName("Login", 4, 2));


		WebElement Login = wait.until(ExpectedConditions.elementToBeClickable(LoginPage.LoginButton));
		Login.click();
		

		try {
			WebElement Toaster = wait.until(ExpectedConditions.visibilityOfElementLocated(ToasterObject.toaster));
			Toaster.isDisplayed();
			String toaster = Toaster.getText();
			
			logger.log(Status.INFO, toaster);
			System.out.println(toaster);
			//assertTrue(toaster.contains("Password / Email is wrong"));
			
		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
	}

	@Test(priority = 4, groups = { "Regression", "SmokeTest","test" })
	public static void login_valid() throws InterruptedException {
		logger = extent.createTest("Login Success", "verify login valid case");

	//	driver.get(config.loginurl());

		System.out.println("<----Login valid case---->");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement uname = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.username));
		
		uname.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		uname.sendKeys(Keys.DELETE);
		
		Thread.sleep(3000);
		uname.sendKeys(excel.getDataSheetName("Login", 2, 1));
		System.out.println(excel.getDataSheetName("Login", 2, 1));
		WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(LoginPage.password));
		//pass.click();
		pass.clear();
		Thread.sleep(3000);
		pass.sendKeys(excel.getDataSheetName("Login", 2, 2));
		System.out.println(excel.getDataSheetName("Login", 2, 2));
		WebElement Login = wait.until(ExpectedConditions.elementToBeClickable(LoginPage.LoginButton));
		Login.click();

		System.out.println("login clicked");

		try {
			WebElement Toaster = wait.until(ExpectedConditions.visibilityOfElementLocated(ToasterObject.toaster));
			Toaster.isDisplayed();
			String toaster = Toaster.getText();
			if (toaster.contains("Password / Email is wrong")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.quit();
			} else if (toaster.contains("Login successful")) {

				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
	}

}