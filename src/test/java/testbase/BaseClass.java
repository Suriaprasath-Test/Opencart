package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;  //Log4j
import org.apache.logging.log4j.Logger;  //Log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Properties p;
	public Logger logger;
	@SuppressWarnings("deprecation")
	@BeforeClass (groups= {"master","sanity","regression"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException {
		FileReader file =new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities cap =new DesiredCapabilities();
			
			// Chooseing OS based on parameter passed from XML file
			if(os.equalsIgnoreCase("Linux")) {
				cap.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("invalid OS");
				return;
			}
			
			switch(br) {
			case "chrome": cap.setBrowserName("chrome");break;
			case "firefox": cap.setBrowserName("firefox");break;
			case "edge": cap.setBrowserName("MicrosoftEdge");break;
			default  : System.out.println("invalid browser");return;
			
			}
			driver=new RemoteWebDriver(new URL("http://192.168.31.162:4444"),cap);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(br) {
			case "chrome": driver=new ChromeDriver();break;
			case "firefox": driver=new FirefoxDriver();break;
			case "edge": driver=new EdgeDriver();break;
			default  : System.out.println("invalid browser");return;
			}
		}
	
		
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass(groups= {"master","sanity","regression"})
	public void teardown() {
		driver.quit();
	}
	
	public String randomstring() {
		String generatedstring=RandomStringUtils.secure().nextAlphabetic(7);
		return generatedstring;
	}
	
	public String randomnumber() {
		String generatednumber=RandomStringUtils.secure().nextNumeric(9);
		return generatednumber;
	}
	
	public String randommail() {
		String generatedstring=RandomStringUtils.secure().nextAlphabetic(5);
		String generatednumber=RandomStringUtils.secure().nextNumeric(3);
		return (generatedstring+"@"+generatednumber);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
