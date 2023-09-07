package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.Assert;

public class Wrapper {

	public static WebElement element;
	public static By by, locator;
	public static WebDriverWait wait;
	// public WebDriver driver;
	public static Robot robot;
	public static WebDriver driver;

	public static void captureScreenshot(WebDriver driver, String methodName) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileHandler.copy(src, new File("./Screenshots/" + methodName + "_" + getDate() + ".png"));
			System.out.println("Screenshot captured");

		} catch (IOException e) {

			System.out.println("Unable to capture screendhots " + e.getMessage());
		}

	}

	public static String getDate() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");

		Date currentdate = new Date();

		return customFormat.format(currentdate);
	}

	public static void NestedScroll(WebDriver driver, String LocatorType, String LocatorValue) {
		locator = element_locator(LocatorType, LocatorValue);
		Actions dragger = new Actions(driver);
		element = driver.findElement(locator);
		dragger.moveToElement(element).clickAndHold().moveByOffset(0, 200).release(element).build().perform();
	}

	public static void Scrollintoview(WebDriver driver, String LocatorType, String LocatorValue)
			throws IOException, InterruptedException {
		try {
			// logger.info("Executing - Scrollintoview method");
			locator = element_locator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);

		} catch (NoSuchElementException e) {

			System.err.format("No Element Found to perform Scrollintoview \t" + e);
			// logger.warning("Unable to execute the ScrollintoView method \t" +
			// e.getMessage());
		}
	}

	public static void scrollDown(WebDriver driver) throws IOException, InterruptedException {
		try {
			// logger.info("Executing - scrolldown method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// get the height of the webpage and scroll to the end
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to perform entering the values \t" + e);
			// logger.warning("Unable to execute the scrolldown method \t" +
			// e.getMessage());

		}
	}

	public static void ScrollToTop(WebDriver driver) {
		// logger.info("Executing - scrollToTop method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.err.format("No Element Found to perform entering the values \t" + e);
			// logger.warning("Unable to execute the scrollToTop method \t" +
			// e.getMessage());
		}

		js.executeScript("window.scrollTo(0,0)");

	}

	public static By element_locator(String locatorType, String LocatorValue) {
		switch (locatorType) {
		case "id":
			by = By.id(LocatorValue);
			break;

		case "name":
			by = By.name(LocatorValue);
			break;

		case "className":
			by = By.className(LocatorValue);
			break;

		case "tagName":
			by = By.tagName(LocatorValue);
			break;

		case "xpath":
			by = By.xpath(LocatorValue);
			break;

		case "css":
			by = By.cssSelector(LocatorValue);
			break;

		case "linkText":
			by = By.linkText(LocatorValue);
			break;

		case "partialLinkText":
			by = By.partialLinkText(LocatorValue);
			break;

		default:
			by = null;
			break;
		}
		return by;
	}

	// Explicit wait

	public static void ele_Wait(String WaitType) throws Exception {
		switch (WaitType) {
		case "visibilityOf":
			ele_visibilityOf(driver);
			break;

		case "visibilityOfAllElements":
			ele_visibilityOfAllElements(driver);
			break;

		case "elementToBeClickable":
			ele_elementToBeClickable(driver);
			break;

		case "elementToBeSelected":
			ele_elementToBeSelected(driver);
			break;

		default:
			System.out.println(WaitType + " is invalid");
		}
	}

	public static void ele_visibilityOf(WebDriver driver) throws Exception {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			if (element != null) {
				element = wait.until(ExpectedConditions.visibilityOf(element));
			}
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to visibilityOf \t" + e);
			// logger.warn("Unable to execute the visibilityOf method \t" + e.getMessage());
		}
	}

	public static void ele_visibilityOfAllElements(WebDriver driver) throws Exception {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			if (element != null) {
				wait.until(ExpectedConditions.visibilityOfAllElements(element));

			}
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to visibilityOfAllElements \t" + e);
			// logger.warn("Unable to execute the visibilityOfAllElements method \t" +
			// e.getMessage());
		}
	}

	public static void ele_elementToBeClickable(WebDriver driver) throws Exception {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			if (element != null) {
				wait.until(ExpectedConditions.elementToBeClickable(element));
			}
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to elementToBeClickable \t" + e);
			// logger.warn("Unable to execute the elementtobeClickable method \t" +
			// e.getMessage());
		}
	}

	public static void ele_elementToBeSelected(WebDriver driver) throws Exception {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			if (element != null) {
				wait.until(ExpectedConditions.elementToBeSelected(element));
			}
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to elementToBeSelected \t" + e);
			// logger.warn("Unable to execute the elementToBeSelected method \t" +
			// e.getMessage());
		}
	}

	public static void Robot_uploadFile(WebDriver driver, String LocatorType, String LocatorValue, String value)
			throws Exception {
		try {
			// logger.info("Executing - Upload file method");
			locator = element_locator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			element.click();
			robot = new Robot();
			robot.setAutoDelay(500);
			StringSelection selection = new StringSelection(value);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
			robot.setAutoDelay(500);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.setAutoDelay(500);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to Robot_uploadFile \t" + e);

			// logger.warn("Unable to execute the Upload file method \t" + e.getMessage());
		}

	}

	public static void Fileupload(WebDriver driver, String LocatorType, String LocatorValue, String filepath) {
		locator = element_locator(LocatorType, LocatorValue);
		element = driver.findElement(locator);
		element.sendKeys(filepath);
	}

	public static void fileDownload(WebDriver driver, String LocatorType, String LocatorValue) throws AWTException {

		locator = element_locator(LocatorType, LocatorValue);
		element = driver.findElement(locator);
		element.click();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void AutoSuggestion_Dropdown(String LocatorType, String LocatorValue, String value, WebDriver driver)
			throws Exception {
		try {
			// logger.info("Executing - AutoSuggestion_Dropdown method");
			locator = element_locator(LocatorType, LocatorValue);
			element = driver.findElement(locator);

			element.click();
			Thread.sleep(500);
			element.sendKeys(value);
			Thread.sleep(500);
			Actions act = new Actions(driver);
			act.sendKeys(Keys.DOWN).perform();
			act.sendKeys(Keys.ENTER).build().perform();

		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to perform AutoSuggestion_Dropdown \t" + e);

			// logger.warn("Unable to execute the AutoSuggestiondropdown method \t" +
			// e.getMessage());
		}
	}

	public static void dropdown_selectByVisibleText(String LocatorType, String LocatorValue, String text)
			throws Exception {
		locator = element_locator(LocatorType, LocatorValue);

		try {

			Select se = new Select(driver.findElement(locator));
			se.selectByVisibleText(text);
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to dropdown_selectByVisibleText \t" + e);
			// logger.warn("Unable to execute the visibilityOf method \t" + e.getMessage());
		}
	}

	public static void dropdown_selectByValue(String LocatorType, String LocatorValue, String value) throws Exception {
		locator = element_locator(LocatorType, LocatorValue);

		try {

			Select se = new Select(driver.findElement(locator));
			se.selectByValue(value);
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to dropdown selectBy index \t" + e);
			// logger.warn("Unable to execute the visibilityOf method \t" + e.getMessage());
		}
	}

	public static void dropdown_selectByIndex(String LocatorType, String LocatorValue, int index, WebDriver driver)
			throws Exception {
		locator = element_locator(LocatorType, LocatorValue);

		try {
			Select se = new Select(driver.findElement(locator));
			se.selectByIndex(index);
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to dropdown selectBy index \t" + e);
			// logger.warn("Unable to execute the visibilityOf method \t" + e.getMessage());
		}
	}

	public static String randomNumber(int start, int finish) {
		Random obj = new Random();
		int num = obj.nextInt(finish + 1 - start) + start;
		String random = String.valueOf(num);
		System.out.print(random);
		return random;

	}

	public static String AlphaNumericString(int n) {
		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		// create StringBuffer size of AlphaNumericString
		StringBuilder s = new StringBuilder(n);
		int y;
		for (y = 0; y < n; y++) {
			// generating a random number
			int index = (int) (AlphaNumericString.length() * Math.random());
			// add Character one by one in end of s
			s.append(AlphaNumericString.charAt(index));
		}
		return s.toString();
	}

	public static String randomeString(int n) {
		// chose a Character random from this String
		String AlphaNumericString = "abcdefghijklmnopqrstuvxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// create StringBuffer size of AlphaNumericString
		StringBuilder s = new StringBuilder(n);
		int y;
		for (y = 0; y < n; y++) {
			// generating a random number
			int index = (int) (AlphaNumericString.length() * Math.random());
			// add Character one by one in end of s
			s.append(AlphaNumericString.charAt(index));
		}
		return s.toString();
	}

	public static String randomEmail(int n) {
		// chose a Character random from this String
		String AlphaNumericString = "abcdefghijklmnopqrstuvxyz" + "0123456789";
		// create StringBuffer size of AlphaNumericString
		StringBuilder s = new StringBuilder(n);
		int y;
		for (y = 0; y < n; y++) {
			// generating a random number
			int index = (int) (AlphaNumericString.length() * Math.random());
			// add Character one by one in end of s
			s.append(AlphaNumericString.charAt(index));
		}
		return s.toString();
	}

	public static void assert_Text(WebDriver driver, String LocatorType, String LocatorValue, String ExpectedValue) {
		locator = element_locator(LocatorType, LocatorValue);
		element = driver.findElement(locator);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String ActualValue = element.getText();
		Assert.assertEquals(ActualValue, ExpectedValue);
	}

	public static void CurrentURLassertEqual(WebDriver driver, String ExpectdURL) {
		String strUrl = driver.getCurrentUrl();
		Assert.assertEquals(ExpectdURL, strUrl);

	}

	public static void CurrentURLassertNotEqual(WebDriver driver, String ExpectdURL) {
		String strUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(ExpectdURL, strUrl);

	}
}
