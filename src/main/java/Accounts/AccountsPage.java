package Accounts;

import java.io.IOException;

import org.openqa.selenium.By;

import Base.BasePage;

public class AccountsPage extends BasePage{

	
	public AccountsPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateAccounts gotoCreateAccounts() throws IOException {
		
		click("Accounts_XPATH");
		
		return new CreateAccounts();
	}
	
     public void gotoImportAccounts() {
		
	}
     
     
}
