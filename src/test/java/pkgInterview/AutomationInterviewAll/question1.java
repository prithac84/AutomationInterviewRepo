package pkgInterview.AutomationInterviewAll;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.apache.commons.io.FileUtils;

public class question1 {

	
@Test
	public void question1map() throws IOException {
		
		//Initializing driver and launching amazon url
				String path = System.getProperty("user.dir");		
				System.setProperty("webdriver.chrome.driver", path+"//chromedriver_win32//chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		        driver.get("https://www.google.com/maps/");
		        driver.manage().window().maximize();
		        
		      //Initializing Explicit wait object
		        WebDriverWait wait = new WebDriverWait(driver, 20);
		        
		        //Searching for Wankhade stadium		        
		        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#searchboxinput")))).sendKeys("Wankhede Stadium");
		        driver.findElement(By.cssSelector("input#searchboxinput")).sendKeys(Keys.ENTER);
		      
		     //Save the screen shot image at this test execution instant
		     wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Stadium')]"))));   
		     File src = ((TakesScreenshot)driver).getScreenshotAs((OutputType.FILE));//we have to cast the driver object to take screenshot	     		 
		     FileUtils.copyFile(src, new File(path+"\\target\\scrshot.png"));     		      
		     
		     // Verify the Text Present “Stadium” in the left frame
		      String stadiumText = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Stadium')]")))).getText();
		      Assert.assertTrue(stadiumText.contains("Stadium"));	      
		     
		      //Verify the Title “Wankhede Stadium - Google Maps”
		      System.out.println(driver.getTitle());
		      Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Wankhede Stadium - Google Maps"));
		      
		       //Print the ratings point and number of reviews in the console.
		      String rating = driver.findElement(By.cssSelector("div.gm2-display-2")).getText();
		      System.out.println("Ratings Point: "+rating);
		      String reviewText = driver.findElement(By.xpath("//button[@class='jqnFjrOWMVU__button gm2-caption']")).getText();
		      System.out.println("No of Reviews: "+reviewText);
		       

	}

}
