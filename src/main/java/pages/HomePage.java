package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.BasePage;

public class HomePage extends BasePage{

	
	
	public HomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void goToSupport() {
	
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/a[2]")).click();

	}
	
	public void doSignUp() {
	
	driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/a[5]")).click();
		
	}

	public LoginPage goToLogin() throws IOException {
	
    click("login_XPATH");	
	
	return new LoginPage();
	}

	public void goToLanguage() {
		
	}

	public void goToLearnMore() {
		
	}

	public void validateFooterLinks() {
		
	}


}
