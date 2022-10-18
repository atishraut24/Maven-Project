package Com.Orange.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.OrangeHRM.qa.base.TestBase;

public class OrangeHRMAddUserPage extends TestBase {
	

	@FindBy(xpath = "(//a[@class=\"oxd-topbar-body-nav-tab-item\"])[2]")
	private WebElement AddUser ;
	
	@FindBy (name = "firstName")
	private WebElement Fname;
	
	@FindBy(name = "middleName")
	private WebElement Mname;
	
	@FindBy(name="lastName")
	private WebElement Lname;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
     private WebElement  EID;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement Sbutton;
	
	public OrangeHRMAddUserPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	public String OrangeAddUser(String FirstName,String MiddleName,String LastName,String EmpID) {
		AddUser.click();
		Fname.sendKeys(FirstName);
		Mname.sendKeys(MiddleName);
		Lname.sendKeys(LastName);
		EID.sendKeys(EmpID);
		Sbutton.click();
		
		
		return  "deepak";
		
	}
	
		
	

}
