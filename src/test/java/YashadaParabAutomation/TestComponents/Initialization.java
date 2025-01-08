package YashadaParabAutomation.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import YashadaParabAutomation.pageObjects.LandingPage;

public class Initialization {
	public WebDriver driver;

	public LandingPage creds;

	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream files = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\test\\java\\YashadaParabAutomation\\GlobalData\\GlobalData.properties");
		prop.load(files);
		String browserName =System.getProperty("browser")!=null ?System.getProperty("browser") :prop.getProperty("browser");
		//String browserName = prop.getProperty("browser");
		
		
		if (browserName.contains("Chrome")) {
			ChromeOptions options=new ChromeOptions();
			if (browserName.contains("headless")){
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,990));
		}

		else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;

	}

	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {

		// Read data from json file to string
		String jsonContent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);

		// Read data from String to HashMap using Jackson DataBind
		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getSS(String stringname,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "//SELENIUM//" + stringname + ".jpg");
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir") + "//SELENIUM//" + stringname + ".jpg";
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApp() throws IOException {
		driver = initializeDriver();
		creds = new LandingPage(driver);
		creds.goTo();
		return creds;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
