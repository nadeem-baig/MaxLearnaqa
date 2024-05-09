package PageObjects;

import org.openqa.selenium.By;

public class KLP_Page {

    public static By Add_New_Klp =By.xpath("(//button[@type='button'])[1]");
    public static By Klp_Title =By.xpath("//input[@placeholder='Add KLP Title']");
	public static By Category_dropdown =By.xpath("//div[contains(text(),'Select Category')]");
	public static By Subject_dropdown =By.xpath("//div[contains(text(),'Select Subject')]");
	public static By Topic_dropdown =By.xpath("//div[contains(text(),'Select Topic')]");
	public static By Klp_Content =By.xpath("//textarea[@placeholder='Type the KLP content here']");
	public static By Cancle_Klp =By.xpath("//button[@type='button'][text()='Cancel']");
	public static By Save_Klp =By.xpath("//button[@type='submit']");
	public static By errorMessage = By.xpath("//div[@class='form_error-message mt-25']");    //Title , content
	public static By errorMessage2 = By.xpath("//div[@class='mt-25 ml-25 form_error-message']");  //Category,subject,Topic Drop down
	public static By chars = By.xpath("(//span)[60]");
	public static By Search = By.xpath("//input[@placeholder='Search']");
	public static By No_data = By.xpath("//div[contains(text(),'There are no records to display')]");
	public static By search_result = By.xpath("//div[@class='sc-dIfARi kNNa-dS rdt_TableBody']");
    public static By View_Row =By.id("row-0");
    public static By KLP_Detail_Title = By.xpath("//h4[@id='klp-title']");
	 public static By KLP_preview_close=By.xpath("(//button[@type='button'])[20]");
	 public static By CTA_Button = By.xpath("(//button[@type='button'])[5]");
		public static By Delete_Button = By.xpath("(//button[@type='button'])[7]");
		public static By Delete_Yes = By.xpath("//button[@class='swal-button swal-button--confirm swal-button--danger'][text()='OK']");
		public static By Delete_cancel = By.xpath("//button[@class='swal-button swal-button--cancel'][text()='Cancel']");

	






}
