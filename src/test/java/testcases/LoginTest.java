package testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import Accounts.AccountsPage;
import Accounts.CreateAccounts;
import Base.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.ZohoAppPage;
import utilities.DataUtil;

public class LoginTest extends BasePage {

	public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(dataProviderClass=DataUtil.class, dataProvider="dp")
	public void loginTest(String username,String password) throws IOException, InterruptedException {
		
		HomePage home = new HomePage();
		LoginPage lp =home.goToLogin();
	
		Thread.sleep(2000);
		lp.doLogin(username,password);
		//Assert.fail("Failing login test");
	
	}

}
