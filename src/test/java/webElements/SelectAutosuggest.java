package webElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SelectAutosuggest
{
   WebDriver driver;
   @Test
   @Parameters("browser")
   public void scenario1(String nameofbrowser) throws InterruptedException
   {
     if(nameofbrowser.equals("Chrome"))
     {
    	 driver = new ChromeDriver();
     }
     

     if(nameofbrowser.equals("Firefox"))
     {
    	 driver = new FirefoxDriver();
     }
     
	 driver.get("https://www.google.com/");
	 
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 
	WebElement search =  driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
	search.sendKeys("Sachin Tendulkar");
	
	Thread.sleep(10000);
	
	List <WebElement> suggesions =  driver.findElements(By.xpath("//div[@class='OBMEnb']/ul/li"));
    
	int suggesioncount = suggesions.size();
	suggesions.get(suggesioncount-5).click();
	
	driver.quit();
	
	 
   }
}
