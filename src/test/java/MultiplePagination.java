
import java.sql.Driver;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MultiplePagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.findElement(By.cssSelector("a[href*='offers']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		driver.findElement(By.className("sort-icon")).click();
		List<WebElement> groceries = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalList = groceries.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));
		List<String> price;
		List<String> neededGroceries = Arrays.asList("Rice","Beans","Tomato","Potato","Almond");
		int count = 0;
		// Print price of grocery if grocery is Rice--->Print price(Pagination)
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s -> neededGroceries.contains(s.getText())).map(s -> getPriceVeggie(s,s.getText()))
					.collect(Collectors.toList());
			//price.forEach(s -> System.out.println(s));
			count+=price.size();
			if (neededGroceries.size() != count) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		} while (neededGroceries.size() != count);

		// Search text
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> searchResults = rows.stream().filter(s -> s.getText().contains("Rice"))
				.collect(Collectors.toList());
		Assert.assertEquals(searchResults.size(), rows.size());
		driver.quit();
	}

	private static String getPriceVeggie(WebElement s,String Veggie) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		System.out.printf("%s--%s\n",Veggie,priceValue);
		return priceValue;
	}

}
