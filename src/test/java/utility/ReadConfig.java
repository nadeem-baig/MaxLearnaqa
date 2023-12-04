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
	
	public String CST() {
		String CST = pro.getProperty("CST");
		return CST;
	}
	
	public String departments() {
		String departments = pro.getProperty("departments");
		return departments;
	}
	public String admin_department() {
		String admin_department = pro.getProperty("admin_department");
		return admin_department;
	}
	public String DidyouKnow() {
		String DidyouKnow = pro.getProperty("DidyouKnow");
		return DidyouKnow;
	}
	public String admin_forgotpass() {
		String admin_forgotpass = pro.getProperty("admin_forgotpass");
		return admin_forgotpass;
	}
	public String helpandsupport() {
		String helpandsupport = pro.getProperty("helpandsupport");
		return helpandsupport;
	}
	
	public String Job_title() {
		String Job_title = pro.getProperty("Job_title");
		return Job_title;
	}
	public String Lerners_upload() {
		String Lerners_upload = pro.getProperty("Lerners_upload");
		return Lerners_upload;
	}
	
	public String Permissions() {
		String Permissions = pro.getProperty("Permissions");
		return Permissions;
	}
	
	public String userroles() {
		String userroles = pro.getProperty("userroles");
		return userroles;
	}
	
	public String questions_upload() {
		String questions_upload = pro.getProperty("questions_upload");
		return questions_upload;
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
	public String Forgotpass() {
		String UserWebApp = pro.getProperty("Forgotpass");
		return UserWebApp;
	}
	
	public String Reset() {
		String UserWebApp = pro.getProperty("Reset");
		return UserWebApp;
	}
	
	public String Learntab() {
		String UserWebApp = pro.getProperty("Learntab");
		return UserWebApp;
	}
	public String Squadpage() {
		String UserWebApp = pro.getProperty("Squadpage");
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
