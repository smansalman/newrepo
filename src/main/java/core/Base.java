package core;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class Base {
	public static WebDriver driver;
	public static Properties properties;
	public static Logger Logger;

	private String userDirectory = System.getProperty("user.dir"); // C:\Users\SIDDIQUE\eclipse-workspace\\us.tekschool.bdd.sdet
	private String ppfile = "\\src\\test\\resources\\inputData\\projectProperty.properties";
	private String pathToPP = userDirectory + ppfile;
	

	public Base() {
		try {
			// file reader is reading the file and buffer reader reads the text from property file
			BufferedReader reader;
			reader = new BufferedReader(new FileReader(pathToPP));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// it will take the logger file 
		Logger = Logger.getLogger("Logger_file");
		PropertyConfigurator.configure(".\\src\\test\\resources\\inputData\\log4j.properties");

	}

	public static String getBrowserName() {
		// we are getting data from properties file thats why we are using properties here.
		// properties file is using hashTable so the key is on the left side of equality in property file 
		// and value is on the right side
		String browserName = properties.getProperty("browser");
		return browserName;
	}

	public static String getURL() {
		String url = properties.getProperty("url");
		return url;
	}

	public static long getImpwait() {
		String impWait = properties.getProperty("implicitlyWait");
		return Long.parseLong(impWait);
	}

	public static long getPLTimeOut() {
		String pLTimeOut = properties.getProperty("pageLoadTimeOut");
		return Long.parseLong(pLTimeOut);
	}

	public static void initializeDriver() {
		driver.get(getURL());
	}

	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
