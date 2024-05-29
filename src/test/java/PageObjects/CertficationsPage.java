

package PageObjects;

import org.openqa.selenium.By;

public class CertficationsPage {
	public static By CreateCert_Main = By.xpath("(//button[@type='button'])[1]");

	// Create Page
	public static By CertName = By.xpath("//input[@placeholder='Type the cert name']");
	public static By CertDescription = By.xpath("//textarea[@placeholder='Type the certification description here']");
	public static By PreviewQuestions = By.xpath("//button[@class=add-new-btn create_btn btn btn-secondary]");
	public static By PreviewQuestions_close = By.xpath("//SPAN[@aria-hidden='true'][text()='×']");
	public static By Search_Topic = By.xpath("//textarea[@placeholder='Search']");

	// in Cert content
	public static By Category_dropdown = By.xpath("//div[contains(text(),'Category')]");
	public static By Subject_dropdown = By.xpath("//div[contains(text(),'Subjects')]");
	public static By Category_dropdown_clear = By
			.cssSelector("div.select__indicator.select__clear-indicator.css-tlfecz-indicatorContainer > svg");
	public static By Subject_dropdown_clear = By.cssSelector(
			"div:nth-child(2) > div > div > div.select__indicators > div.select__indicator.select__clear-indicator.css-tlfecz-indicatorContainer > svg");
	public static By Cancel_submit = By.xpath("//a[@href='/data-list/challengs'][text()='Cancel']");
	// Cert content check boxes
	public static By checkbox1 = By.id("6419c33fe40e6a1e12e3c698");
	public static By learninglevel = By.xpath("//div[@class=' css-1wa3eu0-placeholder'][text()='Select Level']");
	public static By PickQuestions = By.xpath("//button[@type='button'][text()='Pick Questions']");
	public static By selectQuestion1 = By
			.cssSelector("li:nth-child(1) > div.question_card > div > label > span > input");
	public static By selectQuestion2 = By
			.cssSelector("li:nth-child(2) > div.question_card > div > label > span > input");
	public static By confirmselection_question = By.xpath("//button[@type='submit'][text()='Confirm Selection']");

	public static By FromDate = By.xpath("//input[@placeholder='From Date']");
	public static By ToDate = By.cssSelector("div:nth-child(2) > div > div > input");
	public static By select_date1 = By.xpath("(//A[@class='ant-picker-today-btn'][text()='Today'])[1]");
	public static By select_date2 = By.xpath("(//A[@class='ant-picker-today-btn'][text()='Today'])[2]");
	public static By Certfrequency = By
			.xpath("(//div[@class=' css-1wa3eu0-placeholder'][text()='Select a frequency'])");
	public static By Passing_Percentage = By.xpath("//input[@placeholder='Value']");

	public static By TimeBound = By.xpath("//span[contains(@class,'ant-switch-inner')][normalize-space()='Off'])[1]");
	public static By AnswerExp = By.xpath("//span[contains(@class,'ant-switch-inner')][normalize-space()='Off'])[2]");

	public static By PickLearners = By.xpath("(//span[@class='pr-2 lear_pick'])[1]");
	public static By IndividualLearners = By.xpath("//p[normalize-space()='Pick Individually']");
	public static By Parameter = By.cssSelector("div:nth-child(1) > select");
	public static By Criteria = By.cssSelector("div:nth-child(3) > select");
	public static By Value = By.xpath("//input[@placeholder='Search Value']");
	public static By Add = By.xpath("//span[text()='Add']");

	public static By Individual_learner1 = By
			.cssSelector("li:nth-child(1) > div.text-center > input[type=\"checkbox\"]");
	public static By Individual_learner2 = By
			.cssSelector("li:nth-child(2) > div.text-center > input[type=\"checkbox\"]");
	public static By ConfirmSelection = By.xpath("//button[text()='Confirm Selection']");

	public static By Createcert = By.xpath("//button[text()='Create Certification']");

	public static By Cert_Error = By.xpath("//p[@class='err_klkk'][text()='Please enter Cert Name']");
	public static By Description_error = By.xpath("//p[@class='err_klkk'][text()='Please enter Cert  Description ']");
	public static By Cert_Content_error = By.xpath("//p[@class='err_klkk'][text()='Please Select Questions']");
	public static By PassingPer_error = By.xpath("//p[@class='err_klkk'][text()='Please Select Passing Percentage']");
	public static By From_Date_error = By.xpath("//p[@class='err_klkk'][text()='Please Select From Date']");
	public static By To_Date_error = By.xpath("//p[@class='err_klkk'][text()='Please Select To Date']");

	public static By CTA_Button = By.xpath("//div[@id='row-0']//*[name()='circle']");
	
	public static By Edit= By.xpath("//button[normalize-space()='Edit']");
	public static By Delete_Button = By.xpath("//button[normalize-space()='Delete']");
	public static By Delete_Yes = By
			.xpath("//button[@class='swal-button swal-button--confirm swal-button--danger'][text()='OK']");
	public static By Delete_cancel = By.xpath("//button[@class='swal-button swal-button--cancel'][text()='Cancel']");

	
	public static By update = By.xpath("//button[text()='Edit Certification']");

	// listing Page
	public static By Search_Cert = By.xpath("//input[@placeholder='Search']");
	public static By No_data = By.xpath("//div[contains(text(),'There are no records to display')]");
	public static By search_result = By.xpath("//div[@class='sc-dIfARi kNNa-dS rdt_TableBody']");
	public static By View_cert = By.id("row-0");
	public static By Details_Tab = By.xpath("//div[text()='Details']");
	public static By participants_Tab = By.xpath("//div[text()='Participants']");
	public static By Notification_Tab = By.xpath("//div[text()='Notifications']");
	// public static By status_dropdown =
	// By.xpath("(//select[@name='status'])[1]]");
	public static By Publish_status = By.xpath("//span[@class='ml-1 d-inline publ_clr']");
	// public static By Draft_status = By.xpath("//span[@class='ml-1 d-inline
	// drft_clr']");
	public static By status_dropdown = By.xpath("//div[@class='status-select']");
	public static By Draft_status = By.xpath("//option[text() ='Draft']");
	public static By Toggle = By.xpath("(//button[@type='button'])[3]");
	public static By status = By.xpath("(//SELECT[@name='status'])[1]");
}