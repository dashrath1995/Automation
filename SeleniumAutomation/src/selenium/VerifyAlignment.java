package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyAlignment
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com");
		int unTbox = driver.findElement(By.id("username")).getLocation().getX();
		int pwTbox = driver.findElement(By.name("pwd")).getLocation().getX();
		if(unTbox==pwTbox)
		{
			System.out.println("UN & PW textbox are properly aligned");
		}
		else
		{
			System.out.println("Not aligned");
		}
		driver.close();

	}
}
