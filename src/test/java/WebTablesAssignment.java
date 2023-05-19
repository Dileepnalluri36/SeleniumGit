import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		List <WebElement> rows = driver.findElements(By.cssSelector("[name='courses'] tr"));
		int rowSize  = rows.size();
		int colSize = rows.get(0).findElements(By.tagName("th")).size();
		System.out.printf("%d %d\n",rowSize,colSize);
	//	System.out.println(rows.get(2).getText());
	for(int i=0;i<colSize;i++) {
		System.out.println(rows.get(2).findElements(By.tagName("td")).get(i).getText());
	}
	driver.quit();

	}
}
