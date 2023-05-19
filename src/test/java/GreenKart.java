import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Explicit wait
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		ArrayList<String> cartItem = new ArrayList<String>();
		cartItem.add("Cucumber");
		cartItem.add("Brocolli");
		cartItem.add("Carrot");
		cartItem.add("Beetroot");
		addItemsToCart(driver, cartItem);
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		//Explicit Wait
	w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@class='promoCode']")));
	driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
	driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
	w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.promoInfo")));
	System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	
	
		driver.quit();

	}

	public static void addItemsToCart(WebDriver driver, ArrayList<String> cartItem) {
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int j = 0;
		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			System.out.println(formattedName);

			if (cartItem.contains(formattedName)) {
				j++;
				System.out.println(j);
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == cartItem.size()) {
					break;
				}
			}

		}
	}

}