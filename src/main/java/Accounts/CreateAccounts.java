package Accounts;

import java.io.IOException;

import org.openqa.selenium.By;

import Base.BasePage;

public class CreateAccounts extends BasePage {

	
	public CreateAccounts() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void createAccount(String username) {
	
		click("CreateAccount_XPATH");
		type("AccountName_XPATH",username);
	
	}
}
