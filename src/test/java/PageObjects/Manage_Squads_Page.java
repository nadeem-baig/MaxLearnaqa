package PageObjects;

import org.openqa.selenium.By;

public class Manage_Squads_Page {

	public static By Add_New_Squad = By.xpath("//span[@class='align-middle add_clr'][text()='ADD NEW TEAM']");
	public static By squad_Name = By.xpath("//input[@placeholder='Type the Team name']");
	public static By squad_image = By.id("UncontrolledPopover");
	public static By Image_Upload = By.xpath("//span[@class='upload-img__btn-txt'][text()='Upload Image']");
	public static By file = By.id("uploadImg");
	public static By Upload_Cancel = By.xpath("//span[@class='upload-img__btn-txt'][text()='Cancel']");

	public static By Parameter = By.xpath("//select[preceding-sibling::*[descendant::text()='Parameter']]");
	public static By criteria = By.xpath("//select[preceding-sibling::*[descendant::text()='Criteria']]");
	public static By Value = By.xpath("//input[@placeholder='Search Value']");
	public static By Ruleset_add = By.xpath("//span[@class='add_Cls'][text()='Add']");
	public static By Ruleset_Clear = By.xpath("//span[@class='clr_Cls'][text()='Clear']");

	public static By checkbox1 = By.xpath("(//input[@type='checkbox'])[3]");
	public static By checkbox2 = By.xpath("(//input[@type='checkbox'])[4]");

	public static By Create_Squad = By.xpath("//span[@class='mr-50'][text()='Create Team']");
	public static By Cancel_Squad = By.xpath("//a[contains(text(),'Cancel')]");
	public static By error_Message = By.xpath("//div[@class='invalid-feedback'][text()='Team Name Required']");
	public static By View_Squad = By.xpath("//div[@id='row-0']");
	public static By Search_Squad = By.xpath("//input[@placeholder='Search']");
	public static By No_data = By.xpath("//div[contains(text(),'There are no records to display')]");
	public static By search_result = By.xpath("//div[@class='sc-dIfARi kNNa-dS rdt_TableBody']");
	public static By Add_Member = By.xpath("//span[contains(text(),'Add Member')]");
	public static By squad_Tab = By.xpath("//div[@id='rc-tabs-1-tab-1']");
	public static By Challenges_Tab = By.xpath("//div[@id='rc-tabs-1-tab-2 ']");

	public static By Parameter_error = By.xpath(
			"//p[@class='mx__learn-admin-react-select__control-error-message'][text()='parameter is not selected']");
	public static By criteria_error = By.xpath(
			"//p[@class='mx__learn-admin-react-select__control-error-message'][text()='criteria is not selected']");
	public static By Value_error = By.xpath(
			"//p[@class='mx__learn-admin-react-select__control-error-message'][text()='Value is not available']");
	public static By logic_error = By.xpath(
			"//p[@class='mx__learn-admin-react-select__control-error-message'][text()='Logic is not available']");

	public static By CTA_Button = By.xpath("(//button[@type='button'])[2]");
	public static By Delete_Button = By.xpath("(//button[@type='button'])[4]");
	public static By Delete_Yes = By.xpath("//button[@class='swal-button swal-button--confirm swal-button--danger'][text()='OK']");
	public static By Delete_cancel = By.xpath("//button[@class='swal-button swal-button--cancel'][text()='Cancel']");
	public static By Cancel_UpdatedSquad = By.xpath("//button[@type='button'][text()='Cancel']");
	public static By Update = By.xpath("//button[@type='submit']");
	public static By editsquad_Name = By.xpath("//input[@id='data-name']");

}
