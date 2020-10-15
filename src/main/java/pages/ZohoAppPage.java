package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.BasePage;

public class ZohoAppPage extends BasePage {

	
	public ZohoAppPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	public void gotoChat() {
		
		driver.findElement(By.xpath("//*[@id=\"zl-myapps\"]/div[1]/div[4]/div/a/span")).click();
	}
	
	
	public void gotoCRM() {
		
		click("CRM_XPATH");
		
	}


	public void gotoWorkDrive() {
		
		driver.findElement(By.xpath("//*[@id=\"zl-myapps\"]/div[1]/div[12]/div/a/span")).click();
	
	}

}
