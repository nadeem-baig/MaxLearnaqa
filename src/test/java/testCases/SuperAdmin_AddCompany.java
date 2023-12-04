
package testCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.CompanyPages;
import PageObjects.ToasterObject;
import utility.Wrapper;

public class SuperAdmin_AddCompany extends BaseClass {
	// navigate to add company page  and click on Add Company button  without Image
	@Test(priority = 1, groups = { "Regression" })
	public void Add_Comapny_Image_required() throws Exception {
		logger = extent.createTest("add company image*", "add new company image required");
		logger.log(Status.INFO, "add new company");

		Add_Company_button_click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement save = wait.until(ExpectedConditions.elementToBeClickable(CompanyPages.Add_Company_Save));
		save.click();

		try {
			WebElement imageerror = wait.until(ExpectedConditions.visibilityOfElementLocated(CompanyPages.error1));

			imageerror.isDisplayed();
			logger.info("Message:" + imageerror.getText());
			String alert = imageerror.getText();
			System.out.println(alert);
			Assert.assertEquals(alert, "Required");
		} catch (Exception e) {
			logger.info(e);
		}
	}
	// navigate to add company page  and click on Add Company button  without
	// Company Name

	@Test(priority = 2, groups = { "Regression" })
	public void Company_Name_Required() throws InterruptedException, Exception {
		logger = extent.createTest("add company name*", "add new comapany name  required");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement upload = wait.until(ExpectedConditions.elementToBeClickable(CompanyPages.UploadImage));

		upload.click();
		Thread.sleep(2000);
		driver.findElement(By.id("uploadImg")).sendKeys(System.getProperty("user.dir") + "/TestData/profile icon.png");
		Thread.sleep(1000);
		System.out.println("Icon is uploaded");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(1000);
		// driver.findElement(addcompanypage.addcompanybutton).click();
		// Thread.sleep(1000);            
		try {
			WebElement nameerror = wait.until(ExpectedConditions.visibilityOfElementLocated(CompanyPages.error1));

			nameerror.isDisplayed();
			String alert = nameerror.getText();
			logger.info("Message: " + alert);

			System.out.println(alert);
			Assert.assertEquals(alert, "Required");
		} catch (

		Exception e) {
			logger.info(e);
		}
		Thread.sleep(1000);
	}

	// navigate to add company page with invalid company name
	@Test(priority = 3, groups = { "Regression" })
	public void Add_company_inValid_name() throws Exception {
		logger = extent.createTest("add invalid company name* ", "add new company invalid company name ");
		logger.log(Status.INFO, "add new company created");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		Wrapper.ScrollToTop(driver);
		WebElement name = wait.until(ExpectedConditions.elementToBeClickable(CompanyPages.companyname));

		name.click();
		name.clear();
		name.sendKeys("abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij");

		try {
			WebElement titleerror = wait.until(ExpectedConditions.visibilityOfElementLocated(CompanyPages.error1));

			titleerror.isDisplayed();
			logger.info("Message: " + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println(alert);
			Assert.assertEquals(alert, "Too Long!");
		} catch (Exception e) {
			logger.info(e);
		}
		name.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}

	// navigate to add company page  and click on Add Company button  without
	// Website Link
	@Test(priority = 4, groups = { "Regression" })

	public void Company_Websitelink_required() throws InterruptedException {
		logger = extent.createTest("add company website*", "add new comapany website Link required");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement companyname = wait.until(ExpectedConditions.elementToBeClickable(CompanyPages.companyname));

		companyname.click();
		companyname.sendKeys(Wrapper.randomeString(6));

		// driver.findElement(CompanyPages.addcompanybutton).click();
		// Thread.sleep(1000);            
		try {
			WebElement linkeerror = wait.until(ExpectedConditions.visibilityOfElementLocated(CompanyPages.error1));

			linkeerror.isDisplayed();
			String alert = linkeerror.getText();
			logger.info("Message: " + alert);

			System.out.println(alert);
			Assert.assertEquals(alert, "Required");
		} catch (

		Exception e) {
			logger.info(e);
		}
		Thread.sleep(1000);
	}
	// navigate to add company page with invalid company website link

	@Test(priority = 5, groups = { "Regression" })
	public void Add_company_inValid_website() throws Exception {
		logger = extent.createTest("add invalid website* ", "add new company invalid company website link");
		logger.log(Status.INFO, "entered invalid website");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement url = wait.until(ExpectedConditions.elementToBeClickable(CompanyPages.CompanyWebsitelink));
		url.click();
		url.sendKeys(Wrapper.randomeString(6));

		try {
			WebElement titleerror = wait.until(ExpectedConditions.visibilityOfElementLocated(CompanyPages.error1));

			titleerror.isDisplayed();
			logger.info("Message: " + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println(alert);
			Assert.assertEquals(alert, "URL is not valid");
		} catch (Exception e) {
			logger.info(e);
		}
		url.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}

//navigate to add company page  and click on Add Company button  without Working days
	@Test(priority = 6, groups = { "Regression" })

	public void Working_days_required() throws InterruptedException {
		logger = extent.createTest("add company working days*", "add new comapany working days required ");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement link = wait.until(ExpectedConditions.elementToBeClickable(CompanyPages.CompanyWebsitelink));

		link.click();

		link.sendKeys("www.test.com");

		// driver.findElement(addcompanypage.addcompanybutton).click();
		// Thread.sleep(1000);            
		try {
			WebElement dayseerror = wait.until(ExpectedConditions.visibilityOfElementLocated(CompanyPages.error1));

			dayseerror.isDisplayed();

			String alert = dayseerror.getText();
			System.out.println(alert);
			logger.info("Message: " + alert);
			Assert.assertEquals(alert, "Required");
		} catch (

		Exception e) {
			logger.info(e);
		}
		Thread.sleep(1000);
	}

	// navigate to add company page  and click on Add Company button  without
	// AddressLine1
	@Test(priority = 7, groups = { "Regression" })
	public void Company_Address_required() throws InterruptedException {
		logger = extent.createTest("add Address Line1*", "add new comapany Address Line1 required");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement workingdays = wait.until(ExpectedConditions.elementToBeClickable(CompanyPages.WorkingDays_Monday));

		workingdays.click();

		// driver.findElement(addcompanypage.addcompanybutton).click();
		// Thread.sleep(1000);            
		try {
			WebElement titleerror = wait.until(ExpectedConditions.visibilityOfElementLocated(CompanyPages.error1));
			titleerror.isDisplayed();

			String alert = titleerror.getText();
			logger.info("Message: " + alert);
			System.out.println(alert);
			Assert.assertEquals(alert, "Required");
		} catch (

		Exception e) {
			logger.info(e);
		}
		Thread.sleep(1000);
	}

// navigate to add company page  and click on Add Company button  without country
	@Test(priority = 8, groups = { "Regression" })
	public void Comapny_Country_required() throws InterruptedException {
		logger = extent.createTest("add company country*", "add new comapany Address Country required");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement address = wait.until(ExpectedConditions.elementToBeClickable(CompanyPages.AddressLine1));

		address.click();
		address.clear();

		address.sendKeys("Hyderabad");
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.TAB, Keys.TAB)).perform();

// driver.findElement(addcompanypage.addcompanybutton).click();
// Thread.sleep(1000);             
		try {
			WebElement countryerror = wait
					.until(ExpectedConditions.visibilityOfElementLocated(CompanyPages.countryerror));

			countryerror.isDisplayed();
			logger.info("Message: " + countryerror.getText());
			String alert = countryerror.getText();
			System.out.println(alert);
			Assert.assertEquals(alert, "Country is Required");

		} catch (

		Exception e) {
			logger.info(e);
		}
		Thread.sleep(1000);
	}
//navigate to add company page  and click on Add Company button  without state

	@Test(priority = 9, groups = { "Regression" })
	public void Company_State_required() throws InterruptedException {
		logger = extent.createTest("add company state*", "add new comapany Address State required");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement selectcountry = wait.until(ExpectedConditions.elementToBeClickable(CompanyPages.Country));

		selectcountry.click();
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER, Keys.TAB)).perform();
		Thread.sleep(2000);
		System.out.println("Country dropdown is clicked");

		// driver.findElement(addcompanypage.addcompanybutton).click();
		// Thread.sleep(1000);            
		try {

			WebElement stateerror = wait.until(ExpectedConditions.visibilityOfElementLocated(CompanyPages.error1));
			stateerror.isDisplayed();
			logger.info("Message: " + stateerror.getText());
			String alert = stateerror.getText();
			System.out.println(alert);
			Assert.assertEquals(alert, "State is Required");
		} catch (

		Exception e) {
			logger.info(e);
		}
		Thread.sleep(1000);
	}

	// navigate to add company page  and click on Add Company button  without zip
	@Test(priority = 10, groups = { "Regression" })

	public void Company_Zipcode_required() throws InterruptedException {
		logger = extent.createTest("add comapany Zipcode*", "add new comapany Zipcode required ");
		Thread.sleep(2000);
		WebElement selectstate = driver.findElement(CompanyPages.State);
		selectstate.click();
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER, Keys.TAB)).perform();
		Thread.sleep(1000);
		// driver.findElement(addcompanypage.addcompanybutton).click();
		// Thread.sleep(1000);            
		try {
			WebElement stateerror = driver.findElement(CompanyPages.error1);
			stateerror.isDisplayed();
			logger.info("Message: " + stateerror.getText());
			String alert = stateerror.getText();
			System.out.println(alert);
			Assert.assertEquals(alert, "Required");
		} catch (

		Exception e) {
			logger.info(e);
		}
		Thread.sleep(1000);
	}

	// navigate to add company page with invalid Zipcode    

	@Test(priority = 11, groups = { "Regression" })
	public void Add_company_inValid_Zipcode() throws Exception {
		logger = extent.createTest("add invalid  Zipcode*", " add new company invalid  Zipcode");
		logger.log(Status.INFO, "entered invalid zipcode");
		Thread.sleep(2000);
		WebElement code = driver.findElement(CompanyPages.Zipcode);
		code.click();
		code.sendKeys("12345678765432345677654", Keys.TAB);
		Thread.sleep(2000);
		try {
			WebElement titleerror = driver.findElement(CompanyPages.error1);
			titleerror.isDisplayed();
			logger.info("Message: " + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println(alert);
			Assert.assertEquals(alert, "Too Long!");
		} catch (Exception e) {
			logger.info(e);
		}
		code.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}

	// navigate to add company page  and click on Add Company button  without
	// POCName
	@Test(priority = 12, groups = { "Regression" })

	public void POC_Name_required() throws InterruptedException {
		logger = extent.createTest("add comapany POC name*", "add new comapany POC full name required");
		Thread.sleep(2000);
		WebElement code = driver.findElement(CompanyPages.Zipcode);
		code.click();
		code.clear();

		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys("500080", Keys.TAB).perform();

		Thread.sleep(1000);
// driver.findElement(addcompanypage.addcompanybutton).click();
// Thread.sleep(1000);
		try {
			WebElement titleerror = driver.findElement(CompanyPages.error1);
			titleerror.isDisplayed();
			logger.info("Error: " + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println(alert);
			Assert.assertEquals(alert, "Required");

		} catch (

		Exception e) {
			logger.info(e);
		}
		Thread.sleep(1000);
	}
	// navigate to add company page with invalid POCfullName

	@Test(priority = 13, groups = { "Regression" })
	public void Add_company_inValid_POC_Name() throws Exception {
		logger = extent.createTest("add invalid POCName", "add company invalid POCName");
		logger.log(Status.INFO, "entered invalid POCName");
		Thread.sleep(2000);
		WebElement Pocname = driver.findElement(CompanyPages.POCFullName);
		Pocname.click();
		Pocname.sendKeys("12456765432", Keys.TAB);
		Thread.sleep(2000);
		try {
			WebElement titleerror = driver.findElement(CompanyPages.error1);
			titleerror.isDisplayed();
			logger.info("Message: " + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println(alert);
			Assert.assertEquals(alert, "Name must characters");
		} catch (Exception e) {
			logger.info(e);
		}
		Pocname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}

//navigate to add company page  and click on Add Company button  without POCEmailId
	@Test(priority = 14, groups = { "Regression" })
	public void POC_emailid_required() throws InterruptedException {
		logger = extent.createTest("add POC Email*", "add new comapany POC Email Id required");
		Thread.sleep(2000);
		WebElement pocname = driver.findElement(CompanyPages.POCFullName);
		pocname.click();
		pocname.clear();

		pocname.sendKeys("samplename");
		Thread.sleep(1000);
		// driver.findElement(CompanyPages.addcompanybutton).click();
		// Thread.sleep(1000);
		try {

			WebElement titleerror = driver.findElement(CompanyPages.error1);
			titleerror.isDisplayed();
			logger.info("Message: " + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println(alert);
			Assert.assertEquals(alert, "Required");
		} catch (

		Exception e) {
			logger.info(e);
		}
		Thread.sleep(1000);
	}
	// navigate to add company page with invalid POCemailId

	@Test(priority = 15, groups = { "Regression" })
	public void Add_company_inValid_POC_emailId() throws Exception {
		logger = extent.createTest("add invalid POC Emailid*", "add company invalid POCEmailid");
		logger.log(Status.INFO, "entered invalid website");
		Thread.sleep(2000);
		WebElement Pocmail = driver.findElement(CompanyPages.POCEmailID);
		Pocmail.click();
		Pocmail.sendKeys("example");
		Thread.sleep(2000);
		try {
			WebElement titleerror = driver.findElement(CompanyPages.error1);
			titleerror.isDisplayed();
			logger.info("Message: " + titleerror.getText());
			String alert = titleerror.getText();
			System.out.println(alert);
			Assert.assertEquals(alert, "Please enter a valid email");
		} catch (Exception e) {
			logger.info(e);
		}
		Pocmail.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}

	// navigate to add company page  and click on Add Company button  without //
	// POCContactNumber
	@Test(priority = 16, groups = { "Regression" })

	public void POC_contactNo_required() throws InterruptedException {
		logger = extent.createTest("POC Contact Number*", "add new omapany POC Contact NumberId required");

		Thread.sleep(2000);
		WebElement pocmail = driver.findElement(CompanyPages.POCEmailID);
		pocmail.click();
		pocmail.clear();

		pocmail.sendKeys("ramidi123@gmail.com");
		// driver.findElement(addcompanypage.addcompanybutton).click();
		// Thread.sleep(3000);

		try {
			WebElement contacteerror = driver.findElement(CompanyPages.error1);
			contacteerror.isDisplayed();
			logger.info("Message: " + contacteerror.getText());
			String alert = contacteerror.getText();
			System.out.println(alert);
			Assert.assertEquals(alert, "Required");
		} catch (

		Exception e) {
			logger.info(e);
		}
		Thread.sleep(1000);
	}

	@Test(priority = 17, groups = { "Regression" })
	public void cancel() throws InterruptedException, IOException {
		logger = extent.createTest("company  cancel  ", "add new company flow cancel ");
		Thread.sleep(2000);
		driver.findElement(CompanyPages.cancelbutton).click();
		logger.info("cancelled");
		Thread.sleep(3000);
	}

	@Test(priority = 18, groups = { "Regression", "SmokeTest" })
	// Add company page will all valid data filled
	public void add_new_company_Valid() throws Exception {
		logger = extent.createTest("add company valid ", "verify add new company enter required all data");
		logger.log(Status.INFO, "add new company created");
		Add_Company_button_click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement upload = wait.until(ExpectedConditions.elementToBeClickable(CompanyPages.UploadImage));
		upload.click();
		
		driver.findElement(By.id("uploadImg")).sendKeys(System.getProperty("user.dir") + "/TestData/profile icon.png");
		Thread.sleep(2000);
		System.out.println("Icon is uploaded");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		WebElement companyname = driver.findElement(CompanyPages.companyname);
		companyname.click();
		companyname.sendKeys(excel.getDataSheetName("SuperAdmin", 6, 1) + Wrapper.randomeString(3));
		Thread.sleep(1000);
		WebElement websitelink = driver.findElement(CompanyPages.CompanyWebsitelink);
		websitelink.click();
		websitelink.sendKeys(excel.getDataSheetName("SuperAdmin", 7, 1));
		System.out.println("Website link entered");
		Thread.sleep(1000);
		driver.findElement(CompanyPages.WorkingDays_Monday).click();
		Thread.sleep(1000);

		WebElement address = driver.findElement(CompanyPages.AddressLine1);
		address.click();
		address.sendKeys("Address");
		System.out.println("address entered");

		WebElement selectcountry = driver.findElement(CompanyPages.Country);
		selectcountry.click();
		Thread.sleep(3000);
		System.out.println("Country dropdown is clicked");
		Actions keyDown1 = new Actions(driver);
		keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(2000);

		WebElement selectstate = driver.findElement(CompanyPages.State);
		selectstate.click();
		Thread.sleep(3000);
		System.out.println("State dropdown is clicked");
		Actions keyDown2 = new Actions(driver);
		keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(2000);

		WebElement code = driver.findElement(CompanyPages.Zipcode);
		code.click();
		code.sendKeys("500080", Keys.TAB);
		Thread.sleep(1000);

		WebElement pocname = driver.findElement(CompanyPages.POCFullName);
		pocname.click();
		pocname.sendKeys(excel.getDataSheetName("SuperAdmin", 8, 1), Keys.TAB);
		System.out.println("POC name entered");
		// keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(1000);
		WebElement pocmail = driver.findElement(CompanyPages.POCEmailID);
		pocmail.click();
		pocmail.sendKeys(excel.getDataSheetName("SuperAdmin", 9, 1));
		System.out.println("POC email entered");
		Thread.sleep(1000);
		WebElement pocnumber = driver.findElement(CompanyPages.POCContactNumber);
		pocnumber.click();
		pocnumber.sendKeys(excel.getDataSheetName("SuperAdmin", 10, 1));
		System.out.println("POC mobile entered");
		Thread.sleep(1000);
		driver.findElement(CompanyPages.Add_Company_Save).click();
		Thread.sleep(3000);
		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("something went wrong")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(CompanyPages.cancelbutton).click();
				Thread.sleep(2000);
			} else if (toaster.contains("Company added successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
	}

	// wait for search to display and enter text then capture results

	@Test(priority = 19, groups = { "Regression" })
	public void Search_company() throws Exception {
		logger = extent.createTest("Search company", "Search company");
		logger.log(Status.INFO, "search company ");
		driver.get(config.Company());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement searchcompany = wait.until(ExpectedConditions.elementToBeClickable(CompanyPages.searchcompany));
		searchcompany.click();
		searchcompany.sendKeys(excel.getDataSheetName("SuperAdmin", 6, 1));
		Thread.sleep(2000);
		if (driver.findElements(CompanyPages.No_data).size() > 0) {
			String nodata = driver.findElement(CompanyPages.No_data).getText();
			System.out.println(nodata);
			logger.log(Status.INFO, nodata);
		} else if (driver.findElements(CompanyPages.search_result).size() > 0) {
			driver.findElement(CompanyPages.View_Row).click();
			System.out.println("Search results matched and data displayed");
			logger.log(Status.INFO, "Search results matched and data displayed");
		}
	}
	// view company

	@Test(priority = 20, groups = { "Regression" })
	public void View_company_details() throws Exception {
		logger = extent.createTest("view company ", "view company details");

		driver.get(config.Company());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement viewcompany = driver.findElement(CompanyPages.View_Row);
		viewcompany.click();

		// capture details

		WebElement editbutton = wait.until(ExpectedConditions.elementToBeClickable(CompanyPages.editcompany));
		editbutton.isDisplayed();
		String Message = editbutton.getText();
		System.out.println("Button Text--" + Message);
		logger.log(Status.INFO, Message);

		WebElement status = driver.findElement(CompanyPages.status);
		status.isDisplayed();
		String Message1 = status.getText();
		System.out.println("Company Status --" + Message1);
		logger.log(Status.INFO, "Company Status - " + Message1);

		WebElement CompanyName = driver.findElement(CompanyPages.companyinfo);
		CompanyName.isDisplayed();
		String Message2 = CompanyName.getText();
		System.out.println("Company Name --" + Message2);
		logger.log(Status.INFO, "Company Name - " + Message2);

		WebElement Company_Website = driver.findElement(CompanyPages.company_website_info);
		Company_Website.isDisplayed();
		String Message3 = Company_Website.getText();
		System.out.println("Company Website --" + Message3);
		logger.log(Status.INFO, "Company Website - " + Message3);

	}

	// Edit company
	@Test(priority = 21, groups = { "Regression", "SmokeTest" })
	public void Edit_Company() throws Exception {
		logger = extent.createTest("Edit company", "verify Edit Company");
		logger.log(Status.INFO, "Edit company address");
		driver.get(config.Company());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement CTA = wait.until(ExpectedConditions.elementToBeClickable(CompanyPages.CTA_Button));
		CTA.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.ENTER, Keys.ENTER)).perform();
		Thread.sleep(2000);
		driver.findElement(CompanyPages.UploadImage).click();
		Thread.sleep(2000);
		driver.findElement(By.id("uploadImg")).sendKeys(System.getProperty("user.dir") + "/TestData/profile icon.png");
		Thread.sleep(2000);
		System.out.println("Icon is uploaded");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(1000);
		WebElement Address = driver.findElement(CompanyPages.AddressLine1);
		Address.clear();
		Address.sendKeys("New Delhi");
		System.out.println("address is entered");
		Thread.sleep(2000);
		driver.findElement(CompanyPages.update_Save).click();
		Thread.sleep(3000);

		try {
			driver.findElement(ToasterObject.toaster).isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Company already exist")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
				driver.findElement(CompanyPages.cancelbutton).click();
				Thread.sleep(2000);
			} else if (toaster.contains("company updated successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}

	}

	// Delete company clicking on cancel

	@Test(priority = 22, groups = { "Regression" })
	public void Delete_company_Cancel() throws Exception {
		logger = extent.createTest("Delete company-No", "Verify company delete");

		driver.get(config.Company());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement CTA = driver.findElement(CompanyPages.CTA_Button);
		CTA.click();
		driver.findElement(CompanyPages.Delete_Button).click();
		Thread.sleep(2000);
		WebElement Cancel = driver.findElement(CompanyPages.Delete_cancel);
		Cancel.click();
		Thread.sleep(2000);
		System.out.println("clicked on cancel button");

	}

	// Delete company clicking on Yes

	@Test(priority = 23, groups = { "Delete" })
	public void Delete_Category_Yes() throws Exception {
		logger = extent.createTest("Delete company - Yes ", "verify company Delete Yes");
		logger.log(Status.INFO, "Delete company");

		driver.get(config.Company());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement CTA = driver.findElement(CompanyPages.CTA_Button);
		CTA.click();
		driver.findElement(CompanyPages.Delete_Button).click();
		Thread.sleep(2000);
		// WebElement Delete = driver.findElement(CompanyPages.Delete_Yes);
		// Delete.click();

		System.out.println("clicked on Yes button");
		try {
			
			WebElement Add = wait.until(ExpectedConditions.visibilityOfElementLocated(ToasterObject.toaster));
			Add.isDisplayed();
			String toaster = driver.findElement(ToasterObject.toaster).getText();
			if (toaster.contains("Sorry, You cannot delete this company which is mapped to subjects")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);
			} else if (toaster.contains("company Deleted successfully")) {
				logger.log(Status.INFO, toaster);
				System.out.println(toaster);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.out.println(e);
			logger.log(Status.ERROR, e);
		}
	}

	public void Add_Company_button_click() throws InterruptedException {
		driver.get(config.Company());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(CompanyPages.addNewCompany));
		Add.click();
		Thread.sleep(2000);

	}
}
