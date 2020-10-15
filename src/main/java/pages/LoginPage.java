package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.BasePage;

public class LoginPage extends BasePage {

	
	
	    public LoginPage() throws IOException {
		super();
		
	}

		public ZohoAppPage doLogin(String username,String password) throws IOException {
		
		type("Email_XPATH",username);
	
		click("ButtonID_XPATH");

		type("Password_XPATH",password);
	
		click("SignIn_XPATH");
	
		return new ZohoAppPage();
	}

	

}
