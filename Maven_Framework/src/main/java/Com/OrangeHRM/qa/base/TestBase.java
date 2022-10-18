package Com.OrangeHRM.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;
import Com.OrangeHRM.qa.Util.TestUtil;
import net.bytebuddy.utility.RandomString;

public class TestBase {
	//1. Declare variables as public and static
	public static WebDriver driver;
	public static Properties props;
	
	// 2. Create constructor including the object of properties class and fileinputstream class
	// add method load() present in properties class
	
	public TestBase() throws IOException {
		props=new Properties();
		FileInputStream fip=new FileInputStream("C:\\Users\\Atish Arun Raut\\eclipse-workspace\\Maven_Framework\\src\\main\\java\\Com\\OrangeHRM\\qa\\config\\config.properties");
		props.load(fip);
		
	}
	// 3. Create methods and setup steps
	   public static void initialization() {
		   System.setProperty("webdriver.chrome.driver", "C:\\Installations\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		   driver.get(props.getProperty("url"));
	   }
	   
	   public String getScreenshotAs(String testCaseName) throws IOException {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
					
			File source =ts.getScreenshotAs(OutputType.FILE);
			String Random = RandomString.make(5);		
			String destination = System.getProperty("user.dir")+"/reports/"+testCaseName+""+Random+".png";
			
			//Files.copy(source, new File(destination));
			FileUtils.copyFile(source, new File(destination));

			

		return destination;
		   
	   }
	

}
