package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Accounts.AccountsPage;
import Accounts.CreateAccounts;
import Base.BasePage;
import pages.ZohoAppPage;
import utilities.DataUtil;

public class CreateAccountTest extends BasePage{

	public CreateAccountTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(dataProviderClass=DataUtil.class, dataProvider="dp")
	public void createAccountTest(String Accountname) throws IOException {
		
		ZohoAppPage zp = new ZohoAppPage();
		zp.gotoCRM();
		AccountsPage ap  = BasePage.menu.gotoAccounts();
		CreateAccounts ca = ap.gotoCreateAccounts();
		ca.createAccount(Accountname);
		//Assert.fail("Failing login test");
	}

}
