package selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageLoadTimeOut 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		try
		{
			driver.get("https://www.facebook.com");
			System.out.println("page is loaded within 5 seconds");
		}
		catch(Exception e)
		{
			System.out.println("page is not loaded within 5 seconds");
		}
	}
}
