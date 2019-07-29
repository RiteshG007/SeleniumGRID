import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestGrid {
	DesiredCapabilities cap = null;
	RemoteWebDriver driver;
	
	  @Parameters("browser")
	  @BeforeClass(alwaysRun = true)
	  public void setUp(String browser) throws Exception {
		  if(browser.equals("chrome"))
		  {
			  	  cap = DesiredCapabilities.chrome();
				  cap.setBrowserName("chrome");
				  cap.setPlatform(Platform.ANY);
				  // cap.setVersion(version);
				  //cap.
		  }
		  else if(browser.equals("ff"))
		  {			  
			  cap = DesiredCapabilities.firefox();
			  cap.setBrowserName("firefox");
			  cap.setPlatform(Platform.ANY);  
	      }
			  
		 
		    driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			driver.get("http://localhost:100/");
	  }
		
		
		
		
		
		@Test
		public void logintest()
		{
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		}
	}


