package com.leaftaps.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.utils.ExcelReaddata;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class projectspecific {

	public String filename;
	public String sheetname;
	public String Leadid;
	public String phonenum;
	public static Properties prop;

	// public static RemoteWebDriver driver;
	public RemoteWebDriver driver;

	@Parameters({ "language" })
	@BeforeMethod
	public void configProperties(String lang) throws IOException {
		FileInputStream fis = null;
		if (lang.equalsIgnoreCase("english"))
		{
			fis = new FileInputStream("./src/main/resources/English.properties");
		} 
		else if (lang.equalsIgnoreCase("french"))
		{
			fis = new FileInputStream("./src/main/resources/French.properties");
		}
		prop = new Properties();
		prop.load(fis);

	}

	@Parameters({ "url", "browsername" })
	@BeforeMethod
	public void launchBrowser(String url, String browsername) {

		if (browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions ch = new ChromeOptions();
			ch.addArguments("--disable-notifications");
			driver = new ChromeDriver(ch);
		}

		else if (browsername.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions eh = new EdgeOptions();
			eh.addArguments("--disable-notifications");
			driver = new EdgeDriver(eh);
		}

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		System.out.println("driver at before test: " + driver);
	}

	@AfterMethod
	public void Closebrowser() {
		driver.close();
	}

	@BeforeMethod
	@DataProvider
	public String[][] provideData() throws IOException {
		/*
		 * String[][] data = new String[2][5];
		 * 
		 * data[0][0] = "DemoSalesManager"; data[0][1] = "crmsfa"; data[0][2] =
		 * "TestLeaf"; data[0][3] = "Hari"; data[0][4] = "R";
		 * 
		 * data[1][0] = "DemoSalesManager"; data[1][1] = "crmsfa"; data[1][2] =
		 * "TestLeaf"; data[1][3] = "Venkatesh"; data[1][4] = "Babu";
		 */

		String[][] data = ExcelReaddata.exceldata(filename, sheetname);

		return data;
	}

}
