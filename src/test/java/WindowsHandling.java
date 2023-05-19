import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		//Handling child windows (Use Iterator and Set in java and Webdriver)
		driver.findElement(By.className("blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
		// Use watch mode to debug the result and add code on the go.
		String mailId = driver.findElement(By.xpath("//p[@class='im-para red']//strong")).getText();
		System.out.println(mailId);
		driver.switchTo().window(parentId);
		driver.findElement(By.cssSelector("#username")).sendKeys(mailId);
	}

}
