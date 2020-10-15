package Base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Accounts.AccountsPage;

public class TopMenu {
	
	WebDriver driver;
	
	public TopMenu(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public void gotoHome() {

	}

	public void gotoLeads() {

	}

	public void gotoContacts() {

		
	}

	public AccountsPage gotoAccounts() throws IOException {

		BasePage.click("Account_XPATH");
	
		return new AccountsPage();
	
	}

	public void gotoDeals() {

	}

	public void gotoActivities() {

	}

	public void signOut() {
		
	}
}

