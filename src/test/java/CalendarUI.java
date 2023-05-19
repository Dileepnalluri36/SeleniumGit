import java.time.Duration;
import java.util.List;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class CalendarUI {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(
				"https://www.makemytrip.com/flights/?cmp=SEM%7CM%7CDF%7CB%7CBrand%7CB_M_Makemytrip_Search_Exact%7CBrand_Top_5_Exact%7CExpanded%7C&s_kwcid=AL%211631%213%21%21e%21%21o%21%21makemytrip%23&ef_id=8544cf875e5c19242bbbabcc2663bae8%3AG%3As&gclid=null/");
		// Month-May Date-28
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		String NeededDate = "25";
		String NeededmonthText="Nov";
		String year="2023";
//Month Selection
		// List<WebElement> month=
		// driver.findElements(By.xpath("(//div[@class='DayPicker-Caption' ] |
		// //div[@role='heading'])//div"));
		boolean selected = false;
		while (selected != true) {
			List<WebElement> month = driver
					.findElements(By.xpath("(//div[@class='DayPicker-Caption' ] | //div[@role='heading'])//div"));
			System.out.println(month.size());
			for (int i = 0; i < month.size(); i++) {
				String monthText = driver
						.findElements(By.xpath("(//div[@class='DayPicker-Caption' ] | //div[@role='heading'])//div"))
						.get(i).getText();
				System.out.println(monthText);
				if (monthText.contains(NeededmonthText) && monthText.contains(year) ) {
					selected = true;
					break;
				}

				
			}
			if(!selected) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
			else {
				break;
			}

		}

		// Date selection
		WebElement dateDriver = driver.findElement(By.xpath("//div[contains(text(),'"+NeededmonthText+"')]/parent::div/parent::div"));
		//List<WebElement> date = dateDriver.findElements(By.xpath("//div[@class='dateInnerCell']//p"));
		List<WebElement> date = dateDriver.findElements(By.xpath("//div[contains(text(),'"+NeededmonthText+"')]/parent::div/parent::div//div[@class='dateInnerCell']//p"));
		System.out.println(date.size());
		for (int i = 0; i < date.size(); i++) {

			String dateText = dateDriver.findElements(By.xpath("//div[contains(text(),'"+NeededmonthText+"')]/parent::div/parent::div//div[@class='dateInnerCell']//p")).get(i).getText();
			System.out.println(dateText);
			if (dateText.equalsIgnoreCase(NeededDate)) {
				Thread.sleep(1000);
				dateDriver.findElements(By.xpath("//div[contains(text(),'"+NeededmonthText+"')]/parent::div/parent::div//div[@class='dateInnerCell']//p")).get(i).click();
				break;
			}

		}
		driver.quit();

	}

}
