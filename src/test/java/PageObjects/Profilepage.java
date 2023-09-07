package PageObjects;

import org.openqa.selenium.By;

public class Profilepage {

	public static By Profiel_Nav = By.xpath("//img[@alt='avatar']");
	public static By Edit_Profilebutton = By.xpath("//span[normalize-space()='Edit Profile']");
	
	
	//public static By name = By.xpath("//span[@class='tab_nameprf']");
	public static By name = By.xpath("//div[@class='client_content nam_prfui']");
	public static By email_id = By.xpath("//div[@class = 'client_content client_content-lower']");
	public static By bio = By.xpath("//div[@class='client_content']");
	public static By Contact_number = By.xpath("//div[@class='client_content']");
	public static By Availability_status = By.xpath("//span[@class = 'badge badge-success badge-pill']");
	
	
	public static By Edit_User_button = By.xpath("//button[@class = 'add-new-btn create_btn btn btn-outline-primary']");
	public static By  Edit_avatar = By.xpath("img[@alt='avatarImg']");
	public static By  Upload_image_button = By.xpath("//span[@class='mr-2 fonticon-wrap upct_ap upld_bth  ml-squad__edit-upload-img-btn-contianer']");
	//public static By  Edit_role =  By.xpath("//div[@class='select__placeholder css-1wa3eu0-placeholder']");
	public static By  Edit_role = By.xpath("//div[@class='select__indicators css-1wy0on6']");
	public static By  Edit_name = By.name("name");
	public static By  Edit_Gender = By.xpath("//div[@class='select__placeholder css-1wa3eu0-placeholder']");
	public static By  Edit_Bio = By.name("bio");
	public static By  Edit_Number = By.xpath("//input[@name='name'][@value='8217888347']");
	public static By  Edit_Email = By.name("email");
	public static By  Edit_EmployeeId = By.name("employee");
	public static By  Edit_Hiredate = By.name("date");
	public static By Edit_Department = By.name("department");
	public static By Edit_Designation = By.name("designation");
	//public static By  Edit_Designation = By.xpath("//div[@class='select__single-value css-1uccc91-singleValue']");
	public static By Edit_country =By.name("country");
	public static By  Edit_state = By.name("State");
	
	
	public static By Edit_cancel = By.xpath("//button[@type='button'][text()='Cancel']");
	public static By Edit_submit = By.xpath("//span[@class='mr-50']");
	
	
}
