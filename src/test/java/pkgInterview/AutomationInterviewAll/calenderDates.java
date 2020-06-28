package pkgInterview.AutomationInterviewAll;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class calenderDates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Users//prith//Desktop//Pritha//TestingAll//udemytrainings//ArchitectTraining//all_train_workspace//AutomationInterviewAll//chromedriver_win32//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='departure']")).click();
		
		//<div class="DayPicker-Day" tabindex="-1" role="gridcell" aria-label="Thu Jun 11 2020" aria-disabled="false" 
		//aria-selected="false"><div class="dateInnerCell"><p>11</p><p class=" todayPrice">4994</p></div></div>

		//<div class="DayPicker-Day" tabindex="-1" role="gridcell" aria-label="Sat Jul 18 2020" aria-disabled="false" aria-selected="false"><div class="dateInnerCell"><p>18</p><p class=" todayPrice">4994</p></div></div>
		
		//#root > div > div.minContainer > div > div > div.fsw.widgetOpen > div.fsw_inner > div.fsw_inputBox.dates.inactiveWidget.activeWidget > div.datePickerContainer > div > div > div > div.DayPicker > div > div.DayPicker-Months > div:nth-child(1) > div.DayPicker-Body > div:nth-child(3) > div:nth-child(7)
		////*[@id="root"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[3]/div[7]
	}

}
