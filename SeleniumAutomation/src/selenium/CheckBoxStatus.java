package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxStatus
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		boolean checkBox = driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected();
		if(checkBox==true)
		{
			System.out.println("checkbox is checked");
		}
		else
		{
			System.out.println("checkbox is not checked");
		}
		driver.close();
	}
}
