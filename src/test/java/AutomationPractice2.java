import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AutomationPractice2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		// Filling name
		driver.findElement(By.name("name")).sendKeys("Dileep");
		Thread.sleep(1000);
		driver.findElement(By.name("email")).sendKeys("Dileep@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Dileep@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select staticDropdwon = new Select(dropdown);
		staticDropdwon.selectByIndex(0);
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("29-02-2000");
		driver.findElement(By.className("btn-success")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.className("alert-success")).getText());
		Assert.assertTrue(driver.findElement(By.className("alert-success")).getText()
				.contains("Success! The Form has been submitted successfully!."));
		driver.quit();
	}

}
