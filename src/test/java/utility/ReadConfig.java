package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			System.out.println("Not able to read congig file " + e.getMessage());
		}
	}

	public String getBrowser() {
		String getBrowser = pro.getProperty("browserName");
		return getBrowser;

	}

	

	public String loginurl() {
		String loginurl = pro.getProperty("loginurl");
		return loginurl;
	}

	public String category() {
		String categories = pro.getProperty("categories");
		return categories;

	}

	public String subject() {
		String subject = pro.getProperty("subjects");
		return subject;

	}

	public String topics() {
		String topics = pro.getProperty("topics");
		return topics;

	}

	public String deck() {
		String decks = pro.getProperty("decks");
		return decks;
	}


	public String flashcards() {
		String flashcards = pro.getProperty("flashcards");
		return flashcards;
	}

	public String klp() {
		String klp = pro.getProperty("klps");
		return klp;
	}

	public String Questions() {
		String Questions = pro.getProperty("Questions");
		return Questions;
	}


	public String Challenge() {
		String Challenge = pro.getProperty("Challenge");
		return Challenge;
	}
	public String Certifications() {
		String Certifications = pro.getProperty("Certifications");
		return Certifications;
	}
	
	public String LearnQuest() {
        String LearnQuests = pro.getProperty("LearnQuest");
        return LearnQuests;
    }


	public String Goals() {
		String Goals = pro.getProperty("Goals");
		return Goals;
	}


	// add methods to read different parameters from config file
	public String learnersurl() {
		String learnersurl = pro.getProperty("learnerurl");
		return learnersurl;

	}

	public String squads() {
		String squads = pro.getProperty("squads");
		return squads;
	}

	public String SuperAdminURL() {
		String SuperAdminURL = pro.getProperty("SuperAdminURL");
		return SuperAdminURL;
	}

	public String Company() {
		String Company = pro.getProperty("Company");
		return Company;
	}

	public String DetailsPage() {
		String DetailsPage = pro.getProperty("DetailsPage");
		return DetailsPage;
	}

	public String UserWebApp() {
		String UserWebApp = pro.getProperty("UserWebApp");
		return UserWebApp;
	}
	public String TodoChallenges() {
		String UserWebApp = pro.getProperty("TodoChallenges");
		return UserWebApp;
	}
	

	/*
	 * //mobile public String filepath() { String filepath =
	 * pro.getProperty("filepath"); return filepath; } public String APK() { String
	 * APK = pro.getProperty("APK"); return APK;
	 * 
	 * }public String deviceName() { String deviceName =
	 * pro.getProperty("deviceName"); return deviceName;
	 * 
	 * } public String udid() { String udid = pro.getProperty("udid"); return udid;
	 * 
	 * }public String port() { String port = pro.getProperty("port"); return port;
	 * 
	 * }
	 */


}
