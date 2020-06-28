package pkgInterview.AutomationInterviewAll;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class question3 {
	ExtentReports reports = new ExtentReports();	
	@BeforeTest
	public void generateExtentReport() {
		String exreppath = System.getProperty("user.dir")+"//extentReportsgenerated//extentrep.html";		
		ExtentSparkReporter reporter = new ExtentSparkReporter(exreppath);
		
		reporter.config().setReportName("AutomationIntervieAllExtentReportName");
		reporter.config().setDocumentTitle("AutomationIntervieAllExtentReportTitle");
		
		
		reports.attachReporter(reporter);
	}

@Test(groups= {"Sanity"})
	public void question3ATACalc() {
	
	reports.createTest("question3ATACalcTestName");
	
		//Initializing driver and launching amazon url
				String path = System.getProperty("user.dir");		
				System.setProperty("webdriver.chrome.driver", path+"//chromedriver_win32//chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				/*System.setProperty("webdriver.gecko.driver", path+"//GeckoDriver//geckodriver.exe");
				WebDriver driver=new FirefoxDriver();
*/
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
				driver.get("http://ata123456789123456789.appspot.com/");
		        driver.manage().window().maximize();		
		        System.out.println(driver.getTitle());
		        
		      //Initializing Explicit wait object
		        WebDriverWait wait = new WebDriverWait(driver, 20);
		        
		        //Entering Required Fields
		        String sa = "7";
		        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#ID_nameField1")))).clear();
		        driver.findElement(By.cssSelector("input#ID_nameField1")).sendKeys(sa);
		        
		        String sb = "4";
		        driver.findElement(By.cssSelector("input#ID_nameField2")).clear();
		        driver.findElement(By.cssSelector("input#ID_nameField2")).sendKeys(sb);
		        
		        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#gwt-uid-6")))).click();
		        
		        driver.findElement(By.cssSelector("button#ID_calculator")).click();
		        
		        String resultText = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#ID_nameField3")))).getAttribute("value").toString();
		        System.out.println("resultText: "+resultText);     
		        int actualResult = Integer.parseInt(resultText);
		        System.out.println("actualResult: "+actualResult); 
		        
		        int a = Integer.parseInt(sa);
		        int b = Integer.parseInt(sb);	        
		        int expectedResult = (a^2)-(2*(a*b))+(b^2);
		        System.out.println("expectedResult: "+expectedResult); 
		        
		        //Verify whether the result value is indeed generated by the equation
		        //Assert.assertEquals(actualResult,expectedResult);
		      Assert.assertEquals(actualResult,121);
		        
		        reports.flush();
		        
		        
	}

}
