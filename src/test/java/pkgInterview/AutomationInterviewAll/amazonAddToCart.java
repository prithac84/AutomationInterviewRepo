package pkgInterview.AutomationInterviewAll;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class amazonAddToCart {
	
	@Test
    public void SearchAndAdd() throws InterruptedException{
		
		//Initializing driver and launching amazon url
		String path = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver", path+"//chromedriver_win32//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        
        //Initializing Explicit wait object
        WebDriverWait wait = new WebDriverWait(driver, 20);
        
        //Searching for product1
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("sugar");
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
        
        //Storing all the search results in a List
        List<WebElement> allSugarList = driver.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']"));
        
        //Adding first item of the search list to cart after getting its price  
        int price1 = 0;
        for(int i=1;i<=1;i++) {	    	
	    	allSugarList.get(i).click();
	    	
	    	//Handling windows with window handler as new window opens on clicking the product
	    	Set<String>s1=driver.getWindowHandles();	    	 
	    	Iterator<String> I1= s1.iterator();	    	
	    	String parentId = I1.next();//Gets the parent window id
	    	String childId = I1.next();// Gets child window id
	    	driver.switchTo().window(childId);
	    	
	    	//Extracting Price of first item to be added to cart and converting it to Integer    	
	    	String strPrice = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='a-size-medium a-color-price priceBlockBuyingPriceString']")))).getText();
	    	price1 = getPrice(strPrice);//getPrice used to get the price only and convert it to integer
	    	
	    	//Clicking on Add To Cart button	    	
	    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#add-to-cart-button")))).click();
	    	driver.switchTo().window(parentId);  	 	
	    }
        
      //Searching for product2
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).clear();
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("salt");
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
        
      //Searching for product1
        List<WebElement> allSaltList = driver.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']"));
      
        //Adding first item of the search list to cart after getting its price  
        int price2 = 0 ;
        for(int i=1;i<=1;i++) {	    	
	    	allSaltList.get(i).click();
	    	
	    //Handling windows with window handler as new window opens on clicking the product
	    	Set<String>s1=driver.getWindowHandles();
	    	Iterator<String> I1= s1.iterator();	    	
	    	String parentId = I1.next();// Gets parent window id
	    	String childId = I1.next();//Gets 1st child window id
	    	String thirdchildId = I1.next();//Gets 2nd child window id
	    	driver.switchTo().window(thirdchildId);
	    
	    	//Extracting Price of first item to be added to cart and converting it to Integer  	
	    	String strPrice = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='a-size-medium a-color-price priceBlockBuyingPriceString']")))).getText();
	    	price2 = getPrice(strPrice);
	    	  
	    	
	    	//Clicking on Add To Cart button
	    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#add-to-cart-button")))).click();
	    	
        }
        //Extracting actual subtotal that is visible and converting it into integer
        String actualSubtotal = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='a-color-price hlb-price a-inline-block a-text-bold']")))).getText();
        int total = getPrice(actualSubtotal);     
        
        //Adding extracted product prices of 1st and 2nd product added to cart
        int expTotal = price1+price2;
        
        //Comparing if ActualTotal is equal to expected Total
        System.out.println("ActualTotal: "+total);
        System.out.println("ExpectedTotal: "+expTotal);
        Assert.assertTrue("ActualTotal is not equal to expected Total", total==expTotal);		
        driver.quit();
    }
	//Method to fetch only price from the extracted string and convert it into integer
	public int getPrice(String gprice) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(gprice);
        String actualSubtotalString = null;
        while(m.find()) {            
            actualSubtotalString = m.group();           
            break;
        }       
        int priceInt = Integer.parseInt(actualSubtotalString);
        
        return priceInt;
        }

	}	
	





