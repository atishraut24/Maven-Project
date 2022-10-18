package Com.Orange.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.OrangeHRM.qa.base.TestBase;

public class OrangeHRMHomePage extends TestBase {
	@FindBy(xpath = "(//a[@class='oxd-topbar-body-nav-tab-item'])[3]")
	private WebElement Reports;
	
	@FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
	private WebElement ReporterName;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement SubmitButton;

	public OrangeHRMHomePage() throws IOException {
	
		PageFactory.initElements(driver, this);	
	}
	
	public String ReporterPage(String Name) {
		Reports.click();
		ReporterName.sendKeys(Name);
		SubmitButton.click();
		return ReporterName.getText();
	}

}
