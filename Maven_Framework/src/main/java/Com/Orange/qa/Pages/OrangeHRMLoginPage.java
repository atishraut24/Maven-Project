package Com.Orange.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

import Com.OrangeHRM.qa.base.TestBase;

public class OrangeHRMLoginPage extends TestBase {


//1. Add all the element as private and using @findby annotations
	@FindBy(name = "username")
	private WebElement Username;
	
	@FindBy(name = "password")
	private WebElement Password;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement Loginbutton;
	
//  Take any Element in homepage to validate
	@FindBy (className = "oxd-userdropdown-name")
	private WebElement  HomepageUsername;
	
// 2. Create constructor of  given class and call initElement method from pagefactory class
	public OrangeHRMLoginPage() throws IOException {
		super();
		
			 PageFactory.initElements(driver, this);
			
		
	}
	 public boolean validateusername(String UN,String PWD) throws InterruptedException {
		 Username.sendKeys(UN);
		 Thread.sleep(3000);
		 Password.sendKeys(PWD);
		 Thread.sleep(3000);
		 Loginbutton.click();
		return HomepageUsername.isDisplayed();
		 
	 }
}
