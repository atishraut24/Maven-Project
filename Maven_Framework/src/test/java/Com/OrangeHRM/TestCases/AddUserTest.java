package Com.OrangeHRM.TestCases;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.Orange.qa.Pages.OrangeHRMAddUserPage;
import Com.Orange.qa.Pages.OrangeHRMHomePage;
import Com.Orange.qa.Pages.OrangeHRMLoginPage;
import Com.OrangeHRM.qa.base.TestBase;

public class AddUserTest extends TestBase {

	public AddUserTest() throws IOException {
		super();	
	}
	OrangeHRMAddUserPage adduser;
	OrangeHRMHomePage Homepage;
	OrangeHRMLoginPage Loginpage;
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		Homepage=new OrangeHRMHomePage();
		adduser=new OrangeHRMAddUserPage();
		Loginpage=new OrangeHRMLoginPage();	
	}
	@Test
	public void AddUsrs() throws InterruptedException {
		boolean UserID=Loginpage.validateusername(props.getProperty("Username"), props.getProperty("Password"));
		Thread.sleep(2000);
	    String returns=adduser.OrangeAddUser(props.getProperty("FirstName"), "MiddleName", "LastName", "EmpId");
	    System.out.println(returns);
	}
	
	
	
	

}
