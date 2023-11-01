package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnableLoginOrNot
{
	static 
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		boolean button = driver.findElement(By.xpath("//button[text()='Log in']")).isEnabled();
		if(button==true)
		{
			System.out.println("Button is enabled");
		}
		else
		{
			System.out.println("Button is not enabled");
		}
		driver.close();

	}
}
