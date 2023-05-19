import java.time.Duration;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options= new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		//Set Proxy
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipAddress:1234");
		//You can also block pop up windows, you can also set the path for downloaded files through automation.
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();//Delete all cookies
		driver.manage().deleteCookieNamed("asdf");//Delete specific cookie
		driver.manage().deleteCookieNamed("sessionKey");//Delete specific cookie
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://expired.badssl.com/");
		

	}

}
