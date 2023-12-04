package PageObjects;

import org.openqa.selenium.By;

public class JobTitlePages {
	
	public static By Edit = By.xpath("(//*[name()='svg'][@class='cursor-pointer mr-1 edit_trash'])[3]");
	public static By Toggle = By.xpath("(//div[@class='ant-switch-handle'])[2]");
	public static By Department_Title = By.xpath("//DIV[@class='select__value-container select__value-container--has-value css-1hwfws3']");
	public static By Job_Title = By.xpath("//INPUT[@id='data-name']");

	public static By Cancel = By.xpath("//BUTTON[@type='button'][text()='Cancel']");
	public static By Update = By.xpath("//BUTTON[@type='submit']");
	public static By error = By.xpath("(//div[@class='form_error-message mt-25'])[1]");
	public static By Delete = By.xpath("(//*[name()='svg'][@class='cursor-pointer mr-1 edit_trash'])[4]");

}
