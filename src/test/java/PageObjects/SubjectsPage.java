package PageObjects;

import org.openqa.selenium.By;

public class SubjectsPage {

	public static By Add_New_Subject = By.xpath("//span[text()='ADD NEW SUBJECT']");
	public static By Subject_Title = By.xpath("//input[@placeholder='Enter Subject Title']");
	public static By sub_upload = By.xpath("//*[@id=\"root\"]/div/div[3]/div[3]/div/div[5]/div[3]/button[2]/span/span");
	public static By File = By.id("file-input");

	public static By chars = By.id("charNum");
	public static By errormessage = By.xpath("//div[@class='form_error-message mt-25']");
	public static By icon = By.xpath("//div[@class='form_error-messagetitl']");
	public static By search = By.xpath("//input[@placeholder='Search']");

	public static By Subject_Nav_Menu = By.xpath("//span[normalize-space()='Subjects']");

	public static By Category_Dropdown = By
			.xpath("//body[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[5]/div[2]/div[3]/div[1]/div[1]");
	public static By description = By.xpath("//textarea[@id='data-name']");
	public static By Cancel = By.xpath("//button[@type='button'][text()='Cancel']");
	public static By Subject_save = By.xpath("//button[@type='submit']");

	public static By Search_category = By.xpath("//input[@placeholder='Search']");
	public static By No_data = By.xpath("//div[contains(text(),'There are no records to display')]");
	public static By search_result = By.xpath("//div[@class='sc-dIfARi kNNa-dS rdt_TableBody']");

	public static By View_Row = By.id("row-0");
	public static By Add_Topics = By.xpath("//span[normalize-space()='ADD NEW TOPIC']");
	public static By CTA_Button = By.xpath("(//button[@type='button'])[2]");
	public static By Delete_Button = By.xpath("(//button[@type='button'])[4]");
	public static By Delete_Yes = By.xpath("//button[@class='swal-button swal-button--confirm swal-button--danger'][text()='OK']");
	public static By Delete_cancel = By.xpath("//button[@class='swal-button swal-button--cancel'][text()='Cancel']");
	public static By status = By.xpath("(//select[@name='status'])[1]");


}
