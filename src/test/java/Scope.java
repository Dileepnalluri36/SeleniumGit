import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// 1.Give me the counts of links on the page.
		int linksCount = driver.findElements(By.tagName("a")).size();
		System.out.println(linksCount);
		//2.Give me count of links on footer page.
		 linksCount = driver.findElements(By.xpath("//div[@id='gf-BIG']//a")).size();
		System.out.println(linksCount);
		
		//3.Count of links on first column of footer page.We are achieving this by limiting WebDriver scope
		WebElement firstColumnLinks = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul"));
		linksCount = firstColumnLinks.findElements(By.tagName("a")).size();
		System.out.println(linksCount);
		
	
		//4.Click on each link in the column and check if the pages are working.
		for(int i=1; i<linksCount;i++) {
			String clickLinkonNewTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			firstColumnLinks.findElements(By.tagName("a")).get(i).sendKeys(clickLinkonNewTab);
			
		}
		//5. Handle every child window and get title url.
		Set <String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
	
		
		///My solution
		int noOfWindows = windows.size();
		while(noOfWindows!=0) {
			driver.switchTo().window(it.next());
		System.out.println(driver.getTitle());	
		noOfWindows--;
		
		}
		///Rahul Shetty solution
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
		System.out.println(driver.getTitle());	
		
		}
		driver.quit();
	}

}
