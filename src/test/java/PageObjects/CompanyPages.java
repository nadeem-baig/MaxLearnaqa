
package PageObjects;
import org.openqa.selenium.By;
public class CompanyPages {

	
	public static By addNewCompany = By.xpath("//span[contains(text(),'Add New Company')]");
	public static By UploadImage = By.xpath("//span[contains(text(),'Upload Image')]");
	public static By companyname = By.name("name");
	public static By CompanyWebsitelink = By.name("websiteLink");
	//working days
	public static By WorkingDays_Monday = By.xpath("//span[@for='Monday']");
	public static By WorkingDays_Tuesday = By.xpath("//span[@for='Tuesday']");
	//address
	public static By AddressLine1 = By.name("addressInfo.address1");
	public static By AddressLine2 = By.name("addressInfo.address2");
	
	public static By Country = By.xpath("//div[contains(text(),'Select a Country')]");
	public static By State = By.xpath("//div[contains(text(),'Select a State')]");
	public static By Zipcode = By.name("addressInfo.zipcode");
	
	//POC
	public static By POCFullName = By.name("pointOfContact.name");
	public static By POCEmailID = By.name("pointOfContact.email");
	public static By POCContactNumber = By.xpath("//input[@type='tel']");
	
	public static By Add_Company_Save = By.xpath("//span[contains(text(),'Add Company')]");
	public static By cancelbutton = By.xpath("//button[contains(text(),'Cancel')]");
	
	
	//error
	public static By error1 = By.xpath("//div[@class='form_error-message mt-25']");
	public static By countryerror = By.xpath("//div[@class='mt-25 ml-25 form_error-message']");
	
	
	public static By searchcompany = By.xpath("//input[@placeholder='Search']");
	public static By No_data = By.xpath("//div[contains(text(),'There are no records to display')]");
	public static By search_result = By.xpath("//div[@class='sc-dIfARi kNNa-dS rdt_TableBody']");
	public static By View_Row =By.id("row-0");
	public static By editcompany = By.xpath("//span[contains(text(),'Edit Company ')]");

	public static By CTA_Button = By.xpath("(//button[@type='button'])[11]");
	public static By Delete_Button = By.xpath("(//button[@type='button'])[13]");
	public static By Delete_Yes = By.xpath("//button[@class='swal-button swal-button--confirm swal-button--danger'][text()='OK']");
	public static By Delete_cancel = By.xpath("//button[@class='swal-button swal-button--cancel'][text()='Cancel']");
	public static By update_Save = By.xpath("//button[@type='submit']");
	public static By status = By.xpath("//span[@class='badge badge-success badge-pill']");
	public static By companyinfo = By.xpath("//span[@class='tab_name']");
	public static By company_website_info = By.cssSelector("div.challenge_status_cls > div:nth-child(1) > div:nth-child(2) > div.client_content");





	
	

}