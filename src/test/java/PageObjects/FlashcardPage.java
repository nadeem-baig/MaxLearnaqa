
package PageObjects;

import org.openqa.selenium.By;

public class FlashcardPage {


	 public static By Add_New_Flashcard =By.xpath("//span[contains(text(),'Add New Flashcard')]");
		public static By addTitle = By.xpath("//input[@placeholder='Enter flash card title']");
		public static By upload =By.xpath("//*[@id=\"root\"]/div/div[3]/div[3]/div/div[4]/div[1]/div[2]/div[2]/div/div/label/span");
		public static By description = By.xpath("(//P)[2]");
		public static By cancel = By.xpath("(//button[@type='button'][text()='Cancel'])[1]");
		public static By publish =By.xpath("(//button[@type='submit'])[1]");
		public static By Error = By.xpath("//div[@class='form_error-message mt-25']");
		public static By Flascard_icon = By.xpath("//div[@class='form_error-messagetitl']");
		public static By file = By.id("file-input");
		public static By chars = By.xpath("(//SPAN[@class='fr-counter'][text()='Characters : 0/1000'])[1]");
		public static By Search = By.xpath("//input[@placeholder='Search']");
		public static By No_data = By.xpath("//div[contains(text(),'No Data')]");
		public static By search_result = By.id("demo");
		public static By View_icon = By.xpath("//tbody/tr[1]/td[7]");
	    public static By deck_Detail =By.id("row-0");

	    public static By Flashcard_content=By.xpath("//div[@class='modal-body']//p");
	    public static By Flashcard_preview_close=By.xpath("//h5[@class='modal-title']");


	    public static By CTA_Button = By.xpath("(//button[@type='button'])[4]");
		public static By Delete_Button = By.xpath("(//button[@type='button'])[6]");
		public static By Delete_Yes = By.xpath("//button[@class='swal-button swal-button--confirm swal-button--danger'][text()='OK']");
		public static By Delete_cancel = By.xpath("//button[@class='swal-button swal-button--cancel'][text()='Cancel']");
		public static By status = By.xpath("(//select[@name='status'])[1]");



}

