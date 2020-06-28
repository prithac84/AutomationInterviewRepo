package pkgInterview.AutomationInterviewAll;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class question2 {

	@Test
	public void question2QAAgility() {
		//Initializing driver and launching amazon url
		String path = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver", path+"//chromedriver_win32//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.get("https://www.qaagility.com");
        driver.manage().window().maximize();
		
		
		/*a. The title contains “QAAgility” in it.*/
        System.out.println(driver.getTitle());
        Assert.assertTrue("Title does not contain QAAgility", driver.getTitle().contains("QAAgility"));
		
		
		/*b.Get the size attributes for the QAAgility logo on top left corner*/		
		System.out.println("Size of logo: "+driver.findElement(By.cssSelector("img.header-image")).getSize());
		
		/*Verify that Twitter” button is present at the top right. */		
		System.out.println("Twitter button Present: "+driver.findElement(By.xpath("//i[contains(@class,'fab fa-twitter')]")).isDisplayed());
		Assert.assertTrue("Twitter button not present", driver.findElement(By.xpath("//i[contains(@class,'fab fa-twitter')]")).isDisplayed());
		
		/*Ensure that the footer text is “QAAgility Technologies Pvt. Ltd. © 2018. All Rights Reserved.”*/		
		String footerText = driver.findElement(By.cssSelector("div.copyright-bar")).getText();
		System.out.println(footerText);
		Assert.assertTrue("FooterText Not matching", footerText.contentEquals("QAAgility Technologies © 2020. All Rights Reserved"));

	}

}
