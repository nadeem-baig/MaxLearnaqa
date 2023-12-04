package webAppPageObjects;

import org.openqa.selenium.By;

public class ChallengesObjects {

	
	public static By ToDo_Tab =By.linkText("To-Do");
	public static By Challenges_Tab=By.xpath("//button[@id='uncontrolled-tab-example-tab-challenges']");
	
	
	//empty challenges screen
	public static By Empty_challenges_header = By.xpath("//h2[@class='empty__squadChallenge-text-header']");
	public static By Empty_challenges_subheader =By.xpath("//p[@class='empty__squadChallenge-text-subHeader']");
	
	
	//activity log
	public static By Empty_Activity_header = By.xpath("//h2[@class='empty__card__header']");
	public static By Empty_Activity_subheader = By.xpath("//p[@class='empty__card__subHeader']");
	public static By Challenges_count = By.xpath("//DIV[@class='max-home__quest-wrapper max__activity-quest-card-bg-bt max__activity-quest-card-rad  max__activity-quest-card ']");
	public static By Certification_count = By.xpath("//DIV[@class='max-home__quest-wrapper mb-0']");

	public static By status = By.xpath("//div[@class='quest-home__progress']");
	public static By Challenge = By.xpath("//*[@id=\"scrollableDiv\"]/div/div/div/button/div/div/div[1]/div/div/h3");
	public static By status1 = By.xpath("//*[@id=\"scrollableDiv\"]/div/div/div/button/div/div/div[1]/div/div/div[2]/div[2]/span");
	public static By startChallenge = By.xpath("//button[@class='filled__custombutton'][text()='Start Challenge']");
	public static By Goals = By.xpath("//DIV[@class='max-learn__goal-card d-flex max-home__quest-wrapper-ani']");
	public static By Goals_status = By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-goals\"]/div/div/div/div/div/div/a/div/div/div/div/div[2]");


	
	//challenge Detail Page
	public static By names = By.xpath("//p[@class='team__info--name']");
	public static By Detail_Close = By.xpath("//button[@class='close__button pt-5']");
 
	public static By close = By.xpath("//button[@class='close_btn right-0']");
	public static By yes_close = By.xpath("//button[@class='swal-button swal-button--confirm swal-button--danger'][text()='Yes, I am sure!']");
	public static By timer = By.xpath("//*[@class='header-timer']");
	public static By upcomming = By.xpath("//button//span[text()='Get updates on your upcoming Challenges']");
	public static By upcomming_close = By.xpath("(//button[@type='button'])[4]");
	public static By upcomming_view = By.xpath("(//h4[@class='modal__body-header'])");
	public static By Team_Names = By.xpath("//span[@class='team_name']");
	public static By Question_count = By.cssSelector("div.question_detail.col > div > div");
	
	public static By No_Of_Questions= By.xpath("//div[contains(text(),'Question -')]");//div[normalize-space()='Question - 1 OF 5']
	public static By put_in_order= By.xpath("//p[contains(text(),'PUT IN ORDER QUESTION')]");
	public static By single_choice= By.xpath("//p[normalize-space()='SINGLE SELECT QUESTION']");
	public static By multi_select= By.xpath("//p[normalize-space()='MULTI SELECT QUESTION']");
	public static By Truefalse= By.xpath("//p[contains(text(),'TRUE OR FALSE QUESTION')]");
	//opt 1
	public static By option1= By.xpath("//div[contains(@class,'col-sm-5 mt-4 mr-1 mb-4 col')]/button[1]");	
	public static By option2= By.xpath("//div[contains(@class,'col-sm-5 mt-4 mr-1 mb-4 col')]/button[2]");	
	
	//submit answer
	public static By submit= By.xpath("//a//button[contains(@type,'button')]"); //button[normalize-space()='Submit answer']
	
	//confidence monitor
	public static By confidencemonitor= By.xpath("//div[contains(text(),'How confident are you of this answer?')]");
	//let me try
	public static By letmetry= By.xpath("//button[contains(text(),'Let me retry')]");  	//button[@class="challenge__outline-btn "]
	//continue to next question
	public static By continue_QA = By.xpath("//button[contains(text(),'Yes, continue')]");   //button[@class="challenge__filled-btn"]
	
		
		
	public static By squad_logo = By.xpath("//img[@class='team__info-logo-image']");
	//click on it and capture total members
	public static By squad_memberscount=By.xpath("//div[@class='member__wrapper col-12']");
	//close sqd details
	public static By close_Squad_details = By.xpath("//div[contains(@class,'backdrop')]//button[contains(@class,'close__button')]");
}
