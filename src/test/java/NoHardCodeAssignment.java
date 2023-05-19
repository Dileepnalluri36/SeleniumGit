import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class NoHardCodeAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int optionTobeSelected = 1;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("(//input[@type='checkbox'])["+optionTobeSelected+ ']'+ "")).click();
		String labelText = driver.findElement(By.xpath("(//input[@type='checkbox'])["+optionTobeSelected+ ']'+ "//parent::label")).getText().trim();
		System.out.println(labelText);
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select staticDropdown= new Select(dropdown);
		staticDropdown.selectByVisibleText(labelText);
		driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys(labelText);
		Thread.sleep(2000);
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		System.out.println(driver.switchTo().alert().getText().contains(labelText));
		driver.switchTo().alert().accept();
		driver.quit();
		
		
	}

}
