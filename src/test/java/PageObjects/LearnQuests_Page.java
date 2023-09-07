package PageObjects;
import org.openqa.selenium.By;
public class LearnQuests_Page {

	public static By createnewQuest = By.xpath("//span[normalize-space()='Create New Quest']");

	//Create Page
    public static By createQuest = By.cssSelector(".btn.btn-add-new-btn.add_btnct1.ml-1");
	public static By LearnQuestName = By.xpath("//INPUT[@placeholder='Type the quest name']");
	public static By QuestDescription = By.xpath("//DIV[@class='fr-element fr-view fr-element-scroll-visible']");
	public static By TimedQuest = By.xpath("//SPAN[@class='ant-switch-inner'][text()='Off']");
	public static By PeriodofperformanceFromDate = By.xpath("(//INPUT[@type='text'])[2]");
	public static By PeriodofperformanceToDate = By.xpath("(//INPUT[@type='text'])[3]");
	public static By Category = By.xpath("(//DIV[@class='select__value-container css-1hwfws3'])[1]");
	public static By Subject = By.xpath("(//div[@class='select__value-container css-1hwfws3'])[1]");
	public static By Topic = By.xpath("//div[text()='Select Topic']");
	public static By SearchbyKeyboard = By.xpath("//INPUT[@placeholder='Start typing a Keyword']");
	public static By ContentType = By.xpath("//textarea[select__placeholder css-1wa3eu0-placeholder=Select a Content Type");
	public static By checkbox_1 = By.xpath("(//INPUT[@class='ant-checkbox-input'])[2]");
	public static By checkbox_2 = By.xpath("(//INPUT[@class='ant-checkbox-input'])[3]");
	public static By checkbox_3 = By.xpath("(//INPUT[@class='ant-checkbox-input'])[4]");
	public static By Addobjects = By.xpath("//button[text()='Add Objects']");
	public static By content = By.xpath("//DIV[@class='col-sm-12 mt-25 ml-25 d-flex justify-content-end align-items-center form_error-message'][text()='Content Required']");

	// error messages
	public static By toastermessage = By.xpath("//DIV[@class='Toastify__toast Toastify__toast--default']");
	public static By topic_Error = By.xpath("//div[text()='Topic Required']");
	public static By Description_error = By.xpath("//div[text()='Description Required']");
	public static By name_error = By.xpath("//div[text()='Name is Required']");
	public static By content_error = By.xpath("//div[text()='Content Required']");
	public static By QuestErrorMessage = By.xpath("//DIV[@class='col-sm-12 mt-25 ml-25 d-flex justify-content-end align-items-center form_error-message'][text()='Topic Required']");

	// listing page
	public static By submit_cancel = By.xpath("//a[normalize-space(.)='Cancel']]");
	public static By search_quest = By.xpath("//input[@placeholder='Search']");
	public static By No_data = By.xpath("//div[contains(text(),'There are no records to display')]");
	public static By search_result = By.xpath("//div[@class='sc-dIfARi kNNa-dS rdt_TableBody']");
	public static By View_quest = By.id("row-0");
	public static By Details_content_Tab = By.xpath("//p[text()='Details & Content']");
	public static By IndividualLearners_Tab = By.xpath("//p[text()='Individual Learners']");
	public static By Notification_Tab = By.xpath("//p[text()='Notifications']");
	public static By Publish_status = By.xpath("//span[@class='ml-1 d-inline publ_clr']");
	public static By Draft_status = By.xpath("//span[@class='ml-1 d-inline drft_clr']");

	// Edit and Delete
	public static By CTA_Button = By.xpath("//div[@id='row-0']//*[name()='circle']");
	public static By Delete_Button = By.xpath("//button[normalize-space()='Delete']");
	public static By Delete_Yes = By.xpath("//button[@class='swal-button swal-button--confirm swal-button--danger'][text()='OK']");
	public static By Delete_cancel = By.xpath("//button[@class='swal-button swal-button--cancel'][text()='Cancel']");
	public static By Update = By.xpath("//button[descendant::text()='Save Quest']");
	public static By delete_toast = By.xpath("//div[@class='Toastify__toast-body']//span");
	public static By member_count = By.xpath("//div[@class='sc-dKfzgJ bCwQdW rdt_TableBody']");
}