package webAppTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import webAppPageObjects.LoginPageObjects;

public class AppLoginTest extends BaseClassWebApp {
	

	@Test(priority = 0, groups = { "Regression" ,"SmokeTest"})
	public static void login_Workspace_Id() throws InterruptedException {
		logger = extent.createTest("verify valid WorkSpaceId", "Workspace Id");
		Thread.sleep(2000);
		driver.get(config.UserWebApp());
		Thread.sleep(3000);
		System.out.println("Enter the valid Workspace id");
		WebElement workspace = driver.findElement(LoginPageObjects.Workspace);
		workspace.sendKeys(excel.getDataSheetName("Login", 15,1));
		Thread.sleep(2000);
		WebElement proceed = driver.findElement(LoginPageObjects.Workspace_proceed);
		proceed.click();
		Thread.sleep(2000);


		
	}

	@Test(priority = 1,groups = { "Regression"})
	public static void login_empty_email() throws InterruptedException {
		logger = extent.createTest("verify login empty case", "email");
		Thread.sleep(2000);
		System.out.println("Login empty email case");
		WebElement uname = driver.findElement(LoginPageObjects.email);
		uname.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		uname.sendKeys(excel.getDataSheetName("Login", 11, 1));
		Thread.sleep(1000);
		WebElement pass = driver.findElement(LoginPageObjects.password);
		pass.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		pass.sendKeys(excel.getDataSheetName("Login", 11, 2));

		Thread.sleep(1000);

		driver.findElement(LoginPageObjects.LoginButton).click();
		Thread.sleep(1000);
		if (driver.findElements(LoginPageObjects.error).size() > 0) {

			logger.log(Status.INFO, "Error :" + driver.findElement(LoginPageObjects.error).getText());
			System.out.println("Error :" + driver.findElement(LoginPageObjects.error).getText());
		} else {
			logger.log(Status.INFO, "Login success");
			System.out.println("login is success");
		}
		Thread.sleep(1000);
	}

	@Test(priority = 2,groups = { "Regression" })
	public static void login_invalid_email() throws InterruptedException {
		logger = extent.createTest("verify login invalid case", "email");

		Thread.sleep(2000);
		System.out.println("Login invalid email case");
		WebElement uname = driver.findElement(LoginPageObjects.email);
		uname.click();
		uname.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		uname.sendKeys(excel.getDataSheetName("Login", 12, 1));
		Thread.sleep(500);
		WebElement pass = driver.findElement(LoginPageObjects.password);
		pass.click();
		pass.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		Thread.sleep(500);
		pass.sendKeys(excel.getDataSheetName("Login", 12, 2));

		Thread.sleep(1000);

		driver.findElement(LoginPageObjects.LoginButton).click();
		Thread.sleep(1000);
		if (driver.findElements(LoginPageObjects.error).size() > 0) {

			logger.log(Status.INFO, "Error :" + driver.findElement(LoginPageObjects.error).getText());
			System.out.println("Error :" + driver.findElement(LoginPageObjects.error).getText());
		} else {
			logger.log(Status.INFO, "Login success");
			System.out.println("login is success");
		}
		Thread.sleep(2000);
	}

	@Test(priority = 3,groups = { "Regression" })
	public static void login_empty_password() throws InterruptedException {
		logger = extent.createTest("verify login empty case", "password");

		System.out.println("Login empty password case");
		WebElement uname = driver.findElement(LoginPageObjects.email);
		uname.click();
		uname.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		Thread.sleep(500);
		uname.sendKeys(excel.getDataSheetName("Login", 13, 1));
		Thread.sleep(500);
		WebElement pass = driver.findElement(LoginPageObjects.password);
		pass.click();
		pass.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		Thread.sleep(500);
		pass.sendKeys(excel.getDataSheetName("Login", 13, 2));

		Thread.sleep(1000);

		driver.findElement(LoginPageObjects.LoginButton).click();
		Thread.sleep(2000);
		if (driver.findElements(LoginPageObjects.error).size() > 0) {

			logger.log(Status.INFO, "Error :" + driver.findElement(LoginPageObjects.error).getText());
			System.out.println("Error :" + driver.findElement(LoginPageObjects.error).getText());
		} else {
			logger.log(Status.INFO, "Login success");
			System.out.println("login is success");
		}
		Thread.sleep(1000);
	}

	@Test(priority = 4,groups = { "Regression"})
	public static void login_invalid_email_password() throws InterruptedException {
		logger = extent.createTest("verify login invalid case", "invalid credentials");
		
		System.out.println("Login invalid credentials case");
		WebElement uname = driver.findElement(LoginPageObjects.email);
		uname.click();
		uname.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		Thread.sleep(500);
		uname.sendKeys(excel.getDataSheetName("Login", 14, 1));
		
		WebElement pass = driver.findElement(LoginPageObjects.password);
		pass.click();
		pass.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		Thread.sleep(500);
		pass.sendKeys(excel.getDataSheetName("Login", 14, 2));

		Thread.sleep(1000);

		driver.findElement(LoginPageObjects.LoginButton).click();
		Thread.sleep(2000);
		if (driver.findElements(LoginPageObjects.OK_popupclose).size() > 0) {

			logger.log(Status.INFO, "Error :" + driver.findElement(LoginPageObjects.invalid_model).getText());
			System.out.println("Error :" + driver.findElement(LoginPageObjects.invalid_model).getText());
			Thread.sleep(2000);
			driver.findElement(LoginPageObjects.OK_popupclose).click();
		} else {
			logger.log(Status.INFO, "Login success");
			System.out.println("login is success");
		}
		Thread.sleep(1000);
	}

	@Test(priority = 5,groups = { "Regression" ,"SmokeTest"})
	public static void login_valid_email_password() throws InterruptedException {
		logger = extent.createTest("verify login valid case", "login");
		
		
		System.out.println("Login valid login case");
		WebElement uname = driver.findElement(LoginPageObjects.email);
		uname.click();
		uname.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		Thread.sleep(1000);
		uname.sendKeys(excel.getDataSheetName("Login", 10, 1));
		Thread.sleep(500);
		WebElement pass = driver.findElement(LoginPageObjects.password);
		pass.click();
		pass.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		Thread.sleep(1000);
		pass.sendKeys(excel.getDataSheetName("Login", 10, 2));

	

		driver.findElement(LoginPageObjects.LoginButton).click();
		Thread.sleep(2000);
		if (driver.findElements(LoginPageObjects.OK_popupclose).size() > 0) {

			logger.log(Status.INFO, "Error :" + driver.findElement(LoginPageObjects.OK_popupclose).getText());
			System.out.println("Error :" + driver.findElement(LoginPageObjects.OK_popupclose).getText());
			// session expired
		} else {
			logger.log(Status.INFO, "Login success");
			System.out.println("login is success");
			
		}
		Thread.sleep(1000);
	}
}
