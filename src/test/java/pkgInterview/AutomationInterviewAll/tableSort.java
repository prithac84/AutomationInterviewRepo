package pkgInterview.AutomationInterviewAll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tableSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
					
	System.setProperty("webdriver.chrome.driver", "C://Users//prith//Desktop//Pritha//TestingAll//udemytrainings//ArchitectTraining//all_train_workspace//AutomationInterviewAll//chromedriver_win32//chromedriver.exe");
	WebDriver driver=new ChromeDriver();

	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	
	List<WebElement> Elementlist = driver.findElements(By.cssSelector("tr td:nth-child(2)"));
ArrayList<String> orgList = new ArrayList<String>();

for(int i=0;i<Elementlist.size();i++)
{
	orgList.add(Elementlist.get(i).getText());
	}
System.out.println(orgList);

Collections.reverse(orgList);
System.out.println(orgList);

Collections.sort(orgList);
System.out.println(orgList);


	}
	
	

}
