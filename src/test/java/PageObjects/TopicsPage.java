package PageObjects;

import org.openqa.selenium.By;

public class TopicsPage {
	public static By Topics_Nav_Menu = By.xpath("//span[contains(text(),'Topics')]");
	public static By Add_New_topic = By.xpath("//span[text()='ADD NEW TOPIC']");
	public static By Topic_Title = By.name("title");
	public static By Category_dropdown = By.xpath("//div[contains(text(),'Pick a category')]");
	public static By Subject_dropdown = By.xpath("//div[contains(text(),'Pick a subject')]");
	public static By Topic_description = By.name("description");
	public static By Topic_publish = By.xpath("//button[@type='submit']");
	public static By Cancel_Topic = By.xpath("//button[@type='reset'][text()='Cancel']");
	public static By Duplicate_Topic = By.xpath("//span[contains(text(),'topics already exist')]");

	public static By error1 = By.xpath("//div[@class='form_error-message mt-25']");
	public static By error2 = By.xpath("//div[@class='mt-25 ml-25 form_error-message']");

	public static By view_Details = By.id("row-0");
	public static By chars = By.xpath("//*[@id=\"root\"]/div/div[3]/div[3]/div[3]/form/div/div[2]/div[6]/div[1]/span");

	public static By search = By.xpath("//input[@placeholder='Search']");
	public static By No_data = By.xpath("//div[contains(text(),'There are no records to display')]");
	public static By search_result = By.xpath("//div[@class='sc-dKfzgJ gupTcW rdt_TableBody']");
	public static By View_Row = By.id("row-0");
	public static By Add_Deck = By.xpath("//span[contains(text(),'Add New Deck')]");
	public static By CTA_Button = By.xpath("(//button[@type='button'])[5]");
	public static By Delete_Button = By.xpath("(//button[@type='button'])[7]");
	public static By Delete_Yes = By.xpath("//button[@class='swal-button swal-button--confirm swal-button--danger'][text()='OK']");
	public static By Delete_cancel = By.xpath("//button[@class='swal-button swal-button--cancel'][text()='Cancel']");
	public static By status = By.xpath("(//select[@name='status'])[1]");

}