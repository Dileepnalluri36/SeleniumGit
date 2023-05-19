import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']//a"));
		//Soft Assertions
			SoftAssert a = new SoftAssert();
			for(int i=0; i<links.size();i++) {
				String newUrl = links.get(i).getAttribute("href");
				HttpURLConnection conn = (HttpURLConnection) new  URL(newUrl).openConnection();
				conn.setRequestMethod("HEAD");
				conn.connect();
				int responseCode = conn.getResponseCode();
				a.assertTrue(responseCode < 400 , newUrl+ " is failed with response code " + responseCode);
				
			}
		
			driver.quit();
			a.assertAll();
	}

}
