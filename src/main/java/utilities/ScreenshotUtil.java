package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import Base.BasePage;

public class ScreenshotUtil extends BasePage {

public ScreenshotUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}



public static String fileName; 
	
	public static void captureScreenshot() throws IOException  {
		
		Date d = new Date();
		 fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";	
		
		
	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	//FileUtils.copyFile(screenshot, new File("./target/reports/"+fileName));
	//FileUtils.copyFile(screenshot, new File("./target/surefire-reports/html/"+fileName));
		
	FileUtils.copyFile(screenshot, new File(".//test-output//html//"+fileName));
	FileUtils.copyFile(screenshot, new File(".//reports//"+fileName));
		
	}
	


  public static void captureElementScreenshot(WebElement element) throws IOException {
	
	Date d = new Date();
	String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";	
	
	
	File	screenshot = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshot, new File(".//screenshot//"+fileName));

}

}



