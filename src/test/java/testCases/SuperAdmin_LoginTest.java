package testCases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.LoginPage;
import PageObjects.ToasterObject;

public class SuperAdmin_LoginTest extends BaseClass {
	@Test(priority = 0, groups = { "Regression" })
	public static void login_empty() throws InterruptedException {
		logger = extent.createTest("login Empty","verify login empty case");
		driver.get(config.SuperAdminURL());
		Thread.sleep(2000);
		System.out.println("Login empty case");
		WebElement uname = driver.findElement(LoginPage.username);
		uname.clear();
		uname.sendKeys(excel.getDataSheetName("SuperAdmin", 1, 1));
		Thread.sleep(500);
		WebElement pass = driver.findElement(LoginPage.password);
		pass.clear();
		pass.sendKeys(excel.getDataSheetName("SuperAdmin", 1, 2));
		Thread.sleep(1000);
		driver.findElement(LoginPage.LoginButton).click();
		Thread.sleep(5000);
		if (driver.findElements(LoginPage.EmailError).size() > 0) {
			String error = driver.findElement(LoginPage.EmailError).getText();
			logger.log(Status.INFO, "Message :" + error);
			System.out.println("Message :" + error);
			assertTrue(error.contains("Please enter Email"));
		} else {
			logger.log(Status.INFO, "Login success");
			System.out.println("login is success");
		}
		Thread.sleep(1000);
	}


	@Test(priority = 1, groups = { "Regression" })

	public static void login_invalid_email() throws InterruptedException {
		logger = extent.createTest("login invalid email","verify login invalid email case");
		driver.get(config.SuperAdminURL());
		Thread.sleep(2000);
		System.out.println("Login invalid case");
		WebElement uname = driver.findElement(LoginPage.username);
		uname.clear();
		Thread.sleep(500);
		uname.sendKeys(excel.getDataSheetName("SuperAdmin", 2, 1));
		Thread.sleep(500);
		WebElement pass = driver.findElement(LoginPage.password);
		pass.clear();
		Thread.sleep(500);
		pass.sendKeys(excel.getDataSheetName("SuperAdmin", 2, 2));
		Thread.sleep(1000);
		driver.findElement(LoginPage.LoginButton).click();
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


	@Test(priority = 2, groups = { "Regression" })

	public static void login_invalid_credentials() throws InterruptedException {
		logger = extent.createTest("login invliad","verify login invalid credentials");
		driver.get(config.SuperAdminURL());
		Thread.sleep(2000);
		System.out.println("Login invalid case");
		WebElement uname = driver.findElement(LoginPage.username);
		uname.clear();
		Thread.sleep(500);
		uname.sendKeys("testnn@hjhs.sd");
		Thread.sleep(500);
		WebElement pass = driver.findElement(LoginPage.password);
		pass.clear();
		Thread.sleep(500);
		pass.sendKeys("efretr");
		Thread.sleep(1000);
		driver.findElement(LoginPage.LoginButton).click();
		Thread.sleep(3000);

		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			logger.log(Status.INFO, toaster);
			assertTrue(toaster.contains("Password / Email is wrong"));

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
	}

	@Test(priority = 3, groups = { "Regression", "SmokeTest" })
	public static void login_valid() throws InterruptedException {
		logger = extent.createTest( "Login Success","verify login valid case");

		driver.get(config.SuperAdminURL());
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement uname = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.username));
		uname.click();
		uname.clear();
		uname.sendKeys(excel.getDataSheetName("SuperAdmin", 3, 1));

		WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(LoginPage.password));
		pass.click();
		pass.clear();
		pass.sendKeys(excel.getDataSheetName("SuperAdmin", 3, 2));

		
		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(LoginPage.LoginButton));
		login.click();
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
				Thread.sleep(200);
			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
	}

}