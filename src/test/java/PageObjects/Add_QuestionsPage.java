package PageObjects;

import org.openqa.selenium.By;

public class Add_QuestionsPage {
	
	
    public static By Add_New_Question =By.xpath("//span[@class='align-middle add_clr ml-ques-btn'][text()='ADD NEW QUESTIONS']");
    public static By Single_Choice =By.xpath("//span[@class='align-middle'][text()='Single Choice Questions']");
    
    public static By Question_Content =By.xpath("//div[@class='fr-element fr-view']//p");
    public static By Option_1 =By.xpath("(//textarea[@name='text'])[1]");
    public static By Option_2 =By.xpath("(//textarea[@name='text'])[2]");
    public static By checkbox =By.xpath("//label[@for='custom-checkbox-0']");
	public static By FeedBack = By.xpath("//textarea[@placeholder='Type your feedback here…']");
	public static By Category_dropdown =By.xpath("(//div[@class='select__value-container select__value-container--has-value css-1hwfws3'])[1]");
	public static By Subject_dropdown =By.xpath("(//div[@class='select__value-container select__value-container--has-value css-1hwfws3'])[2]");
	public static By Topic_dropdown =By.xpath("(//div[@class='select__value-container select__value-container--has-value css-1hwfws3'])[3]");
	public static By Add_Button =By.xpath("//span[@class='add_Cls'][text()='Add']");
	public static By learninglevel =By.xpath("//div[@class='React css-2b097c-container']//input[@type='text']");	
	public static By Timetosolve =By.xpath("//input[@name='text']");
	public static By Klp_dropdown =By.xpath("//div[@class='React klp_slt css-2b097c-container']//div[@class='select__value-container select__value-container--has-value css-1hwfws3']");
	public static By cancel_button =By.xpath("//span[normalize-space()='Cancel']");
	public static By Preview_Button =By.xpath("//span[normalize-space()='Preview']");
	public static By Save_button =By.xpath("//button[@id='popClick']");
	public static By Save_as_publish =By.xpath("//span[normalize-space()='Save and Publish']");
	public static By Status_text =By.xpath("(//select[@name='status'])[1]");
	public static By Preview_close =By.xpath("(//span[@aria-hidden='true'][text()='x']");
	public static By Preview_text =By.xpath("//div[@class='inside-secd']");
	public static By Save_as_draft =By.xpath("//span[contains(text(),'Save as Draft')]");


	public static By Answer_error =By.xpath("//p[@class='err_klkk'][text()='Please Select an Answer']");
	public static By feedback_error =By.xpath("//p[@class='err_klkk'][text()='Please enter feedback']");
	public static By Topic_included_error =By.xpath("//p[@class='err_klkk'][text()='Please add Topics Included']");
	public static By learning_level_error =By.xpath("//p[@class='err_klkk'][text()='Please select Learning level']");
	public static By error =By.className("err_klkk");
	public static By Category_error =By.xpath("//p[@class='error_appas'][text()='Please select Category']");
	public static By subject_error =By.xpath("//p[@class='error_appas'][text()='Please select Subject']");
	public static By Topic_error =By.xpath("//p[@class='error_appas'][text()='Please select Topic']");
	public static By chars =By.id("charNum");
	public static By Search = By.xpath("//input[@placeholder='Search']");
	public static By No_data = By.xpath("//div[contains(text(),'There are no records to display')]");
	public static By search_result = By.xpath("//div[@class='sc-dIfARi kNNa-dS rdt_TableBody']");
	public static By eye_icon = By.xpath("(//*[name()='svg'][@class='mr-4 fonticon-wrap eye_clrdf'])[1]");
	public static By View_close =By.xpath("//button[@aria-label='Close']");	
	public static By CTA_Button = By.xpath("(//button[@type='button'])[6]");
	public static By Delete_Button = By.xpath("(//button[normalize-space()='Delete'])");
	public static By Delete_Yes = By.xpath("//button[@class='swal-button swal-button--confirm swal-button--danger'][text()='OK']");
	public static By Delete_cancel = By.xpath("//button[@class='swal-button swal-button--cancel'][text()='Cancel']");

	//scroll till feedback
	public static String locatortype = "xpath";
	public static String  feedbackview = "//div[@class='add_opti']";
	public static String  feedbackText= "//span[normalize-space()='Feedback']";

	public static By Multi_Choice =By.xpath("//span[contains(text(),'Multiple Choice Questions')]");
	public static By True_False =By.xpath("//span[contains(text(),'True/False Questions')]");
	public static By Put_in_Order =By.xpath("//span[contains(text(),'Put-in-order Questions')]");
	public static By Add_Option = By.xpath("//span[@class='plus_isnner']");
	public static By Radio_button = By.xpath("(//input[@type='radio'])[1]");
	public static By T_F_error =By.xpath("//p[@class='err_klkk'][text()='Please select True/False option']");
	public static By option_Error =By.xpath("//p[@class='err_klkk'][text()='Please enter option']");
    public static By Option_3 =By.xpath("(//textarea[@name='text'])[3]");
    public static By checkbox1 =By.xpath("//label[@for='custom-checkbox-1']");
	public static By status = By.xpath("(//SELECT[@name='status'])[1]");
	
	
	public static By Excel_Uplaod = By.xpath("//label[@for='file-input']//img[@class='excel_catgf ex_flt']");
	public static By file = By.id("file-input");

















    




}
