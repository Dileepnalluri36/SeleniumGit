import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AutoCompleteAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String searchText = "in";
		String neededText = "bahrain";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Actions a = new Actions(driver);
		driver.findElement(By.id("autocomplete")).sendKeys(searchText);
		List<WebElement> searchResults = driver.findElements(By.className("ui-menu-item-wrapper"));
		for(int i=0; i<searchResults.size();i++ ) {
			if(searchResults.get(i).getText().trim().equalsIgnoreCase(neededText)) {
				System.out.println("Matched");
				a.moveToElement(searchResults.get(i)).click().build().perform();
			}
		}
		Assert.assertEquals(driver.findElement(By.id("autocomplete")).getAttribute("value").toLowerCase(), neededText);
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		driver.quit();
	}

}
