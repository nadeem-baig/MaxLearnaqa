package webAppPageObjects;

import org.openqa.selenium.By;

public class LearnTab_Pages {
	
	public static By LearnTab_Button = By.xpath("(//A[@href='/learn'])[1]");
	public static By Hot_Topics_title = By.xpath("//H3[text()='Hot topics for the day']");
	public static By count_topics = By.xpath("//div[@class='silder-topics-container']//div[@class='row']");
	public static By View_all = By.xpath("(//BUTTON[text()='View all'])[1]");
	public static By View_detail = By.xpath("//H4[@class='modal__body-header']");
	public static By details_close = By.xpath("(//BUTTON[@type='button'])[2]");
	public static By continue_learning_heading = By.xpath("//H3[@class='ps-3'][text()='Continue your learning']");
	public static By continue_learning_count = By.xpath("//div[@class='row learning-card-row']");
	public static By continue_learning_viewall= By.xpath("(//BUTTON[text()='View all'])[2]");
	public static By continue_learning_detail= By.xpath("//h4[@class='modal__body-header']");
	public static By Learn_Title= By.xpath("//H3[text()='Learn by category']");
	public static By Learn_category_count= By.xpath("(//DIV[@class='max-learn__catergory-card bg-opacity-50'])");
	public static By Learn_viewall= By.xpath("(//A[@href='/learn/category-list'])[2]");
	public static By Learn_detail= By.xpath("//div[@class='category_row__heading']");
	public static By Goals= By.xpath("//H3[@class='ps-3'][text()='Goals']");
	public static By Goals_count= By.xpath("(//DIV[@class='max-learn__goal-card d-flex max-home__quest-wrapper-ani'])");
	public static By Category= By.xpath("(//DIV[@class='max-learn__catergory-card bg-opacity-50'])[1]");
	public static By Category_view= By.xpath("//div[@class='topic_name']");
	public static By Category_Subjects_count= By.xpath("(//DIV[@class='category_subject__wrapper']");
	public static By Quizme= By.xpath("//DIV[@class='card_quiz_button cursor-pointer']");
	public static By Quizme_close= By.xpath("(//*[name()='use'])[6]");

	public static By Subject= By.xpath("//DIV[@class='category_subject__wrapper']");
	public static By Topics_count= By.xpath("(//DIV[@class='max-learn__learning-card d-flex'])");
	public static By Subject_view= By.xpath("(//DIV[@class='max-learn__learning-card d-flex'])[1]");
	public static By Topic= By.xpath("//DIV[@class='topic-card-wrapper']");
	
	public static By deck= By.xpath("//DIV[@class='topic-card-wrapper']");
	public static By flash_close= By.xpath("//button[@class='detail_close flash-card-wrapper__close_button']");
	
	public static By Empty_learning_header= By.xpath("//h2[@class='empty__squadChallenge-text-header']");
	public static By Empty_learning_subheader= By.xpath("//p[@class='empty__squadChallenge-text-subHeader']");
	public static By empty_topics= By.xpath("(//div[@class='subject_description'])");





	












	




}
