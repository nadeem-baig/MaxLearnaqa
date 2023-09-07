package PageObjects;

import org.openqa.selenium.By;

public class ChallengePage 

{
	public static By CreateChallenge_Main = By.xpath("//SPAN[@class='align-middle add_clr'][text()='Create Challenge']");
	//Create Page
	public static By ChallengeName = By.xpath("//input[@placeholder='Type the challenge name']"); 
	public static By ChallengeDescription =  By.xpath("//textarea[@placeholder='Type the challenge description here']"); 
	public static By  PreviewTopic = By.xpath("//button[@class=add-new-btn create_btn btn btn-secondary]"); 
	public static By  PreviewTopic_close = By.xpath("//SPAN[@aria-hidden='true'][text()='×']");
	public static By  SearchTopic = By.xpath("//textarea[@placeholder='Search']"); //in challenge content
	public static By  Category_dropdown = By.xpath("//div[contains(text(),'Category')]");
	public static By Subject_dropdown = By.xpath("//div[contains(text(),'Subjects')]");
	//challenge content check boxes
	
	public static By checkbox1 = By.cssSelector("tr:nth-child(1) > td:nth-child(1) > label > span > input");
	public static By checkbox2 = By.xpath("(//*[contains(text(), 'Name')]/ancestor-or-self::*/descendant::*/INPUT[@type='checkbox' and contains(@class, 'ant-checkbox-input')])[2]");
	public static By Priority = By.xpath("(//div[@class=' css-1uccc91-singleValue'][text()='NORMAL'])[2]");
	public static By  Question_PerSession =   By.xpath("//div[contains(@class,'p-0 mt-1')]//div[contains(@class,'css-1hwfws3')]");
	public static By  Session_PerDay = By.xpath("//form[contains(@class,'w-100')]//div[contains(@class,'css-1hwfws3')]");
	public static By FromDate = By.cssSelector("div:nth-child(4) > div:nth-child(1) > div > div > input"); 
	//public static By ToDate = By.xpath("//input[@placeholder='To date']");
	public static By ToDate = By.cssSelector("div:nth-child(2) > div > div > input");
	public static By select_date1 = By.xpath("(//A[@class='ant-picker-today-btn'][text()='Today'])[1]");
	public static By select_date2 = By.xpath("(//A[@class='ant-picker-today-btn'][text()='Today'])[2]");

	public static By TimeBounded_PerQuestion = By.xpath("(//button[@type='button'])[2]");
	public static By Answer_Explanation = By.xpath("(//div[@class='ant-switch-handle'])[2]");
	public static By IndividualLearners = By.xpath("//input[@type='radio'])[text()='Individual Learners']");
	public static By Type_Squads = By.xpath("(//input[@type='radio'])[2]");    //squad radio button
	public static By PickSquads = By.xpath("//button[@type='button'][text()='Pick Squads']");   //pick squad button
	public static By Squad_option1 = By.xpath("(//*[contains(text(), 'Squads')]/ancestor-or-self::*/descendant::*/INPUT[@type='checkbox' and contains(@class, 'ant-checkbox-input')])[11]");
	public static By  Squad_option2 = By.cssSelector("li:nth-child(4) > div > div:nth-child(1) > label > span > input");
	public static By Squad_option3 = By.cssSelector("li:nth-child(2) > div > div:nth-child(1) > label > span > input");
	public static By PickLearners = By.xpath("//button[@type='button'][text()='Pick Learners']");
	public static By Individual_option1=By.cssSelector("tr:nth-child(1) > td.check > label > span > input");
	public static By Individual_option2 = By.cssSelector("tr:nth-child(2) > td.check > label > span > input");
	public static By ConfirmSelection = By.xpath("//button[@type='button'][text()='Confirm Selection']");
	public static By CreateChallenge_submit = By.xpath("//button[@type='submit'][text()='Create Challenge']");
	public static By Cancel_Squad = By.xpath("//button[@type='button'][text()='Cancel']");
	public static By Cancel_submit = By.xpath("//a[@href='/data-list/challengs'][text()='Cancel']");
	public static By squad_count = By.xpath("//div//div[text()='ASSIGNED SQUADS(']");
	public static By Learners_count = By.xpath("//div[text()='ASSIGNED LEARNERS(']");

	public static By chars =By.id("charNum");
	public static By Challenge_Error = By.xpath("//p[@class='err_klkk'][text()='Please Enter Challenge Name']");
	public static By Description_error = By.xpath("//p[@class='err_klkk'][text()='Please Enter Challenge Description ']");
	public static By Challenge_Content_error = By.xpath("//p[@class='err_klkk'][text()='Please Select Challenge Content']");
	public static By Session_error = By.xpath("//p[@class='err_klkk'][text()='Please Select Question Per Session']");
	public static By Session_Day_error = By.xpath("//p[@class='err_klkk'][text()='Please Select Sessions Per Day']");
	public static By From_Date_error = By.xpath("//p[@class='err_klkk'][text()='Please Select From Date']");
	public static By To_Date_error = By.xpath("//p[@class='err_klkk'][text()='Please Select To Date']");
	//listing Page
	public static By Search_Challenge = By.xpath("//input[@placeholder='Search']");
	public static By No_data = By.xpath("//div[contains(text(),'There are no records to display')]");
	public static By search_result = By.xpath("//div[@class='sc-dIfARi kNNa-dS rdt_TableBody']");
    public static By View_Challenge =By.id("row-0");
	public static By Details_Tab = By.xpath("//div[text()='Details']");
	public static By participants_Tab = By.xpath("//div[text()='Participants']");
	public static By Notification_Tab = By.xpath("//div[text()='Notifications']");
	public static By Publish_status = By.xpath("//span[@class='ml-1 d-inline publ_clr']");
	public static By Draft_status = By.xpath("//span[@class='ml-1 d-inline drft_clr']");
	
	public static By Challenge_Text = By.xpath("//div[@class='mt-1 detail_font-size']");
	public static By Add_Learner = By.xpath("(//button[@type='button'])[3]");
	//Edit and Delete
	 public static By CTA_Button = By.xpath("//div[@id='row-0']//*[name()='circle']");
	 public static By Delete_Button = By.xpath("//button[normalize-space()='Delete']");
	 public static By Delete_Yes = By.xpath("//button[@class='swal-button swal-button--confirm swal-button--danger'][text()='OK']");
	 public static By Delete_cancel = By.xpath("//button[@class='swal-button swal-button--cancel'][text()='Cancel']");
	 public static By Update =By.xpath("//button[@type='submit'][text()='Update Challenge']");
	 public static By delete_toast = By.xpath("//div[@class='Toastify__toast-body']//span");
	 public static By member_count = By.xpath("//div[@class='sc-dKfzgJ bCwQdW rdt_TableBody']");

}
