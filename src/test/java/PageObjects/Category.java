package PageObjects;

import org.openqa.selenium.By;

public class Category {

	public static By cattitle =By.xpath("//div[normalize-space()='Title is Required']");
	public static By icon =By.xpath("//div[contains(text(),'Icon is Required')]");
	public static By categorycancel =By.xpath("//button[normalize-space()='Cancel']");
	public static By addNewCategory = By.xpath("//div[@id='root']/div/div[3]/div[3]/div/div/div/div/button/span");
	public static By addTitle = By.xpath("//input[@placeholder='Add Category Title']");
	public static By category_Description = By.xpath("//textarea[@type='textarea']");
	public static By cardColor = By.id("colorsid2");
	public static By cat_submitbutton = By.xpath("//button[@type='submit']");
	public static By cat_Fileupload = By.xpath("//span[normalize-space()='Upload Image']");
	public static By errormessage = By.xpath("//div[@class='form_error-message mt-25']");
	public static By errorcard = By.xpath("//div[@class='form_error-messagetitl mt-2 colr_Err']");
	public static By addcategorytext = By.xpath("//div[contains(text(),'Add New Category')");

	public static By cat_draftbutton = By.xpath("//span[@class='mr-50 '][text()='Save as draft']");

	public static By Search_category = By.xpath("//input[@placeholder='Search']");
	public static By No_data = By.xpath("//div[contains(text(),'There are no records to display')]");
	public static By search_result = By.xpath("//div[@class='sc-dIfARi kNNa-dS rdt_TableBody']");
	
	
    public static By View_Row =By.id("row-0");
    public static By Add_Subjects = By.xpath("//span[text()='ADD NEW SUBJECT']");
    
    public static By File =By.id("file-input");
    public static By chars =By.id("charNum");

    public static By CTA_Button = By.xpath("(//button[@type='button'])[2]");
    
	public static By Delete_Button = By.xpath("//button[text()='Delete']");
	public static By Delete_Yes = By.xpath("//button[@class='swal-button swal-button--confirm swal-button--danger'][text()='OK']");
	public static By Delete_cancel = By.xpath("//button[@class='swal-button swal-button--cancel'][text()='Cancel']");
	public static By status = By.xpath("(//select[@name='status'])[1]");

	
}
