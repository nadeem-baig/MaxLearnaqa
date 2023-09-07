package PageObjects;

import org.openqa.selenium.By;

public class DecksPage {

	public static By Decks_Nav_Menu =By.xpath("//span[@class='menu-item menu-title'][text()='Decks']");

    public static By Add_New_Deck =By.xpath("//span[contains(text(),'Add New Deck')]");
	public static By deckTitle = By.xpath("//input[@placeholder='Add Deck Title']");
	public static By Category_dropdown =By.xpath("//div[contains(text(),'Select Category')]");
	public static By Subject_dropdown =By.xpath("//div[contains(text(),'Select Subject')]");
	public static By Topic_dropdown =By.xpath("//div[contains(text(),'Select Topic')]");
	public static By Save =By.xpath("//button[@type='submit']");
	public static By Cancle =By.xpath("//button[@type='button'][text()='Cancel']");
	
	public static By Detail = By.xpath("//P[@title='kyc deck'][text()='kyc deck']");
	public static By errorMessage = By.xpath("//div[@class='form_error-message mt-25']");
	public static By errorMessage1 = By.xpath("//div[@class='mt-25 ml-25 form_error-message']");
	public static By Search_Deck = By.xpath("//input[@placeholder='Search']");
	public static By No_data = By.xpath("//div[contains(text(),'There are no records to display')]");
	public static By search_result = By.xpath("//div[@class='sc-dIfARi kNNa-dS rdt_TableBody']");
    public static By View_Row =By.id("row-0");
    public static By Add_flascard = By.xpath("//span[contains(text(),'Add New Flashcard')]");
    public static By CTA_Button = By.xpath("(//button[@type='button'])[11]");
	public static By Delete_Button = By.xpath("(//button[@type='button'])[13]");
	public static By Delete_Yes = By.xpath("//button[@class='swal-button swal-button--confirm swal-button--danger'][text()='OK']");
	public static By Delete_cancel = By.xpath("//button[@class='swal-button swal-button--cancel'][text()='Cancel']");

}
