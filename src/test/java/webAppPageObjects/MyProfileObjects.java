package webAppPageObjects;

import org.openqa.selenium.By;

public class MyProfileObjects {
	public static By profile_dropdown = By.id("profile-dropdown");
	public static By MyProfile = By.xpath("//li[normalize-space()='My profile']");
	public static By Transcripts = By.xpath("//li[normalize-space()='My Transcripts']");
	public static By Transcripts_search = By.xpath("//INPUT[@placeholder='What you looking for?']");
	public static By Transcripts_count = By.xpath("(//BUTTON[@class='activity__card__wrapper transcript__card__wrapper']");

	
	public static By profilename = By.xpath("//h4[@class='user__profile-name']");
	public static By Edit_profile_iocn =  By.xpath("//div[@class='edit']");
	public static By avatar_img =  By.xpath("(//img[@alt='avatars'])[3]");
	public static By submit_avatar =  By.xpath("//button[normalize-space()='Submit Avatar']");
	
	public static By your_Squad_tab = By.xpath("//button[text()='Your team']");
	public static By your_Squad_header =By.xpath("//p[@class='your__squad-header']");
	public static By Squad_Number_row = By.xpath("//div[@class='table__row-wrapper row']");
	public static By Squad_members = By.xpath("//button[@id='uncontrolled-tab-example-tab-members']");
	public static By score = By.xpath("//h6[@class='total__points'][1]");

	
	public static By Squad_Challenges_tab = By.id("uncontrolled-tab-example-tab-challenges");
	public static By Squad_Challenge_header = By.xpath("(//*[contains(text(), 'squad1')]/ancestor-or-self::*/descendant::*/H2[contains(text(), 'Your')])[1]");
	
	public static By Basic_info_tab = By.id("uncontrolled-tab-example-tab-basicInfo");
	public static By Basic_info_edit=By.xpath("//span[@class='basic-info-edit-btn']");
	public static By Bio= By.id("bio-name");
	public static By mobileNo= By.name("mobileNo");
	public static By language = By.xpath("//select[@class='select__input']");
	public static By password = By.name("password");
	public static By profile_submit= By.id("profile-submit");
	public static By Empty_Header = By.xpath("//h2[@class='empty__squadChallenge-text-header']");
	public static By TotalMembers = By.xpath("//div[@class='undefined d-flex align-items-center justify-content-between squad-details-container']");
	public static By close = By.xpath("//button[@class='btn-close']");
	public static By Empty_challenges_header = By.xpath("//h2[@class='empty__squadChallenge-text-header']");
	public static By Empty_challenges_subheader =By.xpath("//p[@class='empty__squadChallenge-text-subHeader']");
	public static By Empty_Transcripts =By.xpath("//H2[@class='empty__card__header']");

	
	public static By Challenges_count = By.xpath("//div[@class='quest-time-details']");
	public static By Analytics = By.xpath("//button[text()='My Analytics']");
	public static By text1 = By.xpath("//H2[@class='analytics__header my-3 mt-2'][text()='Get insights on your topics']");
	public static By text2 = By.xpath("//H2[@class='analytics__header my-3 mt-2'][text()='Get insights on your challenges']");


	public static By Required_Error = By.xpath("//div[@class='form_error-message mt-25']");
	
	
	public static By ChangePassword = By.xpath("//button[@class='change__password']");
	public static By Old_pass = By.xpath("//INPUT[@id='oldPassword']");
	public static By New_pass = By.xpath("//INPUT[@id='newPassword']");
	public static By Confirm_pass = By.xpath("//INPUT[@id='confirmPassword']");
	public static By Submit = By.xpath("//BUTTON[@type='submit']");
	public static By error=By.xpath("//p[@class='Log_err m-0']");
	
}
