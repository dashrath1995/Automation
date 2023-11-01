package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyUrlNavigation 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.org");
		String expectedUrl="https://www.selenium.dev/";
		String actualUrl=driver.getCurrentUrl();
		if(actualUrl.equals(expectedUrl))
		{
			System.out.println("URL is successfully navigating and pass");
		}
		else
		{
			System.out.println("fail");
		}
		driver.close();
	}
}
