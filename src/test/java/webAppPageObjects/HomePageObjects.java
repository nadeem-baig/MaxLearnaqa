package webAppPageObjects;

import org.openqa.selenium.By;

public class HomePageObjects {
	
	public static By Username = By.xpath("//h2[@class='user_name']");
	public static By home_button = By.xpath("//a[@aria-current='page']");
	public static By Empty_Header = By.xpath("//h4[@class='empty__home--text_header'][text()='No challenge has been assigned to you!']");
	public static By Empty_challenges_subheader =By.xpath("//P[@class='empty__home--text_subHeader'][text()='Challenges will appear here once it has assigned by the administrator.']");
	public static By challenges =By.xpath("//div[@class='d-flex max-home_challenges__card-container']");
	public static By viewAll_Button =By.xpath("//button[contains(text(),'View all')]");
	public static By todo_view =By.xpath("(//H2)[1]");





}
	


