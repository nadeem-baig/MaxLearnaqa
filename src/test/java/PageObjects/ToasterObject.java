package PageObjects;

import org.openqa.selenium.By;

public class ToasterObject {

	public static By toaster = By.className("Toastify");

	// scrollbar xpath

	public static By innerscroll = By.xpath("(//div[@class='ps__thumb-y'])[2]");
	//to update status for 1st row
	public static By status=By.xpath("//div[@id='row-0']//*[@name='status']");
	//flashcard status update
	public static By status2=By.xpath("//tbody[@id='demo']//*[@name='status']");
}
