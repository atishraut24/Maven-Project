package Com.OrangeHRM.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.Orange.qa.Pages.OrangeHRMHomePage;
import Com.Orange.qa.Pages.OrangeHRMLoginPage;
import Com.OrangeHRM.qa.base.TestBase;

public class HomePageTest extends TestBase {
	

	public HomePageTest() throws IOException {
		super();
	}
	OrangeHRMLoginPage Loginpage;
	OrangeHRMHomePage Homepage;
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		Loginpage=new OrangeHRMLoginPage();
		Homepage=new OrangeHRMHomePage();
	}
	@Test
	public void Employeename() throws InterruptedException {
		@SuppressWarnings("unused")
		boolean UserID=Loginpage.validateusername(props.getProperty("Username"), props.getProperty("Password"));
		Thread.sleep(2000);
		Homepage.ReporterPage(props.getProperty("Name"));
	}
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}

}


