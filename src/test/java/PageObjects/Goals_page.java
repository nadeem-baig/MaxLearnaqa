package PageObjects;

import org.openqa.selenium.By;

public class Goals_page {

	public static By create_new_goals = By.xpath("//span[normalize-space()='Create Goal']");

	public static By Create_Goals_Save = By.xpath("//button[normalize-space()='Create Goal']");
	public static By Category = By.xpath("(//div[@class='select__value-container css-1hwfws3'])[1]");
	public static By Subject = By.xpath("(//div[@class='select__value-container css-1hwfws3'])[1]");
	public static By Topic = By.xpath("//div[@class='select__value-container css-1hwfws3']");

	public static By Pick_learners = By.xpath("//span[normalize-space()='Pick Learners']");
	public static By parameter = By.xpath("//option[normalize-space()='Select Parameter']");
	public static By Criteria = By.xpath("//option[normalize-space()='Select Criteria']");
	public static By Value = By.xpath("//input[@placeholder='Search Value']");
	public static By addbutton = By.xpath("//span[normalize-space()='Add']");
	public static By Search_learner=By.xpath("//input[@placeholder='Search for member']");
	public static By nodata= By.xpath("//h5[normalize-space()='No data']");
	public static By checkbox1 = By.xpath("(//input[contains(@type,'checkbox')])[2]");
	
	public static By confirm = By.xpath("//button[normalize-space()='Confirm Selection']");

	public static By learning_level = By.xpath("(//div[contains(text(),'Select Level')])[1]");
	public static By required_status = By.xpath("(//div[contains(text(),'Select Status')])[1]");

	public static By Error = By.xpath("err_klkk");

	public static By Cancel = By.xpath("//a[normalize-space()='Cancel']");
	public static By Search = By.xpath("//input[@placeholder='Search']");
	public static By No_data = By.xpath("//div[contains(text(),'There are no records to display')]");
	public static By search_result = By.xpath("//div[@class='sc-hUOJWJ jYEjQZ rdt_TableBody']");

	public static By view = By.id("row-0");
	public static By view_Edit_Goal=By.xpath("//span[normalize-space()='Edit Goal']");
	public static By Participants = By.xpath("//div[contains(text(),'Participants')]");
	public static By Notifications = By.xpath("//div[contains(text(),'Notifications')]");
	
	public static By CTA_Button = By.xpath("(//button[@type='button'])[3]");
	
	public static By Edit_Goal = By.xpath("//button[normalize-space()='Edit']");
	public static By Submit=By.xpath("//button[normalize-space()='Edit Goal']");
	
	public static By Delete_Button = By
			.xpath("//div[@class='dropdown-menu show']//button[@role='menuitem'][normalize-space()='Delete']");
	public static By Delete_Yes = By
			.xpath("//button[@class='swal-button swal-button--confirm swal-button--danger'][text()='OK']");
	public static By Delete_cancel = By.xpath("//button[@class='swal-button swal-button--cancel'][text()='Cancel']");

}
