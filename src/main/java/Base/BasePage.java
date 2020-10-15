package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.Status;

import extentListeners.ExtentListeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader; 

public class BasePage {

	public static WebDriver driver;
    
	public static Logger log = Logger.getLogger(BasePage.class.getName());
	
	public static Properties OR = new Properties();
	
	public static Properties Config = new Properties();
	
	public static FileInputStream fis;
	
	public static ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\TestData.xlsx");
	
	public static WebDriverWait wait;
	
	public static WebElement dropdown;
	
	public static TopMenu menu;
	
	
	public BasePage() throws IOException {
		
		if(driver==null) {
			
			PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");
			
			FileInputStream	 fis = new FileInputStream(".\\src\\test\\resources\\properties\\OR.properties"); 
			
			 OR.load(fis);
			 
			log.info("OR Properties loaded");
			 	
		 fis = new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties"); 
			
		 Config.load(fis);
		 
		log.info("Config Properties loaded");
			
			if(Config.getProperty("browser").equals("chrome")) {
				
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");	
				
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
				log.info("Chrome Browser Launched!!");
				
			}else if(Config.getProperty("browser").equals("firefox")) {
				
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				log.info("Firefox Browser Launched!!");
				
			}
			
		driver.get(Config.getProperty("testsiteurl"));
		log.info("Navigating to url:"+Config.getProperty("testsiteurl"));	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);	
		wait = new WebDriverWait(driver,Integer.parseInt(Config.getProperty("explicit.wait")));
		menu = new TopMenu(driver);
		
	}
	
	}
  
	public static void type(String key,String value) {
	
		if(key.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
			
		}else if(key.endsWith("_ID")) {
		
			driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
			
	}else if(key.endsWith("_CSS")) {
		
	
		driver.findElement(By.cssSelector(OR.getProperty(key))).sendKeys(value);
		
	}
	
		log.info("Typing in an Element:"+ key+"enterd the value as:"+value);
	
		ExtentListeners.test.log(Status.INFO, "Typing in an Element:"+ key+"enterd the value as:"+value); 	
  }
	
  public static void click(String key) {
		
		if(key.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(key))).click();
			
		}else if(key.endsWith("_ID")) {
		
			driver.findElement(By.id(OR.getProperty(key))).click();
			
	}else if(key.endsWith("_CSS")) {
		
	
		driver.findElement(By.cssSelector(OR.getProperty(key))).click();
		
	}
	
		log.info("Clicking on an Element:"+ key);
	
		ExtentListeners.test.log(Status.INFO, "Clicking on an Element:"+ key); 
		
  }
  
  
    public static void getText(String key) {
		
		if(key.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(key)));
			
		}else if(key.endsWith("_ID")) {
		
			driver.findElement(By.id(OR.getProperty(key)));
			
	}else if(key.endsWith("_CSS")) {
		
	
		driver.findElement(By.cssSelector(OR.getProperty(key)));
		
	}
	
		log.info("Get Text of an Element:"+ key);
	
		ExtentListeners.test.log(Status.INFO, "Get Text of an Element:"+ key); 
		
  }
  
  
  
    public static void select(String key,String value) {
		
		if(key.endsWith("_XPATH")) {
			
			dropdown =	driver.findElement(By.xpath(OR.getProperty(key)));
			
		}else if(key.endsWith("_ID")) {
		
			dropdown =	driver.findElement(By.id(OR.getProperty(key)));
			
	}else if(key.endsWith("_CSS")) {
		
	
		dropdown =	driver.findElement(By.cssSelector(OR.getProperty(key)));
		
	}
	
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		
		log.info("Selecting the value:"+ key+"selected value as:"+value);
	
		ExtentListeners.test.log(Status.INFO, "Selecting the value:"+ key+"selected value as:"+value); 
		
  }
  
  public static boolean isElementPresent(String key) {
		
	 	try {
		if(key.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(key)));
			
		}else if(key.endsWith("_ID")) {
		
			driver.findElement(By.id(OR.getProperty(key)));
			
	}else if(key.endsWith("_CSS")) {
		
	
		driver.findElement(By.cssSelector(OR.getProperty(key)));
		
	}
	
		log.info("Finding in an Element:"+ key);
		ExtentListeners.test.log(Status.INFO, "Finding in an Element:"+ key); 	
		
		return true;
		
		
	 }catch(Throwable t) {
		 
		 log.error("Error finding an element"+ key+"--Error log is"+t.getMessage()); 
		 ExtentListeners.test.log(Status.FAIL, "Error finding an element"+ key+"--Error log is"+t.getMessage()); 	
		 
		return false;
	 }
}
    
@AfterSuite
public void tearDown() {
	
	driver.quit();

}

}