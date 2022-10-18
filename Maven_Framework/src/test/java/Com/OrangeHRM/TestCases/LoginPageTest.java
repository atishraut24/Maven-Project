package Com.OrangeHRM.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Com.Orange.qa.Pages.OrangeHRMLoginPage;
import Com.OrangeHRM.qa.base.TestBase;

public class LoginPageTest extends TestBase{
	public LoginPageTest() throws IOException {
		super();
		
	}
	OrangeHRMLoginPage Loginpage;
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		Loginpage=new OrangeHRMLoginPage();
	}
	@Test
	public void OrangeUsername() throws InterruptedException {
		@SuppressWarnings("unused")
		boolean UserID=Loginpage.validateusername(props.getProperty("Username"), props.getProperty("Password"));
		Assert.assertTrue(false);
	}
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}

}
